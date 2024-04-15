import java.util.*;

public class ChangeString {
    private int shiftCount = 0;
    private boolean flag = false;
    private String shiftStr = "";
    private List<String> result2 = new ArrayList<>();

    public static List<Object> toAr(String inString){
        List<String> splitedStrLine = new ArrayList<>(List.of(inString.split("")));
        List<Object> result = new ArrayList<>();
        List<List<Object>> stack = new ArrayList<>();
        stack.add(result);
        String sum = "";

        for (String c : splitedStrLine){
            if (c.equals("(")) {
                List<Object> newArray = new ArrayList<>();
                stack.get(stack.size() - 1).add(newArray);
                stack.add(newArray);
                continue;
            }
            if (c.equals(")")) {
                if (!sum.equals("")) {
                    stack.get(stack.size() - 1).add(sum);
                }
                stack.remove(stack.size() - 1);
                sum = "";
                continue;
            }
            if (c.equals(" ")) {
                if (!sum.equals("")) {
                    stack.get(stack.size() - 1).add(sum);
                }
                sum = "";
                continue;
            }
            sum = sum + c;

        }
        return result;
    }

    public List<String> toTree(List<?> a) {
        int sumPrevLength = 0;
        int sumNextLength = 0;
        int sumL;
        boolean sumMax = true;
        for (int i = a.size() - 1; i >= 0; i--) {
            String sum = "";
            if (a.get(i) instanceof List<?>) {
                List<?> b = (List<?>) a.get(i);
                if (i < a.size() - 1) {
                        if (sumPrevLength != 0) {
                            shiftCount = sumPrevLength + 1;
                        }
                        else {
                            shiftCount = ((String) a.get(i - 1)).length() + 1;
                        }
                    shiftStr = shiftStr + "|" + " ".repeat(shiftCount);
                    this.toTree(b);
                    if (sumPrevLength != 0) {
                        shiftStr = shiftStr.substring(0, shiftStr.length() - (sumPrevLength + 2));
                    }
                    else {
                        shiftStr = shiftStr.substring(0, shiftStr.length() - (((String) a.get(i - 1)).length() + 2));
                    }
                }
                else {
                    shiftCount = ((String) a.get(i - 1)).length() + 1;
                    shiftStr = shiftStr + " ".repeat(shiftCount + 1);
                    //                    shiftCount = 0;
                    this.toTree(b);
                    shiftStr = shiftStr.substring(0, shiftStr.length() - (((String) a.get(i - 1)).length() + 2));
                }
                flag = true;
                continue;
            }
            if (flag) {
                sum = sum + a.get(i);
                if (sumMax) {
                    sumPrevLength = sum.length();
                    sum = shiftStr + sum + "--+";
                    sumMax = false;
                }
                else {
                    sumNextLength = sum.length();
                    sumL = sumPrevLength - sumNextLength;
                    sum = shiftStr + sum + "-".repeat(sumL) + "--+";
                }
                flag = false;
                result2.add(sum);
                continue;
            }
            sum = shiftStr + a.get(i);
            result2.add(sum);
        }
        return result2;
    }
}
