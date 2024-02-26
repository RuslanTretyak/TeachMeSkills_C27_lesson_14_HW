package logger;

import constants.Constants;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    public static void writeExecutionLog(String log) {
        writeLog(Constants.EXECUTION_LOG_PATH, log);
    }
    public static void writeErrorLog(String log) {
        writeLog(Constants.ERROR_LOG_PATH, log);
    }
    private static void writeLog(String path, String log) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try (FileWriter fileWriter = new FileWriter(path, true)) {
            fileWriter.write(sdf.format(date) + "[" + log + "]\n");
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
