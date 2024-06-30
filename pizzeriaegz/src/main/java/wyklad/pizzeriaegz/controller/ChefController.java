package wyklad.pizzeriaegz.controller;

import wyklad.pizzeriaegz.domain.Pizza;
import wyklad.pizzeriaegz.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/chef")
public class ChefController {

    private final PizzaService pizzaService;

    @Autowired
    public ChefController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public String showOrders(Model model) {
        List<Pizza> pizzas = pizzaService.getAllPizzas();
        model.addAttribute("pizzas", pizzas);
        return "chef";
    }

    @PostMapping("/{id}")
    public String deletePizza(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        pizzaService.deletePizzaById(id);
        redirectAttributes.addFlashAttribute("message", "Pizza usunięta pomyślnie");
        return "redirect:/chef";
    }
}
