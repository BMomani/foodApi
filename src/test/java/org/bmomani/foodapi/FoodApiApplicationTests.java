package org.bmomani.foodapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class FoodApiApplicationTests {

    @Test
    void contextLoads() {
//        implicit test that spring is working
        Assert.isTrue(true, "Spring App booted successfully");
    }

}
