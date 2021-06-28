package ro.ubb.catalog.core.repository;

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
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.catalog.core.ITConfig;
import ro.ubb.catalog.core.model.Address;
import ro.ubb.catalog.core.model.Category;
import ro.ubb.catalog.core.model.Client;
import ro.ubb.catalog.core.model.GunProvider;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ITConfig.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class})
@DatabaseSetup("/META-INF/dbtest/db-data.xml")
public class GunProviderRepositoryTest {

    @Autowired
    private GunProviderRepository gunProviderRepository;

    @Test
    public void findAll() {
        List<GunProvider> all = gunProviderRepository.findAll();
        assertEquals(3, all.size());
    }

    @Test //ent1
    public void findAllGunProvidersWithGunTypes() {
        List<GunProvider> all = gunProviderRepository.findAllGunProvidersWithGunTypes();
        assertEquals(3, all.size());
        assertEquals("gt3", all.get(0).getGunTypes().get(0).getName());
        assertEquals(Category.SHOTGUN, all.get(0).getGunTypes().get(0).getCategory());
        assertEquals("gt1", all.get(1).getGunTypes().get(0).getName());
        assertEquals(Category.RIFLE, all.get(1).getGunTypes().get(0).getCategory());
    }

    @Test //ent2
    public void findByIdWithGunTypes() {
        GunProvider gunProvider = gunProviderRepository.findByIdWithGunTypes(1L).orElseThrow();
        assertEquals("gp1", gunProvider.getName());
        assertEquals("spec1", gunProvider.getSpeciality());
        assertEquals(2, gunProvider.getReputation());
        assertEquals(1L, (long) gunProvider.getGunTypes().get(0).getId());
    }

    @Test //custom1
    public void findByGivenSpeciality() {
        List<GunProvider> gunProviders = gunProviderRepository.findByGivenSpeciality("spec1");
        assertEquals(1, gunProviders.size());
    }

    @Test //custom2
    public void findByReputationInRange() {
        List<GunProvider> gunProviders = gunProviderRepository.findByReputationInRange(1, 3);
        assertEquals(2, gunProviders.size());
    }


    @Test
    @Transactional
    public void update() throws Exception {
        GunProvider gunProvider = gunProviderRepository.findById(1L).orElseThrow();
        gunProvider.setName("newName");
        List<GunProvider> all = gunProviderRepository.findAll();
        assertEquals(all.get(0).getName(), "newName");
    }

    @Test
    public void delete() throws Exception {
        gunProviderRepository.deleteById(3L);
        List<GunProvider> all = gunProviderRepository.findAll();
        assertEquals(2, all.size());
    }

//    @Test
//    public void add() {
//        GunProvider gunProvider = GunProvider.builder()
//                .name("new")
//                .speciality("newSpec")
//                .reputation(4)
//                .build();
//        gunProvider.setId(4L);
//        gunProviderRepository.save(gunProvider);
//    }
}
