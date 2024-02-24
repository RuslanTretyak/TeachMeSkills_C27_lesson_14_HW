import java.util.ArrayList;
import java.util.List;

public class Validator {
    public static String checkDocnumberFormat(String docNumber) {
        List<String> notValidReasons = new ArrayList<>();
        if (!docNumber.startsWith("docnum") && !docNumber.startsWith("contract")) {
            notValidReasons.add("документ не начинается с последовательностей 'docnum' и 'сontract'");
        }
        if (docNumber.length() != Constants.DOCNUMBER_LENGTH) {

        }
        return "";
    }

}
