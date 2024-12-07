package ir.sh.realestate.dto;

import javax.validation.constraints.NotNull;
import java.util.List;

public class OwnerTypeDTO {
    private Long id;
    @NotNull(message = "فیلد نوع کاربر را پر کنید")
    private String ownerType;
    private List<OwnerDTO> ownerDTOS;

    public OwnerTypeDTO() {
    }

    public OwnerTypeDTO(Long id, String ownerType) {
        this.id = id;
        this.ownerType = ownerType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    public List<OwnerDTO> getOwnerDTOS() {
        return ownerDTOS;
    }

    public void setOwnerDTOS(List<OwnerDTO> ownerDTOS) {
        this.ownerDTOS = ownerDTOS;
    }
}
