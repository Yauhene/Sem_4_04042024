package HWork;

import static HWork.CreativeUnit.*;
import static HWork.CreativeUnit.findNameByPhone;

public class Start {
    public static void main(String[] args) {
        System.out.println();
        CreativeUnit unit_1 = new CreativeUnit("Stas", 5); // создаем сотрудника
        addPhone(unit_1, "11111"); // присваиваем ему номера телефонов
        addPhone(unit_1, "11122");
        addPhone(unit_1, "11133");

        CreativeUnit unit_2 = new CreativeUnit("Oleg", 3);
        addPhone(unit_2, "21111");
        addPhone(unit_2, "21122");

        CreativeUnit unit_3 = new CreativeUnit("Shapoklak", 25);
        addPhone(unit_3, "31111");

        CreativeUnit unit_4 = new CreativeUnit("Karabas", 15);
        addPhone(unit_4, "41111");

        CreativeUnit unit_5 = new CreativeUnit("Anna", 3);
        addPhone(unit_5, "51111");

        showThemAll(); // вывод в консоль всего списка сотрудников
        findByExperience(3); // вывод в консоль результата поиска по стажу
        findNameByPhone("11133"); // поиск имени сотрудника по номеру телефона
        findById(3); // поиск сотрудника по номеру id

        addNewbie("Buratino", 1); // добавление нового сотрудника
        addPhone(getMapGeneralList().get(findIdByName("Buratino")), "7777777"); // добавляем новичку телефон
        showThemAll(); // вывод в консоль всего списка сотрудников

    }

}
