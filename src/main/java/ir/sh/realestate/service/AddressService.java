package ir.sh.realestate.service;


import ir.sh.realestate.dto.AddressDTO;

import java.util.List;

public interface AddressService {

    Boolean findPostalCodeExists(String postalCode) throws Exception;
    AddressDTO create(AddressDTO adressDTO)throws Exception;
    AddressDTO update(AddressDTO addressDTO,String postalCode)throws Exception;
    Boolean delete(Long id);
    AddressDTO search(String postalCode) throws Exception;
    List<AddressDTO> getAll();
}
