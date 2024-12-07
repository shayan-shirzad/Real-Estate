package ir.sh.realestate.service;


import ir.sh.realestate.dto.OwnerDTO;

import java.util.List;

public interface OwnerService {
     Boolean findNationalCodeExists(String nationalCode) throws Exception;
     OwnerDTO create(OwnerDTO ownerDTO)throws Exception;
     OwnerDTO update(OwnerDTO ownerDTO, String nationalCode)throws Exception;
     Boolean delete(Long id);
     OwnerDTO search(String nationalCode) throws Exception;
     List<OwnerDTO> getAll();
}
