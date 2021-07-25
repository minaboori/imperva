package com.service.repository;

import com.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, Long> ,CustomerRepositoryCustom {

    @Query("{firstName:'?0'}")
    List findCustomersByFirstName(String firstName);

    @Query("{$or : [{id: ?0}, {firstName : {$regex:?1} }, {lastName:  ?2 }]}")
    List<Customer> findCustomerByIdOrFirstNameOrLastName(long id,String firstName,String lastName);



}
