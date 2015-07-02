package com.getmeseva.db;

/**
 * @author uday
 *
 */
public class MysqlDatabaseInfo {

	String dbHost;
	String dbPort;
	String dbName;
	String userName;
	String password;
	
	
	/**
	 * @return the dbHost
	 */
	public String getDbHost() {
		return dbHost;
	}
	/**
	 * @param dbHost the dbHost to set
	 */
	public void setDbHost(String dbHost) {
		this.dbHost = dbHost;
	}
	/**
	 * @return the dbPort
	 */
	public String getDbPort() {
		return dbPort;
	}
	/**
	 * @param dbPort the dbPort to set
	 */
	public void setDbPort(String dbPort) {
		this.dbPort = dbPort;
	}
	/**
	 * @return the dbName
	 */
	public String getDbName() {
		return dbName;
	}
	/**
	 * @param dbName the dbName to set
	 */
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
