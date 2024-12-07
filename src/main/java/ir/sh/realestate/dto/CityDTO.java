package ir.sh.realestate.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CityDTO {
    private Long id;
    @NotNull(message = "فیلد نام شهر را پر کنید")
    @Size(min = 1, max = 255)
    private String cityName;
    @NotNull(message = "فیلد کد شهر را پر کنید")
    private String cityCode;
    private ProvinceDTO provinceDTO;

    public CityDTO() {
    }

    public CityDTO(Long id, String cityName, String cityCode) {
        this.id = id;
        this.cityName = cityName;
        this.cityCode = cityCode;
    }

    public CityDTO(Long id, String cityName, String cityCode, ProvinceDTO provinceDTO) {
        this.id = id;
        this.cityName = cityName;
        this.cityCode = cityCode;
        this.provinceDTO = provinceDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public ProvinceDTO getProvinceDTO() {
        return provinceDTO;
    }

    public void setProvinceDTO(ProvinceDTO provinceDTO) {
        this.provinceDTO = provinceDTO;
    }
}
