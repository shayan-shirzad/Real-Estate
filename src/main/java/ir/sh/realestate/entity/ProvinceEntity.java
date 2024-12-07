package ir.sh.realestate.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "province_tbl")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ProvinceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "فیلد نام استان را پر کنید")
    @Size(min = 1, max = 255)
    @Column(name = "province_name", nullable = false)
    private String provinceName;
    @NotNull(message = "فیلد کد استان را پر کنید")
    @Column(name = "province_code", nullable = false)
    private String provinceCode;

    @OneToMany(mappedBy = "provinceEntity")
    private List<CityEntity> cityEntities;

    public ProvinceEntity() {
    }

    public ProvinceEntity(Long id, String provinceName, String provinceCode) {
        this.id = id;
        this.provinceName = provinceName;
        this.provinceCode = provinceCode;
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

    public List<CityEntity> getCityEntities() {
        return cityEntities;
    }

    public void setCityEntities(List<CityEntity> cityEntities) {
        this.cityEntities = cityEntities;
    }
}