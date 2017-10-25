import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        JFrame window = new JFrame("circular linked lists!");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setBounds(0, 0, 800, 800); //(x, y, w, h)
        Panel panel = new Panel();
        panel.setFocusable(true);
        panel.grabFocus();
        window.add(panel);
        window.setVisible(true);

        LinkedList<String> list;
        ArrayList<String> fileStrings;
        try {
            list = new LinkedList<>();
            fileStrings = readFile("res" + File.separator + "names.txt");
            fileStrings.forEach(list::addLast);

            list.remove("One");

            Node temp = list.getRoot();
            for (int i = 0; i < 15; i++) {
                System.out.println(temp.data);
                temp = temp.getNext();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static ArrayList<String> readFile(String fileName) throws IOException {
        ArrayList<String> Alist = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            Alist.add(line);
        }
        reader.close();
        return Alist;
    }
}
