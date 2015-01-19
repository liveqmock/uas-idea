package uas.model;

/**
 * 错误信息
 * 
 * @author percy
 *
 */
public class ErrorInfo {
	/**
	 * 错误码
	 */
	private String error;
	/**
	 * 错误描述
	 */
	private String description;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
