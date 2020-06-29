package dictionary;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Login extends JFrame {
	private JButton btnNewButton;
	private JLabel pass_1;
	private JLabel title;
	private JButton log;
	private JTextField txid;
	private JLabel label;
	JPanel panel;
	
	
	public Login() {
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.WHITE);
		label = new JLabel("ID : ");
		label.setBounds(29, 99, 93, 15);
		pass_1 = new JLabel("Password : ");
		pass_1.setBounds(29, 159, 69, 15);
		txid = new JTextField(10);
		txid.setBounds(161, 96, 116, 21);
		JPasswordField txpa = new JPasswordField(10);
		txpa.setBounds(161, 156, 116, 21);
		log = new JButton("Log In");
		log.setBounds(386, 91, 147, 96);
		
		
		log.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String id = "Jo";
				String pass = "1234";
				if (id.equals(txid.getText()) && pass.equals(txpa.getText())) {
					JOptionPane.showMessageDialog(null, "로그인 성공");
//					Login.this.dispose();
				new Join();
					
				} else {
					JOptionPane.showMessageDialog(null, "로그인 실패");
				}

			}

		});
		panel.setLayout(null);

		panel.add(label);
		panel.add(txid);
		panel.add(pass_1);
		panel.add(txpa);
		panel.add(log);
		getContentPane().add(panel);
		
	     
	      
		title = new JLabel("로그인");
		title.setFont(new Font("굴림", Font.PLAIN, 30));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(105, 10, 397, 50);
		panel.add(title);

		btnNewButton = new JButton("회원가입");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.this.dispose();
				new Join();
			}

		});
		btnNewButton.setBounds(180, 267, 97, 23);
		panel.add(btnNewButton);

		setLocationRelativeTo(null);
		setSize(700, 500);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	
	
	
	
	}

	

	



	
	
	
	
	public static void main(String[] args) {
		new Login();
		
	}

}
