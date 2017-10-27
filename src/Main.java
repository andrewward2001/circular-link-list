import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;


public class Main extends JPanel{

    static int size = 800;

    public static void main(String[] args) {

        JFrame window = new JFrame("circular linked lists!");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setBounds(0, 0, 800, 800); //(x, y, w, h)





        Main panel = new Main();
        panel.setFocusable(true);
        panel.grabFocus();
        window.add(panel);
        window.setVisible(true);

        JFrame textWindow = new JFrame("Write your script here...");
        textWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textWindow.setBounds(0, 0, size, size);




        JTextArea textArea = new JTextArea("Names");
        textArea.setFont(new Font("Roboto", Font.PLAIN, 18));

        JScrollPane areaScrollPane = new JScrollPane(textArea);
        areaScrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        areaScrollPane.setPreferredSize(new Dimension(size, size-80));





        ArrayList<String> fileStrings = new ArrayList<String>(); //
        JButton runScriptButton = new JButton("Run Script");
        runScriptButton.setSize(100,50);
        ArrayList<String> finalFileStrings = fileStrings;

        runScriptButton.addActionListener(e -> {



        //convert the list to something
            String names = textArea.getText();
            System.out.println(textArea.getText());

            String[] namesList = names.split("\n");
            finalFileStrings.clear();
            for (String s: namesList) {
                finalFileStrings.add(s);
            }

            for (int i = 0; i < finalFileStrings.size(); i++) {
                System.out.println(finalFileStrings.get(i));
            }


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


        LinkedList<Node> linkedList = new LinkedList<Node>();
        for (String s: finalFileStrings) {

        }


//        LinkedList<String> list;
////        ArrayList<String> fileStrings;
//
//        try {
//            list = new LinkedList<>();
//            fileStrings = readFile("res" + File.separator + "names.txt");
//            fileStrings.forEach(list::addLast);
//
//            list.remove("One");
//
//            Node temp = list.getRoot();
//            for (int i = 0; i < 15; i++) {
//                System.out.println(temp.data);
//                temp = temp.getNext();
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
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
}