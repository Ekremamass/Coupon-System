package db;


import beans.Category;
import beans.Coupon;

import java.sql.Date;
import java.util.Map;

/**
 * Created by kobis on 13 Mar, 2023
 */
public class ConvertUtils {

    public static Coupon couponFromPairs(Map<String, Object> map) {
        long id = (int) map.get("id");
        int companyId = (int) map.get("company_id");
        String category = (String) map.get("category");
        String title = (String) map.get("title");
        String description = (String) map.get("description");
        Date startDate = (Date) map.get("start_date");
        Date endDate = (Date) map.get("end_date");
        int amount = (int) map.get("amount");
        double price = (double) map.get("price");
        String image = (String) map.get("image");

        return new Coupon(id, companyId, Category.valueOf(category), title, description, startDate, endDate, amount, price, image);
    }

//    public static Cat catFromPairs(Map<String, Object> map){
//        int id = (int) map.get("id");
//        String name = (String) map.get("name");
//        boolean isNice = ((int) map.get("is_nice")==1);
//        Date birthday = (Date) map.get("birthday");
//        double weight = (double) map.get("weight");
//        String col = (String)map.get("color");
//        Color color = Color.valueOf(col);
//
//        return new Cat(id,name,birthday,isNice,weight,color);
//    }
//
//    public static Dog dogFromPairs(Map<String,Object> map){
//        long id = (int) map.get("id");
//        String nick = (String) map.get("nick");
//        Date whenToEat = (Date) map.get("eat_time");
//        float danger = (float) map.get("danger");
//
//        return new Dog(id,nick,danger,whenToEat);
//
//    }

    public static boolean booleanFromPairs(Map<String, Object> map) {
        boolean res = ((long) map.get("res") == 1);
        return res;
    }
}
