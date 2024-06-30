package wyklad.pizzeriaegz;

import wyklad.pizzeriaegz.domain.Ingredient;
import wyklad.pizzeriaegz.repository.IngredientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(IngredientRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.save(new Ingredient("Ser", 1.50));
                repository.save(new Ingredient("Salami", 5.50));
                repository.save(new Ingredient("Bazylia", 0.50));
                repository.save(new Ingredient("Oregano", 0.50));
                repository.save(new Ingredient("Kukurydza", 1.50));
                repository.save(new Ingredient("Pieczarki", 1.00));
                repository.save(new Ingredient("Frytki", 8.00));
                repository.save(new Ingredient("Cebula", 0.50));
                repository.save(new Ingredient("Szynka", 3.00));
                repository.save(new Ingredient("Rukola", 2.00));
                repository.save(new Ingredient("Papryczki Jalapeno", 5.00));
                repository.save(new Ingredient("Papryka czerwona", 1.50));
                repository.save(new Ingredient("Sycylijska", 28.50));
                repository.save(new Ingredient("Rzymska", 35.00));
                repository.save(new Ingredient("Bianca", 22.00));
                repository.save(new Ingredient("Caprese", 25.00));
            }
        };
    }
}

