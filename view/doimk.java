package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bo.dangnhapbo;
import dao.cosoo;

import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.Label;
import java.awt.Font;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class doimk extends JFrame {
	dangnhapbo dnbo= new dangnhapbo();
	private JPanel contentPane;
	private JPasswordField txtcu;
	private JPasswordField txtmoilan1;
	private JPasswordField txtmoilan2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					doimk frame = new doimk();
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
	public doimk() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				cosoo cs = new cosoo();
				cs.KetNoi();
				try {
					dnbo.getdn();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 511);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtcu = new JPasswordField();
		txtcu.setBackground(new Color(255, 192, 203));
		txtcu.setBounds(135, 99, 172, 34);
		contentPane.add(txtcu);
		
		Label label = new Label("Mat Khau Cu:");
		label.setAlignment(Label.RIGHT);
		label.setBounds(32, 97, 97, 36);
		contentPane.add(label);
		
		txtmoilan1 = new JPasswordField();
		txtmoilan1.setBackground(new Color(255, 192, 203));
		txtmoilan1.setBounds(135, 163, 172, 34);
		contentPane.add(txtmoilan1);
		
		Label label_1 = new Label("Mat Khau Moi:");
		label_1.setAlignment(Label.RIGHT);
		label_1.setBounds(32, 161, 97, 36);
		contentPane.add(label_1);
		
		txtmoilan2 = new JPasswordField();
		txtmoilan2.setBackground(new Color(255, 192, 203));
		txtmoilan2.setBounds(135, 225, 172, 34);
		contentPane.add(txtmoilan2);
		
		Label label_2 = new Label("Nhap Lai Mat Khau:");
		label_2.setAlignment(Label.RIGHT);
		label_2.setBounds(10, 223, 119, 36);
		contentPane.add(label_2);
		
		Label label_3 = new Label("Doi Mat Khau");
		label_3.setBackground(new Color(255, 192, 203));
		label_3.setFont(new Font(".VnUniverseH", Font.PLAIN, 26));
		label_3.setAlignment(Label.CENTER);
		label_3.setBounds(135, 10, 166, 65);
		contentPane.add(label_3);
		
		Button button = new Button("Xac Nhan");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(dnbo.Sua(txtcu.getText(),txtmoilan1.getText(),txtmoilan2.getText())==1);
					frmmenu f = new frmmenu();
					f.setVisible(true);
					doimk.this.dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBackground(new Color(255, 192, 203));
		button.setFont(new Font("Dialog", Font.PLAIN, 27));
		button.setBounds(135, 294, 172, 65);
		contentPane.add(button);
		
		Button button_1 = new Button("Huy");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmmenu f = new frmmenu();
				f.setVisible(true);
				doimk.this.dispose();
			}
		});
		button_1.setFont(new Font("Dialog", Font.PLAIN, 27));
		button_1.setBackground(new Color(255, 192, 203));
		button_1.setBounds(135, 379, 166, 41);
		contentPane.add(button_1);
	}
}
