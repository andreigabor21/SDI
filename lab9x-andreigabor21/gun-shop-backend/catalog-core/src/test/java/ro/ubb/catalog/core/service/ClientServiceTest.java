package ro.ubb.catalog.core.service;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import ro.ubb.catalog.core.ITConfig;
import ro.ubb.catalog.core.model.Address;
import ro.ubb.catalog.core.model.Client;
import ro.ubb.catalog.core.model.GunType;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ITConfig.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class})
@DatabaseSetup("/META-INF/dbtest/db-data.xml")
public class ClientServiceTest {

    @Autowired
    private ClientService clientService;

    @Test
    public void getClients() throws Exception {
        List<Client> clients = clientService.getAllClients();
        assertEquals(3, clients.size());
    }

    @Test
    public void deleteClient() throws Exception {
        clientService.deleteClient(1L);
        List<Client> clients = clientService.getAllClients();
        assertEquals(2, clients.size());
    }

    @Test
    public void updateClient() throws Exception {
        Client client = Client.builder()
                .name("NewName")
                .dateOfBirth(LocalDate.of(2000, 9, 9))
                .address(new Address("city", "street", 40))
                .build();
        client.setId(1L);
        clientService.updateClient(client);
        List<Client> clients = clientService.getAllClients();
        assertEquals("still 3 clients after update", 3, clients.size());

        Client toFind = clients.get(0);
        assertEquals("new name", toFind.getName(), "NewName");
    }

    @Test
    public void getMostRentedGunType() throws Exception {
        GunType mostRentedGunType = clientService.getMostRentedGunType();
        assertEquals("gt2", mostRentedGunType.getName());
        assertEquals("gp2", mostRentedGunType.getGunProvider().getName());
    }

//    @Test
//    public void addClient() throws Exception {
//        Client client = Client.builder()
//                .name("New")
//                .dateOfBirth(LocalDate.of(2000, 9, 9))
//                .address(new Address("city", "street", 40))
//                .build();
//        client.setId(4L);
//        clientService.addClient(client);
//        assertEquals(4, clientService.getAllClients().size());
//    }
}
