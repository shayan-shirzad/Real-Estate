package ir.sh.realestate.dao;

import ir.sh.realestate.entity.CityEntity;
import ir.sh.realestate.entity.OwnerEntity;
import ir.sh.realestate.entity.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OwnerDAO{
    Boolean existsByNationalCodeEquals(String nationalCode);
    OwnerEntity findByNationalCode(String nationalCode);
    OwnerEntity save(OwnerEntity cityEntity);
    OwnerEntity update(OwnerEntity ownerEntity);
    Boolean deleteById(Long id);
    OwnerEntity getById(Long id);
    List<OwnerEntity> findAll();

}
