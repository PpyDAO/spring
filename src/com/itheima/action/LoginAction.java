package com.itheima.action;

import com.itheima.domain.User;
import com.itheima.service.IUserService;
import com.itheima.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.sql.SQLException;

@Namespace("/")
@ParentPackage("struts-default")
public class LoginAction extends ActionSupport implements ModelDriven<User> {
    private User user = new User();

    @Override
    public User getModel() {
        return user;
    }

    @Action(value = "user_login", results = {@Result(name = "success", location = "/product.jsp"), @Result(name = "fail", location = "/index.jsp")})
    public String login(){
        IUserService userService = new UserServiceImpl();

        User user1 = null;
        try {

            DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class).add(Restrictions.and(Restrictions.eq("username", user.getUsername()), Restrictions.eq("password", user.getPassword())));

            user1 = userService.login(detachedCriteria);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (user1 == null) {
            //用户名或密码错误
            addActionError("用户名或密码错误");
            return "fail";
        } else {
            //登陆成功,将user1存入session
            ServletActionContext.getRequest().getSession().setAttribute("user", user1);
            return "success";
        }
    }
}
