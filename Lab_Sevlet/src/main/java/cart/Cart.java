package cart;

import bean.Product;
import service.ProductService;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<Integer, CartProduct> data = new HashMap<>();

    public boolean add(int id) {
        return add(id, 1);
    }

    public boolean add(int id, int quantity) {
        Product product = ProductService.getInstance().getById(id);

        if(product == null) return false;

        CartProduct cartProduct = data.getOrDefault(id, new CartProduct(product, 0));
        cartProduct.increaseQuantity(quantity);
        data.put(id, cartProduct);

        return true;
    }

    public int getTotal() {
        return data.values().stream().mapToInt(CartProduct::getQuantity).sum();
    }
}
