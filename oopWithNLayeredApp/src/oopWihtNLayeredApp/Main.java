package oopWihtNLayeredApp;

import oopWihtNLayeredApp.business.ProductManager;
import oopWihtNLayeredApp.core.logging.DatabaseLogger;
import oopWihtNLayeredApp.core.logging.FileLogger;
import oopWihtNLayeredApp.core.logging.Logger;
import oopWihtNLayeredApp.core.logging.MailLogger;
import oopWihtNLayeredApp.dataAccess.HibernateProductDao;
import oopWihtNLayeredApp.dataAccess.jdbcProductDao;
import oopWihtNLayeredApp.entities.Product;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Product product1 = new Product(1,"IPhone XR",10000);
        Product product2 = new Product(2,"IPhone 13",24000);
        Product product3 = new Product(3,"IPhone 14",48000);

        Logger[] loggers = {new DatabaseLogger(), new FileLogger(), new MailLogger()};

        ProductManager productManager = new ProductManager(new jdbcProductDao(), loggers);
        ProductManager productManager1 = new ProductManager(new HibernateProductDao(), loggers);
        ProductManager productManager2 = new ProductManager(new HibernateProductDao(), loggers);
        productManager.add(product1);
        productManager1.add(product2);
        productManager1.add(product3);
    }
}