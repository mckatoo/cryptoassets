/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ikatoo.cryptoassets.models.abstracts;

import io.ikatoo.cryptoassets.models.Portifolio;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mckatoo
 */
public class PortifolioATM extends AbstractTableModel {
    
    private final List<Portifolio> _portifolio = new ArrayList();
    private final DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    @Override
    public int getRowCount() {
        return _portifolio.size();
    }

    @Override
    public int getColumnCount() {
        return 11;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Portifolio portifolio = _portifolio.get(rowIndex);
        switch(columnIndex){
            case 0:
                return portifolio.getIcon();
            case 1:
                return portifolio.getAsset();
            case 2:
                return portifolio.getBuy() + " BTC";
            case 3:
                return df.format(portifolio.getDateBuy());
            case 4:
                return portifolio.getSell() + " BTC";
            case 5:
                return df.format(portifolio.getDateSell());
            case 6:
                return portifolio.getCurrent() + " BTC";
            case 7:
                return portifolio.getProfit() + "%";
            case 8:
                return portifolio.getFree() + " " + portifolio.getAsset();
            case 9:
                return portifolio.getInOrder() + " " + portifolio.getAsset();
            case 10:
                return portifolio.getTotalBalance() + " " + portifolio.getAsset();
            default:
                return "";
        }
    }
    
    public void add(Portifolio portifolio) {
        _portifolio.add(portifolio);
        fireTableRowsInserted(_portifolio.size() - 1, _portifolio.size() - 1);
    }
    
    public void del(Portifolio portifolio) {
        _portifolio.remove(portifolio);
        fireTableRowsInserted(_portifolio.size() - 1, _portifolio.size() - 1);
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "Icon";
            case 1:
                return "Asset";
            case 2:
                return "Buy";
            case 3:
                return "Date Buy";
            case 4:
                return "Sell";
            case 5:
                return "Date Sell";
            case 6:
                return "Current";
            case 7:
                return "Profit";
            case 8:
                return "Free";
            case 9:
                return "In Order";
            case 10:
                return "Total Balance";
            default:
                return "";
        }
    }
    
    public Portifolio getPortifolio(int line) {
        return _portifolio.get(line);
    }
    
}
