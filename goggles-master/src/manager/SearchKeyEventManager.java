package manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.SwingConstants;

import object.Word;
import swing.ColorPanel;
import swing.EmptyBackgroundButton;
import swing.ImagePanel;
import swing.MainFrame;
import swing.WhiteBorderTextField;
import swing.WhiteLabel;

//SerchKeyEventManager jTextField, keyAdapter add, key released listener event set
public class SearchKeyEventManager extends KeyAdapter {
	
	// Search key vent field
	private MainFrame mainFrame;
	private WhiteBorderTextField searchTextField;
	private WordTableManager wordManager;
	private ColorPanel randomPanel;
	private ImagePanel rootPanel;
	private Vector<EmptyBackgroundButton> resultButtons;
	private ColorPanel resultPanel;
	private Thread addRandomThread;

	
	// public constructor mainframe get, to set field
	public SearchKeyEventManager(MainFrame mainFrame) {
		resultPanel = mainFrame.getResultPanel();
		resultButtons = new Vector<EmptyBackgroundButton>();
		this.wordManager = mainFrame.getWordManager();
		this.searchTextField = mainFrame.getSearchTextField();
		this.mainFrame = mainFrame;
		this.rootPanel = this.mainFrame.getRootPanel();
		this.randomPanel = this.mainFrame.getRandomPanel();

		randomPanel.setLayout(new GridLayout(1, 3));
		mainFrame.setSearchFieldLocationThread();
		
		//random integ
		addRandomThread = new Thread() {

			@Override
			public void run() {
				addRandom();
			}

		};
		addRandomThread.start();

	}
	//add random words set
	public void addRandom() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		while (true) {

			int count = wordManager.count();
			randomPanel.removeAll();
			ArrayList<Word> words = wordManager.selectLimit((int) (Math.random() * count), 3);
			for (int i = 0; i < words.size(); i++) {
				String name = words.get(i).getName();
				EmptyBackgroundButton nameButton = new EmptyBackgroundButton(name);
				nameButton.setHorizontalAlignment(SwingConstants.LEFT);
				nameButton.setFont(new Font("맑은고딕", Font.PLAIN, 14));
				nameButton.setTime(System.currentTimeMillis());
				randomPanel.add(nameButton);
				resultButtons.add(nameButton);
				nameButton.addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent e) {

						printResult();

					}

					private void printResult() {

						resultPanel.removeAll();
						Word word = wordManager.selectByName(nameButton.getText());
						resultPanel.setBounds(randomPanel.getX(), randomPanel.getY() + 100,
								(int) randomPanel.getSize().getWidth(), 250);
						resultPanel.setLayout(new BorderLayout());
						WhiteLabel head = new WhiteLabel(word.getName() + "    [분류:" + word.getCategory() + "]");
						head.setForeground(Color.yellow);
						head.setFont(new Font("나눔고딕", Font.PLAIN, 14));
						WhiteLabel defLabel = new WhiteLabel("<html><div>" + word.getDef() + "</div>");
						defLabel.setFont(new Font("나눔고딕", Font.PLAIN, 12));
						defLabel.setVerticalAlignment(SwingConstants.TOP);
						resultPanel.add(head, BorderLayout.NORTH);
						resultPanel.add(defLabel, BorderLayout.CENTER);
						rootPanel.add(resultPanel);
					}

				});
			}

			if (mainFrame.isLogin()) {
				randomPanel.setVisible(true);
			} else {
//				categoryPanel.setVisible(false);
				resultPanel.setVisible(false);
				randomPanel.setVisible(false);
			}
			try {
				Thread.sleep(5000);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	
	// if key released, set ui location set searchtextfield

	@Override
	public void keyReleased(KeyEvent e) {

		if (e.getKeyCode() == 10) {
			resultPanel.removeAll();
			if (!searchTextField.getText().equals("")) {
				Word word = wordManager.selectByName(searchTextField.getText());
				if (word != null) {
					resultPanel.setBounds(randomPanel.getX(), randomPanel.getY() + 100,
							(int) randomPanel.getSize().getWidth(), 250);
					resultPanel.setLayout(new BorderLayout());
					WhiteLabel head = new WhiteLabel(word.getName() + "    [분류:" + word.getCategory() + "]");
					head.setForeground(Color.yellow);
					head.setFont(new Font("나눔고딕", Font.PLAIN, 14));
					WhiteLabel defLabel = new WhiteLabel("<html><div>" + word.getDef() + "</div>");
					defLabel.setFont(new Font("나눔고딕", Font.PLAIN, 12));
					defLabel.setVerticalAlignment(SwingConstants.TOP);
					resultPanel.add(head, BorderLayout.NORTH);
					resultPanel.add(defLabel, BorderLayout.CENTER);
					rootPanel.add(resultPanel);
				} else {
					ArrayList<Word> words = wordManager.selectLimitByName(searchTextField.getText(), 0, 3);
					for (int i = 0; i < words.size(); i++) {
						String name = words.get(i).getName();
						EmptyBackgroundButton nameButton = new EmptyBackgroundButton(name);
						nameButton.setHorizontalAlignment(SwingConstants.LEFT);
						nameButton.setFont(new Font("맑은고딕", Font.PLAIN, 14));
						nameButton.setTime(System.currentTimeMillis());
						randomPanel.add(nameButton);
						resultButtons.add(nameButton);
						nameButton.addMouseListener(new MouseAdapter() {

							@Override
							public void mouseClicked(MouseEvent e) {

								printResult();
							}

							public void printResult() {
								resultPanel.removeAll();
								Word word = wordManager.selectByName(nameButton.getText());
								resultPanel.setBounds(randomPanel.getX(), randomPanel.getY() + 100,
										(int) randomPanel.getSize().getWidth(), 250);
								resultPanel.setLayout(new BorderLayout());
								WhiteLabel head = new WhiteLabel(
										word.getName() + "    [분류:" + word.getCategory() + "]");
								head.setForeground(Color.yellow);
								head.setFont(new Font("나눔고딕", Font.PLAIN, 14));
								WhiteLabel defLabel = new WhiteLabel("<html><div>" + word.getDef() + "</div>");
								defLabel.setFont(new Font("나눔고딕", Font.PLAIN, 12));
								defLabel.setVerticalAlignment(SwingConstants.TOP);
								resultPanel.add(head, BorderLayout.NORTH);
								resultPanel.add(defLabel, BorderLayout.CENTER);
								rootPanel.add(resultPanel);
							}
						});
					}
					if (words.size() <= 0) {
						WhiteLabel notFoundLabel = new WhiteLabel("<html><div>" + "단어를 찾지 못하였습니다.<br/>" + "</div>");
						notFoundLabel.setFont(new Font("나눔고딕", Font.PLAIN, 12));
						notFoundLabel.setVerticalAlignment(SwingConstants.TOP);
						resultPanel.add(notFoundLabel, BorderLayout.NORTH);
						rootPanel.add(resultPanel);
					}

				}
			} else {
			}
		}

	}

}
