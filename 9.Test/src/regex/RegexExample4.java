package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample4 {
    public static void main(String[] args) {
        System.out.println(Pattern.matches("А.+а","Алла"));//true
        System.out.println(Pattern.matches("А.+а","Егор Алла Александр"));//false

        Pattern pattern = Pattern.compile("abc");
        System.out.println(pattern.flags());// 0
        Pattern pattern2 = Pattern.compile("abc",Pattern.CASE_INSENSITIVE);
        System.out.println(pattern2.flags());// 2
    }
}
