package db;

import beans.Category;
import beans.Company;
import beans.Coupon;
import beans.Customer;
import dao.*;
import utils.Art;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kobis on 13 Mar, 2023
 */
public class DatabaseManager {


    private static final String CREATE_SCHEMA = "CREATE SCHEMA `coupon_system`";
    private static final String DROP_SCHEMA = "DROP SCHEMA `coupon_system`";

    private static final CategoriesDAO categoryDAO = new CategoriesDAOImpl();
    private static final CustomersDAO customerDAO = new CustomersDAOImpl();
    private static final CompaniesDAO companyDAO = new CompaniesDAOImpl();
    private static final CouponsDAO couponDAO = new CouponsDAOImpl();


    private static final String CREATE_TABLE_COMPANIES = "CREATE TABLE `coupon_system`.`companies` (\n" +
            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `name` VARCHAR(45) NOT NULL,\n" +
            "  `email` VARCHAR(45) NOT NULL,\n" +
            "  `password` VARCHAR(45) NOT NULL,\n" +
            "  PRIMARY KEY (`id`));\n";

    private static final String CREATE_TABLE_CUSTOMERS = "CREATE TABLE `coupon_system`.`customers` (\n" +
            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `first_name` VARCHAR(45) NOT NULL,\n" +
            "  `last_name` VARCHAR(45) NOT NULL,\n" +
            "  `email` VARCHAR(45) NOT NULL,\n" +
            "  `password` VARCHAR(45) NOT NULL,\n" +
            "  PRIMARY KEY (`id`));\n";

    private static final String CREATE_TABLE_CATEGORIES = "CREATE TABLE `coupon_system`.`categories` (\n" +
            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `name` VARCHAR(45) NOT NULL,\n" +
            "  PRIMARY KEY (`id`));\n";

    private static final String CREATE_TABLE_COUPONS = "CREATE TABLE `coupon_system`.`coupons` (\n" +
            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `company_id` INT NOT NULL,\n" +
            "  `category_id` INT NOT NULL,\n" +
            "  `title` VARCHAR(45) NOT NULL,\n" +
            "  `description` VARCHAR(45) NOT NULL,\n" +
            "  `start_date` DATE NOT NULL,\n" +
            "  `end_date` DATE NOT NULL,\n" +
            "  `amount` INT NOT NULL,\n" +
            "  `price` DOUBLE NOT NULL,\n" +
            "  `image` VARCHAR(150) NOT NULL,\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  INDEX `category_id_idx` (`category_id` ASC) VISIBLE,\n" +
            "  INDEX `company_id_idx` (`company_id` ASC) VISIBLE,\n" +
            "  CONSTRAINT `company_id`\n" +
            "    FOREIGN KEY (`company_id`)\n" +
            "    REFERENCES `coupon_system`.`companies` (`id`)\n" +
            "    ON DELETE CASCADE\n" +
            "    ON UPDATE NO ACTION,\n" +
            "  CONSTRAINT `category_id`\n" +
            "    FOREIGN KEY (`category_id`)\n" +
            "    REFERENCES `coupon_system`.`categories` (`id`)\n" +
            "    ON DELETE NO ACTION\n" +
            "    ON UPDATE NO ACTION);\n";

    private static final String CREATE_TABLE_CUSTOMERS_VS_COUPONS = "CREATE TABLE `coupon_system`.`customers_vs_coupons` (\n" +
            "  `customer_id` INT NOT NULL,\n" +
            "  `coupon_id` INT NOT NULL,\n" +
            "  PRIMARY KEY (`customer_id`, `coupon_id`),\n" +
            "  INDEX `coupon_id_idx` (`coupon_id` ASC) VISIBLE,\n" +
            "  CONSTRAINT `customer_id`\n" +
            "    FOREIGN KEY (`customer_id`)\n" +
            "    REFERENCES `coupon_system`.`customers` (`id`)\n" +
            "    ON DELETE CASCADE\n" +
            "    ON UPDATE NO ACTION,\n" +
            "  CONSTRAINT `coupon_id`\n" +
            "    FOREIGN KEY (`coupon_id`)\n" +
            "    REFERENCES `coupon_system`.`coupons` (`id`)\n" +
            "    ON DELETE CASCADE\n" +
            "    ON UPDATE NO ACTION);\n";

    public static void startDatabase() {
        db.DBUtils.runQuery(DROP_SCHEMA);
        db.DBUtils.runQuery(CREATE_SCHEMA);
        db.DBUtils.runQuery(CREATE_TABLE_COMPANIES);
        db.DBUtils.runQuery(CREATE_TABLE_CUSTOMERS);
        db.DBUtils.runQuery(CREATE_TABLE_CATEGORIES);
        db.DBUtils.runQuery(CREATE_TABLE_COUPONS);
        db.DBUtils.runQuery(CREATE_TABLE_CUSTOMERS_VS_COUPONS);
        initDatabase();
        db.ConnectionPool.getConnectionPool();

    }

    public static void endDatabase() {
        db.ConnectionPool.getConnectionPool().closeAllConnections();
    }

    private static void initDatabase() {
        updateCategoriesTable();
        loadCustomers();
        loadCompanies();
        loadCoupons();
    }

    private static void updateCategoriesTable() {
        Arrays.stream(Category.values()).forEach(categoryDAO::add);
    }

