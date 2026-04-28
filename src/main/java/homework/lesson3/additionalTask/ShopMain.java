package homework.lesson3.additionalTask;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/*
Магазин товарів з 3 відділами. Зайдіть у відділ ввівши в консоль його назву.
Введіть stop щоб вийти з відділу. Введіть quit для завершення покупок і виходу з магазину.
Не забудьте про промокод nullpointer який дасть знижку 15%
 */

public class ShopMain {

    public static void main(String[] args) throws IOException {

        List<Product> hygienes = new ArrayList<>();
        List<Product> households = new ArrayList<>();
        List<Product> foods = new ArrayList<>();
        List<Product> myShoppingList = new ArrayList<>();

        foods.add(new Food(45, "bread"));
        foods.add(new Food(50, "milk"));
        foods.add(new Food(20, "eggs"));
        foods.add(new Food(145, "cheese"));
        foods.add(new Food(245, "chicken"));
        foods.add(new Food(55, "apples"));
        foods.add(new Food(90, "rice"));
        foods.add(new Food(170, "pasta"));
        foods.add(new Food(65, "yogurt"));
        foods.add(new Food(45, "butter"));

        households.add(new Household(85, "detergent"));
        households.add(new Household(125, "disinfectant"));
        households.add(new Household(65, "cleaning spray"));
        households.add(new Household(15, "sponge"));
        households.add(new Household(40, "trash bags"));
        households.add(new Household(50, "paper towels"));
        households.add(new Household(100, "bleach"));
        households.add(new Household(85, "dish soap"));
        households.add(new Household(70, "microfiber cloth"));
        households.add(new Household(140, "glass cleaner"));

        hygienes.add(new Hygiene(90, "toothpaste"));
        hygienes.add(new Hygiene(260, "shampoo"));
        hygienes.add(new Hygiene(95, "soap"));
        hygienes.add(new Hygiene(175, "deodorant"));
        hygienes.add(new Hygiene(290, "shower gel"));
        hygienes.add(new Hygiene(10, "toilet paper"));
        hygienes.add(new Hygiene(45, "wet wipes"));
        hygienes.add(new Hygiene(105, "mouthwash"));
        hygienes.add(new Hygiene(160, "hand sanitizer"));
        hygienes.add(new Hygiene(90, "razor"));

        ShopView view = new ShopView();
        ShopController controller = new ShopController(view, hygienes, households, foods, myShoppingList);
        controller.shopRun();
    }
}
