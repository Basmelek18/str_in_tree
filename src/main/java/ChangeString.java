import java.util.*;

public class ChangeString {
    private final String PROBEL = "|   ";
    private final String inString;
    public ChangeString(String inString){
        this.inString = inString;
    }

    public List<String> toTree(){
        List<String> splitedStrLine = new ArrayList<>(List.of(inString.split(" ")));
        List<String> newArray = new ArrayList<>();
        int tabCount = -1;
        var flag = false;
        String sum;
        Collections.reverse(splitedStrLine);
        for (String n : splitedStrLine){
            var splitStr = new ArrayList<>(List.of(n.split("")));
            Collections.reverse(splitStr);
            sum = "";
            String buk = flag ? "--+" : "";
            flag = false;
            for (String m : splitStr){
                if (m.equals(")")) {
                    tabCount++;
                    continue;
                }
                if (m.equals("(")) {
                    tabCount--;
                    flag = true;
                    continue;
                }
                sum = m + sum;
            }
            String value = PROBEL.repeat(flag ? tabCount + 1 : tabCount) + sum + buk;
            newArray.add(value);
        }
        Collections.reverse(newArray);
        return newArray;
    }
}
