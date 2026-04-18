import java.io.*;

public class IOExceptionExample {
    static void readfile () throws IOException {
        FileReader fr = new FileReader("file.txt");
        BufferedReader br = new BufferedReader(fr);
        System.out.println(br.readLine());
}

public static void main(String[] args) {
    try {
        readfile();
    } catch (IOException e) {
        System.out.println("An error occurred: " + e.getMessage());
    } 
}
}
