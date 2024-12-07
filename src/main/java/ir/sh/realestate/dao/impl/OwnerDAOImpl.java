package ir.sh.realestate.dao.impl;

import ir.sh.realestate.dao.OwnerDAO;
import ir.sh.realestate.entity.*;
import ir.sh.realestate.entity.OwnerEntity;
import ir.sh.realestate.entity.OwnerEntity;
import ir.sh.realestate.entity.OwnerEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class OwnerDAOImpl implements OwnerDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Boolean existsByNationalCodeEquals(String nationalCode) {
        Long count = (Long)
                entityManager.createQuery("select count(*) from OwnerEntity o" + " where o.nationalCode = :code")
                        .setParameter("code", nationalCode)
                        .getSingleResult();

        if (count > 0)
            return true;
        else
            return false;
    }

    @Override
    public OwnerEntity findByNationalCode(String nationalCode) {
        OwnerEntity ownerEntity = (OwnerEntity)
                entityManager.createQuery("select o from OwnerEntity o" + " where o.nationalCode= :code")
                        .setParameter("code", nationalCode)
                        .getSingleResult();
        return ownerEntity;
    }

    @Override
    public OwnerEntity save(OwnerEntity ownerEntity) {
        entityManager.persist(ownerEntity);
        return ownerEntity;
    }

    @Override
    public OwnerEntity update(OwnerEntity ownerEntity) {
        entityManager.createQuery("update OwnerEntity o" + " set o.firstName= :f , o.lastName= :l , o.phoneNumber= :p" + " where o.id= :code")
                .setParameter("code", ownerEntity.getId())
                .setParameter("f", ownerEntity.getFirstName())
                .setParameter("l", ownerEntity.getLastName())
                .setParameter("p", ownerEntity.getPhoneNumber())
                .executeUpdate();
        return entityManager.find(OwnerEntity.class, ownerEntity.getId());
    }

    @Override
    public Boolean deleteById(Long id) {
        OwnerEntity ownerEntity = this.getById(id);
        entityManager.remove(ownerEntity);
        return true;
    }

    @Override
    public OwnerEntity getById(Long id) {
        OwnerEntity ownerEntity = (OwnerEntity)
                entityManager.createQuery("from OwnerEntity o" + " where o.id= :id")
                        .setParameter("id", id)
                        .getSingleResult();
        return ownerEntity;
    }

    @Override
    public List<OwnerEntity> findAll() {
        List<OwnerEntity> ownerEntities = (List<OwnerEntity>)
                entityManager.createQuery("from OwnerEntity o")
                        .getResultList();
        return ownerEntities;
    }
}
