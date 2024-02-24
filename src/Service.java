import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Service {
    public static void processFile(File file) {
        List<String> documents = new ArrayList<>();
        try (FileReader fileReader = new FileReader(file)) {
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                documents.add(scanner.nextLine());
            }

        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
        } catch (IOException e) {
            System.out.println("IOException");
        } catch (Exception e) {
            System.out.println("Exception");
        }
        System.out.println(documents);
        for (String docNumber : documents) {
            if (docNumber.startsWith("docnum")) {
                Utility.writeToReport(Constants.DOCNUM_REPORT_PATH, docNumber);
            } else if (docNumber.startsWith("contract")) {
                Utility.writeToReport(Constants.CONTRACT_REPORT_PATH, docNumber);
            } else {
                Utility.writeToReport(Constants.NOTVALID_REPORT_PATH, docNumber);
            }
        }

    }

}
