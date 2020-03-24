import java.io.File;
import java.io.IOException;

public class TestCountHellos {
    public static void main(String[] args) throws IOException {
        File hello = new File("hello.txt");
        File result = new File("result.txt");
        if(result.exists()){
            result.delete();
            result.createNewFile();
        }
        hello.createNewFile();
        FileHandler.CountHellos(hello, result);
    }

}
