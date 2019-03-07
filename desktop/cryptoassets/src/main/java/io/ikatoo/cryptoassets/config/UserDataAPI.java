package io.ikatoo.cryptoassets.config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONObject;

public class UserDataAPI extends GetterSetterFile {

//    private static String getPath() throws IOException {
//        File _folder = new File(System.getProperty("user.home") + "/.cryptoassets/config");
//        if (!_folder.exists()) {
//            _folder.mkdirs();
//            String api = JOptionPane.showInputDialog("Insira sua API KEY.");
//            String secret = JOptionPane.showInputDialog("Insira sua SECRET KEY.");
//            putApiSecretKey(api, secret);
//        }
//
//        File _file = new File(_folder + "/db.json");
//
//        if (!_file.exists()) {
//            _file.createNewFile();
//        }
//        
//        return _file.getAbsolutePath();
//    }
    public static void putFile(String api, String secret) throws IOException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("X-MBX-APIKEY", api);
        jsonObject.put("SECRET-KEY", secret);
        
        setter("api", jsonObject);
    }
    
    public static String getApiKey() throws IOException {
        return getter("api", "X-MBX-APIKEY");
    }
    
    public static String getSecretKey() throws IOException {
        return getter("api", "SECRET-KEY");
    }
    
}
