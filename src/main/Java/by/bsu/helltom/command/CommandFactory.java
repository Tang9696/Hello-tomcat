package by.bsu.helltom.command;

public class CommandFactory extends BookListCommand{

    public Command create(String command){
        switch (command){
            case "login":
                return new LoginCommand();
            case "bookList":
                return (Command) new BookListCommand();
            case "addproindex":
                return (Command) new AddProIndexCommand();
            case "addpro":
                return (Command) new AddProCommand();
            default:
                throw new UnsupportedOperationException();

        }
    }
}
