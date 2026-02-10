package ch.samt.esercizio2.controller;

import ch.samt.esercizio2.model.Product;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
public class ProductController {

    static Map<Integer, Product> products = new HashMap<>();

    static {
        products.put(1, new Product(1, "Prodotto1", 12.99,
                LocalDate.of(2027, 2, 14), "Prodotto di media qualità"));
        products.put(2, new Product(2, "Prodotto2", 5.99,
                LocalDate.of(2027, 6, 21), "Prodotto di bassa qualità"));
        products.put(3, new Product(3, "Prodotto3", 14.99,
                LocalDate.of(2027, 1, 10), "Prodotto di alta qualità"));
    }

    @GetMapping("/products")
    public String productList(
            Model model,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "pricelessthan", required = false) Double price) {

        List<Product> result = new ArrayList<>(products.values());

        if (name != null) {
            result.removeIf(p -> !p.getName().equals(name));
        }

        if (price != null) {
            result.removeIf(p -> p.getPrice() >= price);
        }

        model.addAttribute("products", result);
        return "productList";
    }

    @GetMapping("/products/show/{id}")
    public String showProduct(Model model, @PathVariable int id) {
        Product product = products.get(id);
        if (product == null) {
            return "redirect:/products";
        }
        else {
            model.addAttribute("product", product);
            return "showProduct";
        }
    }

    @GetMapping("/newproduct")
    public String newProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "newProductPage";
    }

    @PostMapping("/newproduct")
    public String newProduct(@Valid @ModelAttribute("product") Product product, Errors errors) {
        if (errors.hasErrors()) {
            return "newProductPage";
        }
        products.put(product.getId(), product);
        return "redirect:/products";
    }
}
