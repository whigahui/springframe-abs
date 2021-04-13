package beans.processor;


import beans.factory.DefaultListableBeanFactory;

/**
 * @author whig
 * @date 2021/4/9 10:24
 * @desc 假设容器中包含了 a 和 b，那么就动态向容器中注入 c，不满足就注入 d，这种骚操作 Spring 也是支持的，
 *       得益于它提供的 BeanFactoryPostProcessor 后置处理器，在AbstractApplicationContext中refresh方法中呗 invokeBeanFactoryPostProcessors 操作。
 */
public interface BeanFactoryPostProcessor {

    //这个就是代表工厂内部初始化之后  所有的Bean定义将会呗加载，  但是bean还没有被初始化完成  允许添加属性在bean早期初始化被
    /**
     * Modify the application context's internal bean factory after its standard
     * initialization. All bean definitions will have been loaded, but no beans
     * will have been instantiated yet. This allows for overriding or adding
     * properties even to eager-initializing beans.
     * @param beanFactory the bean factory used by the application context
     */
    void postProcessBeanFactory(DefaultListableBeanFactory beanFactory) throws Exception;
}
