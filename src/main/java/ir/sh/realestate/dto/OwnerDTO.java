package ir.sh.realestate.dto;

import ir.sh.realestate.annotation.NationalCode;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

public class OwnerDTO {
    private Long id;
    private Date createdTime;
    private String firstName;
    private String lastName;
    @NotNull(message = "فیلد شماره تلفن را پر کنید")
    @Size(min = 11, max = 11, message = "شماره تلفن وارد شده باید 11 رقم باشد. مثال 536****0919")
    private String phoneNumber;
    @NationalCode
    @Size(min = 10, max = 10, message = "کد ملی وارد شده باید 10 رقم باشد")
    private String nationalCode;
    private OwnerTypeDTO ownerTypeDTO;
    private OwnerDTO parent;
    private List<OwnerDTO> subgroupCompanies;
    private List<EstateDTO> estateDTOS;

    public OwnerDTO() {
    }

    public OwnerDTO(OwnerDTO parent) {
        this.parent = parent;
    }

    public OwnerDTO(Long id, Date createdTime, String firstName, String lastName, String phoneNumber, String nationalCode) {
        this.id = id;
        this.createdTime = createdTime;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.nationalCode = nationalCode;
    }

    public OwnerDTO(Long id, Date createdTime, String firstName, String lastName, String phoneNumber, String nationalCode, OwnerTypeDTO ownerTypeDTO) {
        this.id = id;
        this.createdTime = createdTime;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.nationalCode = nationalCode;
        this.ownerTypeDTO = ownerTypeDTO;
    }

    public OwnerDTO(Long id, Date createdTime, String firstName, String lastName, String phoneNumber, String nationalCode, OwnerTypeDTO ownerTypeDTO, OwnerDTO parent, List<OwnerDTO> subgroupCompanies, List<EstateDTO> estateDTOS) {
        this.id = id;
        this.createdTime = createdTime;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.nationalCode = nationalCode;
        this.ownerTypeDTO = ownerTypeDTO;
        this.parent = parent;
        this.subgroupCompanies = subgroupCompanies;
        this.estateDTOS = estateDTOS;
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

    public OwnerTypeDTO getOwnerTypeDTO() {
        return ownerTypeDTO;
    }

    public void setOwnerTypeDTO(OwnerTypeDTO ownerTypeDTO) {
        this.ownerTypeDTO = ownerTypeDTO;
    }

    public OwnerDTO getParent() {
        return parent;
    }

    public void setParent(OwnerDTO parent) {
        this.parent = parent;
    }

    public List<OwnerDTO> getSubgroupCompanies() {
        return subgroupCompanies;
    }

    public void setSubgroupCompanies(List<OwnerDTO> subgroupCompanies) {
        this.subgroupCompanies = subgroupCompanies;
    }

    public List<EstateDTO> getEstateDTOS() {
        return estateDTOS;
    }

    public void setEstateDTOS(List<EstateDTO> estateDTOS) {
        this.estateDTOS = estateDTOS;
    }
}
