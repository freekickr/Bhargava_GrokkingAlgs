package V_HashTables;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private static final Map<String, Integer> phoneBook = new HashMap<>();

    public static void main(String[] args) {
        phoneBook.put("jenny", 8675309);
        phoneBook.put("emergency", 911);

        System.out.println(phoneBook.get("jenny"));
        System.out.println(phoneBook.get("daddy"));
    }
}
