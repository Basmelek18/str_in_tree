import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateNumObj {

    public static List<OurNumber> toNumObj(String inString) {
        inString = inString + " ";
        List<String> splitedStrLine = new ArrayList<>(List.of(inString.split("")));
        List<OurNumber> allObj = new ArrayList<>();
        Integer countId = 0;
        Integer countLevel = 0;
        String sum = "";
        boolean flag = false;

        for (String c : splitedStrLine) {
            if (c.equals("(")) {
                countLevel++;
                continue;
            }
            if (c.equals(")")) {
                if (!flag) {
                    allObj.add(new OurNumber(countId, sum, countLevel));
                    sum = "";
                }
                countLevel--;
                flag = true;
                continue;
            }
            if (c.equals(" ")) {
                if (!flag) {
                    allObj.add(new OurNumber(countId, sum, countLevel));
                    sum = "";
                }
                flag = false;
                countId++;
                continue;
            }
            sum = sum + c;
        }
    return allObj;
    }
}
