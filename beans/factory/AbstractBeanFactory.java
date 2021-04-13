package beans.factory;

import beans.definition.BeanDefinition;
import beans.registry.DefaultSingletonBeanRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author whig
 * @date 2021/4/9 9:01
 * @desc AbstractBeanFactory                实现了依赖关系处理
 *       AbstractAutowireCapableBeanFactory 继承BeanFactory
 *       DefaultListableBeanFactory         继承AbstractAutowireCapableBeanFactory
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    //key -- value 形式呗 在这里啊
    ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    private final List<String> beanDefinitionNames = new ArrayList<String>();                        //bean信息的所有名字放在一个List当中

//    private List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();    //Bean初始化 前置和后置处理器


    //---------------------------------------------------------------------
    // Implementation of BeanFactory interface
    //---------------------------------------------------------------------

    //getBean两种方式 我们用ConcurrentHashMap来做被  我们还需要通过Bean信息  BeanDefinition类中有函数返回Bean Object对象被
    public Object getBean(String name) throws Exception {
        return doGetBean(name, null);
    }

    public <T> T getBean(String name, Class<T> clazz) throws Exception {
        return doGetBean(name, clazz);
    }

    /**
     * protected表示在子类 继承者可以使用呗
     *
     * @param name  bean名字
     * @param clazz 类名.class
     * @param <T>   返回类型class
     *
     */
    protected <T> T doGetBean(String name, Class<T> clazz) {
        //  String beanName = transformedBeanName(name);              1.先检查name是否规范么？
        Object beanInstance;

        Object sharedInstance = getSingleton(name);                 //2. 先检查是否注册过 或者存在过
        if (sharedInstance != null) {
            if (logger.isTraceEnabled()) {
                if (isSingletonCurrentlyInCreation(beanName)) {
                    logger.trace("Returning eagerly cached instance of singleton bean '" + beanName +
                            "' that is not fully initialized yet - a consequence of a circular reference");
                }
                else {
                    logger.trace("Returning cached instance of singleton bean '" + beanName + "'");
                }
            }
            beanInstance = getObjectForBeanInstance(sharedInstance, name, beanName, null);
        }
        return null;
    }


    //判断是否是包含Bean
    public boolean containsBean(String name) {
        return beanDefinitionMap.contains(name);
    }

    //判断是否是单例
    public boolean isSingleton(String name) throws Exception {
        if (beanDefinitionMap.contains(name)) {
            BeanDefinition bean = beanDefinitionMap.get(name);
            return bean.isSingleton();
        }
        throw new RuntimeException("没有相关的name实例");
    }

    //判断是否是多例呗
    public boolean isPrototype(String name) throws Exception {
        if (beanDefinitionMap.contains(name)) {
            BeanDefinition bean = beanDefinitionMap.get(name);
            return !bean.isSingleton();
        }
        throw new RuntimeException("没有相关的name实例");
    }


}
