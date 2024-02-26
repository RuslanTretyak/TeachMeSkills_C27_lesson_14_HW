package util;

import constants.Constants;
import logger.Logger;

public class Validator {
    public static String checkDocnumberFormat(String docNumber) {
        String notValidReasons = "";
        if (!docNumber.startsWith("docnum") && !docNumber.startsWith("contract")) {
            Logger.writeExecutionLog("документ '" + docNumber + "' не прошел проверку на начальную последовательность символов");
            notValidReasons += "документ не начинается с последовательностей 'docnum' и 'сontract', ";
        }
        if (docNumber.length() != Constants.DOCNUMBER_LENGTH) {
            Logger.writeExecutionLog("документ '" + docNumber + "' не прошел проверку на количество символов");
            notValidReasons += "количество символов не равно " + Constants.DOCNUMBER_LENGTH + ", ";
        }
        if (!docNumber.matches("[A-z0-9]*")) {
            Logger.writeExecutionLog("документ '" + docNumber + "' не прошел проверку на недопустимые символы");
            notValidReasons += "номер содержит недопустимые символы, ";
        }
        if (notValidReasons.equals("")){
            Logger.writeExecutionLog("документ '" + docNumber + "' прошел проверку на валидность");
            notValidReasons += "true, ";
        }
        return notValidReasons.substring(0, notValidReasons.length() - 2);
    }

}
