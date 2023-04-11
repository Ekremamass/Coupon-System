import db.DatabaseManager;
import utils.Art;

public class App {
    public static void main(String[] args) {
        System.out.println(Art.LOGO);
        System.out.println("-----------------------------------------------------");
        DatabaseManager.startDatabase();
        DatabaseManager.endDatabase();
        System.out.println(Art.END);
    }
}
