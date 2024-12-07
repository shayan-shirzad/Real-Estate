package ir.sh.realestate.dao;

import ir.sh.realestate.entity.CityEntity;
import ir.sh.realestate.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityDAO2 extends JpaRepository<CityEntity, Long> {
    Boolean existsByCityCodeEquals(String cityCode);
    CityEntity findByCityCode(String cityCode);
}
