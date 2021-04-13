package beans.definition;

import java.util.ArrayList;
import java.util.List;

/**
 * @author whig
 * @date 2021/4/8 16:31
 * @desc 这个应该就是PropertyValues 是一个对象的多个属性 PropertyValue的集合呗
 */
public class PropertyValues {

    //这个就是单个对象所有属性就是封装成一个list呗 在这里哈呢  并且是final引用类型 地址空间就是不能再改变了
    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public PropertyValues() {
    }  //这里边就是定义一个无参构造呗

    /**
     * 添加操作
     * @param propertyValue 添加新的属性值呗
     */
    public void addPropertyValue(PropertyValue propertyValue) {
        propertyValueList.add(propertyValue);
    }



    /**
     * @return 获取返回列表集合呗
     */
    public List<PropertyValue> getPropertyValueList() {
        return propertyValueList;
    }

}
