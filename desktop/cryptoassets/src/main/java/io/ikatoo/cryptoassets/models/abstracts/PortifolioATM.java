/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ikatoo.cryptoassets.models.abstracts;

import io.ikatoo.cryptoassets.models.Portifolio;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
    private final DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm");

    @Override
    public int getRowCount() {
        return _portifolio.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Portifolio portifolio = _portifolio.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return portifolio.getIcon();
            case 1:
                return portifolio.getAsset();
            case 2:
                return portifolio.getBuy().setScale(8, RoundingMode.HALF_EVEN).toPlainString() + " BTC";
            case 3:
                if (portifolio.getDateBuy().getTime() == 0) {
                    return "00/00/00";
                }
                return df.format(portifolio.getDateBuy());
            case 4:
                return portifolio.getCurrent().setScale(8, RoundingMode.HALF_EVEN).toPlainString() + " BTC";
            case 5:
                BigDecimal profit = portifolio.getProfit();
                if (profit.compareTo(BigDecimal.ZERO) == 1) {
                    return profit.setScale(2, RoundingMode.DOWN).toPlainString() + "%";
                } else {
                    return profit.setScale(2, RoundingMode.UP).toPlainString() + "%";
                }
            case 6:
                return portifolio.getFree().setScale(8, RoundingMode.HALF_EVEN).toPlainString() + " " + portifolio.getAsset();
            case 7:
                return portifolio.getInOrder().setScale(8, RoundingMode.HALF_EVEN).toPlainString() + " " + portifolio.getAsset();
            case 8:
                return portifolio.getTotalBalance().setScale(8, RoundingMode.HALF_EVEN).toPlainString() + " " + portifolio.getAsset();
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
        switch (column) {
            case 0:
                return "Icon";
            case 1:
                return "Asset";
            case 2:
                return "Buy - Average Price";
            case 3:
                return "Date Buy - First Buy";
            case 4:
                return "Current";
            case 5:
                return "Profit";
            case 6:
                return "Free";
            case 7:
                return "In Order";
            case 8:
                return "Total Balance";
            default:
                return "";
        }
    }

    public Portifolio getPortifolio(int line) {
        return _portifolio.get(line);
    }

}
