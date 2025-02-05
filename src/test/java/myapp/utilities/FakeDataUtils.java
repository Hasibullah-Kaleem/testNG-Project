package myapp.utilities;

import com.github.javafaker.Faker;

public class FakeDataUtils {

    private static final Faker faker = new Faker();

    public static String getFakeUsername() {
        return faker.name().username() + faker.number().digits(3);
    }

    public static String getFakeEmail() {
        return faker.internet().emailAddress();
    }

    public static String getFakePassword() {
        return "Test" + faker.number().digits(5) + "!";  // A strong password
    }
}
