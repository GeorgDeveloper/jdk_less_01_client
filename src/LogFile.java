import java.io.*;
import java.util.ArrayList;

public class LogFile {
    private byte[] buffer;
    private FileOutputStream outputStream;
    private FileInputStream inputStream;


    File logFile = new File("logFile.txt");


    public void writeLog(String file) {
        byte[] buffer = file.getBytes();
        try {
            outputStream = new FileOutputStream(logFile);
            outputStream.write(buffer);
            outputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<String> readLog(){
        ArrayList<String> result = new ArrayList<>();
        try {
            inputStream = new FileInputStream(logFile);
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                result.add(new String(buffer, 0, bytesRead));
            }
            inputStream.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

}
