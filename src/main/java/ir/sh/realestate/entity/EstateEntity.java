package ir.sh.realestate.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "estate_tbl")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class EstateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdTime;
    @Column(name = "estate_name")
    private String estateName;
    @NotNull(message = "")
    @Size(min = 13, max = 13, message = "کد رهگیری وارد شده باید 13 رقم باشد")
    @Column(name = "tarcking_code", unique = true, nullable = false , length = 13)
    private String trackingCode;
    @Positive(message = "متراژ وارد شده باید بزگتر از صفر باشد")
    @Column(name = "square_meters")
    private int squareMeters;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private OwnerEntity ownerEntity;

    @OneToOne
    @JoinColumn(name = "address_id")
    private AddressEntity addressEntity;

    @ManyToOne
    @JoinColumn(name = "estate_type_id",referencedColumnName = "id")
    private EstateTypeEntity estateTypeEntity;

    public EstateEntity() {
    }

    public EstateEntity(Long id, Date createdTime, String estateName, String trackingCode, int squareMeters) {
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

    public OwnerEntity getOwnerEntity() {
        return ownerEntity;
    }

    public void setOwnerEntity(OwnerEntity ownerEntity) {
        this.ownerEntity = ownerEntity;
    }

    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public void setAddressEntity(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }

    public EstateTypeEntity getEstateTypeEntity() {
        return estateTypeEntity;
    }

    public void setEstateTypeEntity(EstateTypeEntity estateTypeEntity) {
        this.estateTypeEntity = estateTypeEntity;
    }
}