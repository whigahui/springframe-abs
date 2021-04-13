package beans.registry;

/**
 * @author whig
 * @date 2021/4/12 20:42
 * @desc 这个是注册单例Bean的接口呗
 */
public interface SingletonBeanRegistry {

    public void registerSingleton(String beanName, Object singletonObject);

    public Object getSingleton(String beanName);

    public boolean containsSingleton(String beanName);

    public String[] getSingletonNames();

    public int getSingletonCount();
}
