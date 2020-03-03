package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfiReaderFile {
    public static Properties configFILE;
static {
    String path ="login.properties";
    try{
        FileInputStream input = new FileInputStream(path);
        configFILE=new Properties();
        configFILE.load(input);
        input.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
public static String getProperty(String key){
    return configFILE.getProperty(key);

}
}
