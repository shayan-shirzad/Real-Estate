package ir.sh.realestate.service.impl;

import ir.sh.realestate.dao.CityDAO;
import ir.sh.realestate.dto.CityDTO;
import ir.sh.realestate.entity.CityEntity;
import ir.sh.realestate.exception.AlreadyExistsException;
import ir.sh.realestate.exception.NullPointerException;
import ir.sh.realestate.mapper.CityMapper;
import ir.sh.realestate.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDAO cityDAO;

    @Autowired
    private CityMapper cityMapper;


    @Override
    public Boolean findCityCodeExists(String cityCode) throws Exception {
        if(cityDAO.existsByCityCodeEquals(cityCode))
            return true;
        else
            return false;
    }

    @Transactional
    @Override
    public CityDTO create(CityDTO cityDTO) throws Exception {
        if (cityDTO.getCityCode() == null) {
            throw new NullPointerException("فیلد کد شهر را پر کنید");
        }
        else {
            if (!this.findCityCodeExists(cityDTO.getCityCode())) {
                CityEntity cityEntity = cityDAO.save(cityMapper.convertToEntity(cityDTO));
                return cityMapper.convertToDTO(cityEntity);
            } else {
                CityDTO cityDTO1 = cityMapper.convertToDTO(cityDAO.findByCityCode(cityDTO.getCityCode()));
                throw new AlreadyExistsException("شهر " + cityDTO1.getCityName() + " با کد " + cityDTO.getCityCode() + " در سامانه ثبت شده است");
            }
        }
    }

    @Transactional
    @Override
    public CityDTO update(CityDTO cityDTO) throws Exception {
        return cityMapper.convertToDTO(cityDAO.update(cityMapper.convertToEntity(cityDTO)));
    }

    @Transactional
    @Override
    public Boolean delete(Long id) {
        cityDAO.deleteById(id);
        return true;
    }

    @Override
    public CityDTO search(String cityCode) throws Exception {
        return cityMapper.convertToDTO(cityDAO.findByCityCode(cityCode));
    }

    @Override
    public List<CityDTO> getAll() {
        return cityMapper.convertToDTO((List) cityDAO.findAll());
    }
}
