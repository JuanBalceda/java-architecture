package com.balceda.archj.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public abstract class Action {

	public abstract String execute(HttpServletRequest request, HttpServletResponse response);

	public static Action getAction(String type) {
		Action action = null;

		try {
			action = (Action) Class.forName(getPackage() + "." + type + "Action").newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return action;
	};

	private static String getPackage() {

		return Action.class.getPackage().getName();
	}

	public Object getBean(String bean, HttpServletRequest request) {
		WebApplicationContext factory = WebApplicationContextUtils
				.getRequiredWebApplicationContext(request.getSession().getServletContext());
		return factory.getBean(bean);
	}
}
