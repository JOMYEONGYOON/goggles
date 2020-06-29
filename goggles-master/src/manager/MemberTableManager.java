package manager;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import object.Member;

// databasemanager extends to member table manager
public class MemberTableManager extends DatabaseManager {

	// sql query member table
	protected final static String SELECT_MEMBER_BY_ID_SQL = "SELECT id,name,def,category FROM word WHERE id=?";
	protected final static String SELECT_MEMBER_BY_NAME_SQL = "SELECT id,name,def,category FROM word WHERE name=?";
	protected final static String INSERT_MEMBER_AUTO_INCREMENT_NO_SQL = "INSERT INTO member(id,name,phone,birth,email,gender,password, etc) VALUES(?,?,?,?,?,?,?,?)";
	protected final static String SELECT_MEMBER_CHECK_ID_PASSWORD_SQL = "SELECT * FROM member WHERE id=? AND password=?";

	// create member table sql path by scanner
	public void createMemberTable() {
		Scanner sc = null;
		String sql = "";
		try {
			sc = new Scanner(new File(ResourceManager.CREATE_MEMBER_SQL_PATH));
			while (sc.hasNext()) {
				String temp = sc.nextLine() + " ";
				if (temp.equals("")) {
					continue;
				}
				sql += temp;
			}
			PreparedStatement prepareStatement = null;
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.execute();
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// get by id member talbe get member set id , sql connect server
	public Member selectById(String id) {
		Member member = null;
		try {
			PreparedStatement pstmt = connection.prepareStatement(SELECT_MEMBER_BY_ID_SQL);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				member = new Member(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}

	// insert member, exception throws
	public void insert(Member member) throws Exception {
		PreparedStatement pstmt = connection.prepareStatement(INSERT_MEMBER_AUTO_INCREMENT_NO_SQL);
		pstmt.setString(1, member.getId());
		pstmt.setString(2, member.getName());
		pstmt.setString(3, member.getPhone());
		pstmt.setString(4, member.getBirth());
		pstmt.setString(5, member.getEmail());
		pstmt.setString(6, member.getGender());
		pstmt.setString(7, member.getPassword());
		pstmt.setString(8, member.getEtc());
		pstmt.executeUpdate();
	}
	
	// checkId Password, id, password
	public boolean checkIdPassword(String id, String password) throws Exception {
		PreparedStatement pstmt = connection.prepareStatement(SELECT_MEMBER_CHECK_ID_PASSWORD_SQL);
		pstmt.setString(1, id);
		pstmt.setString(2, password);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			return true;
		}
		return false;

	}

}