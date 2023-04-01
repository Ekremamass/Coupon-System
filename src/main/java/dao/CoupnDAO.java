package dao;

import beans.Coupon;

public interface CoupnDAO extends DAO<Coupon,Integer> {
    void addCouponPurchase(int customerID,int couponID);
    void deleteCouponPurchase(int customerID,int couponID);
}
