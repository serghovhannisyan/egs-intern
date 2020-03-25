import java.io.File;
import java.io.IOException;

public class TestCountHellos {
    private static final String INPUT_FILENAME = "hello.txt";
    private static  final String RESULT_FILENAME = "result.txt";
    public static void main(String[] args) throws IOException {
        File hello = new File(INPUT_FILENAME);
        File result = new File(RESULT_FILENAME);
        if(result.exists()){
            result.delete();
        }
        FileHandler.countHellos(hello, result);
    }

}
