package task6;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class LoginFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel panel;
    private JLabel laId;
    private JTextField txtId;
    private JLabel laPass;
    private JPasswordField txtPass;
    private JButton btnLogin;
    public static void main(String[] args) {
    	new LoginFrame();
    }
    public LoginFrame() {
        panel = new JPanel();
        laId = new JLabel("ID :");
        txtId = new JTextField(10);
        laPass = new JLabel("PASSWORD: ");
        txtPass = new JPasswordField(10);
        btnLogin = new JButton("Login");
        panel.add(laId);
        panel.add(txtId);
        panel.add(laPass);
        panel.add(txtPass);
        panel.add(btnLogin);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = "Kim";
                String pass = "1234";
                if (id.equals(txtId.getText()) && pass.equals(txtPass.getText())) {
                    JOptionPane.showMessageDialog(null, "success");
                }else{
                    JOptionPane.showMessageDialog(null,"fail");
                }

            }
        });

        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(600, 400);
        setResizable(false);
    }
}