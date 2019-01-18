import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.util.LinkedList;

public class Chooser {
    private LinkedList<Test> quiz;
    private ObjectInputStream in;
    private FileInputStream input;
    private String fileName;
    public String fileChooser()
    {
        File file=new File("C:\\Users\\Musobek\\IdeaProjects\\InhaLetServerSide");
        JFileChooser chooser=new JFileChooser();
        chooser.setCurrentDirectory(file);
        FileNameExtensionFilter filter=new FileNameExtensionFilter("TEXT FILES","txt");
        chooser.setFileFilter(filter);

        int returnValue=chooser.showOpenDialog(null);

        if(returnValue==JFileChooser.APPROVE_OPTION)
        {


            readTest(chooser.getSelectedFile().getAbsolutePath());

        }
        if(returnValue==JFileChooser.CANCEL_OPTION)
        {
            System.exit(1);
        }
        fileName=chooser.getSelectedFile().getName();
        return chooser.getSelectedFile().getAbsolutePath();
    }

    public String getFileName() {
        return fileName;
    }

    public void readTest(String path)
    {

        try {
            input=new FileInputStream(  path);
            in=new ObjectInputStream(input);
            quiz=(LinkedList<Test>)in.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            fileChooser();
        }
    }


}

