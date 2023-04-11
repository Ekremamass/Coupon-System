package dao;

import beans.Customer;
import db.ConvertUtils;
import db.DBUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerDAOImpl implements CustomerDAO {
    private static final String INSERT_CUSTOMER = "INSERT INTO `coupon_system`.`customers` (`first_name`, `last_name`, `email`, `password`) VALUES (?,?, ?, ? );\n";
    private static final String UPDATE_CUSTOMER = "UPDATE `coupon_system`.`customers` SET `first_name` = ?, `last_name` = ?, `email` = ?, `password` = ? WHERE (`id` = ?);\n";
    private static final String DELETE_CUSTOMER = "DELETE FROM coupon_system.customers WHERE id = ?";
    private static final String GET_ALL_CUSTOMERS = "SELECT * FROM coupon_system.customers";
    private static final String GET_ONE_CUSTOMER = "SELECT * FROM coupon_system.customers WHERE id = ?";
    private static final String EXISTS_CUSTOMER = "SELECT EXISTS (SELECT * FROM coupon_system.customers WHERE id = ?) as res";

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
    public void update(Integer id, Customer customer) {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, customer.getFirstName());
        params.put(2, customer.getLastName());
        params.put(3, customer.getEmail());
        params.put(4, customer.getPassword());
        params.put(5, id);
        DBUtils.runQuery(UPDATE_CUSTOMER, params);
    }

    @Override
    public void delete(Integer id) {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, id);
        DBUtils.runQuery(DELETE_CUSTOMER, params);
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();
        List<?> results = DBUtils.runQueryWithResultSet(GET_ALL_CUSTOMERS);
        for (Object obj : results) {
            Customer customer = ConvertUtils.customerFromPairs((Map<String, Object>) obj);
            customers.add(customer);

        }
        return customers;
    }

    @Override
    public Customer getOne(Integer id) {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, id);
        List<?> results = DBUtils.runQueryWithResultSet(GET_ONE_CUSTOMER, params);
        Customer customer = ConvertUtils.customerFromPairs((Map<String, Object>) results.get(0));
        return customer;
    }

    @Override
    public boolean isExist(Integer id) {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, id);
        List<?> results = DBUtils.runQueryWithResultSet(EXISTS_CUSTOMER, params);
        boolean result = ConvertUtils.booleanFromPairs((Map<String, Object>) results.get(0));
        return result;
    }
}
