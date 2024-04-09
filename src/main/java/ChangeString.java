import java.util.*;

public class ChangeString {
    private final String PROBEL = " ";
    private final String inString;
    public ChangeString(String inString){
        this.inString = inString;
    }

    public List<Object> toAr(){
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

    public static List<Object> toTree(ArrayList<Object> a) {
        List<Object> result = new ArrayList<>();
        int shiftCount = 0;
        boolean flag = false;
        for (int i = a.size() - 1; i >= 0; i--) {
            if (a.get(i) instanceof ArrayList<?>) {
                flag = true;
                shiftCount++;
            }
            if (flag) {
                ;
            }
        }
        return newTree;
    }
}
