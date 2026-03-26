package com.mycompany.java_gui;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    public static final String DATA_DIR = System.getProperty("user.dir") + File.separator + "data";
    static {
        File dir = new File(DATA_DIR);
        if (!dir.exists()) {
            boolean ok = dir.mkdirs();
            if (!ok) {
                System.err.println("WARNING: Could not create data directory at: " + DATA_DIR);
            }
        }
    }

    public static boolean saveToFile(String filename, Object obj) {
        String path = DATA_DIR + File.separator + filename;
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(obj);
            return true;
        } catch (IOException e) {
            System.err.println("ERROR saving file: " + path);
            e.printStackTrace();
            return false;
        }
    }

    
    public static <T> T loadFromFile(String filename, Class<T> expectedClass) {
        String path = DATA_DIR + File.separator + filename;
        File f = new File(path);
        if (!f.exists()) {
            try {
                if (expectedClass == List.class) {
                    return (T) new ArrayList<>();
                }
            } catch (Exception ignored) {}
            return null;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            return (T) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
}

}
