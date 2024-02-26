package util;

import logger.Logger;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


public class Utility {
    public static void writeToReport(String path, String data) {
        try (FileWriter fileWriter = new FileWriter(path, true)) {
            fileWriter.write(data + "\n");

        }catch (FileNotFoundException e) {
            Logger.writeErrorLog("файл '" + path + "' не обнаружен");
            System.out.println("файл '" + path + "' не обнаружен");
        } catch (IOException e) {
            Logger.writeErrorLog("файл '" + path + "': ошибка ввода-вывода");
            System.out.println("файл '" + path + "': ошибка ввода-вывода");
        } catch (Exception e) {
            Logger.writeErrorLog("ошибка при работе с файлом '" + path + "': " + e.getStackTrace());
            System.out.println("ошибка при работе с файлом '" + path + "'");
        }
    }

}
