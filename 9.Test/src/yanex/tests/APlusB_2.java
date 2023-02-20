package yanex.tests;

import java.io.*;
import java.util.StringTokenizer;

public class APlusB_2 {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("C:\\tmp\\input.txt");
        BufferedReader reader = new BufferedReader(fr);
        String inputString = reader.readLine();
        reader.close();
        StringTokenizer st = new StringTokenizer(inputString, " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        FileWriter fw = new FileWriter("C:\\tmp\\output.txt");
        fw.write(String.valueOf(a+b));
        fw.close();
    }
}
