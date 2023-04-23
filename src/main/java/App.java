import db.DatabaseManager;
import tests.AdminFacadeTest;
import tests.CompanyFacadeTest;
import utils.Art;

public class App {
    public static void main(String[] args) {
        System.out.println(Art.LOGO);
        System.out.println("-----------------------------------------------------");
        DatabaseManager.startDatabase();

        AdminFacadeTest adminFacadeTest = new AdminFacadeTest();
        adminFacadeTest.testAsAdmin();

        CompanyFacadeTest companyFacadeTest = new CompanyFacadeTest();
        companyFacadeTest.testAsCompany();

        DatabaseManager.endDatabase();
        System.out.println(Art.END);
    }
}
