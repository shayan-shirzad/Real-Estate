package ir.sh.realestate.service.impl;

import ir.sh.realestate.dao.OwnerDAO;
import ir.sh.realestate.dto.OwnerDTO;
import ir.sh.realestate.entity.OwnerEntity;
import ir.sh.realestate.exception.AlreadyExistsException;
import ir.sh.realestate.exception.NotFoundException;
import ir.sh.realestate.exception.NullPointerException;
import ir.sh.realestate.mapper.EstateMapper;
import ir.sh.realestate.mapper.OwnerMapper;
import ir.sh.realestate.mapper.OwnerTypeMapper;
import ir.sh.realestate.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerDAO ownerDAO;

    @Autowired
    private OwnerMapper ownerMapper;

    @Autowired
    private OwnerTypeMapper ownerTypeMapper;

    @Autowired
    private EstateMapper estateMapper;

    @Override
    public Boolean findNationalCodeExists(String nationalCode) throws Exception {
        if(ownerDAO.existsByNationalCodeEquals(nationalCode))
            return true;
        else
            return false;
    }

    @Transactional
    @Override
    public OwnerDTO create(OwnerDTO ownerDTO) throws Exception {
        if (ownerDTO.getNationalCode() == null) {
            throw new NullPointerException("فیلد کد ملی کاربر را پر کنید");
        }
        else {
            if (!this.findNationalCodeExists(ownerDTO.getNationalCode())) {
                OwnerEntity ownerEntity = ownerDAO.save(ownerMapper.convertToEntity(ownerDTO));
                return ownerMapper.convertToDTO(ownerEntity);
            } else {
                throw new AlreadyExistsException("کاربر با کد ملی " + ownerDTO.getNationalCode() + " در سامانه وجود دارد");
            }
        }
    }

    @Transactional
    @Override
    public OwnerDTO update(OwnerDTO ownerDTO, String nationalCode) throws Exception {
        if (ownerDAO.existsByNationalCodeEquals(nationalCode)) {
            OwnerEntity ownerEntity = ownerDAO.findByNationalCode(nationalCode);
            ownerEntity.setCreatedTime(new Date());
            if(ownerDTO.getFirstName() != null)
                ownerEntity.setFirstName(ownerDTO.getFirstName());

            if (ownerDTO.getLastName() != null)
                ownerEntity.setLastName(ownerDTO.getLastName());

            if (ownerDTO.getPhoneNumber() != null)
                ownerEntity.setPhoneNumber(ownerDTO.getPhoneNumber());

            if (ownerDTO.getOwnerTypeDTO() != null)
                ownerEntity.setOwnerTypeEntity(ownerTypeMapper.convertToEntity(ownerDTO.getOwnerTypeDTO()));

            if (ownerDTO.getEstateDTOS() != null)
                ownerEntity.setEstateEntities(estateMapper.convertToEntity(ownerDTO.getEstateDTOS()));

            return ownerMapper.convertToDTO(ownerDAO.update(ownerEntity));
        }
        else throw new NotFoundException("کاربر با کد ملی " + nationalCode + " در سامانه وجود ندارد");
//        return ownerMapper.convertToDTO(ownerDAO.save(ownerMapper.convertToEntity(ownerDTO)));
    }

    @Transactional
    @Override
    public Boolean delete(Long id) {
        ownerDAO.deleteById(id);
        return true;
    }

    @Override
    public OwnerDTO search(String nationalCode) throws Exception {
        return ownerMapper.convertToDTO(ownerDAO.findByNationalCode(nationalCode));
    }

    @Override
    public List<OwnerDTO> getAll() {
        return ownerMapper.convertToDTO((List) ownerDAO.findAll());
    }
}


