import java.util.ArrayList;
import java.util.List;

public class CreateNumObj {

    public static List<OurNumber> toNumObj(String inString) {
        inString = inString + " ";
        List<String> splitedStrLine = new ArrayList<>(List.of(inString.split("")));
        List<OurNumber> allObj = new ArrayList<>();
        Integer countId = 0;
        Integer countLevel = 0;
        String sum = "";
        boolean flag = false;
        boolean shiftFlag = false;

        for (String c : splitedStrLine) {
            if (c.equals("(")) {
                countLevel++;
                shiftFlag = true;
                continue;
            }
            if (c.equals(")")) {
                if (!flag) {
                    allObj.add(new OurNumber(countId, sum, countLevel));
                    if (shiftFlag) {
                        allObj.get(allObj.size() - 1).setPrevState(countId - 1);
                    }
                    sum = "";
                }
                shiftFlag = false;
                countLevel--;
                flag = true;
                continue;
            }
            if (c.equals(" ")) {
                if (!flag) {
                    allObj.add(new OurNumber(countId, sum, countLevel));
                    if (shiftFlag) {
                        allObj.get(allObj.size() - 1).setPrevState(countId - 1);
                    }
                    sum = "";
                }
                shiftFlag = false;
                flag = false;
                countId++;
                continue;
            }
            sum = sum + c;
        }
    return allObj;
    }
}
