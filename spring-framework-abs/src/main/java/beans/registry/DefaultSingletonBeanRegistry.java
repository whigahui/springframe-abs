package beans.registry;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author whig
 * @date 2021/4/9 20:03
 * @desc BeanFactory只是获取Bean 而真正创建Bean的是DefaultSingletonBeanRegistry 这个相关类呗
 * 原来，DefaultSingletonBeanRegistry搞了一个Set<String> singletonsCurrentlyInCreation，专门来存放正在创建的单例bean的名字
 * （注意，只是名字而不是bean，因为bean还在创建中）。
 * DefaultSingletonBeanRegistry没有getBean()方法，因为它压根就没实现BeanFactory！！
 * 它实现的是SingletonBeanRegistry，专门管理单例bean的。
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    /**
     * 我们本来打算看看Spring的两大顶级接口ApplicationContext和BeanFactory，
     * 结果看BeanFactory时，发现它根本不是一个具体的工厂，不提供容器（没有可以存bean的成员变量），只规定了getBean()方法。
     * 于是，我们翻了翻，在Spring源码的某个角落发现了DefaultSingletonBeanRegistry，它是一个类，还设计了几个Map作为成员变量专门存放单例bean，
     * 也就是我们常说的“单例池”。但是，当我们研究DefaultSingletonBeanRegistry是如何存取东西时，发现它并没有实现BeanFactory！
     * ---------------
     * 我们已经基本确定单例bean就是存在DefaultSingletonBeanRegistry中，但是它却没有实现BeanFactory，没有提供getBean()。
     * 那么AnnotationConfigApplicationContext#getBean()最终通向何处？
     */
    /**
     * Cache of singleton objects: bean name to bean instance.          一级缓存 存放真正的单例Bean
     */
    private final Map<String, Object> singletonObjects = new ConcurrentHashMap<>(256);


    /**
     * Cache of early singleton objects: bean name to bean instance.    二级缓存 发生循环依赖时， 作为早期引用
     */
    private final Map<String, Object> earlySingletonObjects = new ConcurrentHashMap<>(16);


    /**
     * Cache of singleton factories: bean name to ObjectFactory.        三级缓存用于解决循环依赖呗
     */
    private final Map<String, ObjectFactory<?>> singletonFactories = new HashMap<>(16);


    /**
     * Set of registered singletons, containing the bean names in registration order.
     */
    private final Set<String> registeredSingletons = new LinkedHashSet<>(256);

    /**
     * Names of beans that are currently in creation.                     保存正在创建的Bean name 防止重复创建呗
     */
    private final Set<String> singletonsCurrentlyInCreation =
            Collections.newSetFromMap(new ConcurrentHashMap<>(16));



    protected void addSingleton(String beanName, Object singletonObject) {
        synchronized (this.singletonObjects) {
            this.singletonObjects.put(beanName, singletonObject);
            this.singletonFactories.remove(beanName);
            this.earlySingletonObjects.remove(beanName);
            this.registeredSingletons.add(beanName);
        }
    }
    @Override
    public void registerSingleton(String beanName, Object singletonObject) {

    }

    //这个就是在AbstractBeanFactory 自类调用了夫类方法呗 在这里哈呢
    public Object getSingleton(String beanName) {
        return null;
    }

    @Override
    public boolean containsSingleton(String beanName) {
        return false;
    }

    @Override
    public String[] getSingletonNames() {
        return new String[0];
    }

    @Override
    public int getSingletonCount() {
        return 0;
    }

}
