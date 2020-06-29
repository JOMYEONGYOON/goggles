package manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JLabel;

import object.MySQL;

public class DatabaseManager {

	// 데이터베이스 연결 객체
	protected static Connection connection;

	// mysql connect method , driver, connection set
	public void connect(MySQL mySQL) throws Exception {
		Class.forName(ResourceManager.MYSQL_DRIVER);
		connection = DriverManager.getConnection(ResourceManager.MYSQL_JDBC_URL + mySQL.getIp() + ":" + mySQL.getPort()
				+ "/" + mySQL.getDatabaseName() + mySQL.getProperties(), mySQL.getId(), mySQL.getPassword());

	}

	// run by file query
	public void executeQueryByFile(File file) throws Exception {

		String sql = "";
		Scanner sc = new Scanner(file);
		System.out.println("test");
		while (sc.hasNext()) {
			sql += sc.next() + " ";

		}
		System.out.println(sql);
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		prepareStatement.execute();
		sc.close();
	}

	// run by file query , insert, delete, update query
	public void executeUpdateQueryByFile(File file) throws Exception {
		String sql = "";
		Scanner sc = new Scanner(file);
		while (sc.hasNext()) {
			sql += sc.next() + " ";
		}
		System.out.println(sql);
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		prepareStatement.executeUpdate();
		sc.close();
	}

	// creat table method by sql path if fail retry to path force
	public void createTable() {
		Scanner sc = new Scanner(System.in);
		System.out.print(ResourceManager.YES_NO_CREATE_TABLE);
//		String answer = sc.next();
//		if (answer.equals("y") || answer.equals("Y")) {
//
//		} else {
//			System.err.println(ResourceManager.PROGRAM_SHUTDOWN);
//			System.exit(0);
//		}
		createTable();
		try {
			createTable(ResourceManager.CREATE_MEMBER_SQL_PATH);
			createTable(ResourceManager.CREATE_WORD_SQL_PATH);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sc.close();

	}

	// create table sql path by scanner
	public void createTable(String sqlPath) {
		Scanner sc = null;
		try {
			sc = new Scanner(new File(sqlPath));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		String sql = "";

		while (sc.hasNext()) {

			String temp = sc.nextLine() + " ";
			if (temp.equals("")) {
				continue;
			}
			sql += temp;

		}
		PreparedStatement prepareStatement = null;
		try {
			// get connection
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sc.close();
	}

	// drop table by table string name
	public void dropTable(String tableName) {
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = connection.prepareStatement(ResourceManager.SQL_DROP_TABLE + tableName);
			prepareStatement.execute();
		} catch (SQLException e) {
			// error print
			e.printStackTrace();
			System.err.printf("%s %s %s", getClass().getName(), Exception.class.getName(), ResourceManager.ERROR);
		}
	}

	// connect server, mysql server by mysql object (defined)
	public void connectServer(MySQL mySQL) {
		try {
			Class.forName(ResourceManager.MYSQL_DRIVER);
			connection = DriverManager.getConnection(ResourceManager.MYSQL_JDBC_URL + mySQL.getIp() + ":"
					+ mySQL.getPort() + "/" + mySQL.getProperties(), mySQL.getId(), mySQL.getPassword());
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	// execute by update insert query by file sql set file path
	public void executeUpdateInsertQueryByFile(File file) {
		Scanner sc = null;
		try {
			System.out.println(ResourceManager.INSERT_WORD_SQL_PATH);
			sc = new Scanner(file);
			String sql = "";
			while (sc.hasNext()) {
				PreparedStatement prepareStatement = null;
				try {
					System.out.println(sql);
					sql = sc.nextLine();
					prepareStatement = connection.prepareStatement(sql);
					prepareStatement.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println(sql);
					return;
				}
			}

		} catch (FileNotFoundException e) {
			System.err.println(ResourceManager.ALREADY_INSERTED_TABLE_DATA);
		}
		sc.close();

	}

	// execute update set state jlabel set by file
	public void executeUpdateInsertQueryByFile(File file, JLabel stateLabel) {
		Scanner fileLineCheckSC = null;
		try {
			fileLineCheckSC = new Scanner(new File(file.getPath()));
		} catch (FileNotFoundException e1) {

			e1.printStackTrace();
		}
		int lineTotalCount = 0;
		while (fileLineCheckSC.hasNext()) {
			fileLineCheckSC.nextLine();
			lineTotalCount++;
		}
		Scanner sc = null;
		try {
			System.out.println(ResourceManager.INSERT_WORD_SQL_PATH);
			sc = new Scanner(file);
			String sql = "";
			int count = 0;
			while (sc.hasNext()) {
				PreparedStatement prepareStatement = null;
				try {
					System.out.println(sql);
					sql = sc.nextLine();
					prepareStatement = connection.prepareStatement(sql);
					prepareStatement.executeUpdate();
					stateLabel.setText(count + "/" + lineTotalCount);
					Thread.sleep(10);
					count++;
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println(sql);
					return;
				}
			}

		} catch (FileNotFoundException e) {
			System.err.println(ResourceManager.ALREADY_INSERTED_TABLE_DATA);
		}
		sc.close();
		fileLineCheckSC.close();

	}

}
