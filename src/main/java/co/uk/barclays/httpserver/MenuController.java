package co.uk.barclays.httpserver;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {
    private MenuRepo repo;
    private RestaurantRepo restaurantRepo;

    public MenuController(MenuRepo repo, RestaurantRepo restaurantRepo) {
        this.repo = repo;
        this.restaurantRepo = restaurantRepo;
    }

    @PostMapping("/restaurants/{restaurant_id}/menus")
    public Menu addMenu(@RequestBody Menu menuData, @PathVariable Integer restaurant_id) {
        Restaurant restaurant = restaurantRepo.findById(restaurant_id).get();
        menuData.setRestaurant(restaurant);
        return repo.save(menuData);
    }

}
