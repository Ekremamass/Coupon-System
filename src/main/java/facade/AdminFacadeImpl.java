package facade;

import beans.Company;
import beans.Customer;

import java.util.List;
import java.util.Optional;

public class AdminFacadeImpl extends ClientFacade implements AdminFacade {
    private static final String EMAIL = "admin@admin.com";
    private static final String PASSWORD = "admin";

    @Override
    public boolean login(String email, String password) {
        return email.equals(EMAIL) && password.equals(PASSWORD);
    }

    @Override
    public void addCompany(Company company) {
        
    }

    @Override
    public void updateCompany(int id, Company company) {

    }

    @Override
    public void deleteCompany(int id) {

    }

    @Override
    public List<Company> getAllCompanies() {
        return null;
    }

    @Override
    public Optional<Company> getOneCompany(int id) {
        return Optional.empty();
    }

    @Override
    public void addCustomer(Customer customer) {

    }

    @Override
    public void updateCustomer(int id, Customer customer) {

    }

    @Override
    public void deleteCustomer(int id) {

    }

    @Override
    public List<Customer> getAllCustomers() {
        return null;
    }

    @Override
    public Optional<Customer> getOneCustomer(int id) {
        return Optional.empty();
    }


}
