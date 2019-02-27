/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ikatoo.cryptoassets.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javafx.scene.Parent;
import javax.swing.JOptionPane;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 *
 * @author mckatoo
 */
public class ConsumeAPI {

    public static String _secret = "pNg6fI3m0ABq9lEFebOyZ5pMaxmLpHkcJDOjmasKmCYbdnP11ea78iZwqZkIhsff";
    private static ExecutorService executorService = Executors.newFixedThreadPool(1);

    public String httpClientResponse(String url) {

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                TimeUnit.SECONDS.sleep(2);
                return "";
            }

        });

        String outputString = null;
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            HttpGet getRequest = new HttpGet(url);
            getRequest.addHeader("X-MBX-APIKEY", "yesxXQ52di1D2RyMMst97NCRy2dHsBrXzShoSaXXEmVRvJG3wVZm7qtn3AM3zNK0");

            HttpResponse response = httpClient.execute(getRequest);

            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }

            BufferedReader br = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));

            while ((outputString = br.readLine()) != null) {
                return outputString;
            }

            httpClient.close();

        } catch (ClientProtocolException e) {
            JOptionPane.showMessageDialog(null,e);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,e);
        }

        return outputString;
    }

}
