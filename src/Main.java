import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        ArrayList<String> fileStrings;
        try {
            fileStrings = readFile("names.txt");
            fileStrings.forEach(list::addLast);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static ArrayList<String> readFile(String fileName) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while(reader.readLine() != null){
            list.add(reader.readLine());
        }
        reader.close();
        return list;
    }
}