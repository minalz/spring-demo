package cn.minalz.factory;

import cn.minalz.mapper.UserMapper;
import cn.minalz.model.User;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author minalz
 * @since 2022/11/09 00:40:39
 */
public class MinalzFactoryBean implements FactoryBean {

    public Object getObject() throws Exception {
//        User user = new User();
//        return user;
        Object instance = Proxy.newProxyInstance(MinalzFactoryBean.class.getClassLoader(), new Class[]{UserMapper.class}, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        });
        return instance;
    }

    public Class<?> getObjectType() {
        return UserMapper.class;
    }
}
