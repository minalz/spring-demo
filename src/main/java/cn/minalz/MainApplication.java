package cn.minalz;

import cn.minalz.factory.MinalzFactoryBean;
import cn.minalz.model.User;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author minalz
 * @since 2022/11/09 00:31:17
 */
public class MainApplication {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(MainApplication.class);

        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
//        beanDefinition.setBeanClass(User.class);
        beanDefinition.setBeanClass(MinalzFactoryBean.class);
        applicationContext.registerBeanDefinition("xxx", beanDefinition);

        applicationContext.refresh();
        System.out.println(applicationContext.getBean("xxx"));
        System.out.println(applicationContext.getBean("&xxx"));
        // 为什么@autowired中 userMapper 也可以拿到值 是因为先byType 再byName 只有一个类型的一个Bean 只根据type获取就可以了
        // 如果是两个bean 就会报错了

    }
}
