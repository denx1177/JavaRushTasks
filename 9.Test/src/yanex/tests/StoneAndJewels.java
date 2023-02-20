package yanex.tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class StoneAndJewels {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String j = reader.readLine();
        String s = reader.readLine();
        List<Character> jChars = j.chars().mapToObj(e->(char)e).distinct().collect(Collectors.toList());
        List<Character> sChars = s.chars().mapToObj(e->(char)e).filter(x -> jChars.contains(x)).collect(Collectors.toList());
        System.out.println(sChars.size());
    }
}
