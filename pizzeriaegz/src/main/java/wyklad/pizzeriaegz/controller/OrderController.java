package wyklad.pizzeriaegz.controller;

import wyklad.pizzeriaegz.domain.Ingredient;
import wyklad.pizzeriaegz.domain.Pizza;
import wyklad.pizzeriaegz.domain.Size;
import wyklad.pizzeriaegz.service.PizzaService;
import wyklad.pizzeriaegz.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    private final IngredientService ingredientService;
    private final PizzaService pizzaService;

    @Autowired
    public OrderController(IngredientService ingredientService, PizzaService pizzaService) {
        this.ingredientService = ingredientService;
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public String showOrderForm(Model model) {
        model.addAttribute("pizza", new Pizza());
        model.addAttribute("allIngredients", ingredientService.getAllIngredients());
        model.addAttribute("pizzaSizes", Size.values());
        List<Ingredient> ingredients = ingredientService.getAllIngredients();
        model.addAttribute("ingredients", ingredients);
        return "order";
    }

    @PostMapping
    public String createPizza(@RequestParam Size size, @RequestParam List<Long> ingredientIds, @RequestParam String customer) {
        pizzaService.createPizza(size, ingredientIds, customer);
        return "redirect:/order";
    }
}
