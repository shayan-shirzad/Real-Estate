package ir.sh.realestate.mapper;

import ir.sh.realestate.dto.OwnerTypeDTO;
import ir.sh.realestate.entity.OwnerTypeEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OwnerTypeMapper {

    public OwnerTypeEntity convertToEntity(OwnerTypeDTO ownerTypeDTO) {
        OwnerTypeEntity ownerTypeEntity = new OwnerTypeEntity();
        ownerTypeEntity.setId(ownerTypeDTO.getId());
        ownerTypeEntity.setOwnerType(ownerTypeDTO.getOwnerType());
        return ownerTypeEntity;
    }

    public OwnerTypeDTO convertToDTO(OwnerTypeEntity ownerTypeEntity) {
        OwnerTypeDTO ownerTypeDTO = new OwnerTypeDTO();
        ownerTypeDTO.setId(ownerTypeEntity.getId());
        ownerTypeDTO.setOwnerType(ownerTypeEntity.getOwnerType());
        return ownerTypeDTO;
    }

    public List<OwnerTypeDTO> convertToDTO(List<OwnerTypeEntity> ownerTypeEntities){
        List<OwnerTypeDTO> ownerTypeDTOS = new ArrayList<>();
        for (OwnerTypeEntity ownerTypeEntity : ownerTypeEntities){
            ownerTypeDTOS.add(convertToDTO(ownerTypeEntity));
        }
        return ownerTypeDTOS;
    }
}
