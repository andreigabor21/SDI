package ro.ubb.catalog.core.repository.criteria;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ro.ubb.catalog.core.model.GunProvider;
import ro.ubb.catalog.core.model.GunType;
import ro.ubb.catalog.core.repository.CustomRepositorySupport;
import ro.ubb.catalog.core.repository.GunProviderCustomRepository;
import ro.ubb.catalog.core.repository.GunTypeCustomRepository;
import ro.ubb.catalog.core.repository.jpql.ClientJPQLRepositoryImpl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;

@Component("GunTypeCriteriaRepositoryImpl")
public class GunTypeCriteriaRepositoryImpl
        extends CustomRepositorySupport
        implements GunTypeCustomRepository {

    private static final Logger log = LoggerFactory.getLogger(ClientJPQLRepositoryImpl.class);

    @Override
    public List<GunType> findByGivenName(String name) {
        log.trace("findByGivenName(Criteria) - method entered");
        System.out.println("findByGivenName(Criteria) - method entered");
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<GunType> query = criteriaBuilder.createQuery(GunType.class);
        query.distinct(Boolean.TRUE);
        Root<GunType> root = query.from(GunType.class);

        ParameterExpression<String> parameter = criteriaBuilder.parameter(String.class);
        query.where(criteriaBuilder.equal(root.get("name"), name));

        List<GunType> gunTypes = getEntityManager().createQuery(query).getResultList();
        return gunTypes;
    }

    @Override
    public List<GunType> findByNameStartsWith(Character character) {
        log.trace("findByGivenName(Criteria) - method entered");
        System.out.println("findByGivenName(Criteria) - method entered");
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<GunType> query = criteriaBuilder.createQuery(GunType.class);
        query.distinct(Boolean.TRUE);
        Root<GunType> root = query.from(GunType.class);

        query.where(criteriaBuilder.like(root.<String>get("name"),character+"%"));

        List<GunType> gunTypes = getEntityManager().createQuery(query).getResultList();
        return gunTypes;
    }
}
