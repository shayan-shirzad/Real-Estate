package ir.sh.realestate.entity;

import com.fasterxml.jackson.annotation.*;
import ir.sh.realestate.annotation.NationalCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "owner_tbl")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class OwnerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdTime;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @NotNull(message = "فیلد شماره تلفن را پر کنید")
    @Size(min = 11, max = 11, message = "شماره تلفن وارد شده باید 11 رقم باشد. مثال 536****0919")
    @Column(name = "phone_number", unique = true, length = 11)
    private String phoneNumber;
    @NationalCode
    @Column(name = "national_code", unique = true, length = 10)
    private String nationalCode;

    @ManyToOne
    @JoinColumn(name = "owner_type_id",referencedColumnName = "id")
    private OwnerTypeEntity ownerTypeEntity;

    @ManyToOne
    @JoinColumn(name = "parent_id",referencedColumnName = "id")
    private OwnerEntity parent;

    @OneToMany(mappedBy = "parent")
    private List<OwnerEntity> subgroupCompanies;

    @OneToMany(mappedBy = "ownerEntity")
    private List<EstateEntity> estateEntities;

    public OwnerEntity() {
    }

    public OwnerEntity(Long id, Date createdTime, String firstName, String lastName, String phoneNumber, String nationalCode) {
        this.id = id;
        this.createdTime = createdTime;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.nationalCode = nationalCode;
    }

    public OwnerEntity(Long id, Date createdTime, String firstName, String lastName, String phoneNumber, String nationalCode, OwnerTypeEntity ownerTypeEntity) {
        this.id = id;
        this.createdTime = createdTime;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.nationalCode = nationalCode;
        this.ownerTypeEntity = ownerTypeEntity;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public OwnerTypeEntity getOwnerTypeEntity() {
        return ownerTypeEntity;
    }

    public void setOwnerTypeEntity(OwnerTypeEntity ownerTypeEntity) {
        this.ownerTypeEntity = ownerTypeEntity;
    }

    public OwnerEntity getParent() {
        return parent;
    }

    public void setParent(OwnerEntity parent) {
        this.parent = parent;
    }

    public List<OwnerEntity> getSubgroupCompanies() {
        return subgroupCompanies;
    }

    public void setSubgroupCompanies(List<OwnerEntity> subgroupCompanies) {
        this.subgroupCompanies = subgroupCompanies;
    }

    public List<EstateEntity> getEstateEntities() {
        return estateEntities;
    }

    public void setEstateEntities(List<EstateEntity> estateEntities) {
        this.estateEntities = estateEntities;
    }
}
