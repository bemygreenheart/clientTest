

import java.io.*;
import java.util.LinkedList;


public class TestReader {
    private LinkedList<Test> quiz;
    private ObjectInputStream in;
    private FileInputStream input;


    public LinkedList<Test> getQuiz() {
        return quiz;
    }

    public void readTest(File file)
    {
        try {
            input=new FileInputStream(  file);
            in=new ObjectInputStream(input);
            quiz=(LinkedList<Test>)in.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void show()
    {
        for (Test test : quiz)
        {
            System.out.println(test.getQuestion());
            System.out.printf("%s\t%s\t%s\t%s", test.getOption1(), test.getOption2(), test.getOption3(), test.getOption4());
        }

    }

}
