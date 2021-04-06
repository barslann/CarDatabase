package com.coderman.cardatabase.repo;

import com.coderman.cardatabase.domain.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {
    // We can define our own queries in the Spring dAta repositories.
    //The query must start with a prefix, for example, findBy.
    // After the prefix, we can define the entity class fields that are used in the query

    //Fetch cars by brand
//    List<Car> findByBrand(String brand);

    //Fetch cars by color
//    List<Car> findByColor(String color);

    //Fetch cars by year
//    List<Car> findByYear(int year);


    //There can be multiple fields after the By keyword, concatenated with the And or Or keywords.


    //Fetch cars by brand and model
//    List<Car> findByBrandAndModel(String brand, String model);

    //Fetch cars by brand or model
//    List<Car> findByBrandOrModel(String brand, String model);



    // Queries can be sorted by using OrderBy keyword in the query method

    //Fetch cars by brand and sort by year
//    List<Car> findByBrandAndOrderByYear(String brand);


    // We can also create queries by using SQL statements via @Query annotation.


    //Fetch cars by model using SQL
//    @Query("select c from Car c where c.brand = ?1")
//    List<Car> findByModel(String model);


    // More advanced expressions with the @Query annotation
    //for example, like


    //Fetch cars by brand using SQL
//    @Query("select c from Car c where c.brand like %?1")
//    List<Car> findByBrandEndsWith(String brand);





}


/*

    CrudRepository<Car, Long>

    <Car, Long> type arguments define that this is the repository for the Car entity class and type of id  field is long!


    CrudRepository provides multiple Crud methods that we can now start to use.
        long count() - return the number of entities
        Iterable<T> findAll() - returns all the items of a given type
        Optional<T> findById(ID id) - returns one item by id
            Optional class gets introduces in Java 8 SE. Optional is a type of single value container that either has value or doesnt.
            By using optional, we can prevent null pointer exceptions
        void delete(T entity) - deletes an entity
        void deleteAll() - deletes all entities of the repository
        <S extends T> save(S entity) - saves an entity



 */