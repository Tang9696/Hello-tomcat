package by.bsu.helltom.command;

public class CommandFactory extends ProductListCommand {

    public Command create(String command){
        switch (command){
            case "login":
                return new LoginCommand();
            case "proList":
                return (Command) new ProductListCommand();
            case "userList":
                return (Command) new UserListCommand();
            case "orderlist":
                return (Command) new OrderListCommand();
            case "cateList":
                return (Command) new CateListCommand();
            case "addproindex":
                return (Command) new AddProIndexCommand();
            case "upproindex":
                return (Command) new UpProIndexCommand();
            case "addcateindex":
                return (Command) new AddCateIndexCommand();
            case "upcateindex":
                return (Command) new UpCateIndexCommand();
            case "addpro":
                return (Command) new AddProCommand();
            case "addcart":
                return (Command) new AddCartCommand();
            case "addorder":
                return (Command) new AddOrderCommand();
            case "uppro":
                return (Command) new UpProCommand();
            case "upcate":
                return (Command) new UpCateCommand();
            case "addcate":
                return (Command) new AddCateCommand();
            case "delpro":
                return (Command) new DelProCommand();
            case "logout":
                return (Command) new LogoutCommand();
            case "MPge":
                return (Command) new MpageCommand();
            //User
            case "mycartList":
                return (Command) new MycartListCommand();
            case "myorderList":
                return (Command) new MyorderListCommand();
            case "myinfoList":
                return (Command) new MyinfoListCommand();
            case "upinfoindex":
                return (Command) new UpinfoIndexCommand();
            case "upmyinfo":
                return (Command) new UpinfoCommand();
            case "shoppingpage":
                return (Command) new ShoppingListCommand();
            default:
                throw new UnsupportedOperationException();

        }
    }
}
