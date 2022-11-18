package yanex.tests;

import java.io.*;
import java.util.StringTokenizer;

public class APlusB_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputString = reader.readLine();
        StringTokenizer st = new StringTokenizer(inputString, " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        System.out.println(a+b);
    }
}
