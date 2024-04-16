import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String inString = in.nextLine();
//        var pepa = new ChangeString();
//        List<Object> pupa = pepa.toAr(inString);
//        List<String> lupa = pepa.toTree((List<?>) pupa.get(0));
//        Collections.reverse(lupa);
//        for (String any : lupa) {
//            System.out.println(any);
//        }
        Scanner in = new Scanner(System.in);
        String inString = in.nextLine();
        List<OurNumber> result = CreateNumObj.toNumObj(inString);
        System.out.println(result);
        for (OurNumber o : result) {
            System.out.println(o);
            System.out.println(o.getId());
            System.out.println(o.getNumber());
            System.out.println(o.getLevel());
            System.out.println("");
        }
    }
}