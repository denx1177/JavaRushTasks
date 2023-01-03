package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample2 {
    public static void main(String[] args) {


        // Lets use a regular expression to capture data from a few date strings.
        String pattern = "([a-zA-Z]+) (\\d+)";
        Pattern ptrn = Pattern.compile("([a-zA-Z]+) (\\d+)");
        Matcher matcher = ptrn.matcher("June 24, August 9, Dec 12");

// This will print each of the matches and the index in the input string
// where the match was found:
//   June 24 at index [0, 7)
//   August 9 at index [9, 17)
//   Dec 12 at index [19, 25)
        while (matcher.find()) {
            System.out.println(String.format("Match: %s at index [%d, %d]",
                    matcher.group(), matcher.start(), matcher.end()));
        }

// If we are iterating over the groups in the match again, first reset the
// matcher to start at the beginning of the input string.
        matcher.reset();

// For each match, we can extract the captured information by reading the
// captured groups.
        while (matcher.find()) {
            // This will print the number of captured groups in this match
            System.out.println(String.format("%d groups captured",
                    matcher.groupCount()));

            // This will print the month and day of each match.  Remember that the
            // first group is always the whole matched text, so the month starts at
            // index 1 instead.
            System.out.println("Month: " + matcher.group(1) + ", Day: " +
                    matcher.group(2));

            // Each group in the match also has a start and end index, which is the
            // index in the input string that the group was found.
            System.out.println(String.format("Month found at[%d, %d)",
                    matcher.start(1), matcher.end(1)));
        }
    }
}
