package dictionary;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Join extends JFrame{

	private JFrame frame;
	private JTextField id;
	private JTextField name;
	private JTextField phone;
	private JTextField birth;
	private JTextField email;
	private JPasswordField passwordField;
	private JTextField gender;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Join window = new Join();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Join() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 584, 561);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("id");
		lblNewLabel.setFont(new Font("굴림", Font.ITALIC, 18));
		lblNewLabel.setBounds(25, 124, 57, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("name");
		lblNewLabel_1.setFont(new Font("굴림", Font.ITALIC, 18));
		lblNewLabel_1.setBounds(25, 186, 57, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("phone");
		lblNewLabel_2.setFont(new Font("굴림", Font.ITALIC, 18));
		lblNewLabel_2.setBounds(25, 253, 57, 15);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("birth");
		lblNewLabel_3.setFont(new Font("굴림", Font.ITALIC, 18));
		lblNewLabel_3.setBounds(25, 313, 57, 15);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("email");
		lblNewLabel_4.setFont(new Font("굴림", Font.ITALIC, 18));
		lblNewLabel_4.setBounds(25, 377, 57, 15);
		panel.add(lblNewLabel_4);
		
		id = new JTextField();
		id.setBounds(126, 121, 116, 21);
		panel.add(id);
		id.setColumns(10);
		
		name = new JTextField();
		name.setBounds(126, 183, 116, 21);
		panel.add(name);
		name.setColumns(10);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(126, 245, 116, 21);
		panel.add(phone);
		
		birth = new JTextField();
		birth.setColumns(10);
		birth.setBounds(126, 307, 116, 21);
		panel.add(birth);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(126, 377, 116, 21);
		panel.add(email);
		
		JLabel lblNewLabel_4_1 = new JLabel("gender");
		lblNewLabel_4_1.setFont(new Font("굴림", Font.ITALIC, 18));
		lblNewLabel_4_1.setBounds(25, 442, 75, 18);
		panel.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5 = new JLabel("password");
		lblNewLabel_5.setFont(new Font("굴림", Font.ITALIC, 18));
		lblNewLabel_5.setBounds(25, 501, 89, 15);
		panel.add(lblNewLabel_5);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(126, 498, 116, 21);
		panel.add(passwordField);
		
		JTextArea etc = new JTextArea();
		etc.setBounds(353, 182, 165, 86);
		panel.add(etc);
		
		JLabel lblNewLabel_6 = new JLabel("etc");
		lblNewLabel_6.setFont(new Font("굴림", Font.ITALIC, 18));
		lblNewLabel_6.setBounds(273, 215, 57, 15);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("회원가입");
		lblNewLabel_7.setFont(new Font("굴림", Font.PLAIN, 22));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(126, 33, 366, 55);
		
		
		panel.add(lblNewLabel_7);
		
		
		gender = new JTextField();
		gender.setBounds(126, 443, 116, 21);
		panel.add(gender);
		gender.setColumns(10);
		
		JButton btnNewButton = new JButton("회원가입");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idtxt = id.getText();
				String nametxt = name.getText();
				String phonetxt = phone.getText();
				String birthtxt = birth.getText();
				String emailtxt = email.getText();
				String gendertxt = gender.getText();
				String etctxt = etc.getText();
				String passtxt = passwordField.getText();
			}
		});
		btnNewButton.setBounds(340, 396, 152, 86);
		panel.add(btnNewButton);
//		frame.getContentPane().add(panel);
		getContentPane().add(panel);
		
		
		
		setSize(700,600);
		setVisible(true);
	}
}
