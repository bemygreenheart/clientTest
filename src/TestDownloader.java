import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TestDownloader {
    private List<Test> testList;
    private String testName;
    private static final Scanner scanner= new Scanner(System.in);

    public TestDownloader()
    {
testList= new LinkedList<Test>();
        testList.add(new Test("sdfertwet","erewtarweq","rewrtrewr","assdfere","wrewer",3));
        testList.add(new Test("sdfertwet","erewtarweq","rewrtrewr","assdfere","wrewer",1));
    }
    public void takeName()
    {
        System.out.println("Please enter the file name for storage");
        testName=scanner.next();

    }
    public void writeToTheFile() {
        try {
            FileOutputStream out = new FileOutputStream("myTests\\"+testName + ".txt");
            ObjectOutputStream outputStream = new ObjectOutputStream(out);
            outputStream.writeObject(testList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public File[] getTests()
    {
        File file= new File("Tests\\");
        File[] myFiles=file.listFiles();
        return myFiles;
    }
    public String[] getTestNames()
    {
        File file= new File("Tests\\");
        return file.list();
    }
}
