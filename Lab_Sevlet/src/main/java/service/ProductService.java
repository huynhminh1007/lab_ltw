package service;

import bean.Product;
import dao.ProductDAO;

import java.util.List;

public class ProductService {

    private static ProductService instance;

    public static ProductService getInstance() {
        if(instance == null) instance = new ProductService();
        return instance;
    }

    public Product getById(int id) {
       return ProductDAO.getById(id);
    }

    public List<Product> getAll() {
        return ProductDAO.getAll();
    }
}
