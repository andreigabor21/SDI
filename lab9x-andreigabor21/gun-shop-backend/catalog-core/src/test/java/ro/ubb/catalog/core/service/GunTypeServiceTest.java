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
import ro.ubb.catalog.core.model.Category;
import ro.ubb.catalog.core.model.GunType;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ITConfig.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class})
@DatabaseSetup("/META-INF/dbtest/db-data.xml")
public class GunTypeServiceTest {

    @Autowired
    private GunTypeService gunTypeService;

    @Test
    public void getGunTypes() throws Exception {
        List<GunType> gunTypes = gunTypeService.getAllGunTypes();
        System.out.println(gunTypes);
        gunTypes.forEach(g -> System.out.println(g.getGunProvider()));
        assertEquals(3, gunTypes.size());
    }

    @Test
    public void deleteGunType() throws Exception {
        gunTypeService.deleteGunType(1L);
        List<GunType> gunTypes = gunTypeService.getAllGunTypes();
        assertEquals(2, gunTypes.size());
    }

    @Test
    public void updateGunType() throws Exception {
        GunType gunType = GunType.builder()
                .name("NewName")
                .category(Category.RIFLE)
                .build();
        gunType.setId(1L);
        gunTypeService.updateGunType(gunType);
        List<GunType> gunTypes = gunTypeService.getAllGunTypes();
        assertEquals("still 3 GunTypes after update", 3, gunTypes.size());

        GunType toFind = gunTypes.get(0);
        assertEquals("new name", toFind.getName(), "NewName");
    }
}
