package facade;

import beans.Company;
import beans.Customer;

import java.util.List;
import java.util.Optional;

public interface AdminFacade {
    void addCompany(Company company);

    void updateCompany(int id, Company company);

    void deleteCompany(int id);

    List<Company> getAllCompanies();

    Optional<Company> getOneCompany(int id);

    void addCustomer(Customer customer);

    void updateCustomer(int id, Customer customer);

    void deleteCustomer(int id);

    List<Customer> getAllCustomers();

    Optional<Customer> getOneCustomer(int id);

}
