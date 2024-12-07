package ir.sh.realestate.service.impl;

import ir.sh.realestate.dao.OwnerTypeDAO;
import ir.sh.realestate.dto.OwnerTypeDTO;
import ir.sh.realestate.entity.OwnerTypeEntity;
import ir.sh.realestate.exception.NullPointerException;
import ir.sh.realestate.mapper.OwnerTypeMapper;
import ir.sh.realestate.service.OwnerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OwnerTypeServiceImpl implements OwnerTypeService {

    @Autowired
    private OwnerTypeDAO ownerTypeDAO;

    @Autowired
    private OwnerTypeMapper ownerTypeMapper;


    @Transactional
    @Override
    public OwnerTypeDTO create(OwnerTypeDTO ownerTypeDTO) throws Exception {
        if (ownerTypeDTO.getOwnerType() == null) {
            throw new NullPointerException("فیلد نوع کاربر را پر کنید");
        }
        else {
            OwnerTypeEntity ownerTypeEntity = ownerTypeDAO.save(ownerTypeMapper.convertToEntity(ownerTypeDTO));
            return ownerTypeMapper.convertToDTO(ownerTypeEntity);
        }
    }

    @Override
    public OwnerTypeDTO update(OwnerTypeDTO ownerTypeDTO) throws Exception {
        return ownerTypeMapper.convertToDTO(ownerTypeDAO.save(ownerTypeMapper.convertToEntity(ownerTypeDTO)));
    }

    @Override
    public Boolean delete(Long id) {
        ownerTypeDAO.deleteById(id);
        return true;
    }

    @Override
    public List<OwnerTypeDTO> getAll() {
        return ownerTypeMapper.convertToDTO((List) ownerTypeDAO.findAll());
    }
}
