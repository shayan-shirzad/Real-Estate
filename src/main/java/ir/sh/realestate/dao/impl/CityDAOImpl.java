package ir.sh.realestate.dao.impl;

import ir.sh.realestate.dao.CityDAO;
import ir.sh.realestate.entity.CityEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CityDAOImpl implements CityDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Boolean existsByCityCodeEquals(String cityCode) {
        Long count = (Long)
                entityManager.createQuery("select count(*) from CityEntity c" + " where c.cityCode = :code")
                        .setParameter("code", cityCode)
                        .getSingleResult();

        if (count > 0)
            return true;
        else
            return false;
    }

    @Override
    public CityEntity findByCityCode(String cityCode) {
        CityEntity cityEntity = (CityEntity)
                entityManager.createQuery("select c from CityEntity c" + " where c.cityCode= :code")
                        .setParameter("code", cityCode)
                        .getSingleResult();
        return cityEntity;
    }

    @Override
    public CityEntity save(CityEntity cityEntity) {
        entityManager.persist(cityEntity);
        return cityEntity;
    }

    @Override
    public CityEntity update(CityEntity cityEntity) {
        entityManager.merge(cityEntity);
        return cityEntity;
    }

    @Override
    public Boolean deleteById(Long id) {
        CityEntity cityEntity = this.getById(id);
        entityManager.remove(cityEntity);
        return true;
    }

    @Override
    public CityEntity getById(Long id) {
        CityEntity cityEntity = (CityEntity)
                entityManager.createQuery("from CityEntity c" + " where c.id= :id")
                        .setParameter("id", id)
                        .getSingleResult();
        return cityEntity;
    }

    @Override
    public List<CityEntity> findAll() {
        List<CityEntity> cityEntities = (List<CityEntity>)
                entityManager.createQuery("from CityEntity c")
                        .getResultList();
        return cityEntities;
    }
}
