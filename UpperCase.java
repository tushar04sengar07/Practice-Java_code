import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.nio.Buffer;
import java.oi.*;
public class UpperCase {
    public static void main(String[] args) {
        
        try {
            FileReader fr = new FileReader("input.txt");
            BufferedReader br = new BufferedReader(fr);
            StringBuilder conteStringBuilder = new StringBuilder();
            string line;

            while ((line = br.readLine()) != null) {
                conteStringBuilder.append(line.toUpperCase()).append("\n");
            }
            br.close();
            FileWriter fw = new FileWriter("output.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(conteStringBuilder.toString());
            bw.close();

            System.err.println("File converted to uppercase and saved as output.txt");  
        }
        catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
    

