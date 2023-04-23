package tests;

import beans.Company;
import beans.Customer;
import exceptions.CouponSystemException;
import facade.AdminFacadeImpl;

public class AdminFacadeTest {
    private static AdminFacadeImpl adminFacade = new AdminFacadeImpl();

    public void testAsAdmin() {
        Test.test("Admin Facade - bad login - wrong email");
        System.out.println(adminFacade.login("stam@stam.com", "admin"));
        Test.test("Admin Facade - bad login - wrong password");
        System.out.println(adminFacade.login("admin@admin.com", "stam"));
        Test.test("Admin Facade - bad login - wrong email and password");
        System.out.println(adminFacade.login("stam@stam.com", "stam"));
        Test.test("Admin Facade - good login");
        System.out.println(adminFacade.login("admin@admin.com", "admin"));


        Test.test("Admin Facade - bad add company - same name");
        Company c1 = Company.builder()
                .name("KSP")
                .email("stam@stam.com")
                .password("1234")
                .build();
        try {
            adminFacade.addCompany(c1);
        } catch (CouponSystemException e) {
            System.out.println(e.getMessage());
        }

        Test.test("Admin Facade - bad add company - same id");
        c1.setName("KFC");
        c1.setId(1);
        try {
            adminFacade.addCompany(c1);
        } catch (CouponSystemException e) {
            System.out.println(e.getMessage());
        }

        Test.test("Admin Facade - bad add company - same email");
        c1.setName("stam");
        c1.setId(0);
        c1.setEmail("KSP@KSP.com");
        try {
            adminFacade.addCompany(c1);
        } catch (CouponSystemException e) {
            System.out.println(e.getMessage());
        }

        Test.test("Admin Facade - good add company");
        Company c2 = Company.builder()
                .name("EFC")
                .email("efc@efc.com")
                .password("1234")
                .build();
        try {
            adminFacade.addCompany(c2);
        } catch (CouponSystemException e) {
            System.out.println(e.getMessage());
        }

        Test.test("Admin Facade - bad update company - changed id");
        c2.setId(2);
        try {
            adminFacade.updateCompany(11, c2);
        } catch (CouponSystemException e) {
            System.out.println(e.getMessage());
        }

        Test.test("Admin Facade - bad update company - changed name");
        c2.setId(11);
        c2.setName("EEE");
        try {
            adminFacade.updateCompany(11, c2);
        } catch (CouponSystemException e) {
            System.out.println(e.getMessage());
        }

        Test.test("Admin Facade - good update company - changed name");
        c2.setName("EFC");
        c2.setEmail("info@efc.com");
        try {
            adminFacade.updateCompany(11, c2);
        } catch (CouponSystemException e) {
            System.out.println(e.getMessage());
        }

        Test.test("Admin Facade - get one company id=11");
        System.out.println(adminFacade.getOneCompany(11).get());

        Test.test("Admin Facade - delete company id=11");
        adminFacade.deleteCompany(11);

        Test.test("Admin Facade - get all companies");
        adminFacade.getAllCompanies().forEach(System.out::println);

        Test.test("Admin Facade - bad add customer - same email");
        Customer customer1 = Customer.builder()
                .firstName("stam")
                .lastName("stam")
                .email("johndoe@email.com")
                .password("1234")
                .build();
        try {
            adminFacade.addCustomer(customer1);
        } catch (CouponSystemException e) {
            System.out.println(e.getMessage());
        }

        Test.test("Admin Facade - bad add customer - same id");
        customer1.setEmail("stam@stam.com");
        customer1.setId(1);
        try {
            adminFacade.addCustomer(customer1);
        } catch (CouponSystemException e) {
            System.out.println(e.getMessage());
        }

        Test.test("Admin Facade - good add customer");
        Customer customer2 = Customer.builder()
                .firstName("Ahmad")
                .lastName("Jbara")
                .email("ahmadjbara@email.com")
                .password("1234")
                .build();
        try {
            adminFacade.addCustomer(customer2);
        } catch (CouponSystemException e) {
            System.out.println(e.getMessage());
        }

        Test.test("Admin Facade - bad update customer - changed id");
        customer2.setId(2);
        try {
            adminFacade.updateCustomer(1, customer2);
        } catch (CouponSystemException e) {
            System.out.println(e.getMessage());
        }

        Test.test("Admin Facade - good update customer");
        customer2.setId(11);
        customer2.setFirstName("Jaber");
        try {
            adminFacade.updateCustomer(11, customer2);
        } catch (CouponSystemException e) {
            System.out.println(e.getMessage());
        }

        Test.test("Admin Facade - get one customer - id=11");
        System.out.println(adminFacade.getOneCustomer(11).get());

        Test.test("Admin Facade - delete customer - id=11");
        adminFacade.deleteCustomer(11);


        Test.test("Admin Facade - get all customers");
        adminFacade.getAllCustomers().forEach(System.out::println);

    }
}
