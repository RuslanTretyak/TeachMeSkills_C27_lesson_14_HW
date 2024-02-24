import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Utility {
    public static void writeToReport(String path, String data) {
        try (FileWriter fileWriter = new FileWriter(path, true)) {
            fileWriter.write(data + "\n");

        }catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
        } catch (IOException e) {
            System.out.println("IOException");
        } catch (Exception e) {
            System.out.println("Exception");
        }

    }
}
