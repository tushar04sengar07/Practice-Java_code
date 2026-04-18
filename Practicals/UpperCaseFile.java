import java.io.*;
public class UpperCaseFile {
    public static void main(String[] args) {
        try{
            FileReader fr=new FileReader("C:\\Users\\tushar\\Documents\\java\\Practicals\\test.txt");
            BufferedReader br=new BufferedReader(fr);
            StringBuilder content=new StringBuilder();
            String line;
            while((line = br.readLine())!=null){
                content.append(line.toUpperCase()).append("\n");
            }
            br.close();
            FileWriter fw=new FileWriter("C:\\Users\\tushar\\Documents\\java\\Practicals\\test.txt");
            BufferedWriter bw=new BufferedWriter(fw);
            bw.write(content.toString());
            bw.close();
            System.out.println("File content converted to uppercase successfully!");
        } catch(IOException e){
            System.out.println("Error: "+ e.getMessage());
        }
    }
}