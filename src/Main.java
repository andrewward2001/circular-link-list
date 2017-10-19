import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> list;
        ArrayList<String> fileStrings;
        try {
            list = new LinkedList<String>();
            fileStrings = readFile("res" + File.separator + "names.txt");
            fileStrings.forEach(list::addLast);
            System.out.println(fileStrings);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> readFile(String fileName) throws IOException {
        ArrayList<String> Alist = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            Alist.add(line);
        }
        reader.close();
        return Alist;
    }
}