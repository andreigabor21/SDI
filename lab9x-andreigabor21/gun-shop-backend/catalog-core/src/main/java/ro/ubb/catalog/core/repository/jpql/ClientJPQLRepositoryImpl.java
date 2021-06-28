package ro.ubb.catalog.core.repository.jpql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import ro.ubb.catalog.core.model.Client;
import ro.ubb.catalog.core.repository.ClientCustomRepository;
import ro.ubb.catalog.core.repository.CustomRepositorySupport;

import javax.persistence.Query;
import java.util.List;

@Component("ClientJPQLRepositoryImpl")
public class ClientJPQLRepositoryImpl
        extends CustomRepositorySupport
        implements ClientCustomRepository {

    private static final Logger log = LoggerFactory.getLogger(ClientJPQLRepositoryImpl.class);

    @Override
    public List<Client> findByGivenName(String name) {
        log.trace("findByGivenName(JPQL) - method entered");
        System.out.println("findByGivenName(JPQL)  - method entered");
        Query query = getEntityManager().createQuery(
                "select distinct c from Client c where c.name = :name"
        );
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public List<Client> findByGivenCity(String city) {
        log.trace("findByGivenCity(JPQL) - method entered");
        System.out.println("findByGivenCity(JPQL)  - method entered");
        Query query = getEntityManager().createQuery(
                "select distinct c from Client c where c.address.city = :city"
        );
        query.setParameter("city", city);
        return query.getResultList();
    }
}
