package ir.sh.realestate.service;


import ir.sh.realestate.dto.EstateDTO;

import java.util.List;

public interface EstateService {
    Boolean findTrackingCodeExists(String trackingCode) throws Exception;
    EstateDTO create(EstateDTO estateDTO)throws Exception;
    EstateDTO update(EstateDTO estateDTO, String trackingCode)throws Exception;
    Boolean delete(Long id);
    EstateDTO search(String trackingCode) throws Exception;
    List<EstateDTO> getAll();

}

