package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.phongbean;
import bo.phongbo;
import dao.cosoo;

import java.awt.Label;
import java.awt.Color;
import java.awt.Choice;
import java.awt.TextField;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmphongmay extends JFrame {
	ArrayList<phongbean> ds;
	ArrayList<phongbean> tam;
	phongbo phongbo= new phongbo();
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	void NapBang(ArrayList<phongbean> ds) {
		//b1: Tao ra mo hinh bang
		DefaultTableModel sv1= new DefaultTableModel();
		//b2: Tao cot
		sv1.addColumn("Ma Phong");sv1.addColumn("Ten Phong");sv1.addColumn("So Luong May");sv1.addColumn("Tang");;
		//b3: Tao dong
		for(phongbean nv: ds) {
			Object[] t= new Object[5];
			t[0]=nv.getMaphong();
			t[1]=nv.getTenphong();
			t[2]=nv.getSlmay();
			t[3]=nv.getTang();
			sv1.addRow(t);
		}
		//b4: Dua mo hinh vao bang
		table.setModel(sv1);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmphongmay frame = new frmphongmay();
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
	public frmphongmay() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					cosoo cs = new cosoo();
					cs.KetNoi();
					ds=phongbo.getphong();
					NapBang(ds);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 474);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 192, 203));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("Ma Phong:");
		label.setAlignment(Label.RIGHT);
		label.setBounds(37, 56, 62, 22);
		contentPane.add(label);
		
		Label label_1 = new Label("Ten Phong:");
		label_1.setAlignment(Label.RIGHT);
		label_1.setBounds(37, 84, 62, 22);
		contentPane.add(label_1);
		
		Label label_1_1 = new Label("So Luong May:");
		label_1_1.setAlignment(Label.RIGHT);
		label_1_1.setBounds(10, 117, 89, 22);
		contentPane.add(label_1_1);
		
		Label label_1_2 = new Label("Tang:");
		label_1_2.setAlignment(Label.RIGHT);
		label_1_2.setBounds(37, 28, 62, 22);
		contentPane.add(label_1_2);
		
		TextField txtenp = new TextField();
		txtenp.setBounds(112, 84, 98, 22);
		contentPane.add(txtenp);
		
		TextField txtmap = new TextField();
		txtmap.setBounds(112, 56, 98, 22);
		contentPane.add(txtmap);
		
		TextField txtslmay = new TextField();
		txtslmay.setBounds(112, 117, 98, 22);
		contentPane.add(txtslmay);
		
		TextField txttang = new TextField();
		txttang.setBounds(112, 28, 98, 22);
		contentPane.add(txttang);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(64, 207, 529, 200);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Danh Sach Phong", null, scrollPane, null);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int d=table.getSelectedRow();
				txtmap.setText(table.getValueAt(d, 0).toString());
				txtenp.setText(table.getValueAt(d, 1).toString());
				txtslmay.setText(table.getValueAt(d, 2).toString());
				txttang.setText(table.getValueAt(d, 3).toString());
			}
		});
		scrollPane.setViewportView(table);
		
		Button button = new Button("Them");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String maphong=txtmap.getText();
					String tenphong=txtenp.getText();
					int slmay=Integer.parseInt(txtslmay.getText());
					String tang=txttang.getText();
					phongbo.Them(maphong, tenphong, slmay, tang);
					NapBang(ds);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		button.setBounds(267, 34, 70, 22);
		contentPane.add(button);
		
		Button button_1 = new Button("Xoa");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					phongbo.Xoa(txtmap.getText());
					NapBang(ds);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		button_1.setBounds(267, 76, 70, 22);
		contentPane.add(button_1);
		
		Button button_2 = new Button("Sua");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String maphong=txtmap.getText();
					String tenphong=txtenp.getText();
					int slmay=Integer.parseInt(txtslmay.getText());
					String tang=txttang.getText();
					phongbo.Sua(maphong, tenphong, slmay, tang);
					NapBang(ds);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		button_2.setBounds(267, 117, 70, 22);
		contentPane.add(button_2);
		
		Button button_3 = new Button("Quan Ly May");
		button_3.setBackground(new Color(255, 228, 225));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmpc f = new frmpc();
				f.setVisible(true);
				frmphongmay.this.dispose();
			}
		});
		button_3.setBounds(414, 34, 164, 53);
		contentPane.add(button_3);
		
		Button button_4 = new Button("Tim Kiem");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key=JOptionPane.showInputDialog("Nhap tt can tim:");
				try {
					tam=phongbo.timkiem(key);
					NapBang(tam);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		button_4.setBounds(267, 155, 70, 22);
		contentPane.add(button_4);
		
		Button button_5 = new Button("Menu");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmmenu f = new frmmenu();
				f.setVisible(true);
				frmphongmay.this.dispose();
			}
		});
		button_5.setBackground(new Color(255, 228, 225));
		button_5.setBounds(414, 117, 164, 53);
		contentPane.add(button_5);
	}
}
