package com.coderman.cardatabase.repo;


import com.coderman.cardatabase.domain.Car;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest // instead of the @SpringBootTest annotation, this can be used if the test focuses only on JPA components
// When using @DataJpaTest annotation, the H2 database, Hibernate, adn Spring Data are configured automatically for testing.
// SQL logging is also turned on. The tests are transactional by default and roll back at the end of the test case!

public class CarRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager; // used to handle the persist entities and is designed to be used in testing.

    @Autowired
    private CarRepository carRepository;

    @Test
    public void saveCar(){
        Car car = new Car("Tesla", "Model X","White", "ABC-1123", 2017, 86000);
        testEntityManager.persistAndFlush(car);

        Assertions.assertThat(car.getId()).isNotNull();
    }

    @Test
    public void deleteCars(){
        Car car1 = new Car("Tesla", "Model X","White", "ABC-1123", 2017, 86000);
        Car car2 = new Car("Tesla", "Model X","White", "ABC-1123", 2017, 86000);
        testEntityManager.persistAndFlush(car1);
        testEntityManager.persistAndFlush(car2);

        carRepository.deleteAll();
        Assertions.assertThat(carRepository.findAll()).isEmpty();
    }


}
