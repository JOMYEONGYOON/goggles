package task6;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CustomerTableTest {
	JFrame frame;

	public CustomerTableTest() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		String[][] data = { { "1", "2", "3", "4", "5" }, { "1", "2", "3", "4", "5" }, { "1", "2", "3", "4", "5" } };
		String[] headers = { "[1]", "[2]", "[3]", "[4]", "[5]" };
		JTable table = new JTable(data, headers);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setLocation(0, 0);
		scrollPane.setSize(600, 400);
		table.setFont(new Font("나눔손글씨 펜", Font.PLAIN, 18));
		table.setRowHeight(30);
		
		frame.add(scrollPane);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new CustomerTableTest();
	}
}
