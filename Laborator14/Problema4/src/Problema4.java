import java.io.*;

public class Problema4 {
    public static void main(String[] args) {
        InputStreamReader inputStream = null;
        BufferedReader reader = null;
        String str;
        String finalStr = "";
        BufferedWriter writer = null;

        try {
            inputStream = new InputStreamReader(System.in);
            reader = new BufferedReader(inputStream);
            str = reader.readLine();

            while (!str.contains("exit")) {
                finalStr += str + "\n";
                str = reader.readLine();
            }

            writer = new BufferedWriter(new FileWriter("Test.txt", false));
            writer.write(finalStr);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null)
                    inputStream.close();
                if (reader != null)
                    reader.close();
                if (writer != null)
                    writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
