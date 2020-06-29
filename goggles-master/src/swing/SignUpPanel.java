package swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import manager.MemberTableManager;
import manager.ResourceManager;
import object.Member;
import object.MySQL;
import runner.FadeLabelRunner;

public class SignUpPanel extends JPanel {
	
	private WhiteBorderTextField idTF;
	private WhiteBorderTextField nameTF;
	private WhiteBorderTextField phoneTF;
	private WhiteBorderTextField birthTF;
	private WhiteBorderTextField emailTF;
	private WhiteBorderPasswordField passwordFieldTF;
	private WhiteBorderTextField genderTextField;
	private EmptyBackgroundTextArea etcTA;
	private MainFrame mainFrameTest;
	/**
	 * Create the application.
	 */
	public SignUpPanel(MainFrame mainFrameTest) {
		setBorder(new LineBorder(Color.WHITE));
		this.mainFrameTest=mainFrameTest;
		setBackground(ResourceManager.NONE);
		setForeground(Color.WHITE);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setLocation(0, 0);
		
		setLayout(null);

		WhiteLabel lblNewLabel = new WhiteLabel("아이디");
		lblNewLabel.setBounds(25, 79, 57, 15);
		add(lblNewLabel);

		WhiteLabel lblNewLabel_1 = new WhiteLabel("이름");
		lblNewLabel_1.setBounds(25, 163, 57, 15);
		add(lblNewLabel_1);

		WhiteLabel lblNewLabel_2 = new WhiteLabel("연락처");
		lblNewLabel_2.setForeground(Color.WHITE);
		add(lblNewLabel_2);

		WhiteLabel lblNewLabel_3 = new WhiteLabel("생년월일");
		lblNewLabel_3.setBounds(25, 235, 57, 15);
		add(lblNewLabel_3);

		WhiteLabel lblNewLabel_4 = new WhiteLabel("이메일");
		lblNewLabel_4.setBounds(25, 271, 57, 15);
		add(lblNewLabel_4);

		idTF = new WhiteBorderTextField();
		idTF.setBounds(94, 79, 242, 21);
		add(idTF);
		idTF.setColumns(10);

		nameTF = new WhiteBorderTextField();
		nameTF.setBounds(94, 163, 242, 21);
		add(nameTF);
		nameTF.setColumns(10);

		phoneTF = new WhiteBorderTextField();
		phoneTF.setForeground(Color.WHITE);
		phoneTF.setColumns(10);
		phoneTF.setBounds(94, 200, 242, 21);
		add(phoneTF);

		birthTF = new WhiteBorderTextField();
		birthTF.setForeground(Color.WHITE);
		birthTF.setColumns(10);
		birthTF.setBounds(94, 235, 242, 21);
		add(birthTF);

		emailTF = new WhiteBorderTextField();
		emailTF.setForeground(Color.WHITE);
		emailTF.setColumns(10);
		emailTF.setBounds(94, 271, 242, 21);
		add(emailTF);

		WhiteLabel lblNewLabel_4_1 = new WhiteLabel("성별");
		lblNewLabel_4_1.setBounds(25, 302, 75, 18);
		add(lblNewLabel_4_1);

		WhiteLabel lblNewLabel_5 = new WhiteLabel("비밀번호");
		lblNewLabel_5.setBounds(25, 123, 57, 15);
		add(lblNewLabel_5);

		passwordFieldTF = new WhiteBorderPasswordField();
		passwordFieldTF.setBounds(94, 123, 242, 21);
		add(passwordFieldTF);

		etcTA = new EmptyBackgroundTextArea();
		etcTA.setForeground(Color.WHITE);
		etcTA.setBounds(94, 358, 242, 67);
		add(etcTA);

		WhiteLabel lblNewLabel_6 = new WhiteLabel("etc");
		lblNewLabel_6.setBounds(25, 358, 57, 15);
		add(lblNewLabel_6);

		WhiteLabel lblNewLabel_7 = new WhiteLabel("회원가입");
		lblNewLabel_7.setFont(new Font("나눔손글씨 펜", Font.PLAIN, 32));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_7.setBounds(25, 10, 161, 55);

		add(lblNewLabel_7);

		genderTextField = new WhiteBorderTextField();
		genderTextField.setBounds(94, 302, 242, 21);
		add(genderTextField);

		EmptyBackgroundButton btnNewButton = new EmptyBackgroundButton("[완료]");
		
		btnNewButton.setForeground(Color.WHITE);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
		
				String id = idTF.getText();
				String name = nameTF.getText();
				String phone = phoneTF.getText();
				String birth = birthTF.getText();
				String email = emailTF.getText();
				String gender = genderTextField.getText();
				String etc = etcTA.getText();
				String password = passwordFieldTF.getText();
				String[] strs = {id,name,phone,birth,email,gender,etc,password};
				for (String s : strs) {
					if (s.equals("")) {
						WhiteLabel successLabel = new WhiteLabel("모두 입력해주세요");
						successLabel.setBounds(ResourceManager.FRAME_WIDTH-600,150,300,100);
						mainFrameTest.getRootPanel().add(successLabel);
						FadeLabelRunner fade = new FadeLabelRunner(successLabel);
						fade.start();
						return;
					}
				}
				
				
				Member member = new Member(id,name,phone,email,birth,gender,password,etc);
				try {
					MySQL mySQL = new MySQL();
					MemberTableManager memberTable = new MemberTableManager();
					memberTable.connect(mySQL);
					memberTable.insert(member);
					WhiteLabel successLabel = new WhiteLabel("회원가입 성공");
					successLabel.setBounds(ResourceManager.FRAME_WIDTH-600,100,100,100);
					mainFrameTest.getRootPanel().add(successLabel);
					FadeLabelRunner fade = new FadeLabelRunner(successLabel);
					fade.start();
					SignUpPanel.this.setVisible(false);
				}catch(Exception e){
					WhiteLabel failLabel = new WhiteLabel("회원가입 실패");
					failLabel.setBounds(ResourceManager.FRAME_WIDTH-600,100,100,100);
					mainFrameTest.getRootPanel().add(failLabel);
					FadeLabelRunner fade = new FadeLabelRunner(failLabel);
					fade.start();
				}
				
			}
		});
		btnNewButton.setBounds(214, 28, 60, 23);
		add(btnNewButton);
		add(panel);

		setSize(360, 448);
		
		EmptyBackgroundButton btnCancel = new EmptyBackgroundButton("[취소]");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrameTest.getRootPanel().remove(SignUpPanel.this);
			}
		});
		btnCancel.setBounds(286, 27, 62, 24);
		add(btnCancel);
		
		WhiteLabel lblNewLabel_1_1 = new WhiteLabel("이름");
		lblNewLabel_1_1.setText("연락처");
		lblNewLabel_1_1.setBounds(25, 200, 57, 15);
		add(lblNewLabel_1_1);
		setVisible(true);
	}
}
