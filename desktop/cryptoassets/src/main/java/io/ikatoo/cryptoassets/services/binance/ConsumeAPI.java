/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ikatoo.cryptoassets.services.binance;

import io.ikatoo.cryptoassets.config.UserDataAPI;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.sql.Timestamp;

/**
 *
 * @author mckatoo
 */
public class ConsumeAPI {

    public static String _secret;

    long now = new Timestamp(System.currentTimeMillis()).getTime();

    private static ConsumeAPI instance;

    private static ConsumeAPI getInstance() throws IOException {
        if (instance == null) {
            instance = new ConsumeAPI();
        }
        return instance;
    }

    public HttpResponse<String> getResponse(String url) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("X-MBX-APIKEY", UserDataAPI.getApiKey())
                .build();

        HttpResponse<String> response
                = client.send(request, BodyHandlers.ofString());

        return response;
    }

    public String httpClientResponse(String url) throws IOException, InterruptedException {

        HttpResponse<String> response = getResponse(url);
        
        return response.body();
    }

}
