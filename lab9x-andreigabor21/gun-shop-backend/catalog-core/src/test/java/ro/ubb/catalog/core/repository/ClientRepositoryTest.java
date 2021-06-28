package ro.ubb.catalog.core.repository;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.catalog.core.ITConfig;
import ro.ubb.catalog.core.model.Address;
import ro.ubb.catalog.core.model.Client;
import ro.ubb.catalog.core.model.GunProvider;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ITConfig.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class})
@DatabaseSetup("/META-INF/dbtest/db-data.xml")
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    public void findAll() {
        List<Client> clients = clientRepository.findAll();
        assertEquals(3, clients.size());
    }

    @Test //ent1
    public void findAllWithRentalsAndGunTypes() {
        List<Client> clientsWithOther = clientRepository.findAllWithRentalsAndGunTypes();
        assertEquals(3, clientsWithOther.size());
        assertEquals(0, clientsWithOther.get(0).getRentals().size());
        long count = clientsWithOther.get(0).getRentals()
                .stream()
                .filter(rental -> rental.getGunType().getName().equals("gt1"))
                .count();
        assertEquals(0, count);
//        clientsWithOther.forEach(c -> System.out.println(c.getRentals()));
    }

    @Test //ent2
    public void findByIdWithRentalsAndGunTypes() {
        Client client = clientRepository.findByIdWithRentalsAndGunTypes(10L).orElseThrow();
        assertEquals("client1", client.getName());
        assertEquals(LocalDate.of(2000, 6, 6), client.getDateOfBirth());
        assertEquals(new Address("city1", "street1", 20), client.getAddress());
    }

    @Test //custom1
    public void findByGivenName() {
        List<Client> clients = clientRepository.findByGivenName("client1");
        assertEquals(LocalDate.of(2000, 6, 6), clients.get(0).getDateOfBirth());
        assertEquals(new Address("city1", "street1", 20), clients.get(0).getAddress());
//        System.out.println(clients);
    }

    @Test //custom2
    public void findByGivenCity() {
        List<Client> clients = clientRepository.findByGivenCity("city1");
        assertEquals("client1", clients.get(0).getName());
        assertEquals(LocalDate.of(2000, 6, 6), clients.get(0).getDateOfBirth());
        assertEquals(new Address("city1", "street1", 20), clients.get(0).getAddress());
    }


    @Test
    public void add() {
        Address address = new Address("city", "street", 40);
        Client client = Client.builder()
                .name("New")
                .dateOfBirth(LocalDate.of(2000, 9, 9))
                .address(address)
                .build();
        clientRepository.save(client);
        List<Client> clients = clientRepository.findAll();
        System.out.println(clients);
        assertEquals(4, clients.size());
    }

    @Test
    @Transactional
    public void update() throws Exception {
        Client client = clientRepository.findById(20L).orElseThrow();
        client.setName("newName");
        List<Client> clients = clientRepository.findAll();
        assertEquals(clients.get(1).getName(), "newName");
    }

    @Test
    public void delete() throws Exception {
        clientRepository.deleteById(10L);
        List<Client> clients = clientRepository.findAll();
        assertEquals(2, clients.size());
    }
}















