package uas.model;

public class User {

	private String id;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 真实姓名
	 */
	private String realname;
	/**
	 * 用户编号
	 */
	private String number;
	/**
	 * 所在部门
	 */
	private String organizationId;
	/**
	 * 所在部门的编号：默认与ID相同，冗余字段
	 */
	private String organziationCode;
	/**
	 * 所在部门名称
	 */
	private String organizationName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public String getOrganziationCode() {
		return organziationCode;
	}

	public void setOrganziationCode(String organziationCode) {
		this.organziationCode = organziationCode;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

}
