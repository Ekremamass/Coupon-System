package dao;

import beans.Coupon;
import db.ConvertUtils;
import db.DBUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CouponDAOImpl implements CoupnDAO {

    private static final String INSERT_COUPON = "INSERT INTO `coupon_system`.`coupons` (`company_id`, `category_id`, `title`, `description`, `start_date`, `end_date`, `amount`, `price`, `image`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_COUPON = "UPDATE `coupon_system`.`coupons` SET `company_id` = ?, `category_id` = ?, `title` = ?, `description` = ?, `start_date` = ?, `end_date` = ?, `amount` = ?, `price` = ?, `image` = ? WHERE (`id` = ?);\n";
    private static final String DELETE_COUPON = "DELETE FROM coupon_system.coupons WHERE id = ?";
    private static final String GET_ALL_COUPONS = "SELECT * FROM coupon_system.coupons";
    private static final String GET_ONE_COUPON = "SELECT * FROM coupon_system.coupons WHERE id =?";
    private static final String EXISTS_COUPON = "SELECT EXISTS (SELECT * FROM coupon_system.coupons WHERE id = ?) as res";

    private static final String INSERT_COUPON_CUSTOMER = "INSERT INTO `coupon_system`.`customers_vs_coupons` (`customer_id`, `coupon_id`) VALUES (?, ?)";
    private static final String DELETE_COUPON_CUSTOMER = "DELETE FROM coupon_system.customers_vs_coupons WHERE customer_id = ? AND coupon_id = ?";

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
    public void update(Integer id, Coupon coupon) {
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
        params.put(10, id);
        DBUtils.runQuery(UPDATE_COUPON, params);
    }

    @Override
    public void delete(Integer id) {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, id);
        DBUtils.runQuery(DELETE_COUPON, params);
    }

    @Override
    public List<Coupon> getAll() {
        List<Coupon> coupons = new ArrayList<>();
        List<?> results = DBUtils.runQueryWithResultSet(GET_ALL_COUPONS);
        for (Object obj : results) {
            Coupon coupon = ConvertUtils.couponFromPairs((Map<String, Object>) obj);
            coupons.add(coupon);
        }
        return coupons;
    }

    @Override
    public Coupon getOne(Integer id) {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, id);
        List<?> results = DBUtils.runQueryWithResultSet(GET_ONE_COUPON, params);
        Coupon coupon = ConvertUtils.couponFromPairs((Map<String, Object>) results.get(0));
        return coupon;
    }

    @Override
    public boolean isExist(Integer id) {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, id);
        List<?> results = DBUtils.runQueryWithResultSet(EXISTS_COUPON, params);
        boolean result = ConvertUtils.booleanFromPairs((Map<String, Object>) results.get(0));
        return result;
    }

    @Override
    public void addCouponPurchase(int customerID, int couponID) {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, customerID);
        params.put(2, couponID);
        DBUtils.runQuery(INSERT_COUPON_CUSTOMER, params);
    }

    @Override
    public void deleteCouponPurchase(int customerID, int couponID) {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, customerID);
        params.put(2, couponID);
        DBUtils.runQuery(DELETE_COUPON_CUSTOMER, params);
    }
}
