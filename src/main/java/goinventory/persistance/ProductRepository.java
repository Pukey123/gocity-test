package goinventory.persistance;

import goinventory.domain.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Alex created 06/10/2021
 **/
public interface ProductRepository extends CrudRepository<Product, Long> {
}
