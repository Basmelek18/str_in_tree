import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shifter {

    public static List<OurNumber> toShift(List<OurNumber> inputList) {
        Map<Integer, Integer> mapLevel = new HashMap<>();
        Map<Integer, Integer> mapShifter = new HashMap<>();
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

        for (int i = inputList.size() - 1; i >=0; i--) {
            if (mapShifter.containsKey(inputList.get(i).getLevel())) {
                inputList.get(i).setNextState(mapShifter.get(inputList.get(i).getLevel()));
                if (i > 0 && inputList.get(i-1).getLevel() < inputList.get(i).getLevel()) {
                    mapShifter.remove(inputList.get(i).getLevel());
                }
                else {
                    mapShifter.put(inputList.get(i).getLevel(), inputList.get(i).getId());
                }
            }
            else {
                mapShifter.put(inputList.get(i).getLevel(), inputList.get(i).getId());
            }

        }

        for (int i = 0; i < inputList.size(); i++) {
            if (inputList.get(i).getNextState() > 0) {
                inputList.get(inputList.get(i).getNextState()).setShiftBefore(inputList.get(i).getShiftBefore());
            }

            if (i < inputList.size() - 1) {
                if (inputList.get(i+1).getLevel() > inputList.get(i).getLevel()) {
                    inputList.get(i).setShiftAfter("-".repeat(
                            inputList.get(
                                    inputList.get(i+1).getPrevState()
                            ).getNumber().length() - inputList.get(i).getNumber().length()
                    ) + "--+");
                    if (inputList.get(i).getNextState() > 0) {
                        inputList.get(i+1).setShiftBefore(inputList.get(i).getShiftBefore() + "|" + " ".repeat(
                                (inputList.get(i).getNumber() + inputList.get(i).getShiftAfter()).length() - 2
                        ));
                    }
                    else {
                        inputList.get(i+1).setShiftBefore(inputList.get(i).getShiftBefore() + " " + " ".repeat(
                                (inputList.get(i).getNumber() + inputList.get(i).getShiftAfter()).length() - 2
                        ));
                    }
                }
            }
        }
        return inputList;
    }
}
