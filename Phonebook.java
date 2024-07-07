import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Phonebook {
    private static Map<String, ArrayList<Integer>> phoneBook = new HashMap<>();

    public static void main(String[] args) {
        Phonebook myPhoneBook = new Phonebook();

        Scanner scanner = new Scanner(System.in);
        System.out.printf("Введите имя1: ");
        String newName1 = scanner.next();
        System.out.printf("Введите номер телефона1: ");
        Integer newPhoneNum1 = scanner.nextInt();
        System.out.printf("Введите имя2: ");
        String newName2 = scanner.next();
        System.out.printf("Введите номер телефона2: ");
        Integer newPhoneNum2 = scanner.nextInt();
        System.out.printf("Введите имя3: ");
        String newName3 = scanner.next();
        System.out.printf("Введите номер телефона3: ");
        Integer newPhoneNum3 = scanner.nextInt();
        System.out.printf("Введите имя4: ");
        String newName4 = scanner.next();
        System.out.printf("Введите номер телефона4: ");
        Integer newPhoneNum4 = scanner.nextInt();
        scanner.close();

        myPhoneBook.add(newName1, newPhoneNum1);
        myPhoneBook.add(newName2, newPhoneNum2);
        myPhoneBook.add(newName3, newPhoneNum3);
        myPhoneBook.add(newName4, newPhoneNum4);

        System.out.println(myPhoneBook.find(newName1));
        System.out.println(myPhoneBook.getPhoneBook());
        System.out.println(myPhoneBook.getSortedPhoneBook());
           
    }
    
    // Метод добавляет записи в телефонную книгу
    public void add(String name, Integer phoneNum) {
        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).add(phoneNum);
        } else {
            ArrayList<Integer> values = new ArrayList<>();
            values.add(phoneNum);
            phoneBook.put(name, values);
        }
    }

    // Метод выводит всю телефонную книгу без учета сортировки
    public Map<String, ArrayList<Integer>> getPhoneBook() {
        return phoneBook;
    }

    // Метод выводит номера телефонов определенного абонента
    public ArrayList<Integer> find(String name) {
        if (phoneBook.containsKey(name)) {
            return phoneBook.get(name);
        }
        return new ArrayList<Integer>();
    }
    // Метод выводит отсортированную телефонную книгу
    public Map<String, List<Integer>> getSortedPhoneBook() {
        return phoneBook.entrySet()
                .stream()
                .sorted((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
    }
}
