import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionsFactoryHelperMethodsSample {

    public static void main(String[] args) {
        int[] listOfInts = {1, 2, 3};

        getListOfIntegersInJava9Way();
        getListOfIntegersInJava8Way(listOfInts);
        getListOfIntegersInJava7Way(listOfInts);
        getListOfIntegersInJava6Way(listOfInts);
        getListOfIntegersInJava4Way(listOfInts);
    }

    private static List<Integer> getListOfIntegersInJava9Way() {
        return new ArrayList<>(List.of(1, 2, 3));
    }

    private static List<Integer> getListOfIntegersInJava8Way(int[] listOfInts) {
        return IntStream.of(listOfInts)
                .boxed()
                .collect(Collectors.toList());
    }

    private static List<Integer> getListOfIntegersInJava7Way(int[] listOfInts) {
        List<Integer> result = new ArrayList<>();
        for (int number : listOfInts) {
            result.add(number);
        }

        return result;
    }

    private static List<Integer> getListOfIntegersInJava6Way(int[] listOfInts) {
        List<Integer> result = new ArrayList<Integer>();
        for (int number : listOfInts) {
            result.add(number);
        }

        return result;
    }

    private static List getListOfIntegersInJava4Way(int[] listOfInts) {
        List result = new ArrayList();
        for (int index = 0; index < listOfInts.length; index++) {
            result.add(listOfInts[index]);
        }

        return result;
    }

}
