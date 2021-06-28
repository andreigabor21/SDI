package ro.ubb.catalog.core.repository.criteria;

import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ro.ubb.catalog.core.model.Client;
import ro.ubb.catalog.core.model.GunProvider;
import ro.ubb.catalog.core.model.GunProvider_;
import ro.ubb.catalog.core.repository.CustomRepositorySupport;
import ro.ubb.catalog.core.repository.GunProviderCustomRepository;
import ro.ubb.catalog.core.repository.jpql.ClientJPQLRepositoryImpl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;

@Component("GunProviderCriteriaRepositoryImpl")
public class GunProviderCriteriaRepositoryImpl
        extends CustomRepositorySupport
        implements GunProviderCustomRepository {

    private static final Logger log = LoggerFactory.getLogger(ClientJPQLRepositoryImpl.class);

    @Override
    public List<GunProvider> findByGivenSpeciality(String speciality) {
        log.trace("findByGivenSpeciality(Criteria) - method entered");
        System.out.println("findByGivenSpeciality(Criteria) - method entered");
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<GunProvider> query = criteriaBuilder.createQuery(GunProvider.class);
        query.distinct(Boolean.TRUE);
        Root<GunProvider> root = query.from(GunProvider.class);

        ParameterExpression<String> parameter = criteriaBuilder.parameter(String.class);
        query.where(criteriaBuilder.equal(root.get("speciality"), speciality));

        List<GunProvider> gunProviders = getEntityManager().createQuery(query).getResultList();
        return gunProviders;
    }

    @Override
    public List<GunProvider> findByReputationInRange(int lowerBound, int upperBound) {
        log.trace("findByReputationInRange(Criteria) - method entered");
        System.out.println("findByReputationInRange(Criteria) - method entered");
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<GunProvider> query = criteriaBuilder.createQuery(GunProvider.class);
        query.distinct(Boolean.TRUE);
        Root<GunProvider> root = query.from(GunProvider.class);

        query.select(root)
                .where(criteriaBuilder.between(root.get(GunProvider_.reputation), lowerBound, upperBound));

        List<GunProvider> resultList = getEntityManager().createQuery(query).getResultList();
        return resultList;
    }
}
