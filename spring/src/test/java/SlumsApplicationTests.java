import com.slums.hands.config.MyBeanDefinitionRegistryPostProcessor;
import com.slums.hands.entity.Company;
import com.slums.hands.entity.Position;
import com.slums.hands.entity.ServiceA;
import com.slums.hands.entity.ServiceB;
import com.slums.hands.entity.User;
import com.slums.hands.service.DynamicService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.ManagedList;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;

@SpringBootTest
class SlumsApplicationTests {

    @Test
    void contextLoads() {

        BeanDefinitionBuilder positionBeanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(Position.class);
        positionBeanDefinitionBuilder.addPropertyValue("name", "经理");


        BeanDefinitionBuilder userBeanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(User.class);
        userBeanDefinitionBuilder.addPropertyValue("name", "onehands");
        userBeanDefinitionBuilder.addPropertyReference("position", "position");


        AbstractBeanDefinition userBeanDefinition = userBeanDefinitionBuilder.getBeanDefinition();
        System.out.println(userBeanDefinition);
        ManagedList<RuntimeBeanReference> managedList = new ManagedList<>();
        managedList.add(new RuntimeBeanReference("user"));

        AbstractBeanDefinition compositeObj = BeanDefinitionBuilder.genericBeanDefinition(Company.class).getBeanDefinition();
        compositeObj.getPropertyValues().add("users", managedList);


        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registerBeanDefinition("user", userBeanDefinition);
        beanFactory.registerBeanDefinition("position", positionBeanDefinitionBuilder.getBeanDefinition());
        beanFactory.registerBeanDefinition("company", compositeObj);
        User user = beanFactory.getBean(User.class);
        System.out.println(user.getName());
        System.out.println(user);

        Company company = beanFactory.getBean(Company.class);
        System.out.println(company);
    }

    @Test
    void beanLoads() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
//        factory.registerBeanDefinition("myBeanDefinitionRegistryPostProcessor", BeanDefinitionBuilder.genericBeanDefinition(MyBeanDefinitionRegistryPostProcessor.class).getBeanDefinition());

        AnnotatedBeanDefinitionReader annotatedBeanDefinitionReader = new AnnotatedBeanDefinitionReader(factory);

        annotatedBeanDefinitionReader.register(ServiceA.class);
        annotatedBeanDefinitionReader.register(ServiceB.class);
        annotatedBeanDefinitionReader.register(DynamicService.class);
        annotatedBeanDefinitionReader.register(MyBeanDefinitionRegistryPostProcessor.class);
        factory.getBeansOfType(BeanPostProcessor.class).values().forEach(factory::addBeanPostProcessor);


        //打印出注册的bean的配置信息
        for (String beanName : new String[]{"serviceA", "serviceB"}) {
            //通过名称从容器中获取对应的BeanDefinition信息
            BeanDefinition beanDefinition = factory.getBeanDefinition(beanName);
            //获取BeanDefinition具体使用的是哪个类
            String beanDefinitionClassName = beanDefinition.getClass().getName();
            //通过名称获取bean对象
            Object bean = factory.getBean(beanName);
            //打印输出
            System.out.println(beanName + ":");
            System.out.println("    beanDefinitionClassName：" + beanDefinitionClassName);
            System.out.println("    beanDefinition：" + beanDefinition);
            System.out.println("    bean：" + bean);
        }
        System.out.println(factory.getBean(DynamicService.class));

    }
}
