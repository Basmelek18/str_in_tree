import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shifter {

    public static List<OurNumber> toShift(List<OurNumber> inputList) {
        Map<Integer, Integer> mapLevel = new HashMap<>();
        for (OurNumber o : inputList) {
            if (o.getLevel() > 1 && o.getPrevState() >= 0) {
                mapLevel.put(o.getLevel(), o.getPrevState());
            }
        }
        for (OurNumber o : inputList) {
            if (o.getLevel() > 1) {
                o.setPrevState(mapLevel.get(o.getLevel()));
            }
        }
        for (int i = 0; i < inputList.size(); i++) {
            if (i < inputList.size() - 1) {
                if (inputList.get(i+1).getLevel() > inputList.get(i).getLevel()) {
                    inputList.get(i).setShiftAfter("-".repeat(
                            inputList.get(
                                    inputList.get(i+1).getPrevState()
                            ).getNumber().length() - inputList.get(i).getNumber().length()
                    ) + "--+");
                }
            }
        }
        return inputList;
    }
}
