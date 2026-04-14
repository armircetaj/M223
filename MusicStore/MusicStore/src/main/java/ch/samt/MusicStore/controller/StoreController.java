package ch.samt.MusicStore.controller;

import ch.samt.MusicStore.data.StoreRepository;
import ch.samt.MusicStore.model.Instrument;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;

@Controller
public class StoreController {
    private StoreRepository storeRepository;

    @Autowired
    public StoreController(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @GetMapping("/instruments")
    public String loadInstruments(Model model, @RequestParam(value="type", required=false) String type, @RequestParam(value="brand", required=false) String brand) {
        if(type!=null && !(brand==null)) {
            model.addAttribute("instruments", storeRepository.findByTypeIgnoreCaseAndBrandIgnoreCase(type, brand));
        }
        else if (type==null && brand!=null) {
            model.addAttribute("instruments", storeRepository.findByBrandIgnoreCase(brand));
        }
        else if(type!=null && brand==null) {
            model.addAttribute("instruments", storeRepository.findByTypeIgnoreCase(type));
        }
        else {
            model.addAttribute("instruments", storeRepository.findAll());
        }
        return "instrumentsList";
    }

    @GetMapping("/instruments/{price}")
    public String loadItemsByPrice(Model model, @PathVariable("price") BigDecimal price) {
        model.addAttribute("instrument", storeRepository.findByPriceLessThanEqual(price));
        return "instrumentsList";
    }

    @GetMapping("/instruments/sell/{id}")
    public String sellInstrument(Model model, @PathVariable("id") Long id) {
        Optional<Instrument> optionalInstrument = storeRepository.findById(id);
        if(optionalInstrument.isPresent()) {
            Instrument instrument = optionalInstrument.get();
            if(instrument.getStock() > 1) {
                instrument.setStock(instrument.getStock() - 1);
            }
            storeRepository.save(instrument);
        }
        return "redirect:/instruments";
    }

    @GetMapping("/instruments/add/{id}/{number}")
    public String addInstrument(Model model, @PathVariable("id") Long id, @PathVariable("number") Integer number) {
        Optional<Instrument> optionalInstrument = storeRepository.findById(id);
        if(optionalInstrument.isPresent()) {
            Instrument instrument = optionalInstrument.get();
            instrument.setStock(instrument.getStock() + number);
            storeRepository.save(instrument);
        }
        return "redirect:/instruments";
    }

    @GetMapping("/instruments/insert")
    public String loadInsertPage(Model model) {
        model.addAttribute("instrument", new Instrument());
        return "insertInstrument";
    }
    @PostMapping("/instruments/insert")
    public String insertInstrument(@Valid @ModelAttribute("instrument") Instrument instrument, Errors errors) {
        if (errors.hasErrors()) {
            return "insertInstrument";
        }
        storeRepository.save(instrument);
        return "redirect:/instruments";
    }
}
