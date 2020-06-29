package task6;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

class StringConst {
	static String[] fruits = { "apple", "cherry", "pear" };
	static String images_folder_path = "jpg/";
}

class NorthPanel extends JPanel {
	private CenterPanel centerPanel;
	private ButtonGroup radioButtonGroup;
	private JRadioButton[] radioButtons;

	public ButtonGroup getRadioButtonGroup() {
		return radioButtonGroup;
	}

	public void setRadioButtonGroup(ButtonGroup radioButtonGroup) {
		this.radioButtonGroup = radioButtonGroup;
	}

	public JRadioButton[] getRadioButtons() {
		return radioButtons;
	}

	public void setRadioButtons(JRadioButton[] radioButtons) {
		this.radioButtons = radioButtons;
	}

	private static final long serialVersionUID = 1L;

	public NorthPanel(CenterPanel centerPanel) {
		this.centerPanel = centerPanel;
		radioButtons = new JRadioButton[3];
		radioButtonGroup = new ButtonGroup();
		for (int i = 0; i < radioButtons.length; i++) {
			radioButtons[i] = new JRadioButton(StringConst.fruits[i]);
			final int fi = i;
			radioButtons[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					centerPanel.getLabel().setIcon((centerPanel.getImageIcons())[fi]);
					
				}
			});
			add(radioButtons[i]);
			radioButtonGroup.add(radioButtons[i]);
			
		}

	}

}

class CenterPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private ImageIcon[] imageIcons;
	private JLabel label;

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public CenterPanel() {
		setLayout(new BorderLayout());
		imageIcons = new ImageIcon[3];
		for (int i = 0; i < imageIcons.length; i++) {
			imageIcons[i] = new ImageIcon(StringConst.images_folder_path + StringConst.fruits[i] + ".jpg");
			
		}
		label = new JLabel();
		label.setIcon(imageIcons[0]);
		add(label, BorderLayout.CENTER);
	}

	public ImageIcon[] getImageIcons() {
		return imageIcons;
	}

	public void setImageIcons(ImageIcon[] imageIcons) {
		this.imageIcons = imageIcons;
	}

}

class RadioFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	CenterPanel centerPanel;
	NorthPanel northPanel;

	public RadioFrame() {
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setTitle("Radio Button Test");
		centerPanel = new CenterPanel();
		northPanel = new NorthPanel(centerPanel);
		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		setSize(400, 400);
		setLocation(400, 400);
		setVisible(true);
	}
}

public class RadioButtonFrame {
	public static void main(String[] args) {
		new RadioFrame();
	}
}
