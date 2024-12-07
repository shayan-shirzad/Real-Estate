package ir.sh.realestate.mapper;


import ir.sh.realestate.dto.OwnerDTO;
import ir.sh.realestate.dto.OwnerTypeDTO;
import ir.sh.realestate.entity.OwnerEntity;
import ir.sh.realestate.entity.OwnerTypeEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Component
public class OwnerMapper {
    public OwnerEntity convertToEntity(OwnerDTO ownerDTO) {
        ownerDTO.setCreatedTime(new Date());
        if (ownerDTO.getOwnerTypeDTO() != null){
            return new OwnerEntity(ownerDTO.getId(), ownerDTO.getCreatedTime(), ownerDTO.getFirstName(),
                    ownerDTO.getLastName(), ownerDTO.getPhoneNumber(), ownerDTO.getNationalCode(),
                    new OwnerTypeEntity(ownerDTO.getOwnerTypeDTO().getId(), ownerDTO.getOwnerTypeDTO().getOwnerType()));
        }else
            return new OwnerEntity(ownerDTO.getId(), ownerDTO.getCreatedTime(), ownerDTO.getFirstName(),
                    ownerDTO.getLastName(), ownerDTO.getPhoneNumber(), ownerDTO.getNationalCode());
    }

    public OwnerDTO convertToDTO(OwnerEntity ownerEntity) {
        if (ownerEntity.getOwnerTypeEntity() != null){
            return new OwnerDTO(ownerEntity.getId(), ownerEntity.getCreatedTime(), ownerEntity.getFirstName(),
                    ownerEntity.getLastName(), ownerEntity.getPhoneNumber(), ownerEntity.getNationalCode(),
                    new OwnerTypeDTO(ownerEntity.getOwnerTypeEntity().getId(), ownerEntity.getOwnerTypeEntity().getOwnerType()));
        }else
            return new OwnerDTO(ownerEntity.getId(), ownerEntity.getCreatedTime(), ownerEntity.getFirstName(),
                    ownerEntity.getLastName(), ownerEntity.getPhoneNumber(), ownerEntity.getNationalCode());
    }

    public List<OwnerDTO> convertToDTO(List<OwnerEntity> ownerEntities) {
        List<OwnerDTO> ownerDTOS = new ArrayList<>();
        for (OwnerEntity ownerEntity : ownerEntities) {
            ownerDTOS.add(convertToDTO(ownerEntity));
        }
        return ownerDTOS;
    }

//    public OwnerDTO convertToDTO(OwnerEntity ownerEntity) {
//        OwnerDTO ownerDTO = new OwnerDTO();
//        if (ownerEntity.getOwnerTypeEntity() != null ) {
//            OwnerTypeDTO ownerTypeDTO = new OwnerTypeDTO(ownerEntity.getOwnerTypeEntity().getId(), ownerEntity.getOwnerTypeEntity().getOwnerType());
//            ownerDTO.setOwnerTypeDTO(ownerTypeDTO);
//        }
//        ownerDTO.setId(ownerEntity.getId());
//        ownerDTO.setCreatedTime(ownerEntity.getCreatedTime());
//        ownerDTO.setFirstName(ownerEntity.getFirstName());
//        ownerDTO.setLastName(ownerEntity.getLastName());
//        ownerDTO.setPhoneNumber(ownerEntity.getPhoneNumber());
//        ownerDTO.setNationalCode(ownerEntity.getNationalCode());
//        return ownerDTO;
//    }

}
