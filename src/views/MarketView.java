package views;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import datahandle.DataAPI;
import java.awt.*;

public class MarketView extends JFrame {
    public static DataAPI dataAPI;

    // Biến thành viên cho các bảng và model của chúng
    private JTable hotCoinsTable;
    private DefaultTableModel hotCoinsModel;

    private JTable newListingTable;
    private DefaultTableModel newListingModel;

    private JTable topGainerTable;
    private DefaultTableModel topGainerModel;

    private JTable topVolumeTable;
    private DefaultTableModel topVolumeModel;
  
    public static JLabel labelId;
    public static JLabel labelName;
    
    public MarketView() {
        // Set the title of the window
        setTitle("Markets Overview");
        setSize(1113, 624);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());

        // Create top navigation bar
        JPanel navBar = new JPanel();
        navBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        navBar.setBackground(new Color(24, 26, 27));

        String[] navOptions = {"Buy Crypto", "Markets", "Trade", "Futures", "Earn", "Square", "More"};
        for (String option : navOptions) {
            JLabel label = new JLabel(option);
            label.setForeground(Color.WHITE);
            navBar.add(label);
        }

        // Add login and signup buttons
        JButton loginButton = new JButton("Log In");
        JButton signUpButton = new JButton("Sign Up");
        navBar.add(loginButton);
        navBar.add(signUpButton);
        JPanel profile = new JPanel();
        profile.setLayout(new FlowLayout(FlowLayout.RIGHT)); // Đặt layout bên phải
        profile.setBackground(new Color(24, 26, 27)); // Cài màu nền cho profile panel

        labelId = new JLabel("ID:");
        labelId.setForeground(Color.WHITE);
        labelName = new JLabel("Name:");
        labelName.setForeground(Color.WHITE);
        profile.add(labelId);
        profile.add(labelName);
        navBar.add(profile);
        getContentPane().add(navBar, BorderLayout.NORTH);

        // Create the central content panel with horizontal layout
        JPanel contentPanel = new JPanel(new GridLayout(1, 4)); // Sử dụng GridLayout để sắp xếp các bảng ngang
        contentPanel.setBackground(new Color(24, 26, 27));

        // Thêm các bảng vào contentPanel
        contentPanel.add(createTableSection("Hot Coins", new String[]{"ID","Coin", "Price", "Change"}, new String[][]{
                {"BNB", "$574.40", "+2.66%"},
                {"BTC", "$63.73K", "+2.66%"},
                {"ETH", "$2.55K", "+5.61%"}
        }));

        contentPanel.add(createTableSection("New Listing", new String[]{"ID","Coin", "Price", "Change"}, new String[][]{
                {"1MBABYDC", "$0.0023316", "+5.08%"},
                {"NEIRO", "$0.00091001", "-1.26%"},
                {"TURBO", "$0.0064", "+23.31%"}
        }));

        contentPanel.add(createTableSection("Top Gainer Coin", new String[]{"ID","Coin", "Price", "Change"}, new String[][]{
                {"FIDA", "$0.368", "+55.01%"},
                {"SXP", "$0.3242", "+50.23%"},
                {"ARK", "$0.4209", "+29.75%"}
        }));

        contentPanel.add(createTableSection("Top Volume Coin", new String[]{"ID","Coin", "Price", "Change"}, new String[][]{
                {"BTC", "$63.73K", "+2.66%"},
                {"ETH", "$2.55K", "+5.61%"},
                {"SOL", "$150.18", "+8.07%"}
        }));

        // Add the content panel to the frame
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        // Set background color for the entire frame
        getContentPane().setBackground(new Color(24, 26, 27));
    }

    private JPanel createTableSection(String title, String[] columns, String[][] data) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(24, 26, 27));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(titleLabel, BorderLayout.NORTH);

        // Tạo bảng và model
        JTable table = new JTable(new DefaultTableModel(data, columns));
        table.setBackground(new Color(33, 37, 41));
        table.setForeground(Color.WHITE);
        table.setRowHeight(30);
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(170); 
        table.getColumnModel().getColumn(2).setPreferredWidth(100); 
        
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table.rowAtPoint(evt.getPoint());
                if (row >= 0) {
                	String coinName = table.getValueAt(row, 0).toString();
                	int coinID = Integer.parseInt(coinName);
                	OrderView orderView = new OrderView(coinID);
                	orderView.setVisible(true);
            
                }
            }
        });

        // Lưu trữ bảng và model
        if (title.equals("Hot Coins")) {
            hotCoinsTable = table;
            hotCoinsModel = (DefaultTableModel) table.getModel();
        } else if (title.equals("New Listing")) {
            newListingTable = table;
            newListingModel = (DefaultTableModel) table.getModel();
        } else if (title.equals("Top Gainer Coin")) {
            topGainerTable = table;
            topGainerModel = (DefaultTableModel) table.getModel();
        } else if (title.equals("Top Volume Coin")) {
            topVolumeTable = table;
            topVolumeModel = (DefaultTableModel) table.getModel();
        }

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
            MarketView dashboard = new MarketView();
            dataAPI.getListCoinTop(dashboard);
            dataAPI.getListGainerCoin(dashboard);
            dataAPI.getListVolumeCoin(dashboard);
            dataAPI.getListNewCoin(dashboard);
            dashboard.setVisible(true);
        });
    }
}
