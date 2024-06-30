package wyklad.pizzeriaegz.service;

import wyklad.pizzeriaegz.domain.Ingredient;
import wyklad.pizzeriaegz.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository; //m
    }

    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    } //Pobieranie skłądników z bazy
}

