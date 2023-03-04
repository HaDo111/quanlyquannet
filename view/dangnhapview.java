package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.dangnhapbean;
import bo.dangnhapbo;
import dao.cosoo;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.Button;

public class dangnhapview extends JFrame {
	private JPanel contentPane;
	private JTextField txttk;
	private JPasswordField txtmk;
	dangnhapbo dnbo= new dangnhapbo();
	ArrayList<dangnhapbean> ds;
	ArrayList<dangnhapbean> tam;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dangnhapview frame = new dangnhapview();
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
	public dangnhapview() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 610);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(107, 127, 238, 39);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txttk = new JTextField();
		txttk.setToolTipText("Username");
		txttk.setText("Username");
		txttk.setBounds(0, 0, 238, 39);
		panel.add(txttk);
		txttk.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(107, 198, 238, 39);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtmk = new JPasswordField();
		txtmk.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==10) 
				{
					try {
						cosoo cs = new cosoo();
						cs.KetNoi();
						 dnbo.getdn();
						
						if(dnbo.kt(txttk.getText(), txtmk.getText())==1)
						{
							frmmenu f = new frmmenu();
							f.setVisible(true);
							dangnhapview.this.dispose();
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		txtmk.setText("password");
		txtmk.setToolTipText("Password");
		txtmk.setBounds(0, 0, 238, 39);
		panel_1.add(txtmk);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.LEADING);
		lblNewLabel.setIcon(new ImageIcon(dangnhapview.class.getResource("/res/logo1.png")));
		lblNewLabel.setBounds(115, 11, 217, 88);
		contentPane.add(lblNewLabel);
		
		Button button = new Button("Dang Ky");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taotk f = new taotk();
				f.setVisible(true);
				dangnhapview.this.dispose();
			}
		});
		button.setBackground(new Color(255, 192, 203));
		button.setBounds(107, 395, 238, 39);
		contentPane.add(button);
		
		Button button_1 = new Button("Dang Nhap");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cosoo cs = new cosoo();
					cs.KetNoi();
					 dnbo.getdn();
					
					if(dnbo.kt(txttk.getText(), txtmk.getText())==1)
					{
						frmmenu f = new frmmenu();
						f.setVisible(true);
						dangnhapview.this.dispose();
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_1.setBackground(new Color(255, 192, 203));
		button_1.setBounds(107, 319, 238, 39);
		contentPane.add(button_1);
	}
}
