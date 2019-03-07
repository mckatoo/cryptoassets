/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ikatoo.cryptoassets.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;

/**
 *
 * @author mckatoo
 */
public class Parameters {
    private static String getPath() throws IOException {
        File _folder = new File(System.getProperty("user.home") + "/.cryptoassets/config");
        if (!_folder.exists()) {
            _folder.mkdirs();
        }

        File _file = new File(_folder + "/config.json");

        if (!_file.exists()) {
            _file.createNewFile();
        }
        return _file.getAbsolutePath();
    }

    public static void putFile(String recvWindow, String limit) throws IOException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("recvWindow", recvWindow);
        jsonObject.put("limit", limit);

        try (FileWriter file = new FileWriter(getPath())) {
            file.write(jsonObject.toString());
            file.close();
        }
    }

    public static int getRecvWindow() throws IOException {
        int key;
        try (FileReader file = new FileReader(getPath())) {
            BufferedReader bufferedReader = new BufferedReader(file);
            JSONObject jsonObject = new JSONObject(bufferedReader.readLine());
            key = jsonObject.getInt("recvWindow");
        }
        
        return key;
    }

    public static int getLimit() throws IOException {
        int key;
        try (FileReader file = new FileReader(getPath())) {
            BufferedReader bufferedReader = new BufferedReader(file);
            JSONObject jsonObject = new JSONObject(bufferedReader.readLine());
            key = jsonObject.getInt("limit");
        }
        
        return key;
    }

}
