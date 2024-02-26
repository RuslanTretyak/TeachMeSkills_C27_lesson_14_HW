package service;

import constants.Constants;
import exception.EmptyFileException;
import logger.Logger;
import util.Utility;
import util.Validator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Service {
    public static void processFile(File file) {
        Logger.writeExecutionLog("получен файл" + file.getAbsolutePath());
        List<String> documents = new ArrayList<>();
        try (FileReader fileReader = new FileReader(file)) {
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                documents.add(scanner.nextLine());
            }
            if (documents.isEmpty()) {
                throw new EmptyFileException();
            }

        } catch (FileNotFoundException e) {
            Logger.writeErrorLog("файл '" + file.getAbsolutePath() + "' не обнаружен");
            System.out.println("файл '" + file.getAbsolutePath() + "' не обнаружен");
        } catch (IOException e) {
            Logger.writeErrorLog("файл '" + file.getAbsolutePath() + "': ошибка ввода-вывода");
            System.out.println("файл '" + file.getAbsolutePath() + "': ошибка ввода-вывода");
        } catch (EmptyFileException e) {
            System.out.println(e.getMessage());
            Logger.writeErrorLog(e.getMessage());
        } catch (Exception e) {
            Logger.writeErrorLog("ошибка при работе с файлом '" + file.getAbsolutePath() + "': " + e.getStackTrace());
            System.out.println("ошибка при работе с файлом '" + file.getAbsolutePath() + "'");
        }
        Logger.writeExecutionLog("получены номера документров: " + documents);
        for (String docNumber : documents) {
            Logger.writeExecutionLog("проверка формата номера документа '" + docNumber + "'");
            String notValidReason = Validator.checkDocnumberFormat(docNumber);
            if (!notValidReason.equals("true")) {
                Utility.writeToReport(Constants.NOTVALID_REPORT_PATH, docNumber
                        + " причина: " + notValidReason);
                Logger.writeExecutionLog("документ '" + docNumber + "' записан в отчет " + Constants.NOTVALID_REPORT_PATH);
            } else if (docNumber.startsWith("docnum")) {
                Utility.writeToReport(Constants.DOCNUM_REPORT_PATH, docNumber);
                Logger.writeExecutionLog("документ '" + docNumber + "' записан в отчет " + Constants.DOCNUM_REPORT_PATH);
            } else {
                Utility.writeToReport(Constants.CONTRACT_REPORT_PATH, docNumber);
                Logger.writeExecutionLog("документ '" + docNumber + "' записан в отчет " + Constants.CONTRACT_REPORT_PATH);
            }
        }

    }

}
