package helpers;

import java.util.List;
import java.util.Random;

public class Methods {
    public static int returnRandomIndex(List<String> list) {
        Random random = new Random();
        return random.nextInt(list.size());
    }

    public static String returnItemByIndex(List<String> list, int index) {
        return list.get(index);
    }
}
