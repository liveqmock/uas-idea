package uas.controller.oauth;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import uas.exception.UasException;
import uas.model.AccessToken;
import uas.model.Token;
import uas.repo.AccessTokenRepo;
import uas.service.AuthzService;

/**
 * 授权模块<br>
 * 思路参考百度开发平台的OAuth2来实现的。<br>
 * 百度参考文档地址:http://developer.baidu.com/wiki/index.php?title=docs/oauth/
 * application
 * <p>
 * 流程：<br>
 * <ul>
 * <li>引导用户授权，这里集成了CAS如果用户未登陆，会自动跳转到CAS登陆的地址上进行登陆。
 * <li>客户端通过发起Http请求根据AuthorziationCode获取访问令牌
 * </p>
 * 
 * @author percy
 *
 */
@Controller
@RequestMapping("/oauth2")
public class AuthorizeController {
	private Logger log = LoggerFactory.getLogger(AuthorizeController.class);

	@Autowired
	private AuthzService authzService;
	@Autowired
	private AccessTokenRepo accessTokenRepo;
	/**
	 * 引导用户授权<br>
	 * 因为这里集成了CAS如果用户未登陆，会自动跳转到CAS登陆的地址上进行登陆。
	 * 
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
	 *         引导（302）浏览器跳转到客户端地址上，格式为：YOUR_REGISTERED_URI?code=CODE<br>
	 */
	@RequestMapping("authorize")
	public String authorization(
			@RequestParam(value = "response_type", required = false) String responseType,
			@RequestParam(value = "client_id", required = true) String clientId,
			@RequestParam(value = "redirect_uri", required = false) String redirectUri,
			@RequestParam(value = "scope", required = false) String scope,
			@RequestParam(value = "display", required = false) String display)
			throws UasException {
		
		
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
	 * @return 返回一个Token(Json)<br>
	 *         错误返回也是一个Json<br>
	 *         正确格式为:
	 * 
	 *         <pre>
	 * {
	 *     "access_token": "1.a6b7dbd428f731035f771b8d15063f61.86400.1292922000-2346678-124328",
	 *     "expires_in": 86400,
	 *     "refresh_token": "2.385d55f8615fdfd9edb7c4b5ebdc3e39.604800.1293440400-2346678-124328",
	 *     "scope": "basic email",
	 *     "session_key": "ANXxSNjwQDugf8615OnqeikRMu2bKaXCdlLxn",
	 *     "session_secret": "248APxvxjCZ0VEC43EYrvxqaK4oZExMB",
	 * }
	 * </pre>
	 * 
	 *         错误格式为：
	 * 
	 *         <pre>
	 * HTTP/1.1 400 Bad Request
	 * Content-Type: application/json
	 * Cache-Control: no-store
	 *  
	 * {
	 *     "error": "invalid_grant",
	 *     "error_description": "Invalid authorization code: ANXxSNjwQDugOnqeikRMu2bKaXCdlLxn"
	 * }
	 * </pre>
	 * 
	 */
	@ResponseBody
	@RequestMapping(name = "/token", method =    RequestMethod.POST)
	public Token token(
			@RequestParam(value = "grant_type", required = false) String grantType,
			@RequestParam(value = "code", required = true) String code,
			@RequestParam(value = "client_id", required = true) String clientId,
			@RequestParam(value = "client_secret", required = true) String clientSecret,
			@RequestParam(value = "redirect_uri", required = false) String redirectUri)
			throws UasException {
		
		
		return null;
	}

	/**
	 * 刷新令牌<br>
	 * 该方法不写实现<br>
	 * 解释：因我们的场景不是特别复杂，可以不用考虑刷新令牌。令牌有效期为12小时以上。但是这个接口必须有，遵循规范而已
	 * 
	 * @return 刷新令牌
	 */
	public String refreshToken() throws UasException {
		return null;
	}

	@RequestMapping("/test")
	public ModelAndView test(HttpServletRequest request ,HttpServletResponse response) throws IOException, CloneNotSupportedException {
		log.debug("访问测试:" + (authzService == null));
		authzService.testSave();
		//response.setContentType("");
		//response.getWriter().write("true");
		
		Map map = new HashMap();
		map.put("message", "true");
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		model.addAllObjects(map);
		return model;
	}
	
	@ResponseBody
	@RequestMapping("/findAll")
	public List<AccessToken> findAll (HttpServletResponse response) {
		//response.setContentType("application/json;charset=UTF-8");
		return accessTokenRepo.findAll();
	}

}
