package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Desktop;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import com.mysql.jdbc.Connection;

import controller.MarketController;
import datahandle.DataAPI;
import model.Token;
import socket.SocketHandle;
import utils.DrawPanel;
import utils.EventViewMain;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JPopupMenu;
public class MainView extends JFrame implements ActionListener {

	JPanel panelMenu, panelExit, panelHienThi, panelMenubar;
	JPanel panelReport,panelHome,panelAddProduct,panelSell,panelStocks,panelSetting,PanelHome;
	JLabel lblSearch, lblCodeAcc, lblAboutMe;
	JScrollPane scrollPane;
	JScrollPane scrollPaneProduct;
	JButton btnLogout;
	JSeparator separator;
	JLabel lblNewLabel, lblPosi, lblExit, lblicon;
	public static JLabel lblNameLg;
	public static JLabel lblPosition;	
	Connection con;
	JPopupMenu menuTable;
	DefaultTableModel model;
	JScrollPane scrollPane_1;
	JSeparator separator_2;
	JLabel lblInformationProduct;
	JPanel panelImagePr;
	JScrollPane scrollPane_2;
	
    private JPanel panelStock = new JPanel();
    private JPanel panelSta = new JPanel();
    private JPanel panelAddPr = new JPanel();
    private JPanel panelSale = new JPanel();
  
