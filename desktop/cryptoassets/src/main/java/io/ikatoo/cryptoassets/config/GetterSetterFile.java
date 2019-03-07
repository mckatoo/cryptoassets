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
import javax.swing.JOptionPane;
import org.json.JSONObject;

/**
 *
 * @author mckatoo
 */
public class GetterSetterFile {

    public static String getPath(String fileWithoutExtension) throws IOException {
        File _folder = new File(System.getProperty("user.home") + "/.cryptoassets/config");
        if (!_folder.exists()) {
            _folder.mkdirs();
            String api = JOptionPane.showInputDialog("Insira sua API KEY.");
            String secret = JOptionPane.showInputDialog("Insira sua SECRET KEY.");
            UserDataAPI.putFile(api, secret);
        }

        File _file = new File(_folder + "/" + fileWithoutExtension + ".json");

        if (!_file.exists()) {
            _file.createNewFile();
        }

        return _file.getAbsolutePath();
    }

    public static String getter(String fileWithoutExtension, String key) throws IOException {
        String _key;
        try (FileReader file = new FileReader(getPath(fileWithoutExtension))) {
            BufferedReader bufferedReader = new BufferedReader(file);
            JSONObject jsonObject = new JSONObject(bufferedReader.readLine());
            _key = jsonObject.getString(key);
        }

        return _key;
    }

    public static void setter(String fileWithoutExtension, JSONObject jsonObject) throws IOException {

        try (FileWriter file = new FileWriter(getPath(fileWithoutExtension))) {
            file.write(jsonObject.toString());
            file.close();
        }
    }
}
