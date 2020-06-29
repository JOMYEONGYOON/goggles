package manager;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import org.apache.commons.lang3.RandomUtils;

import com.thedeanda.lorem.LoremIpsum;

import object.Member;
import object.MySQL;

public class RandomInsertManager extends MemberTableManager {
	
	// random insert member loremIpsum
	public void randomInsert() {

		Member member = new Member();
		try {
			String sql = INSERT_MEMBER_AUTO_INCREMENT_NO_SQL;
			PreparedStatement pstmt = connection.prepareStatement(sql);
			LoremIpsum loremIpsum = new LoremIpsum();
			pstmt.setString(1, loremIpsum.getWords(1));
			int r = ((int) (Math.random() * 2));
			String gender = "";
			if (r == 1) {
				gender = "male";
				pstmt.setString(2, loremIpsum.getNameMale());
			} else {
				gender = "female";
				pstmt.setString(2, loremIpsum.getNameFemale());

			}

			pstmt.setString(3, loremIpsum.getPhone());

			// RandomUtils ApacheCommons
			Date date = new Date(Math.abs(System.currentTimeMillis() - RandomUtils.nextLong()));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
			String dateString = sdf.format(date);
			pstmt.setString(4, dateString);
			pstmt.setString(5, loremIpsum.getEmail());
			pstmt.setString(6, gender);
			pstmt.setString(7, loremIpsum.getWords(1));
			pstmt.setString(8, loremIpsum.getWords(20, 50));
			pstmt.executeUpdate();
			System.out.println(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	// random integer manager
	public static void main(String[] args) {

		RandomInsertManager ri = new RandomInsertManager();
		try {
			ri.connect(new MySQL());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < 10; i++) {
			ri.randomInsert();
		}
	}
}
