import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inString = in.nextLine();
        var pepa = new ChangeString();
        List<Object> pupa = pepa.toAr(inString);
        System.out.println(pepa.toTree((List<?>) pupa.get(0)));

    }
}