import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inString = in.nextLine();
        var pepa = new ChangeString(inString);
        for (String underStr : pepa.toTree()) {
            System.out.println(underStr);
        }


    }
}