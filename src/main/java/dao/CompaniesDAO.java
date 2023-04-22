package dao;

import beans.Company;

public interface CompaniesDAO extends DAO<Company, Integer> {
    boolean isCompanyExists(String email, String password);

    boolean isExistsByName(String name);

    boolean isExistsByEmail(String email);


}
