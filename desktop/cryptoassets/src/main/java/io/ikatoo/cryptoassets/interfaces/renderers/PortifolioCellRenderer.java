/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ikatoo.cryptoassets.interfaces.renderers;

import java.awt.Color;
import java.awt.Component;
import java.math.BigDecimal;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author mckatoo
 */
public class PortifolioCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if ((column == 5) && (new BigDecimal(value.toString().substring(0, value.toString().length() - 1)).compareTo(BigDecimal.ZERO) == 1)) {
            setBackground(Color.decode("#009b24"));
            setForeground(Color.white);
        } else {
            setBackground(Color.red);
            setForeground(Color.white);
        }
        
        setHorizontalAlignment(SwingConstants.CENTER);

        if (value instanceof ImageIcon) {
            setBackground(Color.white);
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

        return this;
    }

}
