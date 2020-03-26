import java.io.*;

public class FileHandler {
    public static void countHellos(File in, File out){
        try(BufferedReader reader = new BufferedReader(new FileReader(in));
        BufferedWriter writer = new BufferedWriter(new FileWriter(out, true))){
            String[] arr;
            String line = reader.readLine();;
            int count = 0, lineNum = 0;
            while(true){
              arr = line.split("\\s");
              for(String s : arr){
                  if(s.equalsIgnoreCase("hello")){
                      count++;
                  }
              }
              writer.write(lineNum +"-"+count);
              writer.newLine();
              count = 0;
              lineNum++;
              line = reader.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
