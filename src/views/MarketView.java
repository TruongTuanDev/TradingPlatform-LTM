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

        // Bỏ setTitle, setSize, setDefaultCloseOperation và setLocationRelativeTo

        setLayout(new BorderLayout());

        // Set background color for the entire panel
        setBackground(new Color(255, 0, 0)); // Màu đỏ

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

        // Add tables to contentPanel
        contentPanel.add(createTableSection("Hot Coins", new String[]{"ID", "Coin", "Price", "Change"}, new String[][]{
                {"BNB", "$574.40", "+2.66%"},
                {"BTC", "$63.73K", "+2.66%"},
                {"ETH", "$2.55K", "+5.61%"}
        }));

        contentPanel.add(createTableSection("New Listing", new String[]{"ID", "Coin", "Price", "Change"}, new String[][]{
                {"1MBABYDC", "$0.0023316", "+5.08%"},
                {"NEIRO", "$0.00091001", "-1.26%"},
                {"TURBO", "$0.0064", "+23.31%"}
        }));

        contentPanel.add(createTableSection("Top Gainer Coin", new String[]{"ID", "Coin", "Price", "Change"}, new String[][]{
                {"FIDA", "$0.368", "+55.01%"},
                {"SXP", "$0.3242", "+50.23%"},
                {"ARK", "$0.4209", "+29.75%"}
        }));

        contentPanel.add(createTableSection("Top Volume Coin", new String[]{"ID", "Coin", "Price", "Change"}, new String[][]{
                {"BTC", "$63.73K", "+2.66%"},
                {"ETH", "$2.55K", "+5.61%"},
                {"SOL", "$150.18", "+8.07%"}
        }));

        add(contentPanel, BorderLayout.CENTER);
    }

    private JPanel createTableSection(String title, String[] columns, String[][] data) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(0, 102, 204)); // Màu xanh dương đậm

        JLabel titleLabel = new JLabel(title);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(titleLabel, BorderLayout.NORTH);

        // Tạo bảng và model
        JTable table = new JTable(new DefaultTableModel(data, columns));
        table.setBackground(new Color(0, 0, 0)); // Màu vàng
        table.setForeground(new Color(255, 255, 255)); // Màu chữ đen
        table.setRowHeight(30);
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(170);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);

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

            MarketView dashboard = new MarketView();
            frame.add(dashboard);
            dataAPI.getListCoinTop(dashboard);
            dataAPI.getListGainerCoin(dashboard);
            dataAPI.getListVolumeCoin(dashboard);
            dataAPI.getListNewCoin(dashboard);
            frame.setVisible(true);
        });
    }
}
