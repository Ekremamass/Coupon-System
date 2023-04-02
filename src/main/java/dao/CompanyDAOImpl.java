package dao;

import beans.Company;
import db.ConvertUtils;
import db.DBUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompanyDAOImpl implements CompanyDAO {
    private static final String INSERT_COMPANY = "INSERT INTO `coupon_system`.`companies` (`name`, `email`, `password`) VALUES (?, ?, ?);\n";
    private static final String UPDATE_COMPANY = "UPDATE `coupon_system`.`companies` SET `name` = ?, `email` = ?, `password` = ? WHERE (`id` = ?);\n";
    private static final String DELETE_COMPANY = "DELETE FROM coupon_system.companies WHERE id = ?";
    private static final String GET_ALL_COMPANIES = "SELECT * FROM coupon_system.companies";
    private static final String GET_ONE_COMPANY = "SELECT * FROM coupon_system.companies WHERE id = ?";

    @Override
    public void add(Company company) {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, company.getName());
        params.put(2, company.getEmail());
        params.put(3, company.getPassword());
        DBUtils.runQuery(INSERT_COMPANY, params);
    }

    @Override
    public void update(Integer id, Company company) {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, company.getName());
        params.put(2, company.getEmail());
        params.put(3, company.getPassword());
        params.put(4, id);
        DBUtils.runQuery(UPDATE_COMPANY, params);
    }

    @Override
    public void delete(Integer id) {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, id);
        DBUtils.runQuery(DELETE_COMPANY, params);
    }

    @Override
    public List<Company> getAll() {
        List<Company> companies = new ArrayList<>();
        List<?> results = DBUtils.runQueryWithResultSet(GET_ALL_COMPANIES);
        for (Object obj : results) {
            Company company = ConvertUtils.companyFromPairs((Map<String, Object>) obj);
            companies.add(company);
        }
        return companies;
    }

    @Override
    public Company getOne(Integer id) {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, id);
        List<?> results = DBUtils.runQueryWithResultSet(GET_ONE_COMPANY, params);
        Company company = ConvertUtils.companyFromPairs((Map<String, Object>) results.get(0));
        return company;
    }

    @Override
    public boolean isExist(Integer id) {
        return false;
    }
}
