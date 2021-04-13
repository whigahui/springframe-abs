package beans.definition;

/**
 * @author whig
 * @date 2021/4/8 16:39
 * @desc PropertyValue 在这里就是单个键值对属性赋值呗  表示注入对象的属性
 */
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    //如果是final类型的 我们要不直接就是赋 初始值  要么在构造器里边赋值呗  而且不能再利用set函数来赋值了呗 在这里哈呢
//    private void setName(String name) {
//        this.name = name;
//    }

    private String getName() {
        return name;
    }

    private Object getValue() {
        return value;
    }
}
