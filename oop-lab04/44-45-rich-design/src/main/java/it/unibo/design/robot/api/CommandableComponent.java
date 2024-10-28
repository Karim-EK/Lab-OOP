package it.unibo.design.robot.api;

public interface CommandableComponent extends Component {
    public String[] availableCommands();

    public void sendCommand(String command);
}
