package coding.kyla;

import lombok.Setter;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Test {
    static class Person {
        final int id;

        final String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public int hashCode() {
            int result = id;
            result = 31 * name.hashCode();
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj) return true;
            Person o = (Person) obj;
            if(this.id == o.id && this.name.equals(o.name)) return true;
            return false;
        }
    }

    private static Person[] RAW_DATA = new Person[]{
            new Person(0, "Harry"),
            new Person(0, "Harry"),
            new Person(1, "Harry"),
            new Person(2, "Harry"),
            new Person(3, "Emily"),
            new Person(4, "Jack"),
            new Person(4, "Jack"),
            new Person(5, "Amelia"),
            new Person(5, "Amelia"),
            new Person(6, "Amelia"),
            new Person(7, "Amelia"),
            new Person(8, "Amelia"),
    };

    public static Set<Person> process(Person[] data){
        Set<Person> noDuplicates = Arrays.stream(RAW_DATA).distinct().collect(Collectors.toSet());
        return noDuplicates;
    }

    /*
    id, name,
        0 - Harry
        0 - Harry
        1 - Harry
        2 - Harry
        3 - Emily
        4 - Jack
        4 - Jack
        5 - Amelia
        5 - Amelia
        6 - Amelia
        7 - Amelia
        8 - Amelia

Please write code which will return unique sorted structure by name and id with number of record in group with the same name
        **************************************************

        0 - Harry (1)
        1 - Harry (2)
        2 - Harry (3)
        3 - Emily (1)
        4 - Jack (1)
        5 - Amelia (1)
        6 - Amelia (2)
        7 - Amelia (3)
        8 - Amelia (4)



     */
    public static void main(String[] args) {
        Set<Person> list = process(RAW_DATA);
        String name = null;
        int counter = 0;
        for (Person person : list) {
            if(name == null) name = person.name;
            if(person.name.equals(name)){
                counter++;
            }else{
                name = person.name;
                counter = 1;
            }
            System.out.println(person.id + " - " + person.name + " (" + counter +")");
        }

        System.out.println();
        System.out.println("**************************************************");
        System.out.println();


    }
}
