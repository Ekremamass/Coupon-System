package tests;


import beans.Category;
import beans.Coupon;
import exceptions.CouponSystemException;
import facade.CompanyFacadeImpl;

import java.sql.Date;
import java.time.LocalDate;

public class CompanyFacadeTest {
    private static CompanyFacadeImpl companyFacade = new CompanyFacadeImpl();

    public void testAsCompany() {
        Test.test("Company Facade - good login");
        companyFacade.login("KSP@KSP.com", "1234");

        Test.test("Company Facade - good add coupon");
        Coupon coupon = Coupon.builder()
                .title("20% off Logitech products")
                .image("https://shorturl.at/epxRT")
                .price(500)
                .category(Category.ELECTRICITY)
                .companyID(1)
                .description("get 20% off any Logitech product")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
                .amount(100)
                .build();
        try {
            companyFacade.addCoupon(coupon);
        } catch (CouponSystemException e) {
            System.out.println(e.getMessage());
        }

        Test.test("Company Facade - bad add coupon - same title");
        try {
            companyFacade.addCoupon(coupon);
        } catch (CouponSystemException e) {
            System.out.println(e.getMessage());
        }

        Test.test("Company Facade - bad update coupon - changed id");
        coupon.setId(2);
        try {
            companyFacade.updateCoupon(4, coupon);
        } catch (CouponSystemException e) {
            System.out.println(e.getMessage());
        }

        Test.test("Company Facade - bad update coupon - changed company id");
        coupon.setId(4);
        coupon.setCompanyID(2);
        try {
            companyFacade.updateCoupon(4, coupon);
        } catch (CouponSystemException e) {
            System.out.println(e.getMessage());
        }

        Test.test("Company Facade - good update coupon");
        coupon.setCompanyID(1);
        coupon.setAmount(50);
        coupon.setTitle("30% OFF Everything!!!");
        coupon.setDescription("price 30% off all products");
        try {
            companyFacade.updateCoupon(4, coupon);
        } catch (CouponSystemException e) {
            System.out.println(e.getMessage());
        }

        Test.test("Company Facade - show all company coupons");
        companyFacade.getCompanyCoupons().forEach(System.out::println);

        Test.test("Company Facade - show all company coupons - electricity");
        companyFacade.getCompanyCoupons(Category.ELECTRICITY).forEach(System.out::println);

        Test.test("Company Facade - show all company coupons - max price 500");
        companyFacade.getCompanyCoupons(500.0).forEach(System.out::println);

        Test.test("Company Facade - delete coupon id=4");
        companyFacade.deleteCoupon(4);

        Test.test("Company Facade - show all company coupons");
        companyFacade.getCompanyCoupons().forEach(System.out::println);

        Test.test("Company Facade - get company details");
        System.out.println(companyFacade.getCompanyDetails());


    }
}
