package ir.sh.realestate.service.impl;

import ir.sh.realestate.dao.EstateDAO;
import ir.sh.realestate.dto.EstateDTO;
import ir.sh.realestate.entity.EstateEntity;
import ir.sh.realestate.exception.AlreadyExistsException;
import ir.sh.realestate.exception.NotFoundException;
import ir.sh.realestate.exception.NullPointerException;
import ir.sh.realestate.mapper.AddressMapper;
import ir.sh.realestate.mapper.EstateMapper;
import ir.sh.realestate.mapper.EstateTypeMapper;
import ir.sh.realestate.mapper.OwnerMapper;
import ir.sh.realestate.service.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class EstateServiceImpl implements EstateService {

    @Autowired
    private EstateDAO estateDAO;

    @Autowired
    private EstateMapper estateMapper;

    @Autowired
    private OwnerMapper ownerMapper;

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private EstateTypeMapper estateTypeMapper;

    @Override
    public Boolean findTrackingCodeExists(String trackingCode) throws Exception {
        if(estateDAO.existsByTrackingCodeEquals(trackingCode))
            return true;
        else
            return false;
    }

    @Transactional
    @Override
    public EstateDTO create(EstateDTO estateDTO)throws Exception{
        if (estateDTO.getTrackingCode() == null) {
            throw new NullPointerException("فیلد کد رهگیری را پر کنید");
        }
        else {
            if (!this.findTrackingCodeExists(estateDTO.getTrackingCode())) {
                EstateEntity estateEntity = estateDAO.save(estateMapper.convertToEntity(estateDTO));
                return estateMapper.convertToDTO(estateEntity);
            } else {
                //throw new AlreadyExistsException("ملک با کد رهگیری " + estateDTO.getTrackingCode() + " در سامانه وجود دارد");
                throw new AlreadyExistsException("estate.exists.with.this.trackingCode",estateDTO.getTrackingCode());

            }
        }

    }

    @Override
    public EstateDTO update(EstateDTO estateDTO, String trackingCode) throws Exception {
        if (estateDAO.existsByTrackingCodeEquals(trackingCode)) {
            EstateEntity estateEntity = estateDAO.findByTrackingCode(trackingCode);
            estateEntity.setCreatedTime(new Date());
            if (estateDTO.getEstateName() != null)
                estateEntity.setEstateName(estateDTO.getEstateName());

            if (estateDTO.getSquareMeters() > 0)
                estateEntity.setSquareMeters(estateDTO.getSquareMeters());

            if (estateDTO.getOwnerDTO() != null)
                estateEntity.setOwnerEntity(ownerMapper.convertToEntity(estateDTO.getOwnerDTO()));

            if (estateDTO.getAddressDTO() != null)
                estateEntity.setAddressEntity(addressMapper.convertToEntity(estateDTO.getAddressDTO()));

            if (estateDTO.getEstateTypeDTO() != null)
                estateEntity.setEstateTypeEntity(estateTypeMapper.convertToEntity(estateDTO.getEstateTypeDTO()));

            return estateMapper.convertToDTO(estateDAO.save(estateEntity));
        }
        else throw new NotFoundException("ملک با کد رهگیری " + trackingCode + " در سامانه وجود ندارد");
    }

    @Override
    public Boolean delete(Long id) {
        estateDAO.deleteById(id);
        return true;
    }

    @Override
    public EstateDTO search(String trackingCode) throws Exception {
        return estateMapper.convertToDTO(estateDAO.findByTrackingCode(trackingCode));
    }

    @Override
    public List<EstateDTO> getAll() {
        return estateMapper.convertToDTO((List) estateDAO.findAll());
    }


}
