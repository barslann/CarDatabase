package com.coderman.cardatabase;

import com.coderman.cardatabase.web.CarController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
class CarDatabaseApplicationTests {

    @Autowired
    private CarController carController;

    // This method checks that the instance of the controller class was created and injected successfully!
    @Test
    void contextLoads() {
        Assertions.assertThat(carController).isNotNull();
    }

}
