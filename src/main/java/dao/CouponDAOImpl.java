package dao;

import beans.Coupon;
import db.DBUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CouponDAOImpl implements CoupnDAO {

    private static final String INSERT_COUPON = "INSERT INTO `coupon_system`.`coupons` (`company_id`, `category_id`, `title`, `description`, `start_date`, `end_date`, `amount`, `price`, `image`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    @Override
    public void add(Coupon coupon) {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, coupon.getCompanyID());
        params.put(2, coupon.getCategory().DBValue());
        params.put(3, coupon.getTitle());
        params.put(4, coupon.getDescription());
        params.put(5, coupon.getStartDate());
        params.put(6, coupon.getEndDate());
        params.put(7, coupon.getAmount());
        params.put(8, coupon.getPrice());
        params.put(9, coupon.getImage());
        DBUtils.runQuery(INSERT_COUPON, params);
    }

    @Override
    public void update(Integer integer, Coupon coupon) {

    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public List<Coupon> getAll() {
        return null;
    }

    @Override
    public Coupon getOne(Integer integer) {
        return null;
    }

    @Override
    public boolean isExist(Integer integer) {
        return false;
    }

    @Override
    public void addCouponPurchase(int customerID, int couponID) {

    }

    @Override
    public void deleteCouponPurchase(int customerID, int couponID) {

    }
}
