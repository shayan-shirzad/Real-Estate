package ir.sh.realestate.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class AddressDTO {
    private Long id;
    private Date createdTime;
    private String street;
    private String alley;
    @NotNull(message = "فیلد کد پستی را پر کنید")
    @Size(min = 10, max = 10, message = "کد پستی وارد شده باید 10 رقم باشد")
    private String postalCode;
    private CityDTO cityDTO;
    private ProvinceDTO provinceDTO;

    public AddressDTO() {
    }

    public AddressDTO(Long id, Date createdTime, String street, String alley, String postalCode) {
        this.id = id;
        this.createdTime = createdTime;
        this.street = street;
        this.alley = alley;
        this.postalCode = postalCode;
    }

    public AddressDTO(Long id, Date createdTime, String street, String alley, String postalCode, CityDTO cityDTO) {
        this.id = id;
        this.createdTime = createdTime;
        this.street = street;
        this.alley = alley;
        this.postalCode = postalCode;
        this.cityDTO = cityDTO;
    }

    public AddressDTO(Long id, Date createdTime, String street, String alley, String postalCode, ProvinceDTO provinceDTO) {
        this.id = id;
        this.createdTime = createdTime;
        this.street = street;
        this.alley = alley;
        this.postalCode = postalCode;
        this.provinceDTO = provinceDTO;
    }

    public AddressDTO(Long id, Date createdTime, String street, String alley, String postalCode, CityDTO cityDTO, ProvinceDTO provinceDTO) {
        this.id = id;
        this.createdTime = createdTime;
        this.street = street;
        this.alley = alley;
        this.postalCode = postalCode;
        this.cityDTO = cityDTO;
        this.provinceDTO = provinceDTO;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAlley() {
        return alley;
    }

    public void setAlley(String alley) {
        this.alley = alley;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public CityDTO getCityDTO() {
        return cityDTO;
    }

    public void setCityDTO(CityDTO cityDTO) {
        this.cityDTO = cityDTO;
    }

    public ProvinceDTO getProvinceDTO() {
        return provinceDTO;
    }

    public void setProvinceDTO(ProvinceDTO provinceDTO) {
        this.provinceDTO = provinceDTO;
    }
}
