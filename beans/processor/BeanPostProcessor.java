package beans.processor;


/**
 * @author whig
 * @date 2021/4/8 15:47
 * @desc 如果用户还想在 bean 的初始化前后做一些操作呢？比如生成代理对象，修改对象属性等，Spring 为我们提供了 BeanPostProcessor 后置处理器
 */
public interface BeanPostProcessor {


    //初始化Bean之前进行操作呗
    default Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception {
        return bean;
    }

    //初始化Bean之后 在进行操作呗
    default Object postProcessAfterInitialization(Object bean, String beanName) throws Exception {
        return bean;
    }

    //---------------------以前案例
//    public class MyBeanPostProcessor implements BeanPostProcessor {
//        /**
//         * 一个初始化前操作 一个初始化后操作 差不多其实  bean是传过来的bean beanName是bean的ID
//         */
//        @Override
//        public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//            return null;
//        }
//
//        /**
//         * 这个方法有bug 这里如果是xml配置文件单独配置这个还行 否则就会报错  假如出入其他类型的 cast转换就失败了  用if判断一下
//         */
//        @Override
//        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//
//            //这个beanName怎么使用有待研究
//
//            if(bean instanceof Processor ){
//                Processor processor=(Processor)bean;
//                processor.setName("阿辉");
//            }
//            return bean;
//
//        }
//    }
}
