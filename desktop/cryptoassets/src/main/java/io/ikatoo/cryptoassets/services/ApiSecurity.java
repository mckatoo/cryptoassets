/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ikatoo.cryptoassets.services;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Hex;

/**
 *
 * @author mckatoo
 */
public final class ApiSecurity {

    private static ApiSecurity instance;

    private static ApiSecurity getInstance() {
        if (instance == null) {
            instance = new ApiSecurity();
        }
        return instance;
    }

    public static String encode(String key, String query) throws Exception {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
        sha256_HMAC.init(secret_key);
        return Hex.encodeHexString(sha256_HMAC.doFinal(query.getBytes("UTF-8")));
    }
}
