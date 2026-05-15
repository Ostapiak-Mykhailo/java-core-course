package homework.lesson3.additionalTask;

import java.io.IOException;
import java.util.List;

public class ShopController {

    private final ShopView view;
    List<Product> hygienes;
    List<Product> households;
    List<Product> foods;
    private final List<Product> myShoppingList;

    public ShopController(ShopView view, List<Product> hygienes, List<Product> households, List<Product> foods,
                          List<Product> myShoppingList) {
        this.view = view;
        this.hygienes = hygienes;
        this.households = households;
        this.foods = foods;
        this.myShoppingList = myShoppingList;
    }

    public void shopRun() throws IOException {
        view.greetCustomer();
        boolean shopIsOpen = true;
        while (shopIsOpen) {
            selectDepartment();
            System.out.println("Enter 'quit' to exit the shop or press Enter to continue:");
            String str = view.getInput();
            if (str.equals("quit")) {
                shopIsOpen = false;
            }
        }
        printCheck();
    }

    private void selectDepartment() throws IOException {
        System.out.println("Choose department: Household, Hygiene or Food");
        DepartmentType department = view.selectDepartment();
        switch (department) {
            case FOOD -> showFoodProductList(foods);
            case HYGIENE -> showHygieneProductList(hygienes);
            case HOUSEHOLD -> showHouseholdProductList(households);
        }
    }

    public void showFoodProductList(List<Product> foods) throws IOException {
        System.out.println("Now you can see the product list from Food department. Enter the products you would " +
                "like to choose and enter `stop` to quite");
        for (Product product : foods) {
            System.out.println(product.toString());
        }
        String input;
        while (!(input = view.getInput()).equals("stop")) {
            boolean isFound = false;
            for (Product product : foods) {
                if (product.getName().equals(input)) {
                    myShoppingList.add(product);
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                System.out.println("Invalid input");
            }
        }
    }

    public void showHouseholdProductList(List<Product> households) throws IOException {
        System.out.println("Now you can see the product list from Household department. Enter the products you would " +
                "like to choose and enter `stop` to quite");
        for (Product product : households) {
            System.out.println(product.toString());
        }
        String input;
        while (!(input = view.getInput()).equals("stop")) {
            boolean isFound = false;
            for (Product product : households) {
                if (product.getName().equals(input)) {
                    myShoppingList.add(product);
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                System.out.println("Invalid input");
            }
        }
    }

    public void showHygieneProductList(List<Product> hygienes) throws IOException {
        System.out.println("Now you can see the product list from Hygiene department. Enter the products you would " +
                "like to choose and enter `stop` to quite");
        for (Product product : hygienes) {
            System.out.println(product.toString());
        }
        String input;
        while (!(input = view.getInput()).equals("stop")) {
            boolean isFound = false;
            for (Product product : hygienes) {
                if (product.getName().equals(input)) {
                    myShoppingList.add(product);
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                System.out.println("Invalid input");
            }
        }
    }

    private void printCheck() throws IOException {
        double total = 0;
        double household = 0;
        double hygiene = 0;
        double food = 0;
        for (Product product : myShoppingList) {
            total += product.getPrice();
            if (product instanceof Food) {
                food += product.getPrice();
            } else if (product instanceof Household) {
                household += product.getPrice();
            } else if (product instanceof Hygiene) {
                hygiene += product.getPrice();
            }
        }
        System.out.println("Enter promo code");
        String code = view.getInput();
        if (!(code.equals("nullpointer"))) {
            String check = "Amount of expenses: " + "\n" +
                    "For FOOD products = " + food + "\n" +
                    "For HOUSEHOLD products = " + household + "\n" +
                    "For HYGIENE products = " + hygiene + "\n" +
                    "discount = not used" + "\n" +
                    "TOTAL = " + total;
            System.out.println(check);
        } else {
            String check = "Amount of expenses: " + "\n" +
                    "For FOOD products = " + food + "\n" +
                    "For HOUSEHOLD products = " + household + "\n" +
                    "For HYGIENE products = " + hygiene + "\n" +
                    "discount = " + (total * 0.15) + "\n" +
                    "TOTAL = " + (total - (total * 0.15));
            System.out.println(check);
        }

    }
}