    private static void loadCustomers() {
        System.out.println(Art.CUSTOMERS);
        Customer c1 = Customer.builder()
                .firstName("John")
                .lastName("Doe")
                .email("johndoe@email.com")
                .password("1234")
                .build();

        Customer c2 = Customer.builder()
                .firstName("Jane")
                .lastName("Smith")
                .email("janesmith@email.com")
                .password("1234")
                .build();

        Customer c3 = Customer.builder()
                .firstName("Bob")
                .lastName("Jones")
                .email("bobjones@email.com")
                .password("1234")
                .build();

        Customer c4 = Customer.builder()
                .firstName("Samantha")
                .lastName("Lee")
                .email("samlee@email.com")
                .password("1234")
                .build();

        Customer c5 = Customer.builder()
                .firstName("Michael")
                .lastName("Johnson")
                .email("michaelj@email.com")
                .password("1234")
                .build();

        Customer c6 = Customer.builder()
                .firstName("Emily")
                .lastName("Davis")
                .email("emilyd@email.com")
                .password("1234")
                .build();

        Customer c7 = Customer.builder()
                .firstName("Chris")
                .lastName("Wilson")
                .email("chrisw@email.com")
                .password("1234")
                .build();

        Customer c8 = Customer.builder()
                .firstName("Amanda")
                .lastName("Taylor")
                .email("amandat@email.com")
                .password("1234")
                .build();

        Customer c9 = Customer.builder()
                .firstName("David")
                .lastName("Garcia")
                .email("davidg@email.com")
                .password("1234")
                .build();

        Customer c10 = Customer.builder()
                .firstName("Maria")
                .lastName("Martinez")
                .email("mariam@email.com")
                .password("1234")
                .build();

        List<Customer> customers = List.of(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10);
        customerDAO.addAll(customers);

        customerDAO.getAll().forEach(System.out::println);
        System.out.println("-------------------------------------------------");

    }

    private static void loadCompanies() {
        System.out.println(Art.COMPANIES);
        Company c1 = Company.builder()
                .name("KSP")
                .email("KSP@KSP.com")
                .password("1234")
                .build();
        Company c2 = Company.builder()
                .name("BBB")
                .email("info@BBB.com")
                .password("1234")
                .build();

        Company c3 = Company.builder()
                .name("Global Industries")
                .email("info@globalindustries.com")
                .password("1234")
                .build();

        Company c4 = Company.builder()
                .name("Tours")
                .email("info@tours.com")
                .password("1234")
                .build();

        Company c5 = Company.builder()
                .name("Web Solutions Inc.")
                .email("info@websolutionsinc.com")
                .password("1234")
                .build();

        Company c6 = Company.builder()
                .name("Best Buy Co. Inc.")
                .email("info@bestbuy.com")
                .password("1234")
                .build();

        Company c7 = Company.builder()
                .name("Newegg Inc.")
                .email("info@newegg.com")
                .password("1234")
                .build();

        Company c8 = Company.builder()
                .name("Nike Inc.")
                .email("info@nike.com")
                .password("1234")
                .build();

        Company c9 = Company.builder()
                .name("The Coca-Cola Company")
                .email("info@coca-cola.com")
                .password("1234")
                .build();

        Company c10 = Company.builder()
                .name("Walmart Inc.")
                .email("info@walmart.com")
                .password("1234")
                .build();

        List<Company> companies = List.of(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10);
        companyDAO.addAll(companies);

        companyDAO.getAll().forEach(System.out::println);
        System.out.println("---------------------------------------------------------------");
    }

    private static void loadCoupons() {
        System.out.println(Art.COUPONS);
        Coupon c1 = Coupon.builder()
                .companyID(2)
                .category(Category.RESTAURANT)
                .title("1+1 Burger")
                .description("buy burger 200g and get second for free")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
                .amount(100)
                .price(70.0)
                .image("https://media3.giphy.com/media/IgOEWPOgK6uVa/giphy.gif?cid=ecf05e47dtsmbz3xkfjphy7ul1fj4iluf7uke5ww1kmf7dao&rid=giphy.gif&ct=g")
                .build();

        Coupon c2 = Coupon.builder()
                .companyID(7)
                .category(Category.ELECTRICITY)
                .title("Dell free mouse")
                .description("buy DELL laptop and get mouse for free")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusWeeks(3)))
                .amount(100)
                .price(2900.0)
                .image("https://media1.giphy.com/media/W639VPdqy5uX5NZPvN/giphy.gif?cid=ecf05e47fyz661w3v079lpayvlpazh00yqazjtbphrv1xva4&rid=giphy.gif&ct=g")
                .build();

        Coupon c3 = Coupon.builder()
                .companyID(4)
                .category(Category.VACATION)
                .title("All included London")
                .description("everything included travel to london")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
                .amount(50)
                .price(4200.0)
                .image("https://media1.giphy.com/media/3o6nV8OYdUhiuKja1i/giphy.gif?cid=ecf05e47zap0mk2hvwrmdnqhz58v80tufdxbq8tbjpyx3bbq&rid=giphy.gif&ct=g")
                .build();

        List<Coupon> coupons = List.of(c1, c2, c3);
        couponDAO.addAll(coupons);

        couponDAO.getAll().forEach(System.out::println);
        System.out.println("-----------------------------------------------------");

//        couponDAO.addCouponPurchase(1, 3);
//        couponDAO.addCouponPurchase(2, 1);
    }
}
