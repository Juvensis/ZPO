package wyklad.pizzeriaegz.repository;

import wyklad.pizzeriaegz.domain.Pizza;
import org.springframework.data.jpa.repository.JpaRepository; //create delete
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}
