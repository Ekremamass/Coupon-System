package dao;

import beans.Customer;
import db.DBUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerDAOImpl implements CustomerDAO {
    private static final String INSERT_CUSTOMER = "INSERT INTO `coupon_system`.`customers` (`first_name`, `last_name`, `email`, `password`) VALUES (?,?, ?, ? );\n";

    @Override
    public void add(Customer customer) {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, customer.getFirstName());
        params.put(2, customer.getLastName());
        params.put(3, customer.getEmail());
        params.put(4, customer.getPassword());
        DBUtils.runQuery(INSERT_CUSTOMER, params);
    }

    @Override
    public void update(Integer integer, Customer customer) {

    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public List<Customer> getAll() {
        return null;
    }

    @Override
    public Customer getOne(Integer integer) {
        return null;
    }

    @Override
    public boolean isExist(Integer integer) {
        return false;
    }
}
