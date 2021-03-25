package x.godk.dp.command;

/**
 * @author wt
 * @program practice
 * @create 2020-07-29  13:52
 */
public class CreateCommand extends Command {


    public CreateCommand(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        getReceiver().invoker();
    }
}
