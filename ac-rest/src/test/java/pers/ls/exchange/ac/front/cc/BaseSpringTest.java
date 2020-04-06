package pers.ls.exchange.ac.front.cc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.ls.exchange.ac.front.se.BrandService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BaseSpringTest {
    @Autowired
    BrandService brandService;

    @Test
    public void testBrand(){
        String brandNameById = brandService.getBrandNameById(1L);
        System.out.println(brandNameById);
    }
}
