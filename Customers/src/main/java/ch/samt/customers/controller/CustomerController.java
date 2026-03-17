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
                    new Customers(1L, "Mario", "Rossi", 40, "Figino", "4868 7191 9682 9038", "12/28", "223"),
                    new Customers(2L, "Giorgio", "Verdi", 30, "Lugano", "6495 0300 1886 8352", "18/27", "432"),
                    new Customers(3L, "Ennio", "Bianchi", 33, "Bellinzona", "4868719158130060", "07/28", "178")
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
            Customers customer = customers.stream()
                    .filter(c -> c.getId().equals(customerId))
                    .findFirst().orElse(null);
            model.addAttribute("customer", customer);
        }
        return "customerList";
    }
}
