package ir.sh.realestate.dao;

import ir.sh.realestate.entity.EstateTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstateTypeDAO2 extends JpaRepository<EstateTypeEntity, Long> {

}
