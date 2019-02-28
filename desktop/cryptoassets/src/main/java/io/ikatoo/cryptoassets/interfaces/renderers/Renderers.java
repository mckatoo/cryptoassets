/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ikatoo.cryptoassets.interfaces.renderers;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author mckatoo
 */
public class Renderers extends DefaultTableCellRenderer {
    
//    JLabel lbl = new JLabel();
//    public String pathImage;
//    public static ImageIcon[] images = {};

//    public void setImages(int i, ImageIcon images) {
//        this.images[i] = images;
//    }

//    @Override
//    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//        
//        lbl.setText((String) value);
//        lbl.setIcon(images[row]);
//        setHorizontalAlignment(CENTER);
//        setHorizontalTextPosition(CENTER);
//        
//        return lbl;
//    }
    
    @Override
    protected void setValue(Object value) {
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
