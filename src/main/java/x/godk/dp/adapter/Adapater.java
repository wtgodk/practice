package x.godk.dp.adapter;

/**
 * @author wt
 * @program practice
 * @create 2020-06-11  13:35
 */
public class Adapater implements Target {


    private Adaptee adaptee;

    public Adapater(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.get();
    }
}
