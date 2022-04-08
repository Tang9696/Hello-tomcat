package by.bsu.helltom.command;

public class CommandFactory extends ProductListCommand {

    public Command create(String command){
        switch (command){
            case "login":
                return new LoginCommand();
            case "proList":
                return (Command) new ProductListCommand();
            case "addproindex":
                return (Command) new AddProIndexCommand();
            case "addpro":
                return (Command) new AddProCommand();
            default:
                throw new UnsupportedOperationException();

        }
    }
}
