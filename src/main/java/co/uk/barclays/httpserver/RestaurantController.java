package co.uk.barclays.httpserver;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {
    private RestaurantRepo repository;

    public RestaurantController(RestaurantRepo repository) {
        this.repository = repository;

    }

    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurants() {
        return this.repository.findAll();
    }

    @PostMapping("/restaurants")
    public Restaurant createRestaurant(@RequestBody Restaurant newRestaurant) {
        return repository.save(newRestaurant);

    }

    @GetMapping("/restaurants/{id}")
    public Restaurant getOne(@PathVariable Integer id) {
        return repository.findById(id).get();
    }

    @PutMapping("/restaurants/{id}")
    public Restaurant updateOne(@PathVariable Integer id, @RequestBody Restaurant restaurantUpdate) {
        return repository.findById(id).map(restaurant -> {
            restaurant.setName(restaurantUpdate.getName());
            restaurant.setImageURL(restaurantUpdate.getImageURL());
            return repository.save(restaurant);
        }).orElseThrow();
    }

    @DeleteMapping("/restaurants/{id}")
    public void deleteOne(@PathVariable Integer id) {
        repository.deleteById(id);
    }

}
