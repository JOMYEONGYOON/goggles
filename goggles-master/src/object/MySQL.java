package object;

public class MySQL {
	private String id = "root";
	private String password = "1234";
	private String properties = "?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
	private String ip = "127.0.0.1";
	private String port = "3306";
	private String databaseName = "dictionary";

	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public MySQL() {

	}

	public MySQL(String id, String password, String properties, String ip, String port) {
		this.id = id;
		this.password = password;
		this.properties = properties;
		this.ip = ip;
		this.port = port;

	}

	public MySQL(String id, String password, String properties, String databaseName, String ip, String port) {
		this.id = id;
		this.password = password;
		this.properties = properties;
		this.ip = ip;
		this.port = port;
		this.databaseName = databaseName;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProperties() {
		return properties;
	}

	public void setProperties(String properties) {
		this.properties = properties;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}
