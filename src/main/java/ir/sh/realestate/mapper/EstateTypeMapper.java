package ir.sh.realestate.mapper;

import ir.sh.realestate.dto.EstateTypeDTO;
import ir.sh.realestate.entity.EstateTypeEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EstateTypeMapper {
    EstateTypeEntity convertToEntity(EstateTypeDTO estateTypeDTO);
    List<EstateTypeEntity> convertToEntity(List<EstateTypeDTO> estateTypeDTOS);
    EstateTypeDTO convertToDTO(EstateTypeEntity estateTypeEntity);
    List<EstateTypeDTO> convertToDTO(List<EstateTypeEntity> estateTypeEntities);
}
