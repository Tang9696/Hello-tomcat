package by.bsu.helltom.util;

import java.util.UUID;

public class RandomUtil {

    public static String main() {
        String randomString = usingUUID();
        System.out.println("Random string of 6 characters is: "
                + randomString.substring(0, 6));
        return randomString.substring(0,6);
    }

    static String usingUUID() {
        UUID randomUUID = UUID.randomUUID();
        return randomUUID.toString().replaceAll("-", "");
    }
}

