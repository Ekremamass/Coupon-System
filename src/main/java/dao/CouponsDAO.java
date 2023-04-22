package dao;

import beans.Coupon;

public interface CouponsDAO extends DAO<Coupon, Integer> {
    void addCouponPurchase(int customerID, int couponID);

    void deleteCouponPurchase(int customerID, int couponID);
}
