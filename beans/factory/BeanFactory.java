package beans.factory;


/**
 * @author whig
 * @date 2021/4/8 15:19
 * @desc BeanFactory根据下边的方法就是典型的工厂模式被  但是只有获取getBean 没有创建
 */
public interface BeanFactory {

    /**
     * 根据名称从容器中获取bean
     * @param name bean的名字
     * @return bean实例对象
     */
    public Object getBean(String name) throws Exception;

    <T> T getBean(String name, Class<T> clazz) throws Exception;

    boolean containsBean(String name); // 是否存在

    boolean isSingleton(String name) throws Exception;  //否为单实例

    boolean isPrototype(String name) throws Exception;// 是否为原型（多实例）
}
