package x.godk.dp.command;

import lombok.Getter;
import lombok.Setter;

/**
 * 命令模式
 *
 * @author wt
 * @program practice
 * @create 2020-07-29  13:49
 */
@Setter
@Getter
public abstract class Command {

    /**
     * 命令接受者
     */
    private Receiver receiver;

    public Command(Receiver receiver) {
        this.receiver = receiver;
    }

    /**
     * 执行命令
     */
    public abstract void execute();
}
