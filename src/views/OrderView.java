package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.SwingUtilities;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.OrderController;
import datahandle.DataAPI;

import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class OrderView extends JFrame{
	public String symbool;
	public String price;
	public String percentChange;
	
	JLabel lblParCoin,lblPriceOder,lbl24hChange;
	JSpinner txtPriceBuy,txtAmountBuy,txtPriceSell,txtAmountSell;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static DataAPI dataAPI;
	public static int coinId;
	private DefaultTableModel modelDataOtherCoin;
	public static JLabel lableUsername,lblAvbUSD,lblAvbUSD_1;
	private JButton btnTransaction;
	
	public OrderView() {
	}
	public int getCoinId() {
		return coinId;
	}


	public OrderView(int coinId, String symbool, String price, String percentChange) throws HeadlessException {
		this.coinId = coinId;
		this.symbool = symbool;
		this.price = price;
		this.percentChange = percentChange;
		dataAPI = new DataAPI(); 
		 SwingUtilities.invokeLater(() -> {
	            dataAPI.getListCoinTopOrther(this);
	        });
		initComponents();	

	}


	public OrderView(int coinId) {
		initComponents();

		
	}
	private void bindingData() {
//		lblParCoin.setText(symboool);
//		lblPriceOder.setText(price);
//		lbl24hChange.setText(percentChange);		
	}

	public void initComponents() {
		lableUsername = new JLabel();
		
		
		NumberFormat format = NumberFormat.getInstance(Locale.US);
		Number number = null;
		try {
			number = format.parse(price);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    double value = number.doubleValue();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1304, 713);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		 
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 0, 1290, 113);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnTransaction = new JButton("Deposit/Withdraw");
		btnTransaction.setBounds(1100, 23, 180, 30);
		btnTransaction.setBackground(new Color(0, 102, 204)); // Màu xanh đậm hơn
		btnTransaction.setFont(new Font("Times New Roman", Font.BOLD, 17)); // Chữ đậm hơn
		btnTransaction.setForeground(Color.WHITE);
		btnTransaction.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TransactionView  transactionView = new TransactionView();
				TransactionView.lblAccountId.setText(lableUsername.getText());
				TransactionView.txtBalance.setText(lblAvbUSD.getText());
				transactionView.setVisible(true);
			}
		});

		// Bo góc nút
		btnTransaction.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true)); // Viền trắng, bo tròn

		// Hiệu ứng hover
		btnTransaction.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btnTransaction.setBackground(new Color(51, 153, 255));
		        // Thay đổi màu khi hover
		    }

		    @Override
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btnTransaction.setBackground(new Color(0, 102, 204)); // Trả lại màu ban đầu khi không hover
		    }
		});

		// Hiệu ứng bo góc
		btnTransaction.setFocusPainted(false); // Loại bỏ viền mặc định khi nhấn vào
		btnTransaction.setOpaque(true);
		btnTransaction.setContentAreaFilled(true);
		panel.add(btnTransaction);
		lblParCoin = new JLabel("BTC");
		lblParCoin.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblParCoin.setBounds(49, 23, 73, 30);
		lblParCoin.setText(symbool);
		panel.add(lblParCoin);
		
		JLabel lblName = new JLabel("Price Bitcoin");
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblName.setBounds(59, 63, 79, 18);
		panel.add(lblName);
		
		lblPriceOder = new JLabel("62,864.94");
		lblPriceOder.setForeground(new Color(0, 255, 0));
		lblPriceOder.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblPriceOder.setBounds(220, 23, 134, 30);
		lblPriceOder.setText(price);
		panel.add(lblPriceOder);
		
		JLabel Changescs = new JLabel("24h Change");
		Changescs.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		Changescs.setBounds(391, 31, 79, 18);
		panel.add(Changescs);
		
		lbl24hChange = new JLabel("2%");
		lbl24hChange.setForeground(new Color(255, 0, 0));
		lbl24hChange.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lbl24hChange.setBounds(391, 63, 79, 18);
		lbl24hChange.setText(percentChange);
		panel.add(lbl24hChange);
		
		JLabel lblVolumn = new JLabel("20,496");
		lblVolumn.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblVolumn.setBounds(498, 63, 79, 18);
		panel.add(lblVolumn);
		
		JLabel lblhVolume = new JLabel("24h Volume");
		lblhVolume.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblhVolume.setBounds(480, 33, 79, 18);
		panel.add(lblhVolume);
		
		JLabel sssvege = new JLabel("MarketCap");
		sssvege.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		sssvege.setBounds(580, 33, 79, 18);
		panel.add(sssvege);
		
		JLabel lblMarketcap = new JLabel("20,496,909,987");
		lblMarketcap.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblMarketcap.setBounds(580, 63, 97, 18);
		panel.add(lblMarketcap);
		
		JLabel lblusdt = new JLabel("/USDT");
		lblusdt.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblusdt.setBounds(137, 23, 73, 30);
		panel.add(lblusdt);
		
        JPanel panelPriceOder = new JPanel();
        panelPriceOder.setBounds(0, 113, 299, 563);
        panelPriceOder.setLayout(new BorderLayout()); // Để bảng chiếm hết không gian
        contentPane.add(panelPriceOder);

        // Tạo mô hình dữ liệu cho bảng
        String[] dataListOder = { "Price (USDT)", "Amount (BTC)", "Total" };
        DefaultTableModel modelDataListModel = new DefaultTableModel(dataListOder, 0); // 0 là số dòng ban đầu

        // Tạo bảng JTable với mô hình dữ liệu
        JTable tableOder = new JTable(modelDataListModel);

        // Thêm bảng vào một JScrollPane để có thể cuộn nếu cần
        JScrollPane scrollPane = new JScrollPane(tableOder);
        panelPriceOder.add(scrollPane, BorderLayout.CENTER);

        // Thêm dữ liệu mẫu vào bảng (tùy ý)
        modelDataListModel.addRow(new Object[]{"63400", "0.1", "6340"});
        modelDataListModel.addRow(new Object[]{"63410", "0.2", "12682"});
        modelDataListModel.addRow(new Object[]{"63420", "0.5", "31710"});
		
		
		JPanel panelPriceOtherCoin = new JPanel();
		panelPriceOtherCoin.setBounds(1013, 113, 277, 563);
		// Tạo panel_1_1
		panelPriceOtherCoin.setLayout(new BorderLayout()); // Để bảng chiếm hết không gian
        contentPane.add(panelPriceOtherCoin);

        // Tạo mô hình dữ liệu cho bảng với các cột Name, Last Price, 24h Change
        String[] dataListOtherCoin = {"ID ","Name", "Last Price", "24h Change" };
        modelDataOtherCoin = new DefaultTableModel(dataListOtherCoin, 0); // 0 là số dòng ban đầu

        // Tạo bảng JTable với mô hình dữ liệu
        JTable tableOtherCoin = new JTable(modelDataOtherCoin);

        // Thêm bảng vào một JScrollPane để có thể cuộn nếu cần
        JScrollPane scrollPane2 = new JScrollPane(tableOtherCoin);
        panelPriceOtherCoin.add(scrollPane2, BorderLayout.CENTER);

        // Thêm dữ liệu mẫu vào bảng (tùy ý)
        modelDataOtherCoin.addRow(new Object[]{"1","Bitcoin", "63400", "+1.5%"});
        modelDataOtherCoin.addRow(new Object[]{"2","Ethereum", "4500", "-0.8%"});
        modelDataOtherCoin.addRow(new Object[]{"3","BNB", "400", "+2.1%"});
		
		JPanel panelBSOder = new JPanel();
		panelBSOder.setBounds(299, 460, 714, 216);
		contentPane.add(panelBSOder);

		// Sử dụng GridLayout với 1 hàng và 2 cột để chia panel_2 thành 2 phần bằng nhau
		panelBSOder.setLayout(new GridLayout(1, 2));

		// Tạo hai panel con với các màu khác nhau
		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(Color.BLUE); // Màu cho panel trái
		panelBSOder.add(leftPanel);
		leftPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Price");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 26, 53, 21);
		leftPanel.add(lblNewLabel);
		
		txtPriceBuy = new JSpinner();
		txtPriceBuy.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		txtPriceBuy.setBounds(73, 25, 212, 23);
		
		txtPriceBuy.setValue(value);
		leftPanel.add(txtPriceBuy);
		
		JLabel rgrbr = new JLabel("USDT");
		rgrbr.setForeground(Color.WHITE);
		rgrbr.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rgrbr.setBounds(294, 27, 53, 21);
		leftPanel.add(rgrbr);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setForeground(Color.WHITE);
		lblAmount.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblAmount.setBounds(10, 67, 63, 21);
		leftPanel.add(lblAmount);
		
		
		
		txtAmountBuy = new JSpinner();
		txtAmountBuy.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		txtAmountBuy.setBounds(73, 66, 212, 23);
		txtAmountBuy.setValue(0);
		leftPanel.add(txtAmountBuy);
		
		JLabel lblBtc = new JLabel("BTC");
		lblBtc.setForeground(Color.WHITE);
		lblBtc.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblBtc.setBounds(294, 67, 53, 21);
		leftPanel.add(lblBtc);
		
		JLabel lblNewLabel_1 = new JLabel("Avbl");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 120, 45, 13);
		leftPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Max Buy");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 143, 63, 13);
		leftPanel.add(lblNewLabel_1_1);
		
		JLabel bfbfbUSD = new JLabel("USDT");
		bfbfbUSD.setForeground(Color.WHITE);
		bfbfbUSD.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		bfbfbUSD.setBounds(294, 121, 45, 13);
		leftPanel.add(bfbfbUSD);
		
		JLabel lblCoinMax = new JLabel("BTC");
		lblCoinMax.setForeground(Color.WHITE);
		lblCoinMax.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCoinMax.setBounds(294, 144, 45, 13);
		leftPanel.add(lblCoinMax);
		
		lblAvbUSD = new JLabel("Tâmmmm");
		lblAvbUSD.setForeground(Color.WHITE);
		lblAvbUSD.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblAvbUSD.setBounds(180, 121, 100, 13);
		leftPanel.add(lblAvbUSD);
		
		JLabel lblCoinMax_2 = new JLabel("0.356");
		lblCoinMax_2.setForeground(Color.WHITE);
		lblCoinMax_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCoinMax_2.setBounds(219, 144, 45, 13);
		leftPanel.add(lblCoinMax_2);
		
		JButton btnBuy = new JButton("BUY");
		btnBuy.setBackground(new Color(0, 255, 64));
		btnBuy.setForeground(new Color(255, 255, 255));
		btnBuy.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnBuy.setBounds(10, 177, 329, 29);
		
		btnBuy.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("ok3");
				double quantity_order = ((Number) txtAmountBuy.getValue()).doubleValue();
			    String symbol = symbool;
			    LocalDateTime currentDateTime = LocalDateTime.now();
			    String buyDate = currentDateTime.toString();
			    String userName=lableUsername.getText();
			    System.out.println("User name : "+userName );
			    double priceBuy =((Number) txtPriceBuy.getValue()).doubleValue();
			    double AvbUSD = Double.parseDouble(lblAvbUSD.getText()); 
			    double quantityUSD = priceBuy * quantity_order;
			    if(AvbUSD < quantityUSD) {
					JOptionPane.showMessageDialog(null, "Số dư không đủ");
			    }else {
			    	 OrderController.buyCoin(priceBuy, quantity_order, symbol, buyDate,userName);
			    }
			   
			}
		});
	
		leftPanel.add(btnBuy);

		JPanel rightPanel = new JPanel();
		rightPanel.setBackground(Color.ORANGE); // Màu cho panel phải
		panelBSOder.add(rightPanel);
		rightPanel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Price");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(10, 26, 53, 21);
		rightPanel.add(lblNewLabel_2);
		
		JLabel lblAmount_1 = new JLabel("Amount");
		lblAmount_1.setForeground(Color.WHITE);
		lblAmount_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblAmount_1.setBounds(10, 67, 66, 21);
		rightPanel.add(lblAmount_1);
		
		txtPriceSell = new JSpinner();
		txtPriceSell.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		txtPriceSell.setBounds(73, 25, 212, 23);
		txtPriceSell.setValue(value);
		rightPanel.add(txtPriceSell);
		
		txtAmountSell = new JSpinner();
		txtAmountSell.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		txtAmountSell.setBounds(73, 65, 212, 23);
		rightPanel.add(txtAmountSell);
		
		JLabel rgrbr_1 = new JLabel("USDT");
		rgrbr_1.setForeground(Color.WHITE);
		rgrbr_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rgrbr_1.setBounds(294, 26, 53, 21);
		rightPanel.add(rgrbr_1);
		
		JLabel lblCoin_1 = new JLabel("BTC");
		lblCoin_1.setForeground(Color.WHITE);
		lblCoin_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblCoin_1.setBounds(295, 67, 53, 21);
		rightPanel.add(lblCoin_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Avbl");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(10, 120, 45, 13);
		rightPanel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Max Sell");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(10, 143, 63, 13);
		rightPanel.add(lblNewLabel_1_1_1);
		
		JLabel bfbfbUSD_1 = new JLabel("USDT");
		bfbfbUSD_1.setForeground(Color.WHITE);
		bfbfbUSD_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		bfbfbUSD_1.setBounds(302, 143, 45, 13);
		rightPanel.add(bfbfbUSD_1);
		
		JLabel lblCoinMax_1 = new JLabel("BTC");
		lblCoinMax_1.setForeground(Color.WHITE);
		lblCoinMax_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCoinMax_1.setBounds(302, 120, 45, 13);
		rightPanel.add(lblCoinMax_1);
		
		lblAvbUSD_1 = new JLabel("Tâm");
		lblAvbUSD_1.setForeground(Color.WHITE);
		lblAvbUSD_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblAvbUSD_1.setBounds(219, 121, 45, 13);
		rightPanel.add(lblAvbUSD_1);
		
		JLabel lblCoinMaxSell = new JLabel("0.356");
		lblCoinMaxSell.setForeground(Color.WHITE);
		lblCoinMaxSell.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCoinMaxSell.setBounds(219, 144, 45, 13);
		rightPanel.add(lblCoinMaxSell);
		
		JButton btnSell = new JButton("SELL");
		btnSell.setForeground(Color.WHITE);
		btnSell.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnSell.setBackground(new Color(255, 0, 0));
		btnSell.setBounds(10, 177, 329, 29);
		btnSell.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("ok3");
				double quantity_order = ((Number) txtAmountSell.getValue()).doubleValue();
			    String symbol = symbool;
			    LocalDateTime currentDateTime = LocalDateTime.now();
			    String buyDate = currentDateTime.toString();
			    String userName=lableUsername.getText();
			    double priceSell =((Number) txtPriceSell.getValue()).doubleValue();;
			    Double quantityCrurent = Double.parseDouble(lblAvbUSD_1.getText()) ;
			    if(quantityCrurent < quantity_order) {
			    	JOptionPane.showMessageDialog(null, "Số dư không đủ");
			    }else {
			    	OrderController.sellCoin(priceSell, quantity_order, symbol, buyDate,userName);
			    }		    
			}
		});
		rightPanel.add(btnSell);
	}

	 public void updateHotCoinsTable(String[][] topGainerData) {
		 modelDataOtherCoin.setRowCount(0);
	        for (String[] row : topGainerData) {
	        	modelDataOtherCoin.addRow(row);
	        }
	    }
}

