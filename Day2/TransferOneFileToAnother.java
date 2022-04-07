import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TransferOneFileToAnother {
    public static void main(String[] args) {

        try {
            // Reading from a file
            BufferedReader reader = new BufferedReader(new FileReader("files/sample.txt"));
            String content = "";
            String line = reader.readLine();
            while (line != null) {
                content += line + "\n";
                line = reader.readLine();
            }
            reader.close();

            // Transform the content
            content += "This file is modified using Java! :D";

            // Writing into a new file
            BufferedWriter writer = new BufferedWriter(new FileWriter("files/new.txt"));
            writer.write(content);
            writer.close();

        } catch (FileNotFoundException e) {
            System.out.println("Ooops! :( Looks like you are in the wrong directory!");
        } catch (IOException e) {
            System.out.println("Awww! :( Looks like there is some issue with I/O");
        }

    }
}
