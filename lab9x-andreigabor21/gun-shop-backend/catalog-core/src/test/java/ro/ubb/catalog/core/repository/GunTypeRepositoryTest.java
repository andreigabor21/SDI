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
import ro.ubb.catalog.core.model.Category;
import ro.ubb.catalog.core.model.GunType;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ITConfig.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class})
@DatabaseSetup("/META-INF/dbtest/db-data.xml")
public class GunTypeRepositoryTest {

    @Autowired
    private GunTypeRepository gunTypeRepository;

    @Test
    public void findAll() {
        List<GunType> all = gunTypeRepository.findAll();
        assertEquals(3, all.size());
    }

    @Test //ent1
    public void findAllGunTypesWithRentals() {
        List<GunType> all = gunTypeRepository.findAllGunTypesWithRentals();
        assertEquals(3, all.size());
        int maxPrice = all.get(0).getRentals().stream().
                map(r -> r.getPrice())
                .max(Integer::compare)
                .orElseThrow();
        assertEquals(500, maxPrice);
    }

    @Test //ent2
    public void findByIdWithRentals() {
        GunType gunType = gunTypeRepository.findByIdWithRentals(1L).orElseThrow();
        assertEquals("gt1", gunType.getName());
        assertEquals(Category.RIFLE, gunType.getCategory());
    }

    @Test //ent3
    public void findAllGunTypesWithProviders() {
        List<GunType> all = gunTypeRepository.findAllGunTypesWithProviders();
        assertEquals("gp1", all.get(0).getGunProvider().getName());
        assertEquals("gp2", all.get(1).getGunProvider().getName());
        assertEquals("gp3", all.get(2).getGunProvider().getName());
    }

    @Test //custom1
    public void findByGivenName() {
        List<GunType> gunTypes = gunTypeRepository.findByGivenName("gt1");
        assertEquals(1, gunTypes.size());
    }

    @Test //custom2
    public void findByNameStartsWith() {
        List<GunType> gunTypes = gunTypeRepository.findByNameStartsWith('g');
        assertEquals(3, gunTypes.size());
    }

    @Test
    @Transactional
    public void update() throws Exception {
        GunType gunType = gunTypeRepository.findById(1L).orElseThrow();
        gunType.setName("newName");
        List<GunType> all = gunTypeRepository.findAll();
        assertEquals(all.get(0).getName(), "newName");
    }

    @Test
    public void delete() throws Exception {
        gunTypeRepository.deleteById(2L);
        List<GunType> all = gunTypeRepository.findAll();
        assertEquals(2, all.size());
    }

//    @Test
//    public void add() {
//        GunProvider provider = new GunProvider("name", "speciality", 3, null);
//        gunProviderRepository.save(provider);
//        GunType gunType = GunType.builder()
//                .name("newGun")
//                .category(Category.RIFLE)
//                .gunProvider(provider)
//                .build();
//        gunType.setId(3L);
//        gunTypeRepository.save(gunType);
//        List<GunType> all = gunTypeRepository.findAll();
//        assertEquals(3, all.size());
//    }
}
