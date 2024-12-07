package ir.sh.realestate.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "estate_type_tbl")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class EstateTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "فیلد نوع کاربری ملک را پر کنید")
    @Column(name = "estate_type", unique = true, nullable = false)
    private String estateType;

    @OneToMany(mappedBy = "estateTypeEntity")
    private List<EstateEntity> estateEntities;

    public EstateTypeEntity() {
    }

    public EstateTypeEntity(Long id, String estateType) {
        this.id = id;
        this.estateType = estateType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstateType() {
        return estateType;
    }

    public void setEstateType(String estateType) {
        this.estateType = estateType;
    }

    public List<EstateEntity> getEstateEntities() {
        return estateEntities;
    }

    public void setEstateEntities(List<EstateEntity> estateEntities) {
        this.estateEntities = estateEntities;
    }
}
