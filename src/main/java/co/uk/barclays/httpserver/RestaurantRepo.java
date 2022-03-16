package co.uk.barclays.httpserver;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepo extends JpaRepository<Restaurant, Integer> {
}
