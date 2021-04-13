package beans.definition;

/**
 * @author whig
 * @date 2021/4/8 16:08
 * @desc 重配置文件中读取一些Bean信息定义呗  1. bean名字 2.bean类名 3.是否是单例模式 4. bean的属性呗
 * 源码当中 BeanDefinition中是一个接口 定义了一些信息 并由抽象类AbstractBeanDefinition来实现接口
 */
public class BeanDefinition {

    private Object bean;                    //实例化后的对象

    private Class beanClass;                //获取到beanClass 这是属于什么类型么 在这里啊呢

    private String beanClassName;           //bean类名

    private Boolean singleton;              //是否是单例模式

    //PropertyValues 实际上是一个 List，表示一组属性的定义，内部存储的对象是 PropertyValue 对象，表示一个属性定义和其对应的注入属性：
    private PropertyValues propertyValues;  //存放所有相关的bean属性呗 在这里哈呢

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
        try {
            //Class<?> clazz = Class.forName("java.lang.String");  //Java虚拟机载入一个类的时候，它就会自动创建一个Class类的实例来表示这个类 为反射创造条件呗 在这里
            Class<?> clazz = Class.forName(beanClassName);         //这里边就是bean类路径名呗 例如就是java.lang.String 返回class时运行时Class对象 java.lang.String呗
            this.beanClass = clazz;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setSingleton(boolean singleton) {
        this.singleton = singleton;
    }

    public Boolean isSingleton() {
        return singleton;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    public PropertyValues getPropertyValues() {
        //这里边就是先进行一下判断呗 在这里哈呢
        if (propertyValues == null)
            propertyValues = new PropertyValues();      //如果是空的 我们创建一个新的 并在这里返回呗 对吧哈呢
        return propertyValues;
    }
}
