import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Download {



    private String SERVER = "192.168.43.123";
    static int port = 12345;
    static int port1 = 12346;
    static int port2 = 12347;
    static int port3 = 12348;
    private Socket socket = null;
    private Socket socket1 = null;
    private Socket socket2 = null;
    private Socket socket3 = null;
    private int current;
    private int readBytes;
    private FileOutputStream fileOutputStream = null;
    private BufferedOutputStream bufferedOutputStream = null;
    private InputStreamReader reader = null;
    private InputStreamReader reader1 = null;
    private InputStreamReader reader2 = null;
    private BufferedReader bufferedReader = null;
    private BufferedReader bufferedReader1 = null;
    private BufferedReader bufferedReader2 = null;
    private int numberFormatted;
    private File file=null;
    private String id="jhh";
    private int time;
    private String forderName="Tests";

    public int getTime() {
        return time;
    }

    public void testDownload() throws UnknownHostException {
        try {
            socket = new Socket(SERVER, port);
        } catch (IOException e) {
            System.exit(1);
        }

        try {
            socket1 = new Socket(SERVER, port1);
        } catch (IOException e) {
            System.exit(1);
        }
        catch (Exception e)
        {
            System.exit(1);
        }
        try {
            socket2 = new Socket(SERVER, port2);
        }
        catch (IOException e) {
            System.exit(1);
        }
        try {
            socket3 = new Socket(SERVER, port3);
        }
        catch (IOException e) {
            System.exit(1);
        }

        try {

            recieveId();
            createNewFile();
            recieveSize();
            receiveFile();
            recieveTime();

        } finally {

                try {
                    if (reader != null) reader.close();
                    if (bufferedReader != null) bufferedReader.close();

                    if (reader != null) reader.close();
                    if (bufferedReader != null) bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        System.out.println(time);

        }
        public void recieveSize (){

            try {  //recieve file size
                System.out.println("waiting");
                InputStream inputStream2 = socket.getInputStream();
                reader1 = new InputStreamReader(inputStream2);
                bufferedReader1 = new BufferedReader(reader1);
                String message = bufferedReader1.readLine();
                numberFormatted=Integer.parseInt(message);
                System.out.println("Size is recieved " + numberFormatted);
                inputStream2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    public void recieveId (){

        try {
            System.out.println("waiting2");
            InputStream inputStream = socket2.getInputStream();
            reader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(reader);
            System.out.println("recieving");
            id = bufferedReader.readLine();

            System.out.println("Id is recieved " +id);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


        public void receiveFile ()
        {
            try {


                // socket = new Socket(SERVER, port);


                byte[] bytes = new byte[numberFormatted+1];
                System.out.println("array1");
                InputStream inputStream = socket1.getInputStream();
                fileOutputStream = new FileOutputStream(file);
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

                System.out.println("array2");
                readBytes = inputStream.read(bytes, 0, bytes.length);
                current = readBytes;
                do {
                    readBytes = inputStream.read(bytes, current, (bytes.length - current));
                    if (readBytes >= 0) {
                        current += readBytes;

                    }
                    System.out.println("array3");
                } while (readBytes > -1);
                bufferedOutputStream.write(bytes, 0, current);
                bufferedOutputStream.flush();
                System.out.println("file is received");
                System.out.println("file location"+file.getAbsolutePath());


            } catch (UnknownHostException e) {
                e.printStackTrace();
                System.out.println("nothing");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                {
                    try {
                        if (socket1 != null) socket1.close();
                        if (fileOutputStream != null) fileOutputStream.close();
                        if (bufferedOutputStream != null) bufferedOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    public  void createNewFile() {

        file = new File("Tests\\"+id );
        try {
            file.createNewFile();
            System.out.println("File is created");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void recieveTime (){

        try {
            System.out.println("waiting3");
            InputStream inputStream3 = socket3.getInputStream();
            reader2 = new InputStreamReader(inputStream3);
            bufferedReader2 = new BufferedReader(reader2);
            String message = bufferedReader2.readLine();
            time=Integer.parseInt(message);
            System.out.println("Size is recieved " + time);
            inputStream3.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

public String getId()
{
    return id;
}

    public File getFile() {
        return file;
    }
}

