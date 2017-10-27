import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;


public class Main {

    static int size = 800;
    static LinkedList<String> linkedList = new LinkedList<>();

    public static void main(String[] args) {


        JFrame window = new JFrame("circular linked lists!");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setBounds(0, 0, 800, 800); //(x, y, w, h)
        Panel panel = new Panel();
        panel.setFocusable(true);
        panel.grabFocus();
        window.add(panel);
        window.setVisible(true);

        JFrame textWindow = new JFrame("Paste the names here...");
        textWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textWindow.setBounds(0, 0, size, size);


        JTextArea textArea = new JTextArea("Names");
        textArea.setFont(new Font("Roboto", Font.PLAIN, 18));

        JScrollPane areaScrollPane = new JScrollPane(textArea);
        areaScrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        areaScrollPane.setPreferredSize(new Dimension(size, size - 80));


        ArrayList<String> fileStrings = new ArrayList<>(); //
        JButton runScriptButton = new JButton("Run Script");
        runScriptButton.setSize(100, 50);
        ArrayList<String> finalFileStrings = fileStrings;

        runScriptButton.addActionListener(e -> {


            //convert the list to something
            String names = textArea.getText();
            System.out.println(textArea.getText());

            String[] namesList = names.split("\n");
            finalFileStrings.clear();
            for (String s : namesList) {
                finalFileStrings.add(s);
            }

            finalFileStrings.forEach(System.out::println);


        });


        areaScrollPane.setFocusable(true);
        areaScrollPane.grabFocus();
        panel.add(runScriptButton);
        panel.setVisible(true);
        areaScrollPane.add(runScriptButton);
        areaScrollPane.setVisible(true);
        textArea.setVisible(true);
        textWindow.setLayout(new FlowLayout(FlowLayout.CENTER));
        textWindow.add(areaScrollPane);
        textWindow.setVisible(true);
        textWindow.add(runScriptButton);


        for (int i = 0; i < finalFileStrings.size(); i++) {
            linkedList.addLast(finalFileStrings.get(i));
        }

    }

    public static ArrayList<String> readFile(String fileName) throws IOException {
        ArrayList<String> Alist = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            Alist.add(line);
        }
        reader.close();
        return Alist;
    }

    public static LinkedList getLinkedList() {
        return linkedList;
    }
}