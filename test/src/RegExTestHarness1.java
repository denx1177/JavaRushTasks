import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExTestHarness1 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        if (console == null){
            System.err.println("No console.");
            System.exit(1);
        }
        String str = "";
        while (!str.equals("2233")){
            System.out.print("\nEnter your regex: ");
            Pattern pattern = Pattern.compile(console.nextLine());
            System.out.print("Enter input string for search: ");
            Matcher matcher = pattern.matcher(console.nextLine());

            boolean found = false;
            while (matcher.find()){
                System.out.format("I fount the text" + "\"%s\" starting at" + "index %d and ending at index %d.%n",
                        matcher.group(), matcher.start(), matcher.end() );
                found = true;
            }
            if (!found){
                System.out.format("No match found.%n");
            }
            str = console.nextLine();
        }
    }
}
