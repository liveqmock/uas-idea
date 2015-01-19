package uas.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uas.model.AccessToken;
import uas.model.Token;
import uas.repo.AccessTokenRepo;

/**
 * 授权服务
 * 
 * @author percy
 *
 */
@Service
public class AuthzService {
	
	private Logger log = LoggerFactory.getLogger(AuthzService.class);
	
	@Autowired
	private AccessTokenRepo accessTokenRepo;
	/**
	 * 获取授权码
	 * 
	 * @param responseType
	 *            授权类型：可以为空，默认为code
	 * @param clientId
	 *            应用编码：必填
	 * @param redirectUri
	 *            返回到客户端地址
	 * @param scope
	 *            授权访问的范围：可以为空
	 * @param display
	 *            回调类型：可以为空
	 * @return <br>
	 *         返回授权码
	 */
	public String authorization(String responseType, String clientId,
			String redirectUri, String scope, String display) {
		return null;
	}

	/**
	 * 获取访问令牌<br>
	 * 与上述接口由浏览器发起的请求不同的是，该接口有客户端发起请求<br>
	 * 
	 * @param grantType
	 *            授权类型：可以为空，默认为authorization_code
	 * @param code
	 *            上述接口返回的授权码：必填
	 * @param clientId
	 *            客户端编码：必填
	 * @param clientSecret
	 *            客户端密码：必填
	 * @param redirectUri
	 *            客户端注册时候的Uri：建议填写，以后可以有效验证。
	 * @return <br>
	 *         返回一个Token(Json)<br>
	 *
	 */
	public Token token(String grantType, String code, String clientId,
			String clientSecret, String redirectUri) {
		return null;
	}

	@Transactional
	public void testSave() throws CloneNotSupportedException {
		AccessToken accessToken = new AccessToken();
		accessToken.setAppId("43tasret");
		accessToken.setCreatedTime(new Date());
		accessToken.setCode("5qw45");
		accessToken.setExpiredTime(new Date());
		accessToken.setIp("dsagasdg");
		accessToken.setToken("gdsagasdg");
		accessToken.setUname("gasgdsagdsag");
//		accessToken.setId(53L);
		accessTokenRepo.save(accessToken);
		//accessTokenRepo.saveAndFlush(accessToken);
		log.debug("=============================" + accessToken.getId());
		//throw new RuntimeException("test");
		
		accessToken = accessTokenRepo.getOne(1L);
		accessToken.setUname("ddddd1");
		//克隆对象也不能解決不开启事物而保持session的问题
		//AccessToken new_accessToken = (AccessToken)accessToken.clone();
		//new_accessToken.setUname("ddddd1");
		//set在事物结束时会自动持久化到数据库
		//accessTokenRepo.save(new_accessToken);
	}

}
