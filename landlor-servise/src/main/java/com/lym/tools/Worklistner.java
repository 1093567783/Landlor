package com.lym.tools;

import javax.servlet.http.HttpServletRequest;

import com.lym.dubbo.DubboUser;
import com.lym.manager.process.ActivityManager;
import com.lym.manager.user.UserManager;
import com.lym.model.user.vo.UserVO;

import com.lym.service.user.UserService;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;

@Component
public class Worklistner implements TaskListener{

	@Override
	public void notify(DelegateTask delegateTask) {

		UserManager userManager = SpringUtil.getObject(UserManager.class);
		ActivityManager activityManager  = SpringUtil.getObject(ActivityManager.class);
		UserVO user = activityManager.getUser();
		UserVO manager = userManager.getUserById(user.getManagerId());
		delegateTask.setAssignee(manager.getRealName());
	}

}
