package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.dangnhapbean;
import bo.dangnhapbo;

import java.awt.Color;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Button;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class frmmenu extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmmenu frame = new frmmenu();
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
	public frmmenu() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 515);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Button button = new Button("Quan Ly Phong");
		button.setBackground(new Color(255, 192, 203));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmphongmay f = new frmphongmay();
				f.setVisible(true);
				frmmenu.this.dispose();
			}
		});
		button.setBounds(179, 27, 285, 439);
		contentPane.add(button);
		
		Button button_1 = new Button("Quan Ly May");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmpc f = new frmpc();
				f.setVisible(true);
				frmmenu.this.dispose();
			}
		});
		button_1.setBackground(new Color(255, 192, 203));
		button_1.setBounds(470, 27, 284, 439);
		contentPane.add(button_1);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(255, 228, 225));
		panel.setBounds(0, 0, 173, 476);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Button button_2 = new Button("Dang Xuat");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dangnhapview f = new dangnhapview();
				f.setVisible(true);
				frmmenu.this.dispose();
			}
		});
		button_2.setBounds(0, 136, 173, 50);
		panel.add(button_2);
		button_2.setBackground(new Color(255, 192, 203));
		
		Label label = new Label("Xin Chao Ban:");
		label.setBounds(0, 0, 163, 22);
		panel.add(label);
		
		Button button_2_1 = new Button("Doi Mat Khau");
		button_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doimk f = new doimk();
				f.setVisible(true);
				frmmenu.this.dispose();
			}
		});
		button_2_1.setBackground(new Color(255, 192, 203));
		button_2_1.setBounds(0, 81, 173, 50);
		panel.add(button_2_1);
	}
}
