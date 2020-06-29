package object;

public class Word {
	private int no;
	private String name;
	private String def;
	private String category;

	public Word() {

	}

	public Word(String name, String def, String category) {

		this.name = name;
		this.def = def;
		this.category = category;

	}

	public Word(int no, String name, String def, String category) {

		this.no = no;
		this.name = name;
		this.def = def;
		this.category = category;

	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDef() {
		return def;
	}

	public void setDef(String def) {
		this.def = def;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}


}
