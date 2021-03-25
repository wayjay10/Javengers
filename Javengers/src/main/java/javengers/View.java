package javengers;
// @author Ann Katz;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;

public class View extends JFrame {
    private JPanel mainPanel;
    private JTabbedPane tabbedPane;
    private JLabel titleLabel;
    private JPanel adminPanel;
    private JPanel userViewPanel;
    private JTextField searchTextField;
    private JLabel searchByLabel;
    private JRadioButton andRadioButton;
    private JRadioButton orRadioButton;
    private JRadioButton phraseRadioButton;
    private JButton searchButton;
    private JList filesList;
    private JLabel filesLabel;
    private JLabel statusLabel;
    private JLabel dateLabel;
    private JLabel nameLabel;
    private JList nameList;
    private JList statusList;
    private JList dateList;
    private JLabel adminTitle;
    private JButton addFileButton;
    private JButton removeFileButton;
    private JButton updateListButton;

    DefaultListModel listModel;

    public View(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        addFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser= new JFileChooser();

                chooser.showOpenDialog(null);
                File f = chooser.getSelectedFile();
                String filename = f.getPath();
                DefaultListModel listModel = new DefaultListModel();
                listModel.addElement(f);



            }
        });

        removeFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var n = nameList.getSelectedIndex();
                nameList.remove(n);
            }
        });

        updateListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listModel = new DefaultListModel();

                // create a file that is really a directory
                File aDirectory = new File("/files");

                // get a listing of all files in the directory
                String[] filesInDir = aDirectory.list();

                // sort the list of files (optional)
                Arrays.sort(filesInDir);

                // have everything i need, just print it now
                for ( int i=0; i<filesInDir.length; i++ ) {
                    System.out.println("file: " + filesInDir[i]);

                    listModel.addElement(filesInDir[i]);
                    nameList = new JList(listModel);
                }

            }
        });
    }



    public static void main(String[] args) {
        JFrame frame = new View("Index Search Engine");
        frame.setVisible(true);
    }


}
