package x.godk.dp.proxy;

/**
 * 代理模式： 为其他对象提供一个代理以控制对 这个对象的访问
 *
 * @author wt
 * @program practice
 * @create 2020-06-04  13:33
 */
public class Proxy implements Subject {


    private RealSubject realSubject;

    /**
     * 构造方法 偷梁换柱 更换为 realSubject
     */
    public Proxy() {
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
    }

    @Override
    public void print() {
        //方法实际调用为
        realSubject.print();
    }
}
