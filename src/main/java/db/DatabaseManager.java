package db;

/**
 * Created by kobis on 13 Mar, 2023
 */
public class DatabaseManager {


    private static final String CREATE_SCHEMA = "CREATE SCHEMA `coupon_system`";
    private static final String DROP_SCHEMA = "DROP SCHEMA `coupon_system`";


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
            "  `image` VARCHAR(45) NOT NULL,\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  CONSTRAINT `company_id`\n" +
            "    FOREIGN KEY (`id`)\n" +
            "    REFERENCES `coupon_system`.`companies` (`id`)\n" +
            "    ON DELETE NO ACTION\n" +
            "    ON UPDATE NO ACTION,\n" +
            "  CONSTRAINT `category_id`\n" +
            "    FOREIGN KEY (`id`)\n" +
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
            "    ON DELETE NO ACTION\n" +
            "    ON UPDATE NO ACTION,\n" +
            "  CONSTRAINT `coupon_id`\n" +
            "    FOREIGN KEY (`coupon_id`)\n" +
            "    REFERENCES `coupon_system`.`coupons` (`id`)\n" +
            "    ON DELETE NO ACTION\n" +
            "    ON UPDATE NO ACTION);\n";


    public static void startDatabase() {
        db.DBUtils.runQuery(DROP_SCHEMA);
        db.DBUtils.runQuery(CREATE_SCHEMA);
        db.DBUtils.runQuery(CREATE_TABLE_COMPANIES);
        db.DBUtils.runQuery(CREATE_TABLE_CUSTOMERS);
        db.DBUtils.runQuery(CREATE_TABLE_CATEGORIES);
        db.DBUtils.runQuery(CREATE_TABLE_COUPONS);
        db.DBUtils.runQuery(CREATE_TABLE_CUSTOMERS_VS_COUPONS);
        db.ConnectionPool.getConnectionPool();

    }

    public static void endDatabase(){
        db.ConnectionPool.getConnectionPool().closeAllConnections();
    }

}
