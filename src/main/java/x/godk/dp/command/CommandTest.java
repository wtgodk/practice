package x.godk.dp.command;

/**
 * 命令模式 测试
 * <p>
 * 命令模式命令执行者 和 命令发出者 无直接联系
 *
 * @author wt
 * @program practice
 * @create 2020-07-29  13:55
 */
public class CommandTest {

    public static void main(String[] args) {

        Receiver receiver = new Receiver();

        Command command = new CreateCommand(receiver);

        Invoker invoker = new Invoker(command);

        invoker.executeCommand();
    }
}
