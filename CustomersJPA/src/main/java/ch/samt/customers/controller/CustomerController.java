package ch.samt.customers.controller;

import ch.samt.customers.data.CustomerRepository;
import ch.samt.customers.model.Customers;
import ch.samt.customers.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerService = new CustomerService(customerRepository);
    }

    @GetMapping("/insert")
    public String loadInsertPage(Model model) {
        model.addAttribute("customer", new Customers());
        return "insertCustomer";
    }
    @PostMapping("/insert")
    public String insertCustomer(@Valid @ModelAttribute("customer") Customers customer, Errors errors) {
        if (errors.hasErrors()) {
            return "insertCustomer";
        }
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }
    @GetMapping("/customers")
    public String loadCustomers(Model model, @RequestParam(value="id", required=false) Long customerId) {
        if (customerId == null) {
            model.addAttribute("customers", customerService.getAllCustomers());
        }
        else {
            model.addAttribute("customers", customerService.getCustomerById(customerId));
        }
        return "customerList";
    }
    @GetMapping("/customersbycity")
    public String loadCustomersByCity(Model model, @RequestParam(value="city", required=false) String city) {
        if (city == null) {
            model.addAttribute("customers", customerService.getAllCustomers());
        }
        else {
            model.addAttribute("customers", customerService.getCustomersByCity(city));
        }
        return "customerList";
    }
}
