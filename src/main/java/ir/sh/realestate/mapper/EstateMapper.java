package ir.sh.realestate.mapper;

import ir.sh.realestate.dto.AddressDTO;
import ir.sh.realestate.dto.EstateDTO;
import ir.sh.realestate.dto.EstateTypeDTO;
import ir.sh.realestate.dto.OwnerDTO;
import ir.sh.realestate.entity.AddressEntity;
import ir.sh.realestate.entity.EstateEntity;
import ir.sh.realestate.entity.EstateTypeEntity;
import ir.sh.realestate.entity.OwnerEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class EstateMapper {
    public EstateEntity convertToEntity(EstateDTO estateDTO){
        estateDTO.setCreatedTime(new Date());
        EstateEntity estateEntity = new EstateEntity(estateDTO.getId(), estateDTO.getCreatedTime(), estateDTO.getEstateName(),
                estateDTO.getTrackingCode(), estateDTO.getSquareMeters());

        if (estateDTO.getOwnerDTO() != null) {
            OwnerEntity ownerEntity = new OwnerEntity(estateDTO.getOwnerDTO().getId(), estateDTO.getOwnerDTO().getCreatedTime(),
                    estateDTO.getOwnerDTO().getFirstName(), estateDTO.getOwnerDTO().getLastName(),
                    estateDTO.getOwnerDTO().getPhoneNumber(), estateDTO.getOwnerDTO().getNationalCode());
            estateEntity.setOwnerEntity(ownerEntity);
        }

        if (estateDTO.getAddressDTO() != null){
            AddressEntity addressEntity = new AddressEntity(estateDTO.getAddressDTO().getId(), estateDTO.getAddressDTO().getCreatedTime(),
                    estateDTO.getAddressDTO().getStreet(), estateDTO.getAddressDTO().getAlley(),
                    estateDTO.getAddressDTO().getPostalCode());
            estateEntity.setAddressEntity(addressEntity);
        }

        if (estateDTO.getEstateTypeDTO() != null) {
            EstateTypeEntity estateTypeEntity = new EstateTypeEntity(estateDTO.getEstateTypeDTO().getId(),
                    estateDTO.getEstateTypeDTO().getEstateType());
            estateEntity.setEstateTypeEntity(estateTypeEntity);
        }
        return estateEntity;
    }

    public List<EstateEntity> convertToEntity(List<EstateDTO> estateDTOS){
        List<EstateEntity> estateEntities = new ArrayList<>();
        for (EstateDTO estateDTO : estateDTOS){
            estateEntities.add(convertToEntity(estateDTO));
        }
        return estateEntities;
    }

    public EstateDTO convertToDTO(EstateEntity estateEntity){
        EstateDTO estateDTO = new EstateDTO(estateEntity.getId(), estateEntity.getCreatedTime(), estateEntity.getEstateName(),
                estateEntity.getTrackingCode(), estateEntity.getSquareMeters());

        if (estateEntity.getOwnerEntity() != null) {
            OwnerDTO ownerDTO = new OwnerDTO(estateEntity.getOwnerEntity().getId(), estateEntity.getOwnerEntity().getCreatedTime(),
                    estateEntity.getOwnerEntity().getFirstName(), estateEntity.getOwnerEntity().getLastName(),
                    estateEntity.getOwnerEntity().getPhoneNumber(), estateEntity.getOwnerEntity().getNationalCode());
            estateDTO.setOwnerDTO(ownerDTO);
        }

        if (estateEntity.getAddressEntity() != null){
            AddressDTO addressDTO = new AddressDTO(estateEntity.getAddressEntity().getId(), estateEntity.getAddressEntity().getCreatedTime(),
                    estateEntity.getAddressEntity().getStreet(), estateEntity.getAddressEntity().getAlley(),
                    estateEntity.getAddressEntity().getPostalCode());
            estateDTO.setAddressDTO(addressDTO);
        }

        if (estateEntity.getEstateTypeEntity() != null) {
            EstateTypeDTO estateTypeDTO = new EstateTypeDTO(estateEntity.getEstateTypeEntity().getId(),
                    estateEntity.getEstateTypeEntity().getEstateType());
            estateDTO.setEstateTypeDTO(estateTypeDTO);
        }
        return estateDTO;
    }

    public List<EstateDTO> convertToDTO(List<EstateEntity> estateEntities){
        List<EstateDTO> estateDTOS = new ArrayList<>();
        for (EstateEntity estateEntity : estateEntities){
            estateDTOS.add(convertToDTO(estateEntity));
        }
        return estateDTOS;
    }


//    public EstateDTO convertToDTO(EstateEntity estateEntity){
//        OwnerDTO ownerDTO = new OwnerDTO(estateEntity.getOwnerEntity().getId(), estateEntity.getOwnerEntity().getCreatedTime(), estateEntity.getOwnerEntity().getFirstName(), estateEntity.getOwnerEntity().getLastName(), estateEntity.getOwnerEntity().getPhoneNumber(), estateEntity.getOwnerEntity().getNationalCode());
//        AddressDTO addressDTO = new AddressDTO(estateEntity.getAddressEntity().getId(), estateEntity.getAddressEntity().getCreatedTime(), estateEntity.getAddressEntity().getStreet(), estateEntity.getAddressEntity().getAlley(), estateEntity.getAddressEntity().getPostalCode() );
//        EstateTypeDTO estateTypeDTO = new EstateTypeDTO(estateEntity.getEstateTypeEntity().getId(), estateEntity.getEstateTypeEntity().getEstateType());
//        EstateDTO estateDTO = new EstateDTO();
//        estateDTO.setId(estateEntity.getId());
//        estateDTO.setCreatedTime(estateEntity.getCreatedTime());
//        estateDTO.setEstateName(estateEntity.getEstateName());
//        estateDTO.setTrackingCode(estateEntity.getTrackingCode());
//        estateDTO.setSquareMeters(estateEntity.getSquareMeters());
//        estateDTO.setOwnerDTO(ownerDTO);
//        estateDTO.setAddressDTO(addressDTO);
//        estateDTO.setEstateTypeDTO(estateTypeDTO);
//        return estateDTO;
//    }

//    public EstateEntity convertToEntity(EstateDTO estateDTO){
//        OwnerEntity ownerEntity = new OwnerEntity(estateDTO.getOwnerDTO().getId(), estateDTO.getOwnerDTO().getCreatedTime(), estateDTO.getOwnerDTO().getFirstName(), estateDTO.getOwnerDTO().getLastName(), estateDTO.getOwnerDTO().getPhoneNumber(), estateDTO.getOwnerDTO().getNationalCode());
//        AddressEntity addressEntity = new AddressEntity(estateDTO.getAddressDTO().getId(), estateDTO.getAddressDTO().getCreatedTime(), estateDTO.getAddressDTO().getStreet(), estateDTO.getAddressDTO().getAlley(), estateDTO.getAddressDTO().getPostalCode() );
//        EstateTypeEntity estateTypeEntity = new EstateTypeEntity(estateDTO.getEstateTypeDTO().getId(), estateDTO.getEstateTypeDTO().getEstateType());
//        EstateEntity estateEntity = new EstateEntity();
//        estateEntity.setId(estateDTO.getId());
//        estateEntity.setCreatedTime(estateDTO.getCreatedTime());
//        estateEntity.setEstateName(estateDTO.getEstateName());
//        estateEntity.setTrackingCode(estateDTO.getTrackingCode());
//        estateEntity.setSquareMeters(estateDTO.getSquareMeters());
//        estateEntity.setOwnerEntity(ownerEntity);
//        estateEntity.setAddressEntity(addressEntity);
//        estateEntity.setEstateTypeEntity(estateTypeEntity);
//        return estateEntity;
//    }

}
