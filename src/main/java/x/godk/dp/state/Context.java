package x.godk.dp.state;

import lombok.Data;

/**
 * context 上下文，用来处理状态
 *
 * @author wt
 * @program practice
 * @create 2020-06-11  11:32
 */
@Data
public class Context {


    private State state;

    public Context(State state) {
        this.state = state;
    }

    public void request() {
        state.contextState(this);
    }


}
