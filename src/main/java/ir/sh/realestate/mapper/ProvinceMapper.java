package ir.sh.realestate.mapper;

import ir.sh.realestate.dto.ProvinceDTO;
import ir.sh.realestate.entity.ProvinceEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProvinceMapper {

    public ProvinceEntity convertToEntity(ProvinceDTO provinceDTO){
        ProvinceEntity provinceEntity = new ProvinceEntity();
        provinceEntity.setId(provinceDTO.getId());
        provinceEntity.setProvinceName(provinceDTO.getProvinceName());
        provinceEntity.setProvinceCode(provinceDTO.getProvinceCode());
        return provinceEntity;
    }

    public ProvinceDTO convertToDTO(ProvinceEntity provinceEntity){
        ProvinceDTO provinceDTO = new ProvinceDTO();
        provinceDTO.setId(provinceEntity.getId());
        provinceDTO.setProvinceName(provinceEntity.getProvinceName());
        provinceDTO.setProvinceCode(provinceEntity.getProvinceCode());
        return provinceDTO;
    }

    public List<ProvinceDTO> convertToDTO(List<ProvinceEntity> provinceEntities){
        List<ProvinceDTO> provinceDTOS = new ArrayList<>();
        for (ProvinceEntity provinceEntity : provinceEntities){
            provinceDTOS.add(convertToDTO(provinceEntity));
        }
        return provinceDTOS;
    }
}
