package main.java.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by lukas_cerny on 31. 3. 2016.
 */
public class LocateString {
    /** Instance properties */
    private static Properties prop = new Properties();

    /**
     * Staticky blok pro vytvoreni a nacteni dat do properties
     */
    static{
        InputStream input = null;
        try {

            String filename = "main\\resources\\Messages.properties";
            input = LocateString.class.getClassLoader().getResourceAsStream(filename);
            if(input==null) System.out.println("Sorry, unable to find " + filename);
            prop.load(input);
        } catch (IOException ex) {
            System.exit(1);
        } finally{
            if(input!=null){
                try {
                    input.close();
                } catch (IOException e) {
                    System.err.println(LocateString.getValue("error.close_properties"));
                }
            }
        }
    }

    /**
     * Vraci vetu definovanou v properties souboru
     * @param key - klic v properties
     * @return veta z properties
     */
    public static String getValue(String key){
        return prop.getProperty(key);
    }
}
