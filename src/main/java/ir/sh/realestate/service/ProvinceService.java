package ir.sh.realestate.service;

import ir.sh.realestate.dto.ProvinceDTO;

import java.util.List;

public interface ProvinceService {

    Boolean findProvinceCodeExists(String provinceCode) throws Exception;
    ProvinceDTO create(ProvinceDTO provinceDTO)throws Exception;
    ProvinceDTO update(ProvinceDTO provinceDTO)throws Exception;
    Boolean delete(Long id);
    ProvinceDTO search(String provinceCode) throws Exception;
    List<ProvinceDTO> getAll();

}
