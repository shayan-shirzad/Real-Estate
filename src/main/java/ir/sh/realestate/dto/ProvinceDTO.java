package ir.sh.realestate.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class ProvinceDTO {
    private Long id;
    @NotNull(message = "فیلد نام استان را پر کنید")
    @Size(min = 1, max = 255)
    private String provinceName;
    @NotNull(message = "فیلد کد استان را پر کنید")
    private String provinceCode;
    private List<CityDTO> cityDTOS;

    public ProvinceDTO() {
    }

    public ProvinceDTO(Long id, String provinceName, String provinceCode) {
        this.id = id;
        this.provinceName = provinceName;
        this.provinceCode = provinceCode;
    }

    public ProvinceDTO(Long id, String provinceName, String provinceCode, List<CityDTO> cityDTOS) {
        this.id = id;
        this.provinceName = provinceName;
        this.provinceCode = provinceCode;
        this.cityDTOS = cityDTOS;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public List<CityDTO> getCityDTOS() {
        return cityDTOS;
    }

    public void setCityDTOS(List<CityDTO> cityDTOS) {
        this.cityDTOS = cityDTOS;
    }
}
