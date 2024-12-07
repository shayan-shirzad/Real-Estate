package ir.sh.realestate.service;

import ir.sh.realestate.dto.EstateTypeDTO;

import java.util.List;

public interface EstateTypeService {
    EstateTypeDTO create(EstateTypeDTO estateTypeDTO)throws Exception;
    EstateTypeDTO update(EstateTypeDTO estateTypeDTO)throws Exception;
    Boolean delete(Long id);
    EstateTypeDTO getById(Long id);
    List<EstateTypeDTO> getAll();
}
