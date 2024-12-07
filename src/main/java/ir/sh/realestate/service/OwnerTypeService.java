package ir.sh.realestate.service;

import ir.sh.realestate.dto.OwnerTypeDTO;

import java.util.List;

public interface OwnerTypeService {

    OwnerTypeDTO create(OwnerTypeDTO ownerTypeDTO)throws Exception;
    OwnerTypeDTO update(OwnerTypeDTO ownerTypeDTO)throws Exception;
    Boolean delete(Long id);
    List<OwnerTypeDTO> getAll();
}
