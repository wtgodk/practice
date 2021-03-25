package x.godk.dp.subject;

import java.util.Objects;

/**
 * @author wt
 * @program practice
 * @create 2020-06-10  10:10
 */
public class MrZhang implements Observer {

    /**
     * 委托者 名字 唯一
     */
    private String name = "张三 ";

    @Override
    public void doEvent(Subject subject, String msg) {
        System.out.println(name + "收到消息 ,发送者：" + subject.getName() + " 消息内容:" + msg);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MrZhang)) {
            return false;
        }
        MrZhang mrZhang = (MrZhang) o;
        return Objects.equals(name, mrZhang.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
