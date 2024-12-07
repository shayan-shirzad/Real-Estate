package ir.sh.realestate.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "owner_type_tbl")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class OwnerTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "owner_type", unique = true, nullable = false)
    @NotNull(message = "فیلد نوع کاربر را پر کنید")
    private String ownerType;

    @OneToMany(mappedBy = "ownerTypeEntity")
    private List<OwnerEntity> ownerEntities;

    public OwnerTypeEntity() {
    }

    public OwnerTypeEntity(Long id, String ownerType) {
        this.id = id;
        this.ownerType = ownerType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    public List<OwnerEntity> getOwnerEntities() {
        return ownerEntities;
    }

    public void setOwnerEntities(List<OwnerEntity> ownerEntities) {
        this.ownerEntities = ownerEntities;
    }
}
