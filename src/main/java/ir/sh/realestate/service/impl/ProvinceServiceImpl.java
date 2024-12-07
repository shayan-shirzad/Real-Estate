package ir.sh.realestate.service.impl;

import ir.sh.realestate.dao.ProvinceDAO;
import ir.sh.realestate.dto.CityDTO;
import ir.sh.realestate.dto.ProvinceDTO;
import ir.sh.realestate.entity.ProvinceEntity;
import ir.sh.realestate.exception.AlreadyExistsException;
import ir.sh.realestate.exception.NullPointerException;
import ir.sh.realestate.mapper.ProvinceMapper;
import ir.sh.realestate.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    private ProvinceDAO provinceDAO;

    @Autowired
    private ProvinceMapper provinceMapper;


    @Override
    public Boolean findProvinceCodeExists(String provinceCode) throws Exception {
        if(provinceDAO.existsByProvinceCodeEquals(provinceCode))
            return true;
        else
            return false;
    }

    @Transactional
    @Override
    public ProvinceDTO create(ProvinceDTO provinceDTO) throws Exception {
        if (provinceDTO.getProvinceCode() == null) {
            throw new NullPointerException("فیلد کد استان را پر کنید");
        }
        else {
            if (!this.findProvinceCodeExists(provinceDTO.getProvinceCode())) {
                ProvinceEntity provinceEntity = provinceDAO.save(provinceMapper.convertToEntity(provinceDTO));
                return provinceMapper.convertToDTO(provinceEntity);
            } else {
                ProvinceDTO provinceDTO1 = provinceMapper.convertToDTO(provinceDAO.findByProvinceCode(provinceDTO.getProvinceCode()));
                throw new AlreadyExistsException("استان " + provinceDTO1.getProvinceName() + " با کد " + provinceDTO.getProvinceCode() + " در سامانه ثبت شده است");
            }
        }
    }

    @Override
    public ProvinceDTO update(ProvinceDTO provinceDTO) throws Exception {
        return provinceMapper.convertToDTO(provinceDAO.save(provinceMapper.convertToEntity(provinceDTO)));
    }

    @Override
    public Boolean delete(Long id) {
        provinceDAO.deleteById(id);
        return true;
    }

    @Override
    public ProvinceDTO search(String provinceCode) throws Exception {
        return provinceMapper.convertToDTO(provinceDAO.findByProvinceCode(provinceCode));
    }

    @Override
    public List<ProvinceDTO> getAll() {
        return provinceMapper.convertToDTO((List) provinceDAO.findAll());
    }
}