package com.example.crud.service;

import com.example.crud.model.Customer;
import com.example.crud.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Object createCustomer(Customer customer){
        if(customer.getFirstname()==null || customer.getLastname()==null){
            return ResponseEntity.badRequest().body("400, First Name or Last Name is missing");
        }
         customerRepository.save(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body("201, Successfully Created");
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer saveStudent(Customer customer) {
        return customerRepository.save(customer);
    }

    public Object updateCustomer(Customer customer, String id){
        if (customer == null || customer.getFirstname() == null || customer.getLastname()== null) {
            return ResponseEntity.badRequest().body("400, Body is Empty");
        }
        if (!customerRepository.existsById(Integer.valueOf(id))) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("500, UUID not found");
        }

        customerRepository.save(customer);
        return ResponseEntity.ok("200, Successfully Updated");
    }

    public Customer getStudentById(String id) {
        return customerRepository.findById(Integer.valueOf(id)).get();
    }
    public Object deleteCustomer(String id){
        if(!customerRepository.existsById(Integer.valueOf(id))){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("400, UUID not found");
        }

        try {
            customerRepository.deleteById(Integer.valueOf(id));
            return ResponseEntity.ok("200, Successfully deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("500, Error Not deleted");
        }
    }

}
