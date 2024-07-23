package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.config.models.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {

    @GetMapping(value = "/cars")
    public String printWelcome(ModelMap model, @RequestParam(value = "count", defaultValue = "5") Integer count) {
        List<Car> cars = getCars();
        if (count < 0) {
            count = 0;
        }
        if(count > cars.size()) {
            count = cars.size();
        }
        model.addAttribute("cars", cars.subList(0, count));
        return "cars";
    }

    public List<Car> getCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("BMW", "Black", 1));
        cars.add(new Car("Mercedes", "White", 2));
        cars.add(new Car("Audi", "Red", 3));
        cars.add(new Car("Toyota", "Blue", 4));
        cars.add(new Car("Nissan", "Green", 5));
        return cars;
    }
}
