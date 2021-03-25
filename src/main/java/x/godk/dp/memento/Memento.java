package x.godk.dp.memento;

import lombok.Data;

/**
 * 备忘录 模式
 * <p>
 * 备忘内容数据存放 类
 *
 * @author wt
 * @program practice
 * @create 2020-06-11  13:54
 */
@Data
public class Memento {

    /**
     * 备忘内容
     */
    private String state;

    /**
     * 构造 传入 备忘信息
     *
     * @param state
     */
    public Memento(String state) {
        this.state = state;
    }


}
