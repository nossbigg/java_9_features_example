import java.io.*;

public class TryWithResourcesSample {

    public static void main(String[] args) throws FileNotFoundException {
        File sampleTextFile = new File("src/main/resources/sampleText.txt");
        File anotherSampleTextFile = new File("src/main/resources/anotherSampleText.txt");

        readFilesUsingTryWithResourcesJava9(sampleTextFile, anotherSampleTextFile);
        readFilesUsingTryWithResourcesJava7(sampleTextFile, anotherSampleTextFile);
        readFilesUsingTryWithResourcesJava6(sampleTextFile, anotherSampleTextFile);
    }

    private static void readFilesUsingTryWithResourcesJava9(File file1, File file2) throws FileNotFoundException {
        BufferedReader reader1 = new BufferedReader(new FileReader(file1));
        final BufferedReader reader2 = new BufferedReader(new FileReader(file2));

        try (
                reader1; reader2;
                SampleAutoCloseable sampleAutoCloseable = new SampleAutoCloseable()
        ) {
            System.out.println(reader1.readLine());
            System.out.println(reader2.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void readFilesUsingTryWithResourcesJava7(File file1, File file2) {
        try (
                BufferedReader reader1 = new BufferedReader(new FileReader(file1));
                BufferedReader reader2 = new BufferedReader(new FileReader(file2))
        ) {
            System.out.println(reader1.readLine());
            System.out.println(reader2.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFilesUsingTryWithResourcesJava6(File file1, File file2) {
        BufferedReader reader1 = null;
        BufferedReader reader2 = null;

        try {
            reader1 = new BufferedReader(new FileReader(file1));
            reader2 = new BufferedReader(new FileReader(file2));

            System.out.println(reader1.readLine());
            System.out.println(reader2.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader1.close();
                reader2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
