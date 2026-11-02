package pl.edu.vistula.firstrestapi.product.repository;

import org.springframework.stereotype.Repository;
import pl.edu.vistula.firstrestapi.product.domain.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class ProductRepository {

    protected final Map<Long, Product> map = new HashMap<>();
    protected long counter = 1;

    public Product save(Product entity) {
        if (entity.getId() == null) {
            entity.setId(counter);
            counter++;
        }
        map.put(entity.getId(), entity);
        return entity;
    }

    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(map.get(id));
    }

    public void deleteById(Long id) {
        map.remove(id);
    }
}