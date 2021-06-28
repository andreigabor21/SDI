package ro.ubb.catalog.core.repository.jpql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ro.ubb.catalog.core.model.GunProvider;
import ro.ubb.catalog.core.repository.ClientCustomRepository;
import ro.ubb.catalog.core.repository.CustomRepositorySupport;
import ro.ubb.catalog.core.repository.GunProviderCustomRepository;

import javax.persistence.Query;
import java.util.List;

@Component("GunProviderJPQLRepositoryImpl")
public class GunProviderJPQLRepositoryImpl
        extends CustomRepositorySupport
        implements GunProviderCustomRepository {

    private static final Logger log = LoggerFactory.getLogger(ClientJPQLRepositoryImpl.class);

    @Override
    public List<GunProvider> findByGivenSpeciality(String speciality) {
        log.trace("findByGivenSpeciality(JPQL) - method entered");
        System.out.println("findByGivenSpeciality(JPQL)  - method entered");
        Query query = getEntityManager().createQuery(
                "select distinct gp from GunProvider gp where gp.speciality = :speciality"
        );
        query.setParameter("speciality", speciality);
        return query.getResultList();
    }

    @Override
    public List<GunProvider> findByReputationInRange(int lowerBound, int upperBound) {
        log.trace("findByReputationInRange(JPQL) - method entered");
        System.out.println("findByReputationInRange(JPQL)  - method entered");
        Query query = getEntityManager().createQuery(
                "select distinct gp from GunProvider gp where gp.reputation between :start and :end "
        );
        query.setParameter("start", lowerBound);
        query.setParameter("end", upperBound);
        return query.getResultList();
    }
}
