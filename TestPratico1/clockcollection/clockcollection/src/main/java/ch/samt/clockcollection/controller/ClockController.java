package ch.samt.clockcollection.controller;

import ch.samt.clockcollection.model.Clock;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ClockController {

    static ArrayList<Clock> clocks = new ArrayList<>();

    static {
        clocks.add(new Clock(1, "Rolex", "Submariner", 22999.00));
        clocks.add(new Clock(2, "Audemars", "Diamond", 131999.00));
        clocks.add(new Clock(3, "Rolex", "Speedmaster", 32000.00));
        clocks.add(new Clock(4, "Omega", "Precision", 4999.99));
    }

    @GetMapping("/clocks")
    public String name(Model model) {
        model.addAttribute("name", "Armir");
        return "clock";
    }

    @GetMapping("/clocks/list")
    public String productList(Model model, @RequestParam(value = "id", required = false) Integer id) {
        {
            List<Clock> result = new ArrayList<>(clocks);
            if (id != null) {
                result.removeIf(c -> !(c.getId() == id));
            }

            model.addAttribute("clocks", result);
            return "clockList";
        }
    }

    @GetMapping("/clocks/{brand}")
    public String brand(Model model, @PathVariable String brand) {
        List<Clock> result = new ArrayList<>(clocks);
        if (brand != null) {
            result.removeIf(c -> !(c.getBrand().toLowerCase().equals(brand)));
        }
        model.addAttribute("clocks", result);
        return "clockList";
    }

    @GetMapping("/clocks/add")
    public String addClockForm(Model model) {
        model.addAttribute("clock", new Clock());
        return "clockAdd";
    }

    @PostMapping("/clocks/add")
    public String addClock(@Valid @ModelAttribute("clock") Clock clock, Errors errors) {
        if (errors.hasErrors()) {
            return "clockAdd";
        }
        clocks.add(clock);
        return "redirect:/clocks/list";
    }
}
