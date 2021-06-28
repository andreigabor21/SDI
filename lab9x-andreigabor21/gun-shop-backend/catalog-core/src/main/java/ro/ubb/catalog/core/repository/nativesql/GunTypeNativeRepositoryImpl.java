package ro.ubb.catalog.core.repository.nativesql;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.jpa.HibernateEntityManager;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.catalog.core.model.GunProvider;
import ro.ubb.catalog.core.model.GunType;
import ro.ubb.catalog.core.repository.CustomRepositorySupport;
import ro.ubb.catalog.core.repository.GunProviderCustomRepository;
import ro.ubb.catalog.core.repository.GunTypeCustomRepository;
import ro.ubb.catalog.core.repository.jpql.ClientJPQLRepositoryImpl;

import java.util.List;

@Component("GunTypeNativeRepositoryImpl")
public class GunTypeNativeRepositoryImpl
        extends CustomRepositorySupport
        implements GunTypeCustomRepository {

    private static final Logger log = LoggerFactory.getLogger(ClientJPQLRepositoryImpl.class);

    @Override
    @Transactional
    public List<GunType> findByGivenName(String name) {
        log.trace("findByGivenName(Native) - method entered");
        System.out.println("findByGivenName(Native)  - method entered");

        HibernateEntityManager hibernateEntityManager = getEntityManager().unwrap(HibernateEntityManager.class);
        Session session = hibernateEntityManager.getSession();
        Query query = session.createSQLQuery(
                "select distinct {gt.*} " +
                        "from gun_type gt " +
                        "where gt.name = :name")
                .addEntity("gt", GunType.class)
                .setParameter("name", name)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return query.getResultList();
    }

    @Override
    @Transactional
    public List<GunType> findByNameStartsWith(Character character) {
        log.trace("findByNameStartsWith(Native) - method entered");
        System.out.println("findByNameStartsWith(Native)  - method entered");

        HibernateEntityManager hibernateEntityManager = getEntityManager().unwrap(HibernateEntityManager.class);
        Session session = hibernateEntityManager.getSession();
        Query query = session.createSQLQuery(
                "select distinct {gt.*} " +
                        "from gun_type gt " +
                        "where gt.name like concat(:character,'%') ")
                .addEntity("gt", GunType.class)
                .setParameter("character", character)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return query.getResultList();
    }
}
