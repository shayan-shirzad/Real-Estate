package ir.sh.realestate.dao;

import ir.sh.realestate.entity.EstateTypeEntity;
import ir.sh.realestate.entity.OwnerEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstateTypeDAO{
    EstateTypeEntity save(EstateTypeEntity estateTypeEntity);
    EstateTypeEntity update(EstateTypeEntity estateTypeEntity);
    Boolean delete(EstateTypeEntity estateTypeEntity);
    EstateTypeEntity getById(Long id);
    List<EstateTypeEntity> findAll();
}
