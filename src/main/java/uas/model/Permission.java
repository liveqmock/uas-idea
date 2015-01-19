package uas.model;

/**
 * 权限
 * 
 * @author percy
 *
 */
public class Permission {

	private String id;
	/**
	 * URI
	 */
	private String uri;
	/**
	 * 编码：默认与ID相同，设计时候冗余字段
	 */
	private String code;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
