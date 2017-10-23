import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        LinkedList<String> list = new LinkedList<>();
        ArrayList<String> fileStrings;
        fileStrings = readFile("res" + File.separator + "names.txt");
        fileStrings.forEach(list::addLast);



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