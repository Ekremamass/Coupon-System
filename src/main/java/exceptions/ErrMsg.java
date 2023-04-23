package exceptions;

import lombok.Getter;

@Getter
public enum ErrMsg {
    COMPANY_ID_EXISTS("company id already exists"),
    COMPANY_EMAIL_EXISTS("company email already exists"),
    COMPANY_NAME_EXISTS("company name already exists"),
    COMPANY_ID_NOT_MATCH("cannot update company id"),
    COMPANY_NAME_NOT_MATCH("cannot update company name"),
    CUSTOMER_ID_EXISTS("customer id already exists"),
    CUSTOMER_EMAIL_EXISTS("customer email already exists"),
    CUSTOMER_ID_NOT_MATCH("cannot update customer id"),
    COUPON_TITLE_EXISTS("coupon with the same title already exists for this company"),
    COUPON_ID_NOT_MATCH("cannot update coupon id"),
    COUPON_COMPANY_NOT_MATCH("cannot update company id of coupon");
    private String message;

    ErrMsg(String message) {
        this.message = message;
    }
}
