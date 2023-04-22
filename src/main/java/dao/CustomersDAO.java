package dao;

import beans.Customer;

public interface CustomersDAO extends DAO<Customer, Integer> {
    boolean isCustomerExists(String email, String password);
}
