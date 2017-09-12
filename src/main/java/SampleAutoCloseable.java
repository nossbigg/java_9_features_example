public class SampleAutoCloseable implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("SampleAutoCloseable: close() called");
    }

}
