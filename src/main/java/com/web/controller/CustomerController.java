package com.web.controller;

import com.config.AppConfig;
import com.model.Rental;
import com.service.repository.*;
import com.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(value = "/customerList", method = RequestMethod.GET)
    public ModelAndView customerList(@RequestParam(defaultValue = "1") int page, ModelMap model) {
        Pageable pageable = PageRequest.of(page - 1, AppConfig.PAGE_SIZE);
        ModelAndView modelAndView = new ModelAndView("customerList");
        Page<Customer> customerPage = customerRepository.findAll(pageable);
        modelAndView.addObject("customerList", customerPage.getContent());
        modelAndView.addObject("currentPage", page);
        modelAndView.addObject("pageNumber", customerPage.getTotalPages());
        modelAndView.addObject("pageUrl", "customerList");
        return modelAndView;
    }

    @RequestMapping(value = "/searchCustomer", method = RequestMethod.GET)
    public ModelAndView searchCustomer(@RequestParam(defaultValue = "0") long id, @RequestParam String firstName, @RequestParam String lastName, ModelMap model) {
        ModelAndView modelAndView = new ModelAndView("customerList");
        List customerList = customerRepository.findCustomerByIdOrFirstNameOrLastName(id,firstName,lastName);
        modelAndView.addObject("customerList",customerList);
        modelAndView.addObject("currentPage", 1);
        modelAndView.addObject("pageNumber", 0);
        modelAndView.addObject("pageUrl", "customerList");
        return modelAndView;
    }


    @RequestMapping(value = "/editCustomer", method = RequestMethod.GET)
    public ModelAndView editCustomer(@RequestParam long id, ModelMap model) {
        ModelAndView modelAndView = new ModelAndView("customer");
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        List<Customer> customerList = mongoTemplate.find(query, Customer.class);
        if (customerList != null && customerList.size() == 1) {
            modelAndView.addObject("customer", customerList.get(0));
        }
        return modelAndView;
    }

    @PostMapping(value = "/updateCustomer")
    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer, ModelMap model) {
//        mongoTemplate.save(customer);
        customerRepository.updateCustomer(customer);
        return customerList(1,model);
    }

    @RequestMapping(value = "/deleteCustomer")
    public ModelAndView deleteCustomer(@RequestParam long id, ModelMap model) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        List<Customer> customerList = mongoTemplate.find(query, Customer.class);
        if (customerList != null && customerList.size() == 1) {
            mongoTemplate.remove(customerList.get(0));
        }
        return customerList(1, model);
    }

    @RequestMapping(value = "/detailCustomer")
    public ModelAndView detailCustomer(@RequestParam long id, ModelMap model) {
        ModelAndView modelAndView = new ModelAndView("customerDetail");
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        List<Customer> customerList = mongoTemplate.find(query, Customer.class);
        if (customerList != null && customerList.size() == 1) {
            modelAndView.addObject("customer", customerList.get(0));
        }
        return modelAndView;
    }


    @RequestMapping(value = "/detailRental")
    public ModelAndView detailRental(@RequestParam long id, @RequestParam long customerId, ModelMap model) {
        ModelAndView modelAndView = new ModelAndView("paymentList");
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(customerId));
        List<Customer> customerList = mongoTemplate.find(query, Customer.class);
        if (customerList != null && customerList.size() == 1) {
            for (Rental rental : customerList.get(0).getRentalFilms()) {
                if (rental.getRentalId() == id) {
                    modelAndView.addObject("rental", rental);
                }
            }
        }
        return modelAndView;
    }


}
