package ir.sh.realestate.dao;

import ir.sh.realestate.entity.ProvinceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceDAO extends JpaRepository<ProvinceEntity, Long> {
    Boolean existsByProvinceCodeEquals(String provinceCode);
    ProvinceEntity findByProvinceCode(String provinceCode);
}
