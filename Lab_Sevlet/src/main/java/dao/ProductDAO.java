package dao;

import bean.Product;
import db.JDBIConnector;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductDAO {

    public static List<Product> getAll() {
        List<Product> products = JDBIConnector.me().withHandle((handle ->
            handle.createQuery("SELECT * FROM products")
                    .mapToBean(Product.class)
                    .stream().collect(Collectors.toList())
        ));
        return products;
    }

    public static Product getById(final int id) {
        Optional<Product> product = JDBIConnector.me().withHandle((handle ->
            handle.createQuery("SELECT * FROM products WHERE id = :id")
                    .bind("id", id)
                    .mapToBean(Product.class)
                    .stream().findFirst()
        ));
        return product.isEmpty()? null : product.get();
    }
}
