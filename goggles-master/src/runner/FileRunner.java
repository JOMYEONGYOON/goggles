package runner;

import java.io.File;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import org.apache.commons.io.FilenameUtils;

import manager.DatabaseManager;
import object.MySQL;

public class FileRunner {
	private DatabaseManager databaseManager;

	public void run(String command, String target, JLabel stateLabel, JTextArea textArea) {
		// 실행파일 명령, 대상 출력
		System.err.println("----------------------------------------------");
		System.out.printf("%10s %8s \n%10s %20s\n", "command", command, "target", target);
		String fileExtension = FilenameUtils.getExtension(target);
		databaseManager = new DatabaseManager();
		databaseManager.connectServer(new MySQL());
		// 파일 확장자가 SQL일 때만 데이터베이스 연결
		String result = "";
		if (fileExtension.equals("sql")) {
			System.out.println("sql");

			try {
//				MySQL wrongPasswordMySQL = new MySQL();
//				wrongPasswordMySQL.setPassword("wrong password");
//				databaseManager.connect(wrongPasswordMySQL);
				MySQL mySQL = new MySQL();
				// 명령어 판단하는 부분
//				System.out.println(command);
				String baseName = FilenameUtils.getBaseName(target);
				System.out.println(baseName);
				// 명령과 타겟에 따라 데이터베이스 매니저에서파일로 연결 실행
				if (command.equals("create")) {
					databaseManager.executeQueryByFile(new File(target));
				} else if (command.equals("delete")) {
					databaseManager.connect(mySQL);
					databaseManager.executeUpdateQueryByFile(new File(target));
					System.out.println(target);
				} else if (command.equals("insert")) {
					databaseManager.connect(mySQL);
					databaseManager.executeUpdateInsertQueryByFile(new File(target), stateLabel);
				} else {
					System.out.println("Nothing..");
				}
				result = String.format("%s %s %s", command, target, "완료");
				System.out.println(result);

			} catch (Exception e) {
				result = String.format("%s %s %s", command, target, "실패");
				System.out.println(result);
				e.printStackTrace();
			}
			stateLabel.setText(result);
		} else {
			result = "unknown command";
		}
	}

}
