import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Lesson_13 {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<String>(20);
        words.add("Solo");
        words.add("Tea");
        words.add("Cat");
        words.add("Milk");
        words.add("Solo");
        words.add("Bird");
        words.add("One");
        words.add("Milk");
        words.add("Bird");
        words.add("Solo");
        words.add("Coffee");
        words.add("Solo");
        words.add("Milk");
        words.add("Bird");
        words.add("Solo");
        words.add("Solo");
        words.add("Bird");
        words.add("Milk");
        words.add("Cat");
        words.add("Dog");
        ArrayList<String> uniqueWords = new ArrayList<String>();
        boolean flag = true;
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.size(); j++) {
                if (words.get(i).equals(words.get(j)) && i != j) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                uniqueWords.add(words.get(i));
            }
            flag = true;
        }
        for (String s : uniqueWords) {
            System.out.println(s);
        }
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String s : words) {
            if (map.containsKey(s)) {
                map.replace(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        for (Map.Entry<String, Integer> item : map.entrySet()) {
            System.out.println(item.getKey() + " - " + item.getValue());
        }

        TelephoneDirectory telephoneDirectory = new TelephoneDirectory();
        telephoneDirectory.add("Fuchs", "+7325345202");
        telephoneDirectory.add("Kaufman", "+7234234948");
        telephoneDirectory.add("Kaufman", "+7143235566");
        telephoneDirectory.add("Statham", "+7358945452");
        telephoneDirectory.add("Fuchs", "+7368732647");
        ArrayList<String> phones = telephoneDirectory.get("Fuchs");
        for (String phone : phones) {
            System.out.println(phone);
        }
    }
}
