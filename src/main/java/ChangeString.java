import java.util.ArrayList;

public class ChangeString {
    private final String PROBEL = "----";
    private final String inString;
    public ChangeString(String inString){
        this.inString = inString;
    }

    public ArrayList<String> toTree(){
        var splitedStrLine = inString.split(" ");
        ArrayList<String> newArray = new ArrayList<>();
        int tabCount = 0;
        String sum;
        for (String n : splitedStrLine){
            var splitStr = n.split("");
            sum = "";
            for (String m : splitStr){
                if (m.equals("(")) {
                    tabCount++;
                    continue;
                }
                if (m.equals(")")){
                    tabCount--;
                    continue;
                }
                sum = sum + m;
            }
            sum = PROBEL.repeat(tabCount) + sum;
            newArray.add(sum);
        }
        return newArray;
    }
}
