package x.godk.dp.state;

/**
 * 状态 接口
 *
 * @author wt
 * @program practice
 * @create 2020-06-11  11:33
 */
public interface State {

    /**
     * 设置 上下文的 下一个状态
     *
     * @return
     */
    void contextState(Context context);
}
