package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bo.dangnhapbo;
import dao.cosoo;

import java.awt.Color;
import java.awt.Label;
import java.awt.Font;
import java.awt.TextField;
import javax.swing.JPasswordField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class taotk extends JFrame {
	dangnhapbo dnbo= new dangnhapbo();

	private JPanel contentPane;
	private JPasswordField txtmk1;
	private JPasswordField txtmk2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					taotk frame = new taotk();
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
	public taotk() {
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
		setBounds(100, 100, 495, 524);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("Dang Ky");
		label.setFont(new Font("VNI 22 JackieO", Font.PLAIN, 20));
		label.setBackground(new Color(255, 192, 203));
		label.setAlignment(Label.CENTER);
		label.setBounds(164, 10, 145, 83);
		contentPane.add(label);
		
		Label label_1 = new Label("Ten Dang Nhap:");
		label_1.setAlignment(Label.RIGHT);
		label_1.setBounds(55, 145, 91, 22);
		contentPane.add(label_1);
		
		TextField txttdn = new TextField();
		txttdn.setBackground(new Color(255, 192, 203));
		txttdn.setBounds(164, 145, 145, 33);
		contentPane.add(txttdn);
		
		txtmk1 = new JPasswordField();
		txtmk1.setBackground(new Color(255, 192, 203));
		txtmk1.setBounds(164, 202, 145, 43);
		contentPane.add(txtmk1);
		
		Label label_2 = new Label("Mat Khau:");
		label_2.setBounds(84, 218, 62, 22);
		contentPane.add(label_2);
		
		Label label_2_1 = new Label("Nhap Lai Mat Khau:");
		label_2_1.setBounds(39, 283, 107, 22);
		contentPane.add(label_2_1);
		
		txtmk2 = new JPasswordField();
		txtmk2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==10) 
				{
					try {
						if(dnbo.Them(txttdn.getText(), txtmk1.getText(), txtmk2.getText())==1)
						{
							dangnhapview f = new dangnhapview();
							f.setVisible(true);
							taotk.this.dispose();
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		txtmk2.setBackground(new Color(255, 192, 203));
		txtmk2.setBounds(164, 267, 145, 43);
		contentPane.add(txtmk2);
		
		Button button = new Button("Dang Ky");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(dnbo.Them(txttdn.getText(), txtmk1.getText(), txtmk2.getText())==1)
					{
						dangnhapview f = new dangnhapview();
						f.setVisible(true);
						taotk.this.dispose();
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(164, 353, 145, 43);
		contentPane.add(button);
		
		Button button_1 = new Button("Huy");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dangnhapview f = new dangnhapview();
				f.setVisible(true);
				taotk.this.dispose();
			}
		});
		button_1.setBounds(164, 411, 145, 43);
		contentPane.add(button_1);
	}
}
