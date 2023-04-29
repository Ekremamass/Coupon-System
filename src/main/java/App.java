import db.DatabaseManager;
import jobs.CouponExpirationDailyJob;
import tests.AdminFacadeTest;
import tests.CompanyFacadeTest;
import tests.CustomerFacadeTest;
import utils.Art;

public class App {
    public static void main(String[] args) {
        System.out.println(Art.LOGO);
        System.out.println("-----------------------------------------------------");
        DatabaseManager.startDatabase();

        CouponExpirationDailyJob couponExpirationDailyJob = new CouponExpirationDailyJob();
        Thread thread = new Thread(couponExpirationDailyJob);
        thread.setDaemon(true);
        thread.start();

        AdminFacadeTest adminFacadeTest = new AdminFacadeTest();
        adminFacadeTest.testAsAdmin();

        CompanyFacadeTest companyFacadeTest = new CompanyFacadeTest();
        companyFacadeTest.testAsCompany();

        CustomerFacadeTest customerFacadeTest = new CustomerFacadeTest();
        customerFacadeTest.testAsCustomer();

        DatabaseManager.endDatabase();
        couponExpirationDailyJob.stop();
        System.out.println(Art.END);
    }
}
