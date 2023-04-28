package facade;

import beans.Company;
import beans.Customer;
import exceptions.CouponSystemException;
import exceptions.ErrMsg;

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
    public void addCompany(Company company) throws CouponSystemException {
        int id = company.getId();
        if (companiesDAO.isExistsById(id)) {
            throw new CouponSystemException(ErrMsg.COMPANY_ID_EXISTS);
        }
        if (companiesDAO.isExistsByEmail(company.getEmail())) {
            throw new CouponSystemException(ErrMsg.COMPANY_EMAIL_EXISTS);
        }
        if (companiesDAO.isExistsByName(company.getName())) {
            throw new CouponSystemException(ErrMsg.COMPANY_NAME_EXISTS);
        }
        companiesDAO.add(company);
    }

    @Override
    public void updateCompany(int id, Company company) throws CouponSystemException {
        Company c = companiesDAO.getOne(id);
        if (c == null || c.getId() != company.getId()) {
            throw new CouponSystemException(ErrMsg.COMPANY_ID_NOT_MATCH);
        }
        if (!c.getName().equals(company.getName())) {
            throw new CouponSystemException(ErrMsg.COMPANY_NAME_NOT_MATCH);
        }
        companiesDAO.update(id, company);
    }

    @Override
    public void deleteCompany(int id) {
        companiesDAO.delete(id);
    }

    @Override
    public List<Company> getAllCompanies() {
        List<Company> companies = companiesDAO.getAll();
        return companies;
    }

    @Override
    public Optional<Company> getOneCompany(int id) throws CouponSystemException {
        if (companiesDAO.isExistsById(id)) {
            Company company = companiesDAO.getOne(id);
            return Optional.of(company);
        }
        throw new CouponSystemException(ErrMsg.COMPANY_NOT_FOUND);
    }

    @Override
    public void addCustomer(Customer customer) throws CouponSystemException {
        int id = customer.getId();
        if (customersDAO.isExistsById(id)) {
            throw new CouponSystemException(ErrMsg.CUSTOMER_ID_EXISTS);
        }
        if (customersDAO.isExistsByEmail(customer.getEmail())) {
            throw new CouponSystemException(ErrMsg.CUSTOMER_EMAIL_EXISTS);
        }
        customersDAO.add(customer);
    }

    @Override
    public void updateCustomer(int id, Customer customer) throws CouponSystemException {
        Customer c = customersDAO.getOne(id);
        if (c == null || c.getId() != customer.getId()) {
            throw new CouponSystemException(ErrMsg.CUSTOMER_ID_NOT_MATCH);
        }
        customersDAO.update(id, customer);
    }

    @Override
    public void deleteCustomer(int id) {
        customersDAO.delete(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = customersDAO.getAll();
        return customers;
    }

    @Override
    public Optional<Customer> getOneCustomer(int id) {
        Customer customer = customersDAO.getOne(id);
        return Optional.of(customer);
    }
}
