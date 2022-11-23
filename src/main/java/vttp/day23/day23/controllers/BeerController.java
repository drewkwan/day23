package vttp.day23.day23.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vttp.day23.day23.models.Brewery;
import vttp.day23.day23.models.Style;
import vttp.day23.day23.repositories.BeerRepository;

@Controller
@RequestMapping
public class BeerController {

    @Autowired
    private BeerRepository beerRepo;

    @GetMapping
    public String getHome(Model model) {

        List<Style> styles = beerRepo.getStyles();
        model.addAttribute("styles", styles);
        return "index";
    }

    @GetMapping("/breweries")
    public String getBreweries(@RequestParam Integer id, Model model) {
        // String id = form.getFirst("style");
        System.out.println(id);
        List<Brewery> breweries = beerRepo.getBreweries(id);
        model.addAttribute("breweries", breweries);
        return "breweries";
    }


    
}
