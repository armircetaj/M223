package ch.samt.customers.controller;

import ch.samt.customers.model.Customers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequestMapping("/customers")
@Controller
public class CustomerController {

    private final List<Customers> customers = new ArrayList<>(
            Arrays.asList(
                    new Customers(1L, "Mario", "Rossi", 40),
                    new Customers(2L, "Giorgio", "Verdi", 30),
                    new Customers(3L, "Ennio", "Bianchi", 33)
            ));

    @GetMapping("/insert")
    public String loadInsertPage(@ModelAttribute Customers customer) {
        return "insertCustomer";
    }
    @PostMapping("/insert")
    public String insertCustomer(@ModelAttribute Customers customer, Model model) {
        customers.add(customer);
        model.addAttribute("customers", customers);
        return "customerList";
    }
    @GetMapping("/customers")
    public String loadCustomers(Model model, @RequestParam(value="id", required=false) Long customerId) {
        if (customerId == null) {
            model.addAttribute("customers", customers);
        }
        else {
            Customers costumer = customers.stream()
                    .filter(c -> c.getId().equals(customerId))
                    .findFirst().orElse(null);
            model.addAttribute("customer", customer);
        }
        return "customerList";
    }
}
