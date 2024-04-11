import java.util.*;

public class ChangeString {
    private final String PROBEL = " ";
    private int shiftCount = 0;
    private boolean flag = false;
    private List<String> result2 = new ArrayList<>();
//    public ChangeString(String inString){
//        this.inString = inString;
//    }

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

    public List<?> toTree(List<?> a) {
        int sumPrevLength = 0;
        int sumNextLength = 0;
        int sumL;
        boolean sumMax = true;
        for (int i = a.size() - 1; i >= 0; i--) {
            String sum = "";
            if (a.get(i) instanceof List<?>) {
                shiftCount++;
                List<?> b = (List<?>) a.get(i);
                this.toTree(b);
                shiftCount--;
                flag = true;
                continue;
            }
            if (flag) {
                sum = sum + a.get(i);
                if (sumMax) {
                    sumPrevLength = sum.length();
                    sum = " ".repeat(shiftCount) + sum + "--+";
                    sumMax = false;
                }
                else {
                    sumNextLength = sum.length();
                    sumL = sumPrevLength - sumNextLength;
                    sum = " ".repeat(shiftCount) + sum + "-".repeat(sumL) + "--+";
                }
                flag = false;
                result2.add(sum);
                continue;
            }
            sum = " ".repeat(shiftCount) + a.get(i);
            result2.add(sum);
        }
        return result2;
    }
}
