import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class Problema3 {
    public static void main(String[] args) {
        FileReader file = null;
        LineNumberReader reader = null;
        String str;
        int lineNo;

        try {
            file = new FileReader("G:\\proiecte\\poo\\Laborator14\\Problema3\\src\\test01.in");
            reader = new LineNumberReader(file);

            while ((str = reader.readLine()) != null) {
                lineNo = reader.getLineNumber();

                if (lineNo % 2 != 0) {
                    System.out.println(lineNo + ": " + str);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (file != null)
                    file.close();

                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
