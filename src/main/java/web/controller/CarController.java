package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

@Controller
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String getAll(@RequestParam(value = "count", required = false) Integer carAmount, Model model) {
        if(carAmount != null) {
            model.addAttribute("cars", carService.findCars(carAmount));
        } else {
            model.addAttribute("cars", carService.findCars());
        }
        return "cars";
    }
}
