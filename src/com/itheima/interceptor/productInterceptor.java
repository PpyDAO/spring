package com.itheima.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.itheima.domain.Result;
import com.itheima.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

public class productInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
        if (user == null) {
            Result result = new Result();
            result.setType("0");
            result.setMessage("权限不够");
            ActionContext.getContext().getValueStack().push(result);

            return "success";
        } else {
            return actionInvocation.invoke();
        }
    }
}
