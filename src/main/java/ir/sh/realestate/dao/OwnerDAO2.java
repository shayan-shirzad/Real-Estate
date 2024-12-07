package ir.sh.realestate.dao;

import ir.sh.realestate.entity.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerDAO2 extends JpaRepository<OwnerEntity, Long> {
    Boolean existsByNationalCodeEquals(String nationalCode);
    OwnerEntity findByNationalCode(String nationalCode);
}
