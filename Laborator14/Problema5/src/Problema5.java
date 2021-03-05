import java.io.File;
import java.io.FileReader;
import java.io.StreamTokenizer;

public class Problema5 {
    public static void main(String[] args) {
        FileReader input = null;
        StreamTokenizer stream = null;
        int cuvinte = 0;
        try {
            input = new FileReader(new File("G:\\proiecte\\poo\\Laborator14\\Problema5\\src\\test02.in"));
            stream = new StreamTokenizer(input);

            stream.wordChars('A', 'Z');
            stream.wordChars('a', 'z');
            stream.whitespaceChars(0, 64);
            stream.whitespaceChars(91, 96);
            stream.whitespaceChars(123, 255);

            while (stream.nextToken() != stream.TT_EOF) {
                System.out.println(stream.sval);
                cuvinte++;
            }

            System.out.println(cuvinte);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (input != null)
                    input.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
