package io.ikatoo.cryptoassets.config;

import java.io.IOException;

import org.json.JSONObject;

public class UserDataAPI extends GetterSetterFile {

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
