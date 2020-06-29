package task6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class HomeFrame {

	private JFrame frmLogin;
	private JTextField textFieldId;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeFrame window = new HomeFrame();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomeFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setResizable(false);
		frmLogin.setTitle("Login");
		frmLogin.getContentPane().setBackground(Color.PINK);
		frmLogin.setForeground(Color.ORANGE);
		frmLogin.getContentPane().setForeground(Color.LIGHT_GRAY);
		frmLogin.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		frmLogin.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Youtube Music");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblNewLabel.setBackground(new Color(153, 255, 204));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(245, 255, 250));
		lblNewLabel.setBounds(52, 17, 87, 15);
		panel.add(lblNewLabel);
		
		JLabel labelId = new JLabel("id");
		labelId.setFont(new Font("굴림", Font.PLAIN, 10));
		labelId.setForeground(SystemColor.window);
		labelId.setBounds(32, 50, 47, 15);
		panel.add(labelId);
		
		JLabel labelPass = new JLabel("password");
		labelPass.setFont(new Font("굴림", Font.PLAIN, 10));
		labelPass.setForeground(SystemColor.window);
		labelPass.setBounds(32, 78, 45, 15);
		panel.add(labelPass);
		
		textFieldId = new JTextField();
		textFieldId.setFont(new Font("굴림", Font.PLAIN, 10));
		textFieldId.setBounds(89, 46, 150, 23);
		panel.add(textFieldId);
		textFieldId.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("굴림", Font.PLAIN, 10));
		passwordField.setBounds(89, 74, 150, 23);
		panel.add(passwordField);
		
		JButton signInButton = new JButton("sign in");
		signInButton.setBorder(BorderFactory.createEmptyBorder());
		signInButton.setForeground(SystemColor.text);
		signInButton.setBackground(SystemColor.textHighlight);
		signInButton.setFont(new Font("굴림", Font.PLAIN, 10));
		signInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String id = "Kim";
	                String pass = "1234";
	                if (id.equals(textFieldId.getText()) && pass.equals(passwordField.getText())) {
	                    JOptionPane.showMessageDialog(null, "success");
	                }else{
	                    JOptionPane.showMessageDialog(null,"fail");
	                }

			}
		});
		signInButton.setBounds(89, 109, 69, 23);
		panel.add(signInButton);
		
		JButton signUpButton = new JButton("sign up");
		signUpButton.setForeground(SystemColor.text);
		signUpButton.setBackground(SystemColor.textHighlight);
		signUpButton.setBorder(BorderFactory.createEmptyBorder());
		signUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		signUpButton.setFont(new Font("굴림", Font.PLAIN, 10));
		signUpButton.setBounds(170, 109, 69, 23);
		panel.add(signUpButton);
		
		JLabel lblNewLabel_1 = new JLabel("▶");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 9));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(32, 17, 18, 18);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("■");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setBounds(29, 17, 55, 18);
		panel.add(lblNewLabel_2);
		frmLogin.setBounds(100, 100, 320, 400);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
