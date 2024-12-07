package ir.sh.realestate.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "address_tbl")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdTime;
    private String street;
    private String alley;
    @NotNull(message = "فیلد کد پستی را پر کنید")
    @Size(min = 10, max = 10, message = "کد پستی وارد شده باید 10 رقم باشد")
    @Column(name = "postal_code", unique = true, nullable = false, length = 10)
    private String postalCode;

    @OneToOne
    private CityEntity cityEntity;

    @OneToOne
    private ProvinceEntity provinceEntity;

    public AddressEntity() {
    }

    public AddressEntity(Long id, Date createdTime, String street, String alley, String postalCode) {
        this.id = id;
        this.createdTime = createdTime;
        this.street = street;
        this.alley = alley;
        this.postalCode = postalCode;
    }

    public AddressEntity(Long id, Date createdTime, String street, String alley, String postalCode, CityEntity cityEntity) {
        this.id = id;
        this.createdTime = createdTime;
        this.street = street;
        this.alley = alley;
        this.postalCode = postalCode;
        this.cityEntity = cityEntity;
    }

    public AddressEntity(Long id, Date createdTime, String street, String alley, String postalCode, ProvinceEntity provinceEntity) {
        this.id = id;
        this.createdTime = createdTime;
        this.street = street;
        this.alley = alley;
        this.postalCode = postalCode;
        this.provinceEntity = provinceEntity;
    }

    public AddressEntity(Long id, Date createdTime, String street, String alley, String postalCode, CityEntity cityEntity, ProvinceEntity provinceEntity) {
        this.id = id;
        this.createdTime = createdTime;
        this.street = street;
        this.alley = alley;
        this.postalCode = postalCode;
        this.cityEntity = cityEntity;
        this.provinceEntity = provinceEntity;
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

    public CityEntity getCityEntity() {
        return cityEntity;
    }

    public void setCityEntity(CityEntity cityEntity) {
        this.cityEntity = cityEntity;
    }

    public ProvinceEntity getProvinceEntity() {
        return provinceEntity;
    }

    public void setProvinceEntity(ProvinceEntity provinceEntity) {
        this.provinceEntity = provinceEntity;
    }
}
