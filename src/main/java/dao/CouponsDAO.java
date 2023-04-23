package dao;

import beans.Category;
import beans.Coupon;

import java.util.List;

public interface CouponsDAO extends DAO<Coupon, Integer> {

    void deleteCouponByCompany(int companyId);

    void addCouponPurchase(int customerID, int couponID);

    void deleteCouponPurchase(int customerID, int couponID);

    boolean isExistsByTitle(int companyId, String title);

    List<Coupon> getCompanyCoupons(int companyId);

    List<Coupon> getCompanyCoupons(int companyId, Category category);

    List<Coupon> getCompanyCoupons(int companyId, double maxPrice);
}
