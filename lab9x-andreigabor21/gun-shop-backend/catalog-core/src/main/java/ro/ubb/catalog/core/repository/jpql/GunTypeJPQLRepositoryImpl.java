package ro.ubb.catalog.core.repository.jpql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ro.ubb.catalog.core.model.GunType;
import ro.ubb.catalog.core.repository.CustomRepositorySupport;
import ro.ubb.catalog.core.repository.GunProviderCustomRepository;
import ro.ubb.catalog.core.repository.GunTypeCustomRepository;

import javax.persistence.Query;
import java.util.List;

@Component("GunTypeJPQLRepositoryImpl")
public class GunTypeJPQLRepositoryImpl
        extends CustomRepositorySupport
        implements GunTypeCustomRepository {

    private static final Logger log = LoggerFactory.getLogger(ClientJPQLRepositoryImpl.class);

    @Override
    public List<GunType> findByGivenName(String name) {
        log.trace("findByGivenName(JPQL) - method entered");
        System.out.println("findByGivenName(JPQL)  - method entered");
        Query query = getEntityManager().createQuery(
                "select distinct gt from GunType gt where gt.name = :name"
        );
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public List<GunType> findByNameStartsWith(Character character) {
        log.trace("findByGivenName(JPQL) - method entered");
        System.out.println("findByGivenName(JPQL)  - method entered");
        Query query = getEntityManager().createQuery(
                "select distinct gt from GunType gt where gt.name like CONCAT(:character,'%')"
        );
        query.setParameter("character", character);
        return query.getResultList();
    }
}
