package ir.sh.realestate.mapper;

import ir.sh.realestate.dto.CityDTO;
import ir.sh.realestate.entity.CityEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CityMapper {
    CityEntity convertToEntity(CityDTO cityDTO);
    List<CityEntity> convertToEntity(List<CityDTO> cityDTOS);
    CityDTO convertToDTO(CityEntity cityEntity);
    List<CityDTO> convertToDTO(List<CityEntity> cityEntities);
}
