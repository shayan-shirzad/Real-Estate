package ir.sh.realestate.dao.impl;

import ir.sh.realestate.dao.EstateTypeDAO;
import ir.sh.realestate.entity.EstateTypeEntity;
import ir.sh.realestate.entity.EstateTypeEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EstateTypeDAOImpl implements EstateTypeDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EstateTypeEntity save(EstateTypeEntity estateTypeEntity) {
        entityManager.persist(estateTypeEntity);
        return estateTypeEntity;
    }

    @Override
    public EstateTypeEntity update(EstateTypeEntity estateTypeEntity) {
        entityManager.merge(estateTypeEntity);
        return estateTypeEntity;
    }

    @Override
    public Boolean delete(EstateTypeEntity estateTypeEntity) {
        entityManager.createQuery("delete from EstateTypeEntity e" + " where e.id= :code")
                .setParameter("code", estateTypeEntity.getId())
                .executeUpdate();
        return true;
    }

    @Override
    public EstateTypeEntity getById(Long id) {
        EstateTypeEntity estateTypeEntity = (EstateTypeEntity ) entityManager.createQuery("from EstateTypeEntity e" + " where e.id=: id")
                .setParameter("id", id)
                .getSingleResult();
        return estateTypeEntity;
    }


    @Override
    public List<EstateTypeEntity> findAll() {
        List<EstateTypeEntity> estateEntities = (List<EstateTypeEntity>)
                entityManager.createQuery("from EstateTypeEntity e")
                        .getResultList();
        return estateEntities;
    }
}
