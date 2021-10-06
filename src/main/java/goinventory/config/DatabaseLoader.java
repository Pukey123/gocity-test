package goinventory.config;

import com.google.common.collect.Lists;
import goinventory.domain.Category;
import goinventory.domain.Product;
import goinventory.persistance.CategoryRepository;
import goinventory.persistance.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * @author Alex created 06/10/2021
 **/
@Component
public class DatabaseLoader implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public DatabaseLoader(final ProductRepository productRepository, final CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public void run(final String... args) throws Exception {
        Category kitchen = createCategory("Kitchen");
        Category powerTools = createCategory("Power Tools");
        Category furniture = createCategory("Furniture");
        Category electric = createCategory("Electric");
        Category washroom = createCategory("Washroom");
        Category textiles = createCategory("Textiles");
        Category misc = createCategory("Misc.");

        categoryRepository.saveAll(Lists.newArrayList(
                kitchen, powerTools, furniture, electric, washroom, textiles, misc
        ));

        ArrayList<Product> products = Lists.newArrayList(
                createProduct(kitchen, "Knife Set", "A set of knives in all shapes and sizes.", LocalDateTime.now(),
                        LocalDateTime.now(), LocalDateTime.now()),
                createProduct(kitchen, "Plate Rack", "A storage solution for plates.", LocalDateTime.now(),
                        LocalDateTime.now(), LocalDateTime.now()),
                createProduct(kitchen, "Microwave", "Cook food quick with this handy microwave.", LocalDateTime.now()
                        , LocalDateTime.now(), LocalDateTime.now()),
                createProduct(kitchen, "Juicer", "When life gives you lemons, make lemonade.", LocalDateTime.now(),
                        LocalDateTime.now(), LocalDateTime.now()),
                createProduct(kitchen, "Meat Hooks", "A butchers meat hook.", LocalDateTime.now(),
                        LocalDateTime.now(), LocalDateTime.now()),
                createProduct(kitchen, "Cabinet Knobs", "Make sure you can open your cabinets.", LocalDateTime.now(),
                        LocalDateTime.now(), LocalDateTime.now()),
                createProduct(kitchen, "Frying Pans", "Cook up a storm with this non stick frying pan.",
                        LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now()),
                createProduct(kitchen, "Power Drill", "A drill, but with an electric motor.", LocalDateTime.now(),
                        LocalDateTime.now(), LocalDateTime.now()),
                createProduct(kitchen, "Jack Hammer", "Demolish old concrete and removing pavement, it does it all1",
                        LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now()),
                createProduct(kitchen, "Table Saw", "A saw ideal for table top use.", LocalDateTime.now(),
                        LocalDateTime.now(), LocalDateTime.now()),
                createProduct(kitchen, "Sander", "Get that smooth finish you've been craving.", LocalDateTime.now(),
                        LocalDateTime.now(), LocalDateTime.now()),
                createProduct(kitchen, "Circular Saw", "Its a saw, but circular.", LocalDateTime.now(),
                        LocalDateTime.now(), LocalDateTime.now()),
                createProduct(kitchen, "Diamond Core", "Cut some really big holes in some really tough materials with" +
                        " this solid drill bit.", LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now()),
                createProduct(kitchen, "Paddle Mixer", "Mix just about anything with this paddle mixer.",
                        LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now()),
                createProduct(kitchen, "Sofas", "Sofas galore, they're super soft and comfortable.",
                        LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now()),
                createProduct(kitchen, "Coffee Tables", "Keep your coffee safe and stick it on one of these tables.",
                        LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now()),
                createProduct(kitchen, "Monoblocks", "Lovely paving slabs which look great anywhere!",
                        LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now()),
                createProduct(kitchen, "Footstool", "Pop your feet up, you've earned it.", LocalDateTime.now(),
                        LocalDateTime.now(), LocalDateTime.now()),
                createProduct(kitchen, "Armchair", "Its a chair, but for you arms.", LocalDateTime.now(),
                        LocalDateTime.now(), LocalDateTime.now()),
                createProduct(kitchen, "5 Chest Drawer", "So many drawers.", LocalDateTime.now(), LocalDateTime.now()
                        , LocalDateTime.now()),
                createProduct(kitchen, "3 Chest Drawer", "Not so many drawers.", LocalDateTime.now(),
                        LocalDateTime.now(), LocalDateTime.now()),
                createProduct(kitchen, "Copper Wiring (10m)", "A big ol' spindle of copper wiring.",
                        LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now()),
                createProduct(kitchen, "Wire Strippers", "Strip wire easily, with wire strippers.",
                        LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now()),
                createProduct(kitchen, "Torch", "Shine on.", LocalDateTime.now(), LocalDateTime.now(),
                        LocalDateTime.now()),
                createProduct(kitchen, "Cable Knife", "Cut cables, with a cable knife.", LocalDateTime.now(),
                        LocalDateTime.now(), LocalDateTime.now()),
                createProduct(kitchen, "Insulated Screwdrivers", "Toasty screwdrivers.", LocalDateTime.now(),
                        LocalDateTime.now(), LocalDateTime.now()),
                createProduct(kitchen, "Light Bulb", "What a great idea.", LocalDateTime.now(), LocalDateTime.now(),
                        LocalDateTime.now()),
                createProduct(kitchen, "Batteries", "They last a really really long time.", LocalDateTime.now(),
                        LocalDateTime.now(), LocalDateTime.now()),
                createProduct(kitchen, "Hand Towel", "Towels for your hands.", LocalDateTime.now(),
                        LocalDateTime.now(), LocalDateTime.now()),
                createProduct(kitchen, "Face Towel", "Towels for you face.", LocalDateTime.now(), LocalDateTime.now()
                        , LocalDateTime.now()),
                createProduct(kitchen, "Toilet Seats", "Seats for your toilet.", LocalDateTime.now(),
                        LocalDateTime.now(), LocalDateTime.now()),
                createProduct(kitchen, "Shower Head", "Heads for your shower.", LocalDateTime.now(),
                        LocalDateTime.now(), LocalDateTime.now()),
                createProduct(kitchen, "Drain Plug", "A high quality drain plug.", LocalDateTime.now(),
                        LocalDateTime.now(), LocalDateTime.now()),
                createProduct(kitchen, "Towel Rack", "Hang your towels here.", LocalDateTime.now(),
                        LocalDateTime.now(), LocalDateTime.now())
        );
        productRepository.saveAll(products);
    }

    private Product createProduct(final Category kitchen, final String name, final String description,
                                  final LocalDateTime creationDate, final LocalDateTime updateDate,
                                  final LocalDateTime lastPurchasedDate) {
        Product s = new Product();
        s.setName(name);
        s.setDescription(description);
        s.setCategoryId(kitchen);
        s.setCreationDate(creationDate);
        s.setUpdateDate(updateDate);
        s.setLastPurchasedDate(lastPurchasedDate);
        return s;
    }

    private Category createCategory(final String name) {
        Category category = new Category();
        category.setName(name);
        return category;
    }


}
