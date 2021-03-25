package x.godk.dp.cop;

import lombok.Getter;
import lombok.Setter;

/**
 * @author wt
 * @program practice
 * @create 2020-07-29  15:34
 */
@Setter
@Getter
public abstract class Manager {


    /**
     * 上级
     */
    private Manager superior;
    /**
     * 管理者名称
     */
    private String name;

    public Manager(String name) {
        this.name = name;
    }

    /**
     * 处理
     *
     * @param request
     */
    public abstract void execute(int request);
}
