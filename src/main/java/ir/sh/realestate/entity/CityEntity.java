package ir.sh.realestate.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "city_tbl")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class CityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "فیلد نام شهر را پر کنید")
    @Size(min = 1, max = 255)
    @Column(name = "city_name", nullable = false)
    private String cityName;
    @NotNull(message = "فیلد کد شهر را پر کنید")
    @Column(name = "city_Code", unique = true, nullable = false)
    private String cityCode;

    @ManyToOne
    @JoinColumn(name = "province_id")
    private ProvinceEntity provinceEntity;

    public CityEntity() {
    }

    public CityEntity(Long id, String cityName, String cityCode) {
        this.id = id;
        this.cityName = cityName;
        this.cityCode = cityCode;
    }

    public CityEntity(Long id, String cityName, String cityCode, ProvinceEntity provinceEntity) {
        this.id = id;
        this.cityName = cityName;
        this.cityCode = cityCode;
        this.provinceEntity = provinceEntity;
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

    public ProvinceEntity getProvinceEntity() {
        return provinceEntity;
    }

    public void setProvinceEntity(ProvinceEntity provinceEntity) {
        this.provinceEntity = provinceEntity;
    }
}
