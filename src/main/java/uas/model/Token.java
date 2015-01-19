package uas.model;

/**
 * 访问令牌<br>
 * 
 * 返回格式
 * 
 * @author percy
 *
 */
public class Token {
	private String accessToken;
	private String expires_id;
	private String refreshToken;
	private String scope;
	private String sessionKey;
	private String sessionSecret;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getExpires_id() {
		return expires_id;
	}

	public void setExpires_id(String expires_id) {
		this.expires_id = expires_id;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getSessionKey() {
		return sessionKey;
	}

	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}

	public String getSessionSecret() {
		return sessionSecret;
	}

	public void setSessionSecret(String sessionSecret) {
		this.sessionSecret = sessionSecret;
	}

}
