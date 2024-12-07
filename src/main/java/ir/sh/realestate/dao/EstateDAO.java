package ir.sh.realestate.dao;

import ir.sh.realestate.entity.EstateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EstateDAO extends JpaRepository<EstateEntity,Long> {
    Boolean existsByTrackingCodeEquals(String trackingCode);
    EstateEntity findByTrackingCode(String trackingCode);

}
