package ir.sh.realestate.service;

import ir.sh.realestate.dto.CityDTO;

import java.util.List;

public interface CityService {

    Boolean findCityCodeExists(String cityCode) throws Exception;
    CityDTO create(CityDTO cityDTO)throws Exception;
    CityDTO update(CityDTO cityDTO)throws Exception;
    Boolean delete(Long id);
    CityDTO search(String cityCode) throws Exception;
    List<CityDTO> getAll();
}