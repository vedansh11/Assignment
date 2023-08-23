package com.example.crud.controller;


import com.example.crud.model.Customer;
import com.example.crud.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/sunbase/portal/api/assignment_auth.jsp")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    CustomerService customerRepository;



    @PostMapping("/create")
    public Object createCustomer(@RequestBody Customer customer){
       return customerService.createCustomer(customer);
    }

    @GetMapping("/create")
    public String createCustomer(@ModelAttribute("customer") Customer customer,Model model){
        model.addAttribute("student", customerService.createCustomer(customer));
        return "create_customer";
    }

    @PostMapping("/customer")
    public String saveStudent(@ModelAttribute("customer") Customer student) {
        customerService.saveStudent(student);
        return "redirect:/get_customer_list";
    }


    @GetMapping("/customer/edit/{id}")
    public String editStudentForm(@PathVariable String id, Model model) {
        model.addAttribute("customer", customerService.getStudentById(id));
        return "edit_customer";
    }

    @GetMapping("/get_customer_list")
    public List<Customer> getCustomer(){
        return customerService.getAllCustomers();
    }




    @PostMapping("/update/{id}")
    public Object updateCustomer(@RequestBody Customer customer,@PathVariable String id){
        return customerService.updateCustomer(customer,id);
    }

    @PostMapping("/delete/{id}")
    public Object deleteCustomer(@PathVariable String id){
        return customerService.deleteCustomer(id);
    }

//    @PostMapping("/update/{id}")
//    public String updateCustomer(@ModelAttribute("customer") Customer customer,@PathVariable String id,Model model){
//        customerService.updateCustomer(customer,id);
//        return "redirect:/customer";
//    }

//    @GetMapping("/delete/{id}")
//    public String deleteCustomer(@PathVariable String id){
//        customerService.deleteCustomer(id);
//        return "redirect:/customer";
//    }


}
