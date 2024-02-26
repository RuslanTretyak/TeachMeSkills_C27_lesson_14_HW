import service.Service;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите путь к файлу");
        File file = new File(scanner.next()); //  src\\fileForProcessing.txt
        Service.processFile(file);
    }
}
