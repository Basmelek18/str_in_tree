import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long startTime = System.nanoTime();
//        String inString = in.nextLine();
//        var pepa = new ChangeString();
//        List<Object> pupa = pepa.toAr(inString);
//        List<String> lupa = pepa.toTree((List<?>) pupa.get(0));
//        Collections.reverse(lupa);
//        for (String any : lupa) {
//            System.out.println(any);
//        }
//        Scanner in = new Scanner(System.in);
        String inString = in.nextLine();
        List<OurNumber> result = CreateNumObj.toNumObj(inString);
        result = Shifter.toShift(result);
        System.out.println(result);
        for (OurNumber o : result) {
            System.out.println(o.getShiftBefore()+o.getNumber()+o.getShiftAfter());
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration);
    }
}