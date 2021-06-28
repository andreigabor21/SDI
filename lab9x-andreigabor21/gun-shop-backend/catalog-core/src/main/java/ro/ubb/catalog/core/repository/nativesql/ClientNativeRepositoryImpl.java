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
import ro.ubb.catalog.core.repository.ClientCustomRepository;
import ro.ubb.catalog.core.repository.CustomRepositorySupport;
import ro.ubb.catalog.core.repository.jpql.ClientJPQLRepositoryImpl;

import java.util.List;

@Component("ClientNativeRepositoryImpl")
public class ClientNativeRepositoryImpl
        extends CustomRepositorySupport
        implements ClientCustomRepository {

    private static final Logger log = LoggerFactory.getLogger(ClientJPQLRepositoryImpl.class);

    @Override
    @Transactional
    public List<Client> findByGivenName(String name) {
        log.trace("findByGivenName(Native) - method entered");
        System.out.println("findByGivenName(Native)  - method entered");

        HibernateEntityManager hibernateEntityManager = getEntityManager().unwrap(HibernateEntityManager.class);
        Session session = hibernateEntityManager.getSession();
        Query query = session.createSQLQuery(
                "select distinct {c.*} " +
                        "from client c " +
                        "where c.name = :name")
                .addEntity("c", Client.class)
                .setParameter("name", name)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return query.getResultList();
    }

    @Override
    @Transactional
    public List<Client> findByGivenCity(String city) {
        log.trace("findByGivenCity(Native) - method entered");
        System.out.println("findByGivenCity(Native)  - method entered");

        HibernateEntityManager hibernateEntityManager = getEntityManager().unwrap(HibernateEntityManager.class);
        Session session = hibernateEntityManager.getSession();

        Query query = session.createSQLQuery(
                "select distinct {c.*} " +
                        "from client c " +
                        "where c.city = :city"
        )
                .addEntity("c", Client.class)
                .setParameter("city", city)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Client> resultList = query.getResultList();
        return resultList;
    }
}
