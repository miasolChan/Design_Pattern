package command;

import java.util.LinkedList;

public class RemoteControlWithMultiUndo {

    Command[] onCommands;
    Command[] offCommands;

    static int NUM_UNDO_COMMANDS = 4;//撤销次数上限

    LinkedList<Command> undoCommands;

    public RemoteControlWithMultiUndo() {
        offCommands = new Command[7];
        onCommands = new Command[7];
        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++)
        {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommands = new LinkedList<Command>();
    }

    public void setCommand(int slot,Command onCommand,Command offCommand){
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPressed(int slot) {
        recordCommand(onCommands[slot]);
    }

    public void offButtonWasPressed(int slot) {
        recordCommand(offCommands[slot]);
    }

    public void undoButtonWasPressed() {
        retrieveCommand().undo();
    }

    private Command retrieveCommand(){
        if (undoCommands.isEmpty()){
            System.out.println("无可撤销命令");
            return new NoCommand();
        }else {
            return undoCommands.removeLast();
        }
    }

    private void recordCommand(Command command){
        command.execute();
        if (undoCommands.size()>=NUM_UNDO_COMMANDS){//满则移除首部
            undoCommands.removeFirst();
        }
        undoCommands.add(command);

    }
}
