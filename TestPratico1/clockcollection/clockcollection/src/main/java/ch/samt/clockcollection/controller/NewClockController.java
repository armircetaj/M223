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
public class NewClockController {

    static Map<Integer, Clock> clocks = new HashMap<>();

    static {
        clocks.put(1, new Clock(1, "Rolex", "Submariner", 22999.00));
        clocks.put(2, new Clock(2, "Audemars", "Diamond", 131999.00));
        clocks.put(3, new Clock(3, "Rolex", "Speedmaster", 32000.00));
        clocks.put(4, new Clock(4, "Omega", "Precision", 4999.99));
    }

    @GetMapping("/newclocklist")
    public String productList(Model model, @RequestParam(value = "id", required = false) Integer id) {
        {
            List<Clock> result = new ArrayList<>(clocks.values());
            if (id != null) {
                result.removeIf(c -> !(c.getId() == id));
            }

            model.addAttribute("clocks", result);
            return "clockList";
        }
    }
}
