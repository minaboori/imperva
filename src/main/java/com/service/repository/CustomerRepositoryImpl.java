package com.service.repository;

import com.model.Customer;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;


public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public long updateCustomer( Customer customer) {
        Query query = new Query(Criteria.where("id").is(customer.getId()));
        Update update = new Update();
        update.set("firstName", customer.getFirstName());
        update.set("lastName", customer.getLastName());
        update.set("country", customer.getCountry());
        update.set("city", customer.getCity());
        update.set("address", customer.getAddress());
        update.set("phone",customer.getPhone());

        UpdateResult result = mongoTemplate.updateFirst(query, update, Customer.class);

        if (result != null)
            return result.getModifiedCount();
        else
            return 0l;

    }
}
