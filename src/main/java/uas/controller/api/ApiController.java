package uas.controller.api;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uas.exception.UasException;
import uas.model.App;
import uas.model.Group;
import uas.model.Organization;
import uas.model.Permission;
import uas.model.Role;
import uas.model.User;

/**
 * 开放API接口<br>
 * 
 * @author percy
 *
 */
@RestController
@RequestMapping("/api")
public class ApiController {
	/**
	 * 获取用户信息
	 * 
	 * @param token
	 *            访问令牌：必填
	 * @return <br>
	 *         用户信息<br>
	 * 
	 * <pre>
	 * 
	 * </pre>
	 */
	@RequestMapping("/user-info")
	public User getUserInfo(String token) throws UasException {
		return null;
	}

	/**
	 * 获取该用户所在的系统中的权限
	 * 
	 * @param token
	 *            访问令牌：必填
	 * @return <br>
	 *         用户所拥有的权限
	 * 
	 * <pre>
	 * 
	 * </pre>
	 */
	@RequestMapping("/user-permissions")
	public List<Permission> getPermisstions(String token) throws UasException {
		return null;
	}

	/**
	 * 获取所有部门信息
	 * 
	 * @param token
	 *            访问令牌：必填
	 * @return <br>
	 *         所有的部门信息
	 */
	@RequestMapping("/list-organizations")
	public List<Organization> getAllOrganizations(String token)
			throws UasException {
		return null;
	}

	/**
	 * 获取用户所在组
	 * 
	 * @param token
	 *            访问令牌：必填
	 * @return <br>
	 *         用户所在用户组
	 */
	@RequestMapping("/user-groups")
	public List<Group> getGroups(String token) throws UasException {
		return null;
	}

	/**
	 * 获取所有用户组
	 * 
	 * @param token
	 *            访问令牌：必填
	 * @return <br>
	 *         所有的用户组
	 */
	@RequestMapping("/list-groups")
	public List<Group> getAllGroups(String token) throws UasException {
		return null;
	}

	/**
	 * 获取组下所有的用户
	 * 
	 * @param token
	 *            访问令牌：必填
	 * @param groupId
	 *            该用户组的主键
	 * @return 该用户组下的所有用户
	 */
	@RequestMapping("/group-users")
	public List<User> getUsersByGroup(String token, String groupId)
			throws UasException {
		return null;
	}

	/**
	 * 获取该用户拥有的系统跳转系统
	 * 
	 * @param token
	 *            访问令牌：必填
	 * @return <br>
	 *         该用户拥有的系统跳转系统
	 * 
	 * 
	 */
	@RequestMapping("/user-apps")
	public List<App> getApps(String token) throws UasException {
		return null;
	}

	/**
	 * 获取用户的拥有角色<br>
	 * 
	 * <b> 需要说明的是，在实现过程中，该接口只返回该用户所在的这个应用下的所有角色 </b>
	 * 
	 * @param token
	 * @return <br>
	 *         用户的拥有角色
	 */
	@RequestMapping("/user-roles")
	public List<Role> getRoles(String token) throws UasException {
		return null;
	}

	/**
	 * 根据角色获取所绑定的权限
	 * 
	 * @param token
	 * @param roleId
	 * @return <br>
	 *         角色获取所绑定的权限
	 */
	@RequestMapping("/role-permissions")
	public List<Permission> getPermisstionsByRole(String token, String roleId)
			throws UasException {
		return null;
	}

}
