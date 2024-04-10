package HWork;

import java.util.*;

public class CreativeUnit {
    private int id; // id сотрудника
    private String name; // имя сотрудника
    private String phoneNumber; // номер телефона сотрудника
    private int experience; // стаж сотрудника
    private ArrayList<String> phonesList; // список телефонов сотрудника
    static private int maxId = 0; // значение максимального id
    static private Map<Integer, CreativeUnit> mapGeneralList = new HashMap<>(); // мапа сотрудников id -> экземпляр
    static private Map<Integer, String> mapNameById = new HashMap<>(); // мапа id -> name
    static private Map<String, String> mapNameByPhone = new HashMap<>(); // мапа phoneNumber -> name
    static private Map<String, Integer> mapIdByName = new HashMap<>(); // мапа id по имени

    public CreativeUnit(String name, int experience) {
        this.id = ++maxId;
        this.name = name;
        this.experience = experience;
        this.phonesList = new ArrayList<String>();

        mapGeneralList.put(this.id, this);
        mapIdByName.put(this.name, this.id);

    }

    /*
    Метод поиска сотрудника по имени
     */
    public static int findIdByName (String name) {
        int result;
        System.out.println();
        result = mapIdByName.getOrDefault(name, 0);
        return result;
    }

    /*
    Метод добавления нового калеки и сотрупника
     */
    public static void addNewbie (String name, int experience) {
         new CreativeUnit(name, experience);
    }
    /*
    Метод поиска сотрудника по табельному номеру
     */
    public static void findById(int id) {
        System.out.println();
        System.out.println("Search for an employee by id: " + id);
        if (mapGeneralList.containsKey(id)) {
            System.out.println(showUnit(mapGeneralList.get(id)));
        } else {
            System.out.println("There is no such id: " + id);
        }
    }

    /*
    Метод вывода имени сотрудника по номеру телефона
    */
    public static void findNameByPhone(String phone) {
        System.out.println();
        System.out.println("Search for an employee by phone number " + phone);
        if (mapNameByPhone.containsKey(phone)) {
            System.out.println("This is phone number of " + mapNameByPhone.get(phone) + ": " + phone);
        } else {
            System.out.println("We don't have an employee with that number"  + ": " + phone);
        }


    }
    /*
    Метод поиска сотрудника по указанному стажу
     */
    public static void findByExperience(int years) {
        int found = 0;
        int exp;
        System.out.println();
        System.out.println("Search for an employee by experience " + years + " years");
        List<CreativeUnit> list = new ArrayList<>();
        for (CreativeUnit unit: mapGeneralList.values()) {
            exp = unit.getExperience();
            if (exp == years) {
                list.add(unit);
            }
        }
        found = list.size();
        if (found != 0) {
            System.out.println("****** They lasted " + years + " years: ****************");
            for (CreativeUnit unit: list) {
                System.out.println(CreativeUnit.showUnit(unit));
            }
        } else {
            System.out.println("There is no such experience, " + years + " years");
        }
    }
    /*
    Метод добавления номера телефона сотруднику
     */
    public static void addPhone(CreativeUnit unit, String phone) {
        unit.phonesList.add(phone);
        mapNameByPhone.put(phone, unit.name);
    }

    /*
    Вывод в консоль списка сотрудников со всеми их характеристиками
     */
    public static void showThemAll() {
        System.out.println("==== The whole herd of madmen: =============");
//        String resultString = "";
        for (CreativeUnit unit: mapGeneralList.values()) {
            System.out.println(showUnit(unit));
        }
//        System.out.println(resultString);
        System.out.println("============================================");
    }

/*
Метод вывода информации о сотруднике в консоль
 */
    public static String showUnit(CreativeUnit unit) {
        String resultString = "";
        resultString += "ID: " + unit.getId() + ", ";
        resultString += "name: " + unit.getName() + ", ";
        resultString += "experience: " + unit.getExperience() + ", " + "\n";
        resultString += "     " + "phone numbers: ";
        for ( String item: unit.phonesList) {
            resultString +=  item + ", ";
        }
        return resultString;
    }

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public ArrayList<String> getPhonesList() {
        return phonesList;
    }

    public void setPhonesList(ArrayList<String> phonesList) {
        this.phonesList = phonesList;
    }

    public static int getMaxId() {
        return maxId;
    }

    public static void setMaxId(int maxId) {
        CreativeUnit.maxId = maxId;
    }

    public static Map<Integer, CreativeUnit> getMapGeneralList() {
        return mapGeneralList;
    }

    public static void setMapGeneralList(Map<Integer, CreativeUnit> mapGeneralList) {
        CreativeUnit.mapGeneralList = mapGeneralList;
    }

//    public static Map<Integer, Integer> getMapExperienceById() {
//        return mapExperienceById;
//    }
//
//    public static void setMapExperienceById(Map<Integer, Integer> mapExperienceById) {
//        CreativeUnit.mapExperienceById = mapExperienceById;
//    }

    public static Map<Integer, String> getMapNameById() {
        return mapNameById;
    }

    public static void setMapNameById(Map<Integer, String> mapNameById) {
        CreativeUnit.mapNameById = mapNameById;
    }
}
