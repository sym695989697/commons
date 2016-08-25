package com.ctfo.upp.service.login;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.ctfo.csm.uaa.dao.beans.UAAOrg;
import com.ctfo.csm.uaa.dao.beans.UAAOrgRole;
import com.ctfo.csm.uaa.dao.beans.UAAPermission;
import com.ctfo.csm.uaa.dao.beans.UAAPermissionExampleExtended;
import com.ctfo.csm.uaa.dao.beans.UAASystem;
import com.ctfo.csm.uaa.dao.beans.UAASystemExampleExtended;
import com.ctfo.csm.uaa.dao.beans.UAAUser;
import com.ctfo.csm.uaa.dao.beans.UAA_Relation_OrgRole_PermGroup;
import com.ctfo.csm.uaa.dao.beans.UAA_Relation_OrgRole_PermGroupExampleExtended;
import com.ctfo.csm.uaa.dao.beans.UAA_Relation_PermGroup_Perm;
import com.ctfo.csm.uaa.dao.beans.UAA_Relation_PermGroup_PermExampleExtended;
import com.ctfo.csm.uaa.external.intf.IUAABusinessManager;
import com.ctfo.csm.uaa.external.intf.IUAASystemManager;
import com.ctfo.csm.uaa.intf.authentication.IAuthentication;
import com.ctfo.csm.uaa.meta.beans.UAAOrgMeta;
import com.ctfo.csm.uaa.meta.beans.UAARoleMeta;
import com.ctfo.upp.service.AbstractService;

@Service("loginService")
public class LoginServiceImpl extends AbstractService implements ILoginService {
	private static Log logger = LogFactory.getLog(LoginServiceImpl.class);

	public List<UAAPermission> queryPermissionList(String roleId,
			String systemId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UAARoleMeta> queryOrgRoleList(String systemSign, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public UAAUser queryUserByUserLogin(String userLogin) {
		// TODO Auto-generated method stub
		return null;
	}

	public UAASystem getSystemBySystemSign(String systemSign) {
		// TODO Auto-generated method stub
		return null;
	}

	public UAAOrg queryOrgById(String orgId) {
		// TODO Auto-generated method stub
		return null;
	}

	public UAAOrgRole queryOrgRoleById(String roleId) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isModifyPassWord(String userId) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
