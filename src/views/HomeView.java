package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class HomeView extends JFrame {

    public HomeView() {
        // Set the title of the window
        setTitle("Markets Overview");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
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
        
        add(navBar, BorderLayout.NORTH);
        
        // Create the central content panel
        JPanel contentPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        contentPanel.setBackground(new Color(24, 26, 27));

        // Hot Coins table
        String[] hotCoinsColumns = {"Coin", "Price", "Change"};
        String[][] hotCoinsData = {
                {"BNB", "$574.40", "+2.66%"},
                {"BTC", "$63.73K", "+2.66%"},
                {"ETH", "$2.55K", "+5.61%"}
        };
        JPanel hotCoinsPanel = createTableSection("Hot Coins", hotCoinsColumns, hotCoinsData);
        contentPanel.add(hotCoinsPanel);

        // New Listing table
        String[] newListingColumns = {"Coin", "Price", "Change"};
        String[][] newListingData = {
                {"1MBABYDC", "$0.0023316", "+5.08%"},
                {"NEIRO", "$0.00091001", "-1.26%"},
                {"TURBO", "$0.0064", "+23.31%"}
        };
        JPanel newListingPanel = createTableSection("New Listing", newListingColumns, newListingData);
        contentPanel.add(newListingPanel);

        // Top Gainer table
        String[] topGainerColumns = {"Coin", "Price", "Change"};
        String[][] topGainerData = {
                {"FIDA", "$0.368", "+55.01%"},
                {"SXP", "$0.3242", "+50.23%"},
                {"ARK", "$0.4209", "+29.75%"}
        };
        JPanel topGainerPanel = createTableSection("Top Gainer Coin", topGainerColumns, topGainerData);
        contentPanel.add(topGainerPanel);

        // Top Volume table
        String[] topVolumeColumns = {"Coin", "Price", "Change"};
        String[][] topVolumeData = {
                {"BTC", "$63.73K", "+2.66%"},
                {"ETH", "$2.55K", "+5.61%"},
                {"SOL", "$150.18", "+8.07%"}
        };
        JPanel topVolumePanel = createTableSection("Top Volume Coin", topVolumeColumns, topVolumeData);
        contentPanel.add(topVolumePanel);

        // Add the content panel to the frame
        add(contentPanel, BorderLayout.CENTER);
        
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

        JTable table = new JTable(new DefaultTableModel(data, columns));
        table.setBackground(new Color(33, 37, 41));
        table.setForeground(Color.WHITE);
        table.setRowHeight(30);

        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HomeView dashboard = new HomeView();
            dashboard.setVisible(true);
        });
    }
}
