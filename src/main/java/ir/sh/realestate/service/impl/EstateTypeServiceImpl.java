package ir.sh.realestate.service.impl;

import ir.sh.realestate.dao.EstateTypeDAO;
import ir.sh.realestate.dto.EstateTypeDTO;
import ir.sh.realestate.entity.EstateTypeEntity;
import ir.sh.realestate.exception.NullPointerException;
import ir.sh.realestate.mapper.EstateTypeMapper;
import ir.sh.realestate.service.EstateTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EstateTypeServiceImpl implements EstateTypeService {

    @Autowired
    private EstateTypeDAO estateTypeDAO;

    @Autowired
    private EstateTypeMapper estateTypeMapper;

    @Transactional
    @Override
    public EstateTypeDTO create(EstateTypeDTO estateTypeDTO) throws Exception {
        if (estateTypeDTO.getEstateType() == null) {
            throw new NullPointerException("فیلد نوع کاربری ملک را پر کنید");
        }
        else {
            EstateTypeEntity estateTypeEntity = estateTypeDAO.save(estateTypeMapper.convertToEntity(estateTypeDTO));
            return estateTypeMapper.convertToDTO(estateTypeEntity);
        }
    }

    @Transactional
    @Override
    public EstateTypeDTO update(EstateTypeDTO estateTypeDTO) throws Exception {
        return estateTypeMapper.convertToDTO(estateTypeDAO.update(estateTypeMapper.convertToEntity(estateTypeDTO)));
    }

    @Transactional
    @Override
    public Boolean delete(Long id) {
        estateTypeDAO.delete(estateTypeDAO.getById(id));
        return true;
    }

    @Override
    public EstateTypeDTO getById(Long id) {
        return estateTypeMapper.convertToDTO(estateTypeDAO.getById(id));
    }

    @Override
    public List<EstateTypeDTO> getAll() {
        return estateTypeMapper.convertToDTO((List) estateTypeDAO.findAll());
    }
}
