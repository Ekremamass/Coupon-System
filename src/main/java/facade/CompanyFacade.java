package facade;

import beans.Category;
import beans.Company;
import beans.Coupon;

import java.util.List;

public interface CompanyFacade {
    void addCoupon(Coupon coupon);

    void updateCoupon(int id, Coupon coupon);

    void deleteCoupon(int id);

    List<Coupon> getCompanyCoupons();

    List<Coupon> getCompanyCoupons(Category category);

    List<Coupon> getCompanyCoupons(double maxPrice);

    Company getCompanyDetails();
}
