package ir.sh.realestate.dao;

import ir.sh.realestate.entity.OwnerTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerTypeDAO extends JpaRepository<OwnerTypeEntity, Long> {

}
