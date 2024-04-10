import java.util.*;

/*
Создайте телефонный справочник с помощью Map - телефон это ключ, а имя значение
Найдите человека с самым маленьким номером телефона
Найдите номер телефона человека чье имя самое большое в алфавитном порядке
 */
public class Task03 {
    public static void main(String[] args) {
        Map<String, String> phonebook = Map.of("88", "Svetlana", "99", "Ivan", "77", "Anna",
                "111", "Ira", "222", "Oleg", "456", "Svetlana", "9987", "Svetlana");
        System.out.println();
        System.out.println(phonebook);
        System.out.println();

        Set<String> phones = phonebook.keySet();
//        String keyMin = Collections.min(phones, (o1, o2) -> o1.compareTo(o2));


        Comparator<String> myComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                if ((o1.length() - o2.length()) == 0) {
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        };

        String keyMin = Collections.min(phones, myComparator);
        System.out.println(phonebook.get(keyMin) + " -> " + keyMin);


        Collection<String> names = phonebook.values();
        String nameMax = Collections.max(names, (o1, o2) -> o1.compareTo(o2));

//        System.out.println("==============");
//        System.out.println(nameMax);
//        System.out.println("==============");

        List<String> namePhones = new ArrayList<>();
        for (var entry : phonebook.entrySet()) {
            if (nameMax.equals(entry.getValue())) {
                namePhones.add(entry.getKey());
            }
        }

        for (String namePhone : namePhones) {
            System.out.println(nameMax + " -> " + namePhone);
        }



    }
}
