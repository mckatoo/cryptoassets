/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ikatoo.cryptoassets.interfaces.renderers;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author mckatoo
 */
public class Renderers extends DefaultTableCellRenderer {
    
    @Override
    protected void setValue(Object value) {
        setHorizontalAlignment(SwingConstants.CENTER);
        if (value instanceof ImageIcon) {
            if (value != null) {
                ImageIcon d = (ImageIcon) value;
                setIcon(d);
            } else {
                setText("");
                setIcon(null);
            }
        } else {
            super.setValue(value);
        }
    }

    
    
    
}
