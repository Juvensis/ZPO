package wyklad.pizzeriaegz.service;

import wyklad.pizzeriaegz.domain.Pizza;
import wyklad.pizzeriaegz.domain.Size;
import wyklad.pizzeriaegz.domain.Ingredient;
import wyklad.pizzeriaegz.repository.PizzaRepository;
import wyklad.pizzeriaegz.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PizzaService {

    private final PizzaRepository pizzaRepository;
    private final IngredientRepository ingredientRepository;

    @Autowired
    public PizzaService(PizzaRepository pizzaRepository, IngredientRepository ingredientRepository) {
        this.pizzaRepository = pizzaRepository;
        this.ingredientRepository = ingredientRepository;
    }

    public List<Pizza> getAllPizzas() { //Pobiera pizze z bazy
        return pizzaRepository.findAll();
    }

    public void createPizza(Size size, List<Long> ingredientIds, String customer) {
        Pizza pizza = new Pizza();
        pizza.setSize(size);
        pizza.setCustomer(customer);
        pizza.setTimestamp(new Timestamp(System.currentTimeMillis()));

        List<Ingredient> ingredients = ingredientRepository.findAllById(ingredientIds);
        pizza.setIngredients(ingredients);

        pizzaRepository.save(pizza);
    }

    public void deletePizzaById(Long id) {
        pizzaRepository.deleteById(id);
    }
}