import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Считаем слово
*/
// Поиск совпадений последовательностей символов, не учитывая, что перед ними должен стоять пробел
// или знак препинания.
public class FindText {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileReader reader = new FileReader(br.readLine());
        br.close();
        int charFind = 0;
        int hitCounter = 0;
        while (reader.ready()) {
            char ch = (char) reader.read();
            switch (charFind) {
                case 1: charFind = validateCharacterPosition("world", ch, 1);
                    break;
                case 2: charFind = validateCharacterPosition("world", ch, 2);
                    break;
                case 3: charFind = validateCharacterPosition("world", ch, 3);
                    break;
                case 4: charFind = validateCharacterPosition("world", ch, 4);
            }
            switch (charFind) {
                case 0:
                    charFind = validateCharacterPosition("world", ch, 0);
                    break;
                case 5:
                    hitCounter++;
                    charFind = 0;
            }
        }
        reader.close();
        System.out.println(hitCounter);
    }
    public static int validateCharacterPosition(String word, char ch, int position){
        if (word.substring(position, position+1).equals(String.valueOf(ch))){
            return position+1;
        } else{
            return 0;
        }
    }
}
