package principles;

import java.util.Date;
import java.util.Optional;

public class Strings {

    static String test = "This is a test";

    public static void main(String[] args) {
        Optional<String> test = Optional.empty();
        Date date = new Date();

        System.out.println(date.toString());

    }

}


