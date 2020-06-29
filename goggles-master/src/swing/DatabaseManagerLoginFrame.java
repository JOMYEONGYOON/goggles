package swing;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import manager.DatabaseManager;

public class DatabaseManagerLoginFrame extends JFrame {
	private DatabaseManager databaseManager;
	private static final long serialVersionUID = 1L;
	private JTextField idTextField;
	private JPasswordField pwTextField;
	private JTextField ipTextField;
	private JTextField propertiesTextField;

	public DatabaseManagerLoginFrame() {
		setTitle("데이터베이스 관리자 로그인 화면");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setFont(new Font("Dialog", Font.PLAIN, 10));
		this.setSize(800, 500);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(12, 10, 756, 421);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblMysqlUrl = new JLabel("MySQL Server IP");
		lblMysqlUrl.setBounds(245, 164, 112, 15);
		panel.add(lblMysqlUrl);
		lblMysqlUrl.setFont(new Font("Dialog", Font.PLAIN, 10));

		JLabel lblMysqlProperties = new JLabel("MySQL Properties");
		lblMysqlProperties.setBounds(245, 189, 119, 15);
		panel.add(lblMysqlProperties);
		lblMysqlProperties.setFont(new Font("Dialog", Font.PLAIN, 10));

		JLabel mysqlIdLabel = new JLabel("MySQL ID");
		mysqlIdLabel.setBounds(245, 214, 112, 15);
		panel.add(mysqlIdLabel);
		mysqlIdLabel.setFont(new Font("Dialog", Font.PLAIN, 10));

		JLabel mysqlPasswordLabel = new JLabel("MySQL PW");
		mysqlPasswordLabel.setBounds(245, 239, 112, 15);
		panel.add(mysqlPasswordLabel);
		mysqlPasswordLabel.setFont(new Font("Dialog", Font.PLAIN, 10));

		idTextField = new JTextField();
		idTextField.setEditable(false);
		idTextField.setBounds(369, 211, 137, 21);
		panel.add(idTextField);
		idTextField.setFont(new Font("Dialog", Font.PLAIN, 10));
		idTextField.setText("root");
		idTextField.setColumns(10);

		pwTextField = new JPasswordField();
		pwTextField.setBounds(369, 236, 137, 21);
		panel.add(pwTextField);
		pwTextField.setFont(new Font("Dialog", Font.PLAIN, 10));
		pwTextField.setText("1234");

		propertiesTextField = new JTextField();
		propertiesTextField.setEditable(false);
		propertiesTextField.setBounds(369, 187, 137, 21);
		panel.add(propertiesTextField);
		propertiesTextField.setFont(new Font("Dialog", Font.PLAIN, 10));
		propertiesTextField
				.setText("?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true");
		propertiesTextField.setColumns(10);

		ipTextField = new JTextField();
		ipTextField.setEditable(false);
		ipTextField.setBounds(369, 161, 137, 21);
		panel.add(ipTextField);
		ipTextField.setFont(new Font("Dialog", Font.PLAIN, 10));
		ipTextField.setText("127.0.0.1");
		ipTextField.setColumns(10);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	// test
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatabaseManagerLoginFrame window = new DatabaseManagerLoginFrame();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
