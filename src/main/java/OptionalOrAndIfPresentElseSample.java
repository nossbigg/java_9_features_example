import java.util.Optional;

public class OptionalOrAndIfPresentElseSample {

    public static void main(String[] args) {
        Person johnWinstonDoe = new Person("John", "Winston", "Doe");
        Person winstonDoe = new Person(null, "Winston", "Doe");
        Person winston = new Person(null, "Winston", null);

        System.out.println("Optional Way");
        System.out.println(getAvailableName(johnWinstonDoe));
        System.out.println(getAvailableName(winstonDoe));
        System.out.println(getAvailableName(winston));

        displayFirstNameOrDisplayNotFound(johnWinstonDoe);
        displayFirstNameOrDisplayNotFound(winstonDoe);

        System.out.println();
        System.out.println("Non-Optional Way");
        System.out.println(getAvailableNameNonOptionalWay(johnWinstonDoe));
        System.out.println(getAvailableNameNonOptionalWay(winstonDoe));
        System.out.println(getAvailableNameNonOptionalWay(winston));

        displayFirstNameOrDisplayNotFoundNonOptionalWay(johnWinstonDoe);
        displayFirstNameOrDisplayNotFoundNonOptionalWay(winstonDoe);
    }

    private static void displayFirstNameOrDisplayNotFound(Person person) {
        Optional.ofNullable(person.getFirstName())
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("First name not found"));
    }

    private static void displayFirstNameOrDisplayNotFoundNonOptionalWay(Person person) {
        String firstName = person.getFirstName();
        if(firstName !=null){
            System.out.println(person.getFirstName());
            return;
        }

        System.out.println("First name not found");
    }

    private static String getAvailableName(Person person) {
        Optional<String> availableName =
                Optional.ofNullable(person.getFirstName())
                        .or(() -> Optional.ofNullable(person.getLastName()))
                        .or(() -> Optional.ofNullable(person.getMiddleName()));

        return availableName.get();
    }

    private static String getAvailableNameNonOptionalWay(Person person){
        if(person.getFirstName()!=null){
            return person.getFirstName();
        }

        if(person.getLastName()!=null){
            return person.getLastName();
        }

        return person.getMiddleName();
    }

}
