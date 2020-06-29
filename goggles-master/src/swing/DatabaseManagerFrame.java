package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import org.apache.commons.io.FilenameUtils;

import runner.FileRunner;

public class DatabaseManagerFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel southPanel;
	private JPanel panel;
	private JScrollPane textAreaScrollPane;
	private JPanel northPanel;
	private JScrollPane scrollPane;
	private JPanel textAreaCenterPanel;
	private JTextArea textArea;
	private FileJTree sqlTree;
	private File selectedFileByJTree;
	private String selectedFileNameByJTree;
	private TreePath selectedTreePath;
	private JButton runButton;
	private JLabel stateLabel;
//	private JButton autoButton;

	public DatabaseManagerFrame() {
		setTitle("데이터베이스 관리");
		textArea = new JTextArea();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setFont(new Font("Dialog", Font.PLAIN, 10));
		setSize(800, 500);
		getContentPane().setLayout(null);
		panel = new JPanel();
		getContentPane().setLayout(new BorderLayout(0, 0));
		panel.setLayout(new BorderLayout(0, 0));
		addTextAreaCenterPanel();

		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel.add(scrollPane, BorderLayout.WEST);

		sqlTree = new FileJTree("resources\\sql");
		scrollPane.setViewportView(sqlTree);

		northPanel = new JPanel();
		panel.add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new BorderLayout(0, 0));

		runButton = new JButton("Run");
		runButton.setEnabled(false);
		runButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runFile();
			}

		});
		northPanel.add(runButton, BorderLayout.EAST);

		stateLabel = new JLabel("");
		northPanel.add(stateLabel, BorderLayout.CENTER);

//		autoButton = new JButton("자동생성");
//		autoButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				DatabaseManager database = new DatabaseManager();
//				database.connectServer(new MySQL());
//				if (autoButton.getText().equals("자동삭제")) {
//					FileRunner fileRunner = new FileRunner();
//					fileRunner.run("delete",ResourceManager.DELETE_DATABASE_SQL_PATH, stateLabel);
//					autoButton.setText("자동생성");
//				}else {
//					stateLabel.setText("데이터베이스 자동 생성 작업을 시작합니다.");
//					DatabaseManager databaseManager = new DatabaseManager();
//					databaseManager.connectServer(new MySQL());
//					FileRunner fileRunner = new FileRunner();
//					fileRunner.run("create", ResourceManager.SQL_CREATE_DATABASE_IF_NOT_EXISTS, stateLabel);
//					fileRunner.run("create", ResourceManager.CREATE_MEMBER_SQL_PATH, stateLabel);
//					fileRunner.run("create", ResourceManager.CREATE_WORD_SQL_PATH, stateLabel);
//					fileRunner.run("insert", ResourceManager.INSERT_MEMBER_SQL_PATH, stateLabel);
//					fileRunner.run("insert", ResourceManager.INSERT_WORD_SQL_PATH, stateLabel);
//					stateLabel.setText("데이터베이스 자동 생성 작업이 완료되었습니다.");
//					autoButton.setText("자동삭제");
//				}
//			}
//		});
//		northPanel.add(autoButton, BorderLayout.WEST);

		southPanel = new JPanel();
		panel.add(southPanel, BorderLayout.SOUTH);
		southPanel.setLayout(new GridLayout(0, 1, 0, 0));
		sqlTree.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent me) {
				int clickCount = me.getClickCount();
				if (clickCount == 1) {
					readFile();
				}

			}

		});

		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void runFile() {
		FileRunner runService = new FileRunner();
		Thread th = new Thread() {
			@Override
			public void run() {
				// 명령 확인, 대상 설정
				TreePath parentPath = selectedTreePath.getParentPath();
				String commandFileName = sqlTree.getPath(parentPath).toString();

				System.out.println(commandFileName);
				System.out.println(selectedFileNameByJTree);
				String command = FilenameUtils.getBaseName(commandFileName);
				System.out.println(command);

				// 실행
				runService.run(command, selectedFileNameByJTree, stateLabel, textArea);

			}

		};
		th.start();
	}

	private void readFile() {
		Thread th = new Thread() {
			@Override
			public void run() {
				TreeSelectionModel treeModel = sqlTree.getSelectionModel();
				selectedTreePath = treeModel.getLeadSelectionPath();
//				System.out.println(treePath);
				selectedFileNameByJTree = sqlTree.getPath(selectedTreePath);
//				System.out.println(selectedFileNameByJTree);

				StringBuilder sb = new StringBuilder(new String(""));
				selectedFileByJTree = null;
				selectedFileByJTree = new File(selectedFileNameByJTree);
				FileReader fr = null;
				BufferedReader br = null;
				if (!selectedFileByJTree.isDirectory()) {
					runButton.setEnabled(true);
					try {
						fr = new FileReader(selectedFileByJTree);
						br = new BufferedReader(fr);
						String s;
						while ((s = br.readLine()) != null) {
							sb.append(s + "\n");
						}
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					textArea.setText(sb.toString());
				} else {
					runButton.setEnabled(false);
					File[] folderFiles = selectedFileByJTree.listFiles();
					for (File f : folderFiles) {
						String fName = f.getName();
						sb.append(fName + "\n");
					}
					textArea.setText(sb.toString());
					repaint();

				}
				try {
					if (fr != null) {
						fr.close();

					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		th.start();

	}

	private void addTextAreaCenterPanel() {
		textAreaCenterPanel = new JPanel();
		textAreaCenterPanel.setLayout(new BorderLayout());
		textAreaScrollPane = new JScrollPane(textArea);
		textArea.setEditable(false);
		textAreaCenterPanel.add(textAreaScrollPane, BorderLayout.CENTER);
		panel.add(textAreaCenterPanel, BorderLayout.CENTER);
		getContentPane().add(panel);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatabaseManagerFrame window = new DatabaseManagerFrame();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	protected JPanel getSouthPanel() {
		return southPanel;
	}

	protected JPanel getPanel() {
		return panel;
	}

	protected JScrollPane getTextAreaScrollPane() {
		return textAreaScrollPane;
	}

	protected JPanel getNorthPanel() {
		return northPanel;
	}

	protected JScrollPane getScrollPane() {
		return scrollPane;
	}
}
