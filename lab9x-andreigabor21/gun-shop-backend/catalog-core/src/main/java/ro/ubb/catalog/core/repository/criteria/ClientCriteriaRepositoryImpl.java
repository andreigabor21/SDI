package ro.ubb.catalog.core.repository.criteria;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ro.ubb.catalog.core.model.Client;
import ro.ubb.catalog.core.repository.ClientCustomRepository;
import ro.ubb.catalog.core.repository.CustomRepositorySupport;
import ro.ubb.catalog.core.repository.jpql.ClientJPQLRepositoryImpl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;

@Component("ClientCriteriaRepositoryImpl")
public class ClientCriteriaRepositoryImpl
        extends CustomRepositorySupport
        implements ClientCustomRepository {

    private static final Logger log = LoggerFactory.getLogger(ClientJPQLRepositoryImpl.class);

    @Override
    public List<Client> findByGivenName(String name) {
        log.trace("findByGivenName(Criteria) - method entered");
        System.out.println("findByGivenName(Criteria) - method entered");
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Client> query = criteriaBuilder.createQuery(Client.class);
        query.distinct(Boolean.TRUE);
        Root<Client> root = query.from(Client.class);

        ParameterExpression<String> parameter = criteriaBuilder.parameter(String.class);
        query.where(criteriaBuilder.equal(root.get("name"), name));

        List<Client> clients = getEntityManager().createQuery(query).getResultList();
        return clients;
    }

    @Override
    public List<Client> findByGivenCity(String city) {
        log.trace("findByGivenCity(Criteria) - method entered");
        System.out.println("findByGivenCity(Criteria) - method entered");
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Client> query = criteriaBuilder.createQuery(Client.class);
        query.distinct(Boolean.TRUE);
        Root<Client> root = query.from(Client.class);

        ParameterExpression<String> parameter = criteriaBuilder.parameter(String.class);
        query.where(criteriaBuilder.equal(root.get("address").get("city"), city));

        List<Client> clients = getEntityManager().createQuery(query).getResultList();
        return clients;
    }
}
