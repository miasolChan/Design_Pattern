package singleton;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOTest {
    private static IOTest instance = null;
    private String data = "";
    private static String filePath = "C:\\Users\\miasol\\Desktop\\IOTest.txt";
    public static IOTest getInstance(){
        if (instance == null){
            instance = new IOTest();
        }
        return instance;
    }

    private IOTest() {
        StringBuffer str = new StringBuffer();
        FileReader reader = null;
        File file = new File(filePath);
        try
        {
            reader = new FileReader(file);
            char[] ch = new char[1024];
            int n;
            while ((n = reader.read(ch)) != -1) {
                str.append(new String(ch, 0, n));
            }
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }finally
        {
            data = str.toString();
            try{
                reader.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    };

    public void setData(String data) {
        this.data = data;
    }
    public String getData(){
        return data;
    }
}
