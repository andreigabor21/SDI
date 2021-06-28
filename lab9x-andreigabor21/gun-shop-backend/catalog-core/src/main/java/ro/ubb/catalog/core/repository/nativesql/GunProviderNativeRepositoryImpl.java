package ro.ubb.catalog.core.repository.nativesql;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.jpa.HibernateEntityManager;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.catalog.core.model.Client;
import ro.ubb.catalog.core.model.GunProvider;
import ro.ubb.catalog.core.repository.ClientCustomRepository;
import ro.ubb.catalog.core.repository.CustomRepositorySupport;
import ro.ubb.catalog.core.repository.GunProviderCustomRepository;
import ro.ubb.catalog.core.repository.jpql.ClientJPQLRepositoryImpl;

import java.util.List;

@Component("GunProviderNativeRepositoryImpl")
public class GunProviderNativeRepositoryImpl
        extends CustomRepositorySupport
        implements GunProviderCustomRepository {

    private static final Logger log = LoggerFactory.getLogger(ClientJPQLRepositoryImpl.class);

    @Override
    @Transactional
    public List<GunProvider> findByGivenSpeciality(String speciality) {
        log.trace("findByGivenSpeciality(Native) - method entered");
        System.out.println("findByGivenSpeciality(Native)  - method entered");

        HibernateEntityManager hibernateEntityManager = getEntityManager().unwrap(HibernateEntityManager.class);
        Session session = hibernateEntityManager.getSession();
        Query query = session.createSQLQuery(
                "select distinct {gp.*} " +
                        "from gun_provider gp " +
                        "where gp.speciality = :speciality")
                .addEntity("gp", GunProvider.class)
                .setParameter("speciality", speciality)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return query.getResultList();
    }

    @Override
    @Transactional
    public List<GunProvider> findByReputationInRange(int lowerBound, int upperBound) {
        log.trace("findByReputationInRange(Native) - method entered");
        System.out.println("findByReputationInRange(Native)  - method entered");

        HibernateEntityManager hibernateEntityManager = getEntityManager().unwrap(HibernateEntityManager.class);
        Session session = hibernateEntityManager.getSession();
        Query query = session.createSQLQuery(
                "select distinct {gp.*} " +
                        "from gun_provider gp " +
                        "where gp.reputation between :start and :end")
                .addEntity("gp", GunProvider.class)
                .setParameter("start", lowerBound)
                .setParameter("end", upperBound)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return query.getResultList();
    }
}
