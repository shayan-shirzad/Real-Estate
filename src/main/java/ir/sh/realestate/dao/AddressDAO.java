package ir.sh.realestate.dao;

import ir.sh.realestate.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressDAO extends JpaRepository<AddressEntity,Long> {

    Boolean existsByPostalCodeEquals(String postalCode);
    AddressEntity findByPostalCode(String postalCode);
    List<AddressEntity> findByOrderByStreetAsc();

}
