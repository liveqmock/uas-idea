package uas.repo;

import java.util.List;

import uas.model.App;
import uas.model.Group;
import uas.model.Organization;
import uas.model.Permission;
import uas.model.Role;
import uas.model.User;

/**
 * Api Repo<br>
 * 该仓库使用MyBatis查询，修改业务即修改对应的Mapper文件即可
 * 
 * @author percy
 *
 */
public interface ApiRepo {
	/**
	 * 获取用户信息
	 * 
	 * @param uid
	 *            用户主键：必填
	 * @return <br>
	 *         用户信息<br>
	 * 
	 * <pre>
	 * 
	 * </pre>
	 */
	public User getUserInfo(Long uid);

	/**
	 * 获取该用户所在的系统中的权限
	 * 
	 * @param uid
	 *            用户主键：必填
	 * @param appCode
	 *            应用编码：必填
	 * @return <br>
	 *         用户所拥有的权限
	 * 
	 * <pre>
	 * 
	 * </pre>
	 */
	public List<Permission> getPermisstions(String uid, String appCode);

	/**
	 * 获取所有部门信息
	 * 
	 * @return <br>
	 *         所有的部门信息
	 */
	public List<Organization> getAllOrganizations();

	/**
	 * 获取用户所在组
	 * 
	 * @param uid
	 *            用户主键：必填
	 * @return <br>
	 *         用户所在用户组
	 */
	public List<Group> getGroups(String uid);

	/**
	 * 获取所有用户组
	 * 
	 * @return <br>
	 *         所有的用户组
	 */
	public List<Group> getAllGroups();

	/**
	 * 获取组下所有的用户
	 * 
	 * @param groupId
	 *            该用户组的主键
	 * @return 该用户组下的所有用户
	 */
	public List<User> getUsersByGroup(String groupId);

	/**
	 * 获取该用户拥有的系统跳转系统
	 * 
	 * @param uid
	 *            用户主键：必填
	 * @return <br>
	 *         该用户所用户的应用
	 * 
	 */
	public List<App> getApps(String uid);

	/**
	 * 获取用户的拥有角色<br>
	 * 
	 * <b> 需要说明的是，在实现过程中，该接口只返回该用户所在的这个应用下的所有角色 </b>
	 * 
	 * @param uid
	 *            用户主键：必填
	 * @return 该用户拥有的角色
	 */
	public List<Role> getRoles(String uid);

	/**
	 * 根据角色获取所绑定的权限
	 * 
	 * @param roleId
	 *            角色主键：必填
	 * @return 该角色关联的权限
	 */
	public List<Permission> getPermisstionsByRole(String roleId);
}
