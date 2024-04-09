import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Создайте коллекцию мужских и женских имен с помощью интерфейса List
Отсортируйте коллекцию в алфавитном порядке
Отсортируйте коллекцию по количеству букв в слове
Разверните коллекцию
 */
public class Task01 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ivan", "Anna", "Ira", "Svetlana", "Valentin", "Alexey");
        System.out.println(names);

        Collections.sort(names);
        System.out.println(names);

        Collections.sort(names, (o1, o2) -> o1.length() - o2.length());
        System.out.println(names);

        Collections.reverse(names);
        System.out.println(names);
        System.out.println("---".repeat(10));

        names.sort(Comparator.comparingInt(String::length));
        System.out.println(names);
    }
}
