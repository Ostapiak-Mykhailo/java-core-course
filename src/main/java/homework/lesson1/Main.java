package homework.lesson1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Table> tables = new ArrayList<>();
        Restaurant restaurant = new Restaurant(tables);
        restaurant.doOption();
    }
}
