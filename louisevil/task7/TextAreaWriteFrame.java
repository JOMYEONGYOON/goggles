package task7;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextAreaWriteFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	
	public TextAreaWriteFrame() {
		JTextArea textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		JPanel inputPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) inputPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		getContentPane().add(inputPanel, BorderLayout.NORTH);
		JLabel inputLabel = new JLabel("입력");
		inputPanel.add(inputLabel);
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append(textField.getText() + "\n");
				textField.setText("");
			}
		});
		inputPanel.add(textField);
		textField.setColumns(32);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(512, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new TextAreaWriteFrame();
	}
}
