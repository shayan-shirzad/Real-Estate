package ir.sh.realestate.dto;

import javax.validation.constraints.NotNull;
import java.util.List;

public class EstateTypeDTO {
    private Long id;
    @NotNull(message = "فیلد نوع کاربری ملک را پر کنید")
    private String estateType;
    private List<EstateDTO> estateDTOS;

    public EstateTypeDTO() {
    }

    public EstateTypeDTO(Long id, String estateType) {
        this.id = id;
        this.estateType = estateType;
    }

    public EstateTypeDTO(Long id, String estateType, List<EstateDTO> estateDTOS) {
        this.id = id;
        this.estateType = estateType;
        this.estateDTOS = estateDTOS;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstateType() {
        return estateType;
    }

    public void setEstateType(String estateType) {
        this.estateType = estateType;
    }

    public List<EstateDTO> getEstateDTOS() {
        return estateDTOS;
    }

    public void setEstateDTOS(List<EstateDTO> estateDTOS) {
        this.estateDTOS = estateDTOS;
    }
}
