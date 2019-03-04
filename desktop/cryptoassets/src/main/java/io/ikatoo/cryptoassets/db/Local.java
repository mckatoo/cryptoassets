package io.ikatoo.cryptoassets.db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

import org.json.JSONObject;

public class Local {
    
    private static String getPath() throws IOException {
        File _folder = new File(System.getProperty("user.home") + "/.cryptoassets/db");
        if (!_folder.exists()) {
            _folder.mkdirs();
            String api = JOptionPane.showInputDialog("Insira sua API KEY.");
            String secret = JOptionPane.showInputDialog("Insira sua SECRET KEY.");
            putApiSecretKey(api, secret);
        }

        File _file = new File(_folder + "/db.json");

        if (!_file.exists()) {
            _file.createNewFile();
        }
        return _file.getAbsolutePath();
    }

    public static void putApiSecretKey(String api, String secret) throws IOException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("X-MBX-APIKEY", api);
        jsonObject.put("SECRET-KEY", secret);

        try (FileWriter file = new FileWriter(getPath())) {
            file.write(jsonObject.toString());
            
        }
    }

    public static String getApiKey() throws IOException {
        FileReader file = new FileReader(getPath());
        BufferedReader bufferedReader = new BufferedReader(file);
        JSONObject jsonObject = new JSONObject(bufferedReader.readLine());
        String key = jsonObject.getString("X-MBX-APIKEY");
        
        return key;
    }

    public static String getSecretKey() throws IOException {
        FileReader file = new FileReader(getPath());
        BufferedReader bufferedReader = new BufferedReader(file);
        JSONObject jsonObject;
        jsonObject = new JSONObject(bufferedReader.readLine());
        String key = jsonObject.getString("SECRET-KEY");

        return key;
    }

}
