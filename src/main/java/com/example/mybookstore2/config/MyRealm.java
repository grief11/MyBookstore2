package com.example.mybookstore2.config;




import com.example.mybookstore2.entity.User;
import com.example.mybookstore2.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.HashSet;

public class MyRealm extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(MyRealm.class);

    @Autowired
    UserService userService;
//注入组件

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        logger.info("------------------------------->执行了授权");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获取当前登录的对象
        User user = (User)principals.getPrimaryPrincipal();
        //拿到登录对象的权限，用-分离出每一个权限,放入数组
        String[] perm = user.getPerm().split("-");
        //将整个perm数组转成集合放入HashSet中
        HashSet<String> set = new HashSet<>(Arrays.asList(perm));

        info.setStringPermissions(set);
        //添加权限
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        logger.info("------------------------------->执行了认证");
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        String username = userToken.getUsername();
        //验证用户名是否在数据库中存在
        User user = userService.queryByName(username);
        if (user == null) {
            return null;
        }
        return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
    }
}
