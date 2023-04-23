package facade;

import beans.Company;
import beans.Customer;
import exceptions.CouponSystemException;

import java.util.List;
import java.util.Optional;

public interface AdminFacade {
    void addCompany(Company company) throws CouponSystemException;

    void updateCompany(int id, Company company) throws CouponSystemException;

    void deleteCompany(int id);

    List<Company> getAllCompanies();

    Optional<Company> getOneCompany(int id);

    void addCustomer(Customer customer) throws CouponSystemException;

    void updateCustomer(int id, Customer customer) throws CouponSystemException;

    void deleteCustomer(int id);

    List<Customer> getAllCustomers();

    Optional<Customer> getOneCustomer(int id);

}
