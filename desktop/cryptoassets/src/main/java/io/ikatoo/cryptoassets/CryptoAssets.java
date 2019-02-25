/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ikatoo.cryptoassets;

import io.ikatoo.cryptoassets.interfaces.FrmMain;
import io.ikatoo.cryptoassets.uteis.FormManager;
import java.beans.PropertyVetoException;

/**
 *
 * @author mckatoo
 */
public class CryptoAssets {
    
    private static CryptoAssets instance;
    
    private static CryptoAssets getInstance() {
        if (instance == null) {
            instance = new CryptoAssets();
        }
        return instance;
    }
    
    public static void main(String[] args) throws PropertyVetoException {
        FrmMain frmmain = new FrmMain();
        FormManager.openForm(frmmain);
    }
}
