package uas.model;

import java.util.Date;

/**
 * AuthorizationCode
 * 
 * @author percy
 *
 */
public class AuthorizationCode {

	private String id;
	/**
	 * 用户名
	 */
	private String uname;
	/**
	 * 应用编码
	 */
	private String appId;
	/**
	 * 跳转地址
	 */
	private String redirectUri;
	/**
	 * 创建时间
	 */
	private Date createdTime;
	/**
	 * 过期时间
	 */
	private Date expiredTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getRedirectUri() {
		return redirectUri;
	}

	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getExpiredTime() {
		return expiredTime;
	}

	public void setExpiredTime(Date expiredTime) {
		this.expiredTime = expiredTime;
	}

}
