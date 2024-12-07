package ir.sh.realestate.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.Date;

public class EstateDTO {
    private Long id;
    private Date createdTime;
    private String estateName;
    @NotNull(message = "Not.Null")
    @Size(min = 13, max = 13, message = "کد رهگیری وارد شده باید 13 رقم باشد")
    private String trackingCode;
    @Positive(message = "متراژ وارد شده باید بزگتر از صفر باشد")
    private int squareMeters;
    private OwnerDTO ownerDTO;
    private AddressDTO addressDTO;
    private EstateTypeDTO estateTypeDTO;

    public EstateDTO() {
    }

    public EstateDTO(Long id, Date createdTime, String estateName, String trackingCode, int squareMeters) {
        this.id = id;
        this.createdTime = createdTime;
        this.estateName = estateName;
        this.trackingCode = trackingCode;
        this.squareMeters = squareMeters;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getEstateName() {
        return estateName;
    }

    public void setEstateName(String estateName) {
        this.estateName = estateName;
    }

    public String getTrackingCode() {
        return trackingCode;
    }

    public void setTrackingCode(String trackingCode) {
        this.trackingCode = trackingCode;
    }

    public int getSquareMeters() {
        return squareMeters;
    }

    public void setSquareMeters(int squareMeters) {
        this.squareMeters = squareMeters;
    }

    public OwnerDTO getOwnerDTO() {
        return ownerDTO;
    }

    public void setOwnerDTO(OwnerDTO ownerDTO) {
        this.ownerDTO = ownerDTO;
    }

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }

    public EstateTypeDTO getEstateTypeDTO() {
        return estateTypeDTO;
    }

    public void setEstateTypeDTO(EstateTypeDTO estateTypeDTO) {
        this.estateTypeDTO = estateTypeDTO;
    }
}
