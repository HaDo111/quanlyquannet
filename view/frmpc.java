package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.pcbean;
import bean.phongbean;
import bo.pcbo;
import bo.phongbo;
import dao.cosoo;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Label;
import java.awt.Choice;
import java.awt.TextField;
import java.awt.Color;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class frmpc extends JFrame {
	ArrayList<pcbean> ds;
	ArrayList<pcbean> tam;
	pcbo pcbo= new pcbo();
	phongbo phongbo= new phongbo();
	TextField txtmapc = new TextField();
	TextField txttenpc = new TextField();
	TextField txtmain = new TextField();
	TextField txtbxl = new TextField();
	TextField txtcdh = new TextField();
	TextField txtram = new TextField();
	TextField txtmh = new TextField();
	Choice txtchuot = new Choice();
	Choice txtbanphim = new Choice();
	Choice txtttmay = new Choice();
	Choice txttainghe = new Choice();
	Choice txttp = new Choice();
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	void NapBang(ArrayList<pcbean> ds) {
		//b1: Tao ra mo hinh bang
		DefaultTableModel sv1= new DefaultTableModel();
		//b2: Tao cot
		sv1.addColumn("Ma Pc");sv1.addColumn("Ten Pc");sv1.addColumn("Ten Phong");sv1.addColumn("Main");sv1.addColumn("Bo Xu Ly");sv1.addColumn("card Do Hoa");sv1.addColumn("Ram(GB)");
		sv1.addColumn("Man Hinh(in)");sv1.addColumn("Chuot");sv1.addColumn("Ban Phim");sv1.addColumn("Tai Nghe");sv1.addColumn("Tinh Trang May");
		//b3: Tao dong
		for(pcbean nv: ds) {
			Object[] t= new Object[13];
			t[0]=nv.getMapc();
			t[1]=nv.getTenpc();
			t[2]=nv.getTenphong();
			t[3]=nv.getMain();
			t[4]=nv.getBxl();
			t[5]=nv.getCarddh();
			t[6]=nv.getRam();
			t[7]=nv.getManhinh();
			String a,b,c,d;
			if(nv.isChuot()==true) a="Tot";
			else a="Hong";
			t[8]=a;
			if(nv.isBanphim()==true) b="Tot";
			else b="Hong";
			t[9]=b;
			if(nv.isTainghe()==true) c="Tot";
			else c="Hong";
			t[10]=c;
			if(nv.isTtmanhinh()==true) d="Co The Su Dung";
			else d="Khong The Su Dung";		
			t[11]=d;
													
			sv1.addRow(t);
		}
		//b4: Dua mo hinh vao bang
		table.setModel(sv1);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmpc frame = new frmpc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmpc() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					cosoo cs = new cosoo();
					cs.KetNoi();
					ds=pcbo.getpc();
					NapBang(ds);
					for(phongbean a:phongbo.getphong())
					{
						txttp.add(a.getTenphong());
					}
					txtbanphim.add("Tot");
					txtbanphim.add("Hong");
					txtchuot.add("Tot");
					txtchuot.add("Hong");
					txttainghe.add("Tot");
					txttainghe.add("Hong");
					txtttmay.add("Co The Su Dung");
					txtttmay.add("Khong The Su Dung");
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1184, 501);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 192, 203));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(356, 11, 802, 442);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Danh Sach May", null, scrollPane, null);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int d=table.getSelectedRow();
				txtmapc.setText(table.getValueAt(d, 0).toString());
				txttenpc.setText(table.getValueAt(d, 1).toString());
				txtmain.setText(table.getValueAt(d, 3).toString());
				txtbxl.setText(table.getValueAt(d, 4).toString());
				txtcdh.setText(table.getValueAt(d, 5).toString());
				txtram.setText(table.getValueAt(d, 6).toString());
				txtmh.setText(table.getValueAt(d, 7).toString());
				for(int i=0;i<txttp.getItemCount();i++)
					if(txttp.getItem(i).equalsIgnoreCase(table.getValueAt(d, 2).toString())) {
						txttp.select(i);break;
					}
				for(int i=0;i<txtbanphim.getItemCount();i++)
					if(txtbanphim.getItem(i).equalsIgnoreCase(table.getValueAt(d, 9).toString())) {
						txtbanphim.select(i);break;
					}
				for(int i=0;i<txtchuot.getItemCount();i++)
					if(txtchuot.getItem(i).equalsIgnoreCase(table.getValueAt(d, 8).toString())) {
						txtchuot.select(i);break;
					}
				for(int i=0;i<txttainghe.getItemCount();i++)
					if(txttainghe.getItem(i).equalsIgnoreCase(table.getValueAt(d, 10).toString())) {
						txttainghe.select(i);break;
					}
				for(int i=0;i<txtttmay.getItemCount();i++)
					if(txtttmay.getItem(i).toLowerCase().equalsIgnoreCase(table.getValueAt(d, 11).toString().toLowerCase())) {
						txtttmay.select(i);break;
					}
			}
		});
		scrollPane.setViewportView(table);
		
		Label label = new Label("Ten Phong:");
		label.setBounds(10, 11, 62, 22);
		contentPane.add(label);
		txttp.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String hh = txttp.getSelectedItem();
				try {
					tam=pcbo.timmaphong(hh);
					NapBang(tam);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
		
		txttp.setBounds(111, 13, 114, 20);
		contentPane.add(txttp);
		
		Label label_1 = new Label("Ma PC:");
		label_1.setBounds(10, 39, 62, 22);
		contentPane.add(label_1);
		
		Label label_1_1 = new Label("Ten PC:");
		label_1_1.setBounds(10, 67, 62, 22);
		contentPane.add(label_1_1);
		
		txtmapc.setBounds(111, 39, 114, 22);
		contentPane.add(txtmapc);
		
		txttenpc.setBounds(111, 67, 114, 22);
		contentPane.add(txttenpc);
		
		Label label_1_2 = new Label("Main:");
		label_1_2.setBounds(10, 95, 62, 22);
		contentPane.add(label_1_2);
		
		txtmain.setBounds(111, 95, 114, 22);
		contentPane.add(txtmain);
		
		txtbxl.setBounds(111, 123, 114, 22);
		contentPane.add(txtbxl);
		
		Label label_1_1_1 = new Label("Bo Xu Ly:");
		label_1_1_1.setBounds(10, 123, 62, 22);
		contentPane.add(label_1_1_1);
		
		
		txtcdh.setBounds(111, 151, 114, 22);
		contentPane.add(txtcdh);
		
		Label label_1_1_1_1 = new Label("Card Do Hoa");
		label_1_1_1_1.setBounds(10, 151, 95, 22);
		contentPane.add(label_1_1_1_1);
		
		Label label_1_1_1_2 = new Label("Ram(GB):");
		label_1_1_1_2.setBounds(10, 179, 62, 22);
		contentPane.add(label_1_1_1_2);
		
		txtram.setBounds(111, 179, 114, 22);
		contentPane.add(txtram);
		
		txtmh.setBounds(111, 207, 114, 22);
		contentPane.add(txtmh);
		
		Label label_1_1_1_1_1 = new Label("Man Hinh(in):");
		label_1_1_1_1_1.setBounds(10, 207, 95, 22);
		contentPane.add(label_1_1_1_1_1);
		
		Label label_2 = new Label("Chuot:");
		label_2.setBounds(10, 235, 48, 22);
		contentPane.add(label_2);
		
		txtchuot.setBounds(111, 237, 114, 20);
		contentPane.add(txtchuot);
		
		Label label_2_1 = new Label("Ban Phim");
		label_2_1.setBounds(10, 263, 70, 22);
		contentPane.add(label_2_1);
		
		txtbanphim.setBounds(111, 265, 114, 20);
		contentPane.add(txtbanphim);
		
		Label label_2_2 = new Label("Tai Nghe");
		label_2_2.setBounds(10, 291, 62, 22);
		contentPane.add(label_2_2);
		
		
		txttainghe.setBounds(110, 293, 115, 20);
		contentPane.add(txttainghe);
		
		Label label_3 = new Label("Tinh Trang May:");
		label_3.setBounds(10, 342, 95, 22);
		contentPane.add(label_3);
		
		txtttmay.setBounds(110, 342, 145, 20);
		contentPane.add(txtttmay);
		
		Button button = new Button("Menu");
		button.setBackground(new Color(255, 228, 225));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmmenu f = new frmmenu();
				f.setVisible(true);
				frmpc.this.dispose();
			}
		});
		button.setBounds(27, 404, 115, 49);
		contentPane.add(button);
		
		Button button_1 = new Button("Quan Ly Phong");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmphongmay f = new frmphongmay();
				f.setVisible(true);
				frmpc.this.dispose();
			}
		});
		button_1.setBackground(new Color(255, 228, 225));
		button_1.setBounds(167, 404, 115, 49);
		contentPane.add(button_1);
		
		Button button_2 = new Button("Them");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mapc=txtmapc.getText() ;
				String tenpc=txttenpc.getText(); 
				String tenphong =txttp.getSelectedItem();
				String main=txtmain.getText();
				String bxl=txtbxl.getText();
				int ram=Integer.parseInt(txtram.getText()); 
				int manhinh=Integer.parseInt(txtmh.getText()); 
				String carddh=txtcdh.getText();
				boolean ttmanhinh;
				if(txtttmay.getSelectedItem()=="Co The Su Dung") ttmanhinh=true;else ttmanhinh = false; 
				boolean chuot; 
				if(txtchuot.getSelectedItem()=="Tot") chuot=true;else chuot = false;
				boolean banphim;
				if(txtbanphim.getSelectedItem()=="Tot") banphim=true;else banphim = false;
				boolean tainghe;
				if(txttainghe.getSelectedItem()=="Tot") tainghe=true;else tainghe = false;
				try {
					pcbo.Them(mapc, tenpc, tenphong, main, bxl, ram, manhinh, carddh, ttmanhinh, chuot, banphim, tainghe);
					NapBang(ds);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		button_2.setBackground(new Color(255, 228, 225));
		button_2.setBounds(263, 95, 70, 22);
		contentPane.add(button_2);
		
		Button button_2_1 = new Button("Xoa");
		button_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String mapc=txtmapc.getText() ;
					pcbo.Xoa(mapc);
					NapBang(ds);
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		button_2_1.setBackground(new Color(255, 228, 225));
		button_2_1.setBounds(263, 123, 70, 22);
		contentPane.add(button_2_1);
		
		Button button_2_2 = new Button("Sua");
		button_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mapc=txtmapc.getText() ;
				String tenpc=txttenpc.getText(); 
				String tenphong =txttp.getSelectedItem();
				String main=txtmain.getText();
				String bxl=txtbxl.getText();
				int ram=Integer.parseInt(txtram.getText()); 
				int manhinh=Integer.parseInt(txtmh.getText()); 
				String carddh=txtcdh.getText();
				boolean ttmanhinh;
				if(txtttmay.getSelectedItem()=="Co The Su Dung") ttmanhinh=true;else ttmanhinh = false; 
				boolean chuot; 
				if(txtchuot.getSelectedItem()=="Tot") chuot=true;else chuot = false;
				boolean banphim;
				if(txtbanphim.getSelectedItem()=="Tot") banphim=true;else banphim = false;
				boolean tainghe;
				if(txttainghe.getSelectedItem()=="Tot") tainghe=true;else tainghe = false;
				try {
					pcbo.Sua(mapc, tenpc, tenphong, main, bxl, ram, manhinh, carddh, ttmanhinh, chuot, banphim, tainghe);
					NapBang(ds);
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		button_2_2.setBackground(new Color(255, 228, 225));
		button_2_2.setBounds(263, 151, 70, 22);
		contentPane.add(button_2_2);
		
		Button button_2_3 = new Button("Tim Kiem");
		button_2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key=JOptionPane.showInputDialog("Nhap tt can tim:");
				try {
					tam=pcbo.timkiem(key);
					NapBang(tam);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		button_2_3.setBackground(new Color(255, 228, 225));
		button_2_3.setBounds(263, 179, 70, 22);
		contentPane.add(button_2_3);
		
		Button button_2_4 = new Button("May Bi Hong");
		button_2_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					tam=pcbo.mayhong();
					NapBang(tam);
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		button_2_4.setBackground(new Color(255, 228, 225));
		button_2_4.setBounds(263, 207, 70, 22);
		contentPane.add(button_2_4);
		
		Button button_2_4_1 = new Button("Reset");
		button_2_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NapBang(ds);
			}
		});
		button_2_4_1.setBackground(new Color(255, 228, 225));
		button_2_4_1.setBounds(263, 235, 70, 22);
		contentPane.add(button_2_4_1);
	}
}