    private JPanel panel_1;
    private JLabel lblNewLabel_1;
    private EventViewMain eventViewMain;
  
    
    private static String nameLg;
    public static JLabel lblIconAcc;
    public static DataAPI dataAPI;
    boolean dataReceived = false;
    
    
    public MainView() {
		initComponents();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1600, 800);
		getContentPane().setLayout(null);
		panelHome.setBackground(Color.cyan);
		OrderView orderView = new OrderView(); 
		
	}
  
		
		public void processData() {
		    while (!dataReceived) {
		     
		    }
		    List<Token> listTokens = SocketHandle.receivedTokenList;
		    for (Token token : listTokens) {
		        System.out.println("UI CLIENT " + token.toString());
		    }
		}
    
    public MainView(String name) {
    	this.nameLg = name;
    	initComponents();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1600, 800);
		getContentPane().setLayout(null);
		panelHome.setBackground(Color.cyan);
    }
    
	
	private void initComponents() {
		
		dataAPI = new DataAPI();
		PanelHome = new JPanel();
		PanelHome.setLayout(null);
		
		panelAddPr = new JPanel();
		panelAddPr.setLayout(null);
		
		MarketView dashboard = new MarketView(); 
		dashboard.setBounds(0, 0, 1447, 692);  // Đặt kích thước cho MarketView
	    PanelHome.add(dashboard);// Thêm JPanel vào JFrame
	    OrderView orderView = new OrderView();
	    SendMoneyView sendMoneyView = new SendMoneyView();
	    sendMoneyView.setBounds(0, 0, 1447, 692);  
	    panelAddPr.add(sendMoneyView);
	    
	    dataAPI.getListMyCoin(dashboard);
        dataAPI.getListCoinTop(dashboard);
        dataAPI.getListGainerCoin(dashboard);
        dataAPI.getListVolumeCoin(dashboard);
        dataAPI.getListNewCoin(dashboard);
        
		PanelHome.setBounds(98, 71, 1447, 692);
		
		panelStock = new JPanel();	
		panelStock.setBounds(98, 71, 1447, 692);
		panelSale = new JPanel();
		panelSale.setBounds(98, 71, 1447, 692);
		panelSta = new JPanel();
		panelSta.setBounds(98, 71, 1447, 692);
		
		panelAddPr.setBounds(98, 71, 1447, 692);

		panelMenu = new DrawPanel(0, 0, 0, 0);
		panelMenu.setBounds(0, 0, 98, 790);
		panelMenu.setBackground(Color.BLUE);
		getContentPane().add(panelMenu);
		panelMenu.setLayout(null);
		
		eventViewMain = new EventViewMain();
		
		
		getContentPane().add(PanelHome);
		getContentPane().add(panelStock);
		getContentPane().add(panelSale);
		getContentPane().add(panelSta);
		getContentPane().add(panelAddPr);
	
		panelMenubar = new JPanel();
		panelMenubar.setBackground(new Color(0, 128, 64));
		panelMenubar.setBounds(88, 0, 1448, 72);
		panelMenubar.setBorder(new LineBorder(Color.gray, 3));
		getContentPane().add(panelMenubar);
		panelMenubar.setLayout(null);

		lblAboutMe = new JLabel("About me");
		lblAboutMe.setIcon(new ImageIcon(MainView.class.getResource("/Item/about.png")));
		lblAboutMe.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAboutMe.setHorizontalTextPosition(JLabel.CENTER);
		lblAboutMe.setVerticalTextPosition(JLabel.BOTTOM);
		lblAboutMe.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Desktop link = Desktop.getDesktop();
				try {
					link.browse(new URI("https://www.facebook.com/profile.php?id=100016625893826"));
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				}
			}
		});
		lblAboutMe.setBounds(56, 563, 85, 101);
		panelMenu.add(lblAboutMe);

		lblIconAcc = new JLabel("");
		lblIconAcc.setVerticalAlignment(SwingConstants.BOTTOM);
		lblIconAcc.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconAcc.setBounds(26, 10, 126, 86);
		panelMenu.add(lblIconAcc);

		lblNewLabel = new JLabel("Wecome :");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setBounds(23, 10, 65, 24);
		panelMenubar.add(lblNewLabel);

		lblPosi = new JLabel("Position  :");
		lblPosi.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblPosi.setBackground(Color.BLACK);
		lblPosi.setBounds(23, 38, 65, 24);
		panelMenubar.add(lblPosi);

		lblNameLg = new JLabel();
		lblNameLg.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		lblNameLg.setText(nameLg);
		lblNameLg.setBounds(98, 12, 162, 20);
		panelMenubar.add(lblNameLg);

		lblPosition = new JLabel("Admin");
		lblPosition.setToolTipText("");
		lblPosition.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		lblPosition.setBounds(98, 38, 162, 20);
		panelMenubar.add(lblPosition);
		
		lblExit = new JLabel("X");
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				eventViewMain.closeMenu(panelMenu);
			}
		});
		lblExit.setBackground(Color.red);
		lblExit.setOpaque(true);
		lblExit.setBounds(162, 0, 38, 20);
		panelMenu.add(lblExit);

		btnLogout = new JButton();
		btnLogout.setIcon(new ImageIcon(MainView.class.getResource("/Item/exit.png")));
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogout.setBackground(new Color(255, 0, 0));
		btnLogout.setBounds(0, 710, 206, 41);
		btnLogout.addActionListener(this);
		panelMenu.add(btnLogout);
		
		panelHome = new JPanel();
		panelHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelHome.setVisible(true);
				panelStock.setVisible(false);  
				panelSale.setVisible(false); 
				panelSta.setVisible(false); 
				panelAddPr.setVisible(false);
				
				panelHome.setBackground(Color.cyan);
				panelReport.setBackground(new Color(0, 0, 255));
				panelAddProduct.setBackground(new Color(0, 0, 255));
                panelSell.setBackground(new Color(0, 0, 255));
                panelStocks.setBackground(new Color(0, 0, 255));
                panelSetting.setBackground(new Color(0, 0, 255));
                eventViewMain.openMenu(panelMenu);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panelHome.setBackground(Color.lightGray);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelHome.setBackground(new Color(0, 0, 255));
			}
		});
		panelHome.setBackground(new Color(0, 0, 255));
		panelHome.setBounds(0, 115, 200, 59);
		panelMenu.add(panelHome);
		panelHome.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 0, 0));
		panel_1.setBounds(0, 0, 18, 60);
		panelHome.add(panel_1);
		
		lblNewLabel_1 = new JLabel("Markets");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(106, 10, 150, 41);
		panelHome.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(MainView.class.getResource("/Item/home (2).png")));
		lblNewLabel_2.setBounds(22, 0, 74, 60);
		panelHome.add(lblNewLabel_2);
		
		panelAddProduct = new JPanel();
		panelAddProduct.setLayout(null);
		panelAddProduct.setBackground(Color.BLUE);
		panelAddProduct.setBounds(0, 174, 200, 59);
		panelAddProduct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelStock.setVisible(false);  
				panelSale.setVisible(false); 
				panelSta.setVisible(false); 
				PanelHome.setVisible(false);
				panelAddPr.setVisible(true);
				
				panelAddProduct.setBackground(Color.cyan);
				panelReport.setBackground(new Color(0, 0, 255));
				panelHome.setBackground(new Color(0, 0, 255));
                panelSell.setBackground(new Color(0, 0, 255));
                panelStocks.setBackground(new Color(0, 0, 255));
                panelSetting.setBackground(new Color(0, 0, 255));
                eventViewMain.openMenu(panelMenu);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panelAddProduct.setBackground(Color.lightGray);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelAddProduct.setBackground(Color.BLUE);
			}
		});
		panelMenu.add(panelAddProduct);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.RED);
		panel_1_1.setBounds(0, 0, 18, 60);
		panelAddProduct.add(panel_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Transaction");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(106, 10, 150, 41);
		panelAddProduct.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(MainView.class.getResource("/Item/addItem.png")));
		lblNewLabel_2_1.setBounds(28, 0, 68, 60);
		panelAddProduct.add(lblNewLabel_2_1);
		
		panelSell = new JPanel();
		panelSell.setLayout(null);
		panelSell.setBackground(Color.BLUE);
		panelSell.setBounds(0, 233, 200, 59);
		panelSell.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelStock.setVisible(false);  
				panelSale.setVisible(true); 
				panelSta.setVisible(false); 
				PanelHome.setVisible(false);
				panelAddPr.setVisible(false);
				
				panelSell.setBackground(Color.cyan);
				panelReport.setBackground(new Color(0, 0, 255));
				panelAddProduct.setBackground(new Color(0, 0, 255));
				panelHome.setBackground(new Color(0, 0, 255));
                panelStocks.setBackground(new Color(0, 0, 255));
                panelSetting.setBackground(new Color(0, 0, 255));
                eventViewMain.openMenu(panelMenu);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panelSell.setBackground(Color.lightGray);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelSell.setBackground(Color.BLUE);
			}
		});
		panelMenu.add(panelSell);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(Color.RED);
		panel_1_2.setBounds(0, 0, 18, 60);
		panelSell.add(panel_1_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Place Order");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1_2.setBounds(106, 10, 150, 41);
		panelSell.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.setIcon(new ImageIcon(MainView.class.getResource("/Item/buy.png")));
		lblNewLabel_2_2.setBounds(28, 0, 68, 60);
		panelSell.add(lblNewLabel_2_2);
		
		panelStocks = new JPanel();
		panelStocks.setLayout(null);
		panelStocks.setBackground(Color.BLUE);
		panelStocks.setBounds(0, 291, 200, 59);
		panelStocks.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelStock.setVisible(true); 
				panelSale.setVisible(false); 
				panelSta.setVisible(false); 
				PanelHome.setVisible(false);
				panelAddPr.setVisible(false);
				
				panelStocks.setBackground(Color.cyan);
				panelReport.setBackground(new Color(0, 0, 255));
				panelAddProduct.setBackground(new Color(0, 0, 255));
                panelSell.setBackground(new Color(0, 0, 255));
                panelHome.setBackground(new Color(0, 0, 255));
                panelSetting.setBackground(new Color(0, 0, 255));
                eventViewMain.openMenu(panelMenu);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panelStocks.setBackground(Color.lightGray);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelStocks.setBackground(Color.BLUE);
			}
		});
		panelMenu.add(panelStocks);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setBackground(Color.RED);
		panel_1_3.setBounds(0, 0, 18, 60);
		panelStocks.add(panel_1_3);
		
		JLabel lblNewLabel_1_3 = new JLabel("Portfolio");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1_3.setBounds(106, 10, 150, 41);
		panelStocks.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_2_3 = new JLabel("");
		lblNewLabel_2_3.setIcon(new ImageIcon(MainView.class.getResource("/Item/list.png")));
		lblNewLabel_2_3.setBounds(28, 0, 68, 60);
		panelStocks.add(lblNewLabel_2_3);
		
		panelReport = new JPanel();
		panelReport.setLayout(null);
		panelReport.setBackground(Color.BLUE);
		panelReport.setBounds(0, 350, 200, 59);
		panelReport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelStock.setVisible(false);  
				panelSale.setVisible(false); 
				PanelHome.setVisible(false);
				panelSta.setVisible(true); 
				panelAddPr.setVisible(false);
				
				panelReport.setBackground(Color.cyan);
				panelHome.setBackground(new Color(0, 0, 255));
				panelAddProduct.setBackground(new Color(0, 0, 255));
                panelSell.setBackground(new Color(0, 0, 255));
                panelStocks.setBackground(new Color(0, 0, 255));
                panelSetting.setBackground(new Color(0, 0, 255));
                eventViewMain.openMenu(panelMenu);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panelReport.setBackground(Color.lightGray);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelReport.setBackground(Color.BLUE);
			}
		});
		panelMenu.add(panelReport);
		
		JPanel panel_1_3_1 = new JPanel();
		panel_1_3_1.setBackground(Color.RED);
		panel_1_3_1.setBounds(0, 0, 18, 60);
		panelReport.add(panel_1_3_1);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Transaction History");
		lblNewLabel_1_3_1.setForeground(Color.WHITE);
		lblNewLabel_1_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1_3_1.setBounds(107, 10, 150, 41);
		panelReport.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("");
		lblNewLabel_2_3_1.setIcon(new ImageIcon(MainView.class.getResource("/Item/report.png")));
		lblNewLabel_2_3_1.setBounds(28, 0, 68, 60);
		panelReport.add(lblNewLabel_2_3_1);
		
		panelSetting = new JPanel();
		panelSetting.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelStock.setVisible(false);  
				panelSale.setVisible(false); 
				panelSta.setVisible(false); 
				PanelHome.setVisible(false);
				panelAddPr.setVisible(false);
			
				panelSetting.setBackground(Color.cyan);
				panelReport.setBackground(new Color(0, 0, 255));
				panelHome.setBackground(new Color(0, 0, 255));
				panelAddProduct.setBackground(new Color(0, 0, 255));
                panelSell.setBackground(new Color(0, 0, 255));
                panelStocks.setBackground(new Color(0, 0, 255));
                eventViewMain.openMenu(panelMenu);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panelSetting.setBackground(Color.lightGray);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelSetting.setBackground(Color.BLUE);
			}
		});
		panelSetting.setLayout(null);
		panelSetting.setBackground(Color.BLUE);
		panelSetting.setBounds(0, 409, 200, 59);
		panelMenu.add(panelSetting);
		
		JPanel panel_1_4_1 = new JPanel();
		panel_1_4_1.setBackground(Color.RED);
		panel_1_4_1.setBounds(0, 0, 18, 60);
		panelSetting.add(panel_1_4_1);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Settings");
		lblNewLabel_1_4_1.setForeground(Color.WHITE);
		lblNewLabel_1_4_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1_4_1.setBounds(106, 10, 150, 41);
		panelSetting.add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_2_4_1 = new JLabel("");
		lblNewLabel_2_4_1.setIcon(new ImageIcon(MainView.class.getResource("/Item/setting.png")));
		lblNewLabel_2_4_1.setBounds(28, 0, 68, 60);
		panelSetting.add(lblNewLabel_2_4_1);

		lblicon = new JLabel("");
		lblicon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				eventViewMain.openMenu(panelMenu);
			}
		});
		lblicon.setBounds(20, 10, 50, 52);
		getContentPane().add(lblicon);
		lblPosition.setText("Customer");
	}
	
	public static void main(String[] args) {
		MainView hf = new MainView();
		hf.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLogout) {
			this.setVisible(false);
			
		}

	}
}
//Tuan ok