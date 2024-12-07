package ir.sh.realestate.mapper;

import ir.sh.realestate.dto.AddressDTO;
import ir.sh.realestate.dto.CityDTO;
import ir.sh.realestate.dto.ProvinceDTO;
import ir.sh.realestate.entity.AddressEntity;
import ir.sh.realestate.entity.CityEntity;
import ir.sh.realestate.entity.ProvinceEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Component
public class AddressMapper {
    public AddressEntity convertToEntity(AddressDTO addressDTO){
        addressDTO.setCreatedTime(new Date());
        if (addressDTO.getCityDTO() != null && addressDTO.getProvinceDTO() != null){

            return new AddressEntity(addressDTO.getId(), addressDTO.getCreatedTime(), addressDTO.getStreet(),
                            addressDTO.getAlley(), addressDTO.getPostalCode(),
                    new CityEntity(addressDTO.getCityDTO().getId(), addressDTO.getCityDTO().getCityName(),
                            addressDTO.getCityDTO().getCityCode()),
                    new ProvinceEntity(addressDTO.getProvinceDTO().getId(), addressDTO.getProvinceDTO().getProvinceName(),
                            addressDTO.getProvinceDTO().getProvinceCode()));

        } else if (addressDTO.getCityDTO() != null) {

            return new AddressEntity(addressDTO.getId(), addressDTO.getCreatedTime(), addressDTO.getStreet(),
                            addressDTO.getAlley(), addressDTO.getPostalCode(),
                    new CityEntity(addressDTO.getCityDTO().getId(), addressDTO.getCityDTO().getCityName(),
                            addressDTO.getCityDTO().getCityCode()));

        } else if (addressDTO.getProvinceDTO() != null) {

            return new AddressEntity(addressDTO.getId(), addressDTO.getCreatedTime(), addressDTO.getStreet(),
                            addressDTO.getAlley(), addressDTO.getPostalCode(),
                    new ProvinceEntity(addressDTO.getProvinceDTO().getId(), addressDTO.getProvinceDTO().getProvinceName(),
                            addressDTO.getProvinceDTO().getProvinceCode()));

        }else return new AddressEntity(addressDTO.getId(), addressDTO.getCreatedTime(), addressDTO.getStreet(),
                addressDTO.getAlley(), addressDTO.getPostalCode());
    }

    public AddressDTO convertToDTO(AddressEntity addressEntity){
        if (addressEntity.getCityEntity() != null && addressEntity.getProvinceEntity() != null){

            return new AddressDTO(addressEntity.getId(), addressEntity.getCreatedTime(), addressEntity.getStreet(),
                    addressEntity.getAlley(), addressEntity.getPostalCode(),
                    new CityDTO(addressEntity.getCityEntity().getId(), addressEntity.getCityEntity().getCityName(),
                            addressEntity.getCityEntity().getCityCode()),
                    new ProvinceDTO(addressEntity.getProvinceEntity().getId(), addressEntity.getProvinceEntity().getProvinceName(),
                            addressEntity.getProvinceEntity().getProvinceCode()));

        } else if (addressEntity.getCityEntity() != null) {

            return new AddressDTO(addressEntity.getId(), addressEntity.getCreatedTime(), addressEntity.getStreet(),
                    addressEntity.getAlley(), addressEntity.getPostalCode(),
                    new CityDTO(addressEntity.getCityEntity().getId(), addressEntity.getCityEntity().getCityName(),
                            addressEntity.getCityEntity().getCityCode()));

        } else if (addressEntity.getProvinceEntity() != null) {

            return new AddressDTO(addressEntity.getId(), addressEntity.getCreatedTime(), addressEntity.getStreet(),
                    addressEntity.getAlley(), addressEntity.getPostalCode(),
                    new ProvinceDTO(addressEntity.getProvinceEntity().getId(), addressEntity.getProvinceEntity().getProvinceName(),
                            addressEntity.getProvinceEntity().getProvinceCode()));

        }else return new AddressDTO(addressEntity.getId(), addressEntity.getCreatedTime(), addressEntity.getStreet(),
                addressEntity.getAlley(), addressEntity.getPostalCode());
    }

    public List<AddressDTO> convertToDTO(List<AddressEntity> addressEntities){
        List<AddressDTO> addressDTOS = new ArrayList<>();
        for (AddressEntity addressEntity : addressEntities){
            addressDTOS.add(convertToDTO(addressEntity));
        }
        return addressDTOS;
    }

//    public AddressEntity convertToEntity(AddressDTO addressDTO){
//        CityEntity cityEntity = new CityEntity(addressDTO.getCityDTO().getId(), addressDTO.getCityDTO().getCityName(), addressDTO.getCityDTO().getCityCode());
//        ProvinceEntity provinceEntity = new ProvinceEntity(addressDTO.getProvinceDTO().getId(), addressDTO.getProvinceDTO().getProvinceName(), addressDTO.getProvinceDTO().getProvinceCode());
//        AddressEntity addressEntity = new AddressEntity();
//        addressEntity.setId(addressDTO.getId());
//        addressEntity.setCreatedTime(addressDTO.getCreatedTime());
//        addressEntity.setStreet(addressDTO.getStreet());
//        addressEntity.setAlley(addressDTO.getAlley());
//        addressEntity.setPostalCode(addressDTO.getPostalCode());
//        addressEntity.setCityEntity(cityEntity);
//        addressEntity.setProvinceEntity(provinceEntity);
//        return addressEntity;
//    }
}
