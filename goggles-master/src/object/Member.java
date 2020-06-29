package object;

public class Member {
	private Integer no;
	private String id;
	private String name;
	private String phone;
	private String birth;
	private String email;
	private String gender;
	private String password;
	private String etc;

	public Member(Integer no, String id, String name, String phone, String birth, String email, String gender,
			String password, String etc) {
		this.no = no;
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.birth = birth;
		this.email = email;
		this.gender = gender;
		this.password = password;
		this.etc = etc;
	}

	public Member() {

	}

	public Member(String id, String name, String phone, String email, String birth, String gender, String password,
			String etc) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.birth = birth;
		this.email = email;
		this.gender = gender;
		this.password = password;
		this.etc = etc;

	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getBirth() {
		return birth;
	}

	public String getEmail() {
		return email;
	}

	public String getEtc() {
		return etc;
	}

	public String getGender() {
		return gender;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getNo() {
		return no;
	}

	public String getPassword() {
		return password;
	}

	public String getPhone() {
		return phone;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
