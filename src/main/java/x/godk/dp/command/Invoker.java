package x.godk.dp.command;

/**
 * 命令执行者
 *
 * @author wt
 * @program practice
 * @create 2020-07-29  13:54
 */
public class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }
}
