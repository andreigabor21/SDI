package ro.ubb.catalog.core.service;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
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
import ro.ubb.catalog.core.model.GunProvider;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ITConfig.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class})
@DatabaseSetup("/META-INF/dbtest/db-data.xml")
public class GunProviderServiceTest {

    @Autowired
    private GunProviderService gunProviderService;

    @Test
    public void getGunProviders() throws Exception {
        List<GunProvider> GunProviders = gunProviderService.getAllGunProviders();
        assertEquals(3, GunProviders.size());
    }

    @Test
    public void deleteGunProvider() throws Exception {
        gunProviderService.deleteGunProvider(1L);
        List<GunProvider> GunProviders = gunProviderService.getAllGunProviders();
        assertEquals(2, GunProviders.size());
    }

    @Test
    public void updateGunProvider() throws Exception {
        GunProvider gunProvider = GunProvider.builder()
                .name("NewName")
                .speciality("spec")
                .reputation(3)
                .build();
        gunProvider.setId(1L);
        gunProviderService.updateGunProvider(gunProvider);
        List<GunProvider> gunProviders = gunProviderService.getAllGunProviders();
        assertEquals("still 3 GunProviders after update", 3, gunProviders.size());

        GunProvider toFind = gunProviders.get(0);
        assertEquals("new name", toFind.getName(), "NewName");
    }
}
