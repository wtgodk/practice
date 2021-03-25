package x.godk.dp.subject;

import lombok.Data;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author wt
 * @program practice
 * @create 2020-06-10  09:58
 */
@Data
public class Event {

    /**
     * 要执行的方法对象
     */
    private Object object;
    /**
     * 方法名
     */
    private String methodName;
    /**
     * 方法 参数
     */
    private Object[] params;

    /**
     * 方法参数 类型  对应 params
     */
    private Class[] paramTypes;

    public Event(Object object, String methodName, Object... params) {
        this.object = object;
        this.methodName = methodName;
        this.params = params;
        this.createParamTypes(params);
    }

    /**
     * 根据方法参数数组  获取对应参数类型
     *
     * @param params
     */
    private void createParamTypes(Object[] params) {
        if (params != null) {
            paramTypes = new Class[params.length];
            for (int i = 0; i < params.length; i++) {
                paramTypes[i] = params[i].getClass();
            }
        }
    }

    /**
     * 反射执行 事件的方法
     *
     * @return
     */
    public Object invoke() {
        try {
            Method method = object.getClass().getMethod(methodName, paramTypes);
            if (method == null) {
                throw new RuntimeException("method not exist, " + object.getClass() + "@method:" + methodName);
            }
            return method.invoke(getObject(), params);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

}
