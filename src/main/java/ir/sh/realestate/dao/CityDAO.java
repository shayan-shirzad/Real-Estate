package ir.sh.realestate.dao;

import ir.sh.realestate.entity.CityEntity;
import ir.sh.realestate.entity.EstateTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityDAO{
    Boolean existsByCityCodeEquals(String cityCode);
    CityEntity findByCityCode(String cityCode);
    CityEntity save(CityEntity cityEntity);
    CityEntity update(CityEntity cityEntity);
    Boolean deleteById(Long id);
    CityEntity getById(Long id);
    List<CityEntity> findAll();
}
