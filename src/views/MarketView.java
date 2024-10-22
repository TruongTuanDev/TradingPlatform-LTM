package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import datahandle.DataAPI;
import entities.DataItem;

import java.awt.*;
import java.text.NumberFormat;
import java.util.Locale;
import utils.*;

import javax.swing.table.DefaultTableCellRenderer;

public class MarketView extends JPanel {
    public static DataAPI dataAPI;

    private JTable hotCoinsTable;
    private DefaultTableModel hotCoinsModel;

    private JTable newListingTable;
    private DefaultTableModel newListingModel;

    private JTable topGainerTable;
    private DefaultTableModel topGainerModel;

    private JTable topVolumeTable;
    private DefaultTableModel topVolumeModel;

    public static JLabel labelId;
    public static JLabel labelName, lableBalance;

    public MarketView() {
        lableBalance = new JLabel();

        setLayout(new BorderLayout());
        setBackground(new Color(255, 0, 0)); // Màu đỏ

        // Khởi tạo DefaultTableModel
        hotCoinsModel = new DefaultTableModel(new Object[]{"ID", "Coin", "Price", "Change"}, 0);
        newListingModel = new DefaultTableModel(new Object[]{"ID", "Coin", "Price", "Change"}, 0);
        topGainerModel = new DefaultTableModel(new Object[]{"ID", "Coin", "Price", "Change"}, 0);
        topVolumeModel = new DefaultTableModel(new Object[]{"ID", "Coin", "Price", "Change"}, 0);

        // Create top navigation bar
        JPanel navBar = new JPanel();
        navBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        navBar.setBackground(new Color(0, 102, 204));

        JPanel profile = new JPanel();
        profile.setLayout(new FlowLayout(FlowLayout.RIGHT));
        profile.setBackground(new Color(0, 102, 204)); // Màu xanh dương đậm

        labelId = new JLabel();
        labelId.setForeground(Color.WHITE);
        labelName = new JLabel("Anonymus");
        labelName.setForeground(Color.WHITE);
        labelName.setFont(new Font("Trebuchet MS", Font.ITALIC, 21));

        profile.add(labelId);

        JLabel lblNewLabel = new JLabel("UserName : ");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        profile.add(lblNewLabel);
        profile.add(labelName);
        navBar.add(profile);
        add(navBar, BorderLayout.NORTH);

        // Create the central content panel with horizontal layout
        JPanel contentPanel = new JPanel(new GridLayout(1, 4));
        contentPanel.setBackground(new Color(255, 215, 0)); // Màu vàng

        // Add tables to contentPanel with initialized models
        contentPanel.add(createTableSection("Hot Coins", hotCoinsModel));
        contentPanel.add(createTableSection("New Listing", newListingModel));
        contentPanel.add(createTableSection("Top Gainer Coin", topGainerModel));
        contentPanel.add(createTableSection("Top Volume Coin", topVolumeModel));

        add(contentPanel, BorderLayout.CENTER);
    }

    private JPanel createTableSection(String title, DefaultTableModel model) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(0, 102, 204)); // Màu xanh dương đậm

        JLabel titleLabel = new JLabel(title);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(titleLabel, BorderLayout.NORTH);

        JTable table = new JTable(model); // Sử dụng model đã khởi tạo
        table.setBackground(new Color(0, 0, 0)); 
        table.setForeground(new Color(255, 255, 255)); 
        table.setRowHeight(30);

        // Định dạng màu cột thay đổi giá
        table.getColumnModel().getColumn(3).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus,
                                                           int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (value instanceof String && ((String) value).startsWith("-")) {
                    c.setForeground(Color.RED); 
                } else {
                    c.setForeground(Color.GREEN); 
                }

                return c;
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table.rowAtPoint(evt.getPoint());
                if (row >= 0) {
                    String coinName = table.getValueAt(row, 0).toString();
                    int coinID = Integer.parseInt(coinName);
                    String symbol = table.getValueAt(row, 1).toString();
                    String price = table.getValueAt(row, 2).toString();
                    double priceValue = Double.parseDouble(price.replace("$", "").replace(",", ""));

                    NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
                    String formattedNumber = numberFormat.format(priceValue);

                    String percentChange = table.getValueAt(row, 3).toString();
                    OrderView orderView = new OrderView(coinID, symbol, formattedNumber, percentChange);
                    OrderView.lableUsername.setText(labelName.getText());
                    OrderView.lblAvbUSD.setText(lableBalance.getText());
                    orderView.setVisible(true);
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    public void updateHotCoinsTable(String[][] hotCoinsData) {
        hotCoinsModel.setRowCount(0);
        for (String[] row : hotCoinsData) {
            hotCoinsModel.addRow(row);
        }
    }

    public void updateNewListingTable(String[][] newListingData) {
        newListingModel.setRowCount(0);
        for (String[] row : newListingData) {
            newListingModel.addRow(row);
        }
    }

    public void updateTopGainerTable(String[][] topGainerData) {
        topGainerModel.setRowCount(0);
        for (String[] row : topGainerData) {
            topGainerModel.addRow(row);
        }
    }

    public void updateTopVolumeTable(String[][] topVolumeData) {
        topVolumeModel.setRowCount(0);
        for (String[] row : topVolumeData) {
            topVolumeModel.addRow(row);
        }
    }

    public static void main(String[] args) {
        dataAPI = new DataAPI();
        
        SwingUtilities.invokeLater(() -> {
        	 JFrame frame = new JFrame("Markets Overview");
             frame.setSize(1113, 624);
             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             frame.setLocationRelativeTo(null);

             MarketView dashboard = new MarketView();  // Sử dụng JPanel
             frame.add(dashboard);  // Thêm JPanel vào JFrame

             dataAPI.getListCoinTop(dashboard);
             dataAPI.getListGainerCoin(dashboard);
             dataAPI.getListVolumeCoin(dashboard);
             dataAPI.getListNewCoin(dashboard);
             frame.setVisible(true);  // Hiển thị JFrame chứa JPanel
        });
    }
}
