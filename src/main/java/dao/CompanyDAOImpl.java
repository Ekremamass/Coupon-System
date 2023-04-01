package dao;

import beans.Company;
import db.DBUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompanyDAOImpl implements CompanyDAO {
    private static final String INSERT_COMPANY = "INSERT INTO `coupon_system`.`companies` (`name`, `email`, `password`) VALUES (?, ?, ?);\n";

    @Override
    public void add(Company company) {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, company.getName());
        params.put(2, company.getEmail());
        params.put(3, company.getPassword());
        DBUtils.runQuery(INSERT_COMPANY, params);
    }

    @Override
    public void update(Integer integer, Company company) {

    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public List<Company> getAll() {
        return null;
    }

    @Override
    public Company getOne(Integer integer) {
        return null;
    }

    @Override
    public boolean isExist(Integer integer) {
        return false;
    }
}
