package manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import object.Word;

// word table manager class <--extends database manager
public class WordTableManager extends DatabaseManager {
	private static final String INSERT_WORD_AUTO_INCREMENT_ID_SQL = "INSERT INTO word(name, def, category) VALUES(?, ?, ?)";
	private static final String SELECT_WORD_ALL_SQL = "SELECT * FROM word";
	private static final String SELECT_WORD_ALL_SQL_LIMIT = "SELECT * FROM word limit ?,?";
	private static final String SELECT_WORD_BY_NAME_SQL = "select no,name,def,category from word WHERE name=?";
	private static final String SELECT_WORD_BY_NO_SQL = "select no,name,def,category from word WHERE no=?";
	private static final String SELECT_WORDS_LIMIT_SQL = "select no, name, def, category from word WHERE name like ? limit ?, ?";

	// default constructor
	public WordTableManager() {
	}

	// word count get, maybe used check insert count total
	public int count() {
		int r = 0;
		try {

			PreparedStatement pstmt = connection.prepareStatement("select count(*) from word");
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				r = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}

	// create word table by sql path resources/sql/......
	public void createWordTable() {
		Scanner sc = null;
		String sql = "";
		try {
			// scanner new file resource manager created word sql path
			sc = new Scanner(new File(ResourceManager.CREATE_WORD_SQL_PATH));
			while (sc.hasNext()) {
				String temp = sc.nextLine() + " ";
				if (temp.equals("")) {
					continue;
				}
				sql += temp;
			}
			// prepare statement set sql
			PreparedStatement prepareStatement = null;
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.execute();
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// insert word name,def, category........
	public void insert(Word word) {
		try {
			PreparedStatement pstmt = connection.prepareStatement(INSERT_WORD_AUTO_INCREMENT_ID_SQL);

			System.out.println("---");

			pstmt.setString(1, word.getName());

			pstmt.setString(2, word.getDef());
			pstmt.setString(3, word.getCategory());
			pstmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// insert rows........ sql path
	public void insertRows(String sqlPath) {
		Scanner sc = null;
		try {
			System.out.println(ResourceManager.INSERT_WORD_SQL_PATH);
			sc = new Scanner(new File(sqlPath));
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
	// select words
	public ArrayList<Word> select() {
		ArrayList<Word> words = null;
		try {
			PreparedStatement pstmt = connection.prepareStatement(SELECT_WORD_ALL_SQL);
			ResultSet rs = pstmt.executeQuery();
			words = new ArrayList<Word>();
			while (rs.next()) {
				Word word = new Word();
				word.setNo(rs.getInt(1));
				word.setName(rs.getString(2));
				word.setDef(rs.getString(3));
				word.setCategory(rs.getString(4));
				words.add(word);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return words;
	}
	
	// select by first char name
	public Vector<Word> selectByFirstName(char ch) {
		Vector<Word> words = null;
		try {
			PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM word WHERE name like ? LIMIT 1,10");
			pstmt.setString(1, ch + "%");
			ResultSet rs = pstmt.executeQuery();

			words = new Vector<Word>();
			while (rs.next()) {
				Word word = null;
				word = new Word();
				word.setNo(rs.getInt(1));
				word.setName(rs.getString(2));
				word.setDef(rs.getString(3));
				word.setCategory(rs.getString(4));
				words.add(word);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return words;
	}
	
	//select word by name 
	public Word selectByName(String name) {
		Word word = null;
		try {
			PreparedStatement pstmt = connection.prepareStatement(SELECT_WORD_BY_NAME_SQL);
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				word = new Word();
				word.setNo(rs.getInt(1));
				word.setName(rs.getString(2));
				word.setDef(rs.getString(3));
				word.setCategory(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return word;
	}
	//select word by no
	public Word selectByNo(int no) {
		Word word = null;
		try {

			PreparedStatement pstmt = connection.prepareStatement(SELECT_WORD_BY_NO_SQL);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				word = new Word();
				word.setNo(rs.getInt(1));
				word.setName(rs.getString(2));
				word.setDef(rs.getString(3));
				word.setCategory(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return word;
	}
	//select start~end select limit get
	public ArrayList<Word> selectLimit(int start, int end) {
		// word arraylist define
		ArrayList<Word> words = null;
		try {
			// preparestatementset limit get word limit get connection
			PreparedStatement pstmt = connection.prepareStatement(SELECT_WORD_ALL_SQL_LIMIT);
			
			// start 
			pstmt.setInt(1, start);
			
			//step
			pstmt.setInt(2, end);
			
			//word result set get
			ResultSet rs = pstmt.executeQuery();
			words = new ArrayList<Word>();
			
			// rs get result set
			while (rs.next()) {
				// word
				Word word = new Word();
				word.setNo(rs.getInt(1));
				word.setName(rs.getString(2));
				word.setDef(rs.getString(3));
				word.setCategory(rs.getString(4));
				words.add(word);
			}
		} catch (Exception e) {
			
			//exception print
			e.printStackTrace();
		}
		
		//return
		return words;
	}

	//select limit by name limiti start, end
	public ArrayList<Word> selectLimitByName(String name, int start, int end) {
		ArrayList<Word> words = null;
		try {
			PreparedStatement pstmt = connection.prepareStatement(SELECT_WORDS_LIMIT_SQL);
			pstmt.setString(1, "%" + name + "%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			ResultSet rs = pstmt.executeQuery();

			words = new ArrayList<Word>();
			while (rs.next()) {
				Word word = new Word();
				word.setNo(rs.getInt(1));
				word.setName(rs.getString(2));
				word.setDef(rs.getString(3));
				word.setCategory(rs.getString(4));
				words.add(word);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return words;
	}

	// select Words limit
	public ArrayList<String> selectWordLimit(int start, int end) {
		ArrayList<String> words = null;
		try {
			PreparedStatement pstmt = connection.prepareStatement(SELECT_WORD_ALL_SQL_LIMIT);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			ResultSet rs = pstmt.executeQuery();
			words = new ArrayList<String>();
			while (rs.next()) {
				words.add(rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return words;
	}

}
