


import javax.swing.*;

public class ClientApp {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.add(new Welcome(frame));
//        Test test= new Test("111111","asdf","afwf","werq","wefqer",2);
//        Test test1= new Test("22222","asdf","afwf","werq","wefqer",1);
//        LinkedList<Test> tests= new LinkedList<Test>();
//        tests.add(test);
//        tests.add(test1);
        // frame.add(new QuestionQuiz("This the long string representing question",
        //        "This is the first option","This is the second option","This is the third option","This is the the fourth option"));
        //frame.add(new DownloadPanel(0, frame));
        frame.pack();

/*
TestDownloader testDownloader= new TestDownloader();
TestReader reader=new TestReader();
        File file = new File("C:\\Users\\Dell\\IdeaProjects\\Client\\Tests\\U171000.txt");
        reader.readTest(file);
        List<Test>testList =reader.getQuiz();

        reader.show();
        */
    }
}
