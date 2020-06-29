package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import manager.ResourceManager;
import manager.WordTableManager;
import object.MySQL;

public class MainFrame extends JFrame implements ActionListener {
//	private ImageIcon searchImageIcon;
	private ColorPanel resultPanel;
	private ColorPanel randomPanel;
	private WhiteLabel leftFocusLabel;
	private EmptyBackgroundButton gogglesButton;
	private WhiteLabel rightFocusLabel;
	private ImagePanel rootPanel;
//	private ColorPanel categoryPanel;
//	private EmptyBackgroundButton hideButton;
	private EmptyBackgroundButton exitButton;
	private WhiteBorderTextField searchTextField;
	private WhiteLabel goggles;
//	private EmptyBackgroundButton searchButton;
	private EmptyBackgroundButton signUpButton;
	private EmptyBackgroundButton signInButton;
	private SignInPanel signInPanel;
	private SignUpPanel signUpPanel;
	private TimePannel timePanel;
	private boolean isLogin = false;
	private WordTableManager wordManager;

	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}

	public ColorPanel getRandomPanel() {
		return randomPanel;
	}

	public void setRandomPanel(ColorPanel randomPanel) {
		this.randomPanel = randomPanel;
	}

	public ImagePanel getRootPanel() {
		return rootPanel;
	}

	public void setRootPanel(ImagePanel rootPanel) {
		this.rootPanel = rootPanel;
	}

	public WhiteBorderTextField getSearchTextField() {
		return searchTextField;
	}

	public void setSearchTextField(WhiteBorderTextField searchTextField) {
		this.searchTextField = searchTextField;
	}

	public MainFrame() {
		wordManager = new WordTableManager();
		try {
			wordManager.connect(new MySQL());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initComponents();
		setLocationComponents();
		setUndecorated(true);
		setTheme();
		startFocusLabel();
		setGogglesButton();
//		setSearchButton();
		sertRootPanel();
		addComponents();
		setMainFrame();
		runUIRepaintThread();
		changeImageThread();
	}

	public WordTableManager getWordManager() {
		return wordManager;
	}

	public void setWordManager(WordTableManager wordManager) {
		this.wordManager = wordManager;
	}

	private void changeImageThread() {

		Thread changeImageThread = new Thread() {
			@Override
			public void run() {
//				rootPanel.setBackground(Color.WHI);
				int imageIndex = 1;
				while (true) {
					
					try {
						ColorPanel stopPanel = new ColorPanel(ResourceManager.WHITE);
						sleep(7000);
						stopPanel.setLayout(null);
						stopPanel.setBounds(0, 0, ResourceManager.FRAME_WIDTH, ResourceManager.FRAME_HEIGHT);

//						Thread th = new Thread() {
//
//							@Override
//							public void run() {
//								try {
//									add(stopPanel);
//									for (int i = 0; i < 120; i++) {
//										Color color = new Color(1F, 1F, 1F,i / 120F);
//										stopPanel.setBackground(color);
//										Thread.sleep(5);
//									}
//									for (int i = 120; i >= 0; i--) {
//										Color color = new Color(1F, 1F, 1F, i / 120F);
//										stopPanel.setBackground(color);
//										Thread.sleep(5);
//									}
//									remove(stopPanel);
//								} catch (Exception e) {
//									e.printStackTrace();
//								}
//							}
//
//						};
//						th.start();
						rootPanel.changeImage("resources\\image\\goggles-" + imageIndex + ".jpg");
						if (imageIndex >= 5) {
							imageIndex = 1;
						}
						imageIndex++;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		changeImageThread.start();
	}

	private void runUIRepaintThread() {
		Thread repaintThread = new Thread() {
			@Override
			public void run() {
				while (true) {
					repaint();
					try {
						sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		repaintThread.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
//		System.out.println(command);

	}

	private void addComponents() {
		rootPanel.add(timePanel);
		rootPanel.add(leftFocusLabel);
		rootPanel.add(rightFocusLabel);
		rootPanel.add(gogglesButton);

		rootPanel.add(exitButton);

//		rootPanel.add(hideButton);
//		textField.addKeyListener(this);
	}

	private void initComponents() {
		exitButton = new EmptyBackgroundButton("x");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setFont(new Font("굴림", Font.PLAIN, 12));
		exitButton.setBounds(1219, 12, 47, 32);

//		hideButton.setFont(new Font("굴림", Font.PLAIN, 10));
//		hideButton.setBounds(1158, 12, 47, 32);
//		categoryPanel = new ColorPanel(ResourceManager.BLACK_ALPHA);
		resultPanel = new ColorPanel(ResourceManager.BLACK_ALPHA);
		randomPanel = new ColorPanel(ResourceManager.NONE);
		signUpButton = new EmptyBackgroundButton("[회원가입]");
		signInButton = new EmptyBackgroundButton("[로그인]");
		timePanel = new TimePannel();
//		searchImageIcon = new ImageIcon();
//		setImageIcon();
//		searchButton = new EmptyBackgroundButton(searchImageIcon);

		goggles = new WhiteLabel("Goggles");
		rootPanel = new ImagePanel("resources\\image\\goggles-" + ((int) (Math.random() * 5) + 1) + ".jpg");

		rootPanel.setBackground(ResourceManager.BLACK);
		rootPanel.setBorder(new CompoundBorder(new LineBorder(ResourceManager.NONE, 5, true),
				new LineBorder(new Color(255, 255, 255), 1, true)));
		searchTextField = new WhiteBorderTextField();
//		searchTextField.setForeground(Color.yellow);
		searchTextField.setFont(new Font("나눔손글씨 펜", Font.PLAIN, 24));
		searchTextField.setText("    단어를 검색하려면 로그인이 필요합니다.");
		searchTextField.setEditable(false);
//		textField.setFont(new F);
		leftFocusLabel = new WhiteLabel(">>");
		rightFocusLabel = new WhiteLabel("<<");
		leftFocusLabel.setFont(new Font("나눔손글씨 펜", Font.PLAIN, 96));
		rightFocusLabel.setFont(new Font("나눔손글씨 펜", Font.PLAIN, 96));
		signInButton.setForeground(Color.white);
		signUpButton.setForeground(Color.white);
		signInButton.setFont(new Font("나눔손글씨 펜", Font.PLAIN, 24));
		signUpButton.setFont(new Font("나눔손글씨 펜", Font.PLAIN, 24));
	}

//	private void setImageIcon() {
//		BufferedImage bi = null;
//		try {
//			bi = ImageIO.read(new File("resources\\image\\search_icon.png"));
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		searchImageIcon.setImage(bi);
//
//	}

	public EmptyBackgroundButton getSignUpButton() {
		return signUpButton;
	}

//	public ColorPanel getCategoryPanel() {
//		return categoryPanel;
//	}
//
//	public void setCategoryPanel(ColorPanel categoryPanel) {
//		this.categoryPanel = categoryPanel;
//	}

	public void setSignUpButton(EmptyBackgroundButton signUpButton) {
		this.signUpButton = signUpButton;
	}

	public EmptyBackgroundButton getSignInButton() {
		return signInButton;
	}

	public void setSignInButton(EmptyBackgroundButton signInButton) {
		this.signInButton = signInButton;
	}

	public void setSearchFieldLocationThread() {
//		Thread timePanelLocationThread = new Thread() {
//
//			@Override
//			public void run() {
//				int a = 0;
//				while (a < 255) {
//					a++;
//					Color c = new Color(1.0F, 1.0F, 1.0F, (a / 255.0F));
//					timePanel.setForeground(c);
//					try {
//						Thread.sleep(10);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//				timePanel.setVisible(false);
//			}
//
//		};
//		timePanelLocationThread.start();
		Thread th = new Thread() {
			@Override
			public void run() {
				int step = 1;
				int textField_x = searchTextField.getX();
				int textField_y = searchTextField.getY();
				int goggles_x = goggles.getX();
				int goggles_y = goggles.getY();
				while (true) {
					if (textField_y < 200) {

//						JPanel listPanel = new JPanel();
//						listPanel.setLayout(new BorderLayout());
//						Vector<Word> wordVector = new Vector<Word>();
//						WordTableManager wordTableManager = new WordTableManager();
//						JList<String> jList = new JList<>();
//						try {
//							wordTableManager.connect(new MySQL());
//						} catch (Exception e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//						Word word = wordTableManager.selectByName(textField.getText().trim());
//						if (word == null) {
//							wordVector = wordTableManager.selectByFirstName(textField.getText().charAt(0));
//							for (Word w : wordVector) {
//								jList.add(new EmptyBackgroundButton(w.getName()));
//							}
//						} else {
//							wordVector.add(word);
//							jList.add(new EmptyBackgroundButton(word.getName()));
//						}
//						listPanel.add(jList, BorderLayout.CENTER);
//						repaint();
						break;
					}
					textField_y -= step;
					goggles_y -= step;
					try {
						sleep(2);
						repaint();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					goggles.setLocation(goggles_x, goggles_y);
					searchTextField.setLocation(textField_x, textField_y);

				}
				Thread gogglesMoveThread = new Thread() {

					@Override
					public void run() {
						int goggles_x = goggles.getX();
						int goggles_y = goggles.getY();
						while (true) {
							if (goggles_x < 0) {
								break;
							}
//							textField_x -= step;
//							goggles_x -= step;
							try {
								sleep(1);

							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							goggles.setLocation(goggles_x, goggles_y);
						}
					}

				};
				gogglesMoveThread.start();
				Thread tfMoveThread = new Thread() {

					@Override
					public void run() {
						int textField_x = searchTextField.getX();
						int textField_y = searchTextField.getY();
						while (true) {
							if (textField_y < 250) {
								break;
							}
							textField_y -= step;
							try {
								sleep(3);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							searchTextField.setLocation(textField_x, textField_y);
						}
					}

				};
				tfMoveThread.start();
			}

		};
		th.start();

	}

	private void sertRootPanel() {
		rootPanel.setLayout(null);
	}

	private void setLocationComponents() {
//		categoryPanel.setBounds(250, 300, 750, 32);
		randomPanel.setBounds(250, 280, 750, 80);
		leftFocusLabel.setBounds(25, 309, 100, 100);
		rightFocusLabel.setBounds(1160, 309, 100, 100);
		signUpButton.setBounds(1160, 10, 100, 100);
		signInButton.setBounds(1048, 10, 100, 100);
		timePanel.setBounds(25, 25, 239, 75);
	}

	public ColorPanel getResultPanel() {
		return resultPanel;
	}

	public void setResultPanel(ColorPanel resultPanel) {
		this.resultPanel = resultPanel;
	}

	private void setMainFrame() {

		setSize(new Dimension(ResourceManager.FRAME_WIDTH, ResourceManager.FRAME_HEIGHT));

		setBackground(ResourceManager.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(rootPanel);

		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	private void setSignInButton() {
		signInButton.setBorderPainted(false);
		signInButton.setBorder(new MatteBorder(1, 1, 1, 1, new Color(255, 255, 255)));
		signInButton.setBackground(ResourceManager.BLACK_ALPHA);
		signInButton.setOpaque(false);
		signInButton.setFocusPainted(false);
		signInButton.setContentAreaFilled(false);
		signInButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				if (signInPanel != null) {
//					
					rootPanel.remove(signInPanel);
				}
				if (signUpPanel != null) {
					rootPanel.remove(signUpPanel);
				}
				signInPanel = new SignInPanel(MainFrame.this);
				signInPanel.setBackground(ResourceManager.BLACK_ALPHA);
				signInPanel.setBounds(ResourceManager.FRAME_WIDTH - 400, 100, 365, 300);
				rootPanel.add(signInPanel);
			}

		});
	}

	private void setSignUpButton() {
		signUpButton.setBorderPainted(false);
		signUpButton.setBorder(new MatteBorder(1, 1, 1, 1, new Color(255, 255, 255)));
		signUpButton.setBackground(ResourceManager.BLACK_ALPHA);
		signUpButton.setOpaque(false);
		signUpButton.setFocusPainted(false);
		signUpButton.setContentAreaFilled(false);
		signUpButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (signInPanel != null) {
					rootPanel.remove(signInPanel);

				}
				if (signUpPanel != null) {
					rootPanel.remove(signUpPanel);
				}

				signUpPanel = new SignUpPanel(MainFrame.this);
				signUpPanel.setBackground(ResourceManager.BLACK_ALPHA);
				signUpPanel.setBounds(ResourceManager.FRAME_WIDTH - 400, 100, 365, 500);
				rootPanel.add(signUpPanel);
			}

		});
	}

//	private void setSearchButton() {
//		searchButton.setPreferredSize(new Dimension(100, 50));
//		searchButton.setBorderPainted(false);
//		searchButton.setBorder(null);
//		searchButton.setBackground(ResourceManager.BLACK_ALPHA);
//		searchButton.setOpaque(false);
//		searchButton.setFocusPainted(false);
//		searchButton.setContentAreaFilled(false);
//
//	}

	private void setGogglesButton() {
		gogglesButton = new EmptyBackgroundButton("Goggles");
		gogglesButton.setBorderPainted(false);
		gogglesButton.setBorder(null);
		gogglesButton.setBackground(ResourceManager.BLACK_ALPHA);
		gogglesButton.setOpaque(false);
		gogglesButton.setFocusPainted(false);
		gogglesButton.setContentAreaFilled(false);
		gogglesButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				gogglesButton.removeMouseListener(this);
				gogglesButton.setVisible(false);

				setSignInButton();
				setSignUpButton();
				rootPanel.add(signUpButton);
				rootPanel.add(signInButton);
				rootPanel.validate();
//				System.out.println(signUpButton.isVisible());
				rootPanel.add(signInButton);
				Thread fadeout = new Thread() {

					@Override
					public void run() {
						int alpha = 0;
						while (true) {
							if (alpha > 254) {

								leftFocusLabel.setVisible(false);
								rightFocusLabel.setVisible(false);
								break;
							}
							Color color = new Color(1.0F, 1.0F, 1.0F, alpha / 255.0F);
							alpha = alpha + 5;
							signInButton.setForeground(color);
							signUpButton.setForeground(color);
							try {
								Thread.sleep(1);
								repaint();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}

				};
				fadeout.start();
				Thread textFieldThread = new Thread() {

					@Override
					public void run() {

						goggles.setFont(new Font("나눔손글씨 펜", Font.PLAIN, 96));
						goggles.setForeground(Color.WHITE);
						goggles.setHorizontalAlignment(SwingConstants.CENTER);
						goggles.setBounds(465, 259, 300, 200);
						rootPanel.add(goggles);
						gogglesButton.setVisible(false);
						int goggles_y = goggles.getY();
						int goggles_x = goggles.getX();
						while (true) {
							goggles_y--;
							if (goggles_y < 180) {
								rootPanel.add(searchTextField);
//								rootPanel.add(searchButton);
//								searchButton.setBounds(790, 345, 64, 64);
								searchTextField.setBounds(470, 350, 300, 50);
//								textField.setBackground(ResourceManager.NONE);
//								textField.setBorder(new MatteBorder(1, 1, 1, 1, new Color(255, 255, 255)));
								searchTextField.setFocusable(true);
								Color color = ResourceManager.NONE;
								int alpha = color.getAlpha();

								while (true) {
									if (alpha > 150) {
										break;
									}
									alpha++;
									color = new Color(1.0F, 1.0F, 1.0F, alpha / 256.0F);
									try {
										Thread.sleep(10);
//										textField.setBackground(color);
										repaint();
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
								}
								break;
							}
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							goggles.setLocation(goggles_x, goggles_y);
						}

//						

					}

				};
				textFieldThread.start();
			}

		});
		gogglesButton.setLocation(25, 25);
		gogglesButton.setFont(new Font("나눔손글씨 펜", Font.PLAIN, 96));
		gogglesButton.setForeground(Color.WHITE);
		gogglesButton.setSize(1235, 668);
		gogglesButton.setSize(ResourceManager.FRAME_WIDTH - 100, ResourceManager.FRAME_HEIGHT - 100);
	}

	private void setTheme() {

		leftFocusLabel.setForeground(ResourceManager.WHITE_ALPHA);
		rightFocusLabel.setForeground(ResourceManager.WHITE_ALPHA);
	}

	private void startFocusLabel() {
		Thread focusLabelThread = new Thread() {

			@Override
			public void run() {
				int alpha = 0;
				int leftX = 25;
				Color color = null;
				int rightX = ResourceManager.FRAME_WIDTH - 100;
				int flag = -1;
				while (true) {
					if (alpha > 128 || alpha < 0) {
						flag = flag * -1;
					}
					leftX = leftX + flag;
					rightX = rightX - flag;
					alpha = alpha + flag;

					try {
						color = new Color(1.0F, 1.0F, 1.0F, alpha / 256.0F);
						leftFocusLabel.setForeground(color);
						rightFocusLabel.setForeground(color);
						leftFocusLabel.setLocation(leftX, 300);
						rightFocusLabel.setLocation(rightX, 300);
						repaint();

						sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}

		};
		focusLabelThread.start();
	}
}