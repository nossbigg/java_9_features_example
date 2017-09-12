import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalStreamSample {

    public static void main(String[] args) {
        List<Optional<Person>> listOfOptionalPerson = getListOfOptionalPerson();

        printFirstNamesInJava8Way(listOfOptionalPerson);
        System.out.println();
        printFirstNamesInJava9Way(listOfOptionalPerson);
    }

    private static void printFirstNamesInJava9Way(List<Optional<Person>> listOfOptionalPerson) {
        List<String> firstNames = listOfOptionalPerson.stream()
                .flatMap(Optional::stream)
                .map(Person::getFirstName)
                .collect(Collectors.toList());

        firstNames.forEach(System.out::println);
    }

    private static void printFirstNamesInJava8Way(List<Optional<Person>> listOfOptionalPerson) {
        List<String> firstNames = listOfOptionalPerson.stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(Person::getFirstName)
                .collect(Collectors.toList());

        firstNames.forEach(System.out::println);
    }

    private static List<Optional<Person>> getListOfOptionalPerson() {
        List<Optional<Person>> result = new ArrayList<>();

        result.add(Optional.of(new Person("John", "", "Doe")));
        result.add(Optional.empty());
        result.add(Optional.of(new Person("Alice", "", "Peters")));

        return result;
    }

}
