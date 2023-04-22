package facade;

import beans.Category;
import beans.Company;
import beans.Coupon;

import java.util.List;

public class CompnyFacadeImpl extends ClientFacade implements CompanyFacade {

    private int companyId;

    @Override
    public boolean login(String email, String password) {
        return false;
    }

    @Override
    public void addCoupon(Coupon coupon) {

    }

    @Override
    public void updateCoupon(int id, Coupon coupon) {

    }

    @Override
    public void deleteCoupon(int id) {

    }

    @Override
    public List<Coupon> getCompanyCoupons() {
        return null;
    }

    @Override
    public List<Coupon> getCompanyCoupons(Category category) {
        return null;
    }

    @Override
    public List<Coupon> getCompanyCoupons(double maxPrice) {
        return null;
    }

    @Override
    public Company getCompanyDetails() {
        return null;
    }
}
