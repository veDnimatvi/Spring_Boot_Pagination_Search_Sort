package thien.codelearn.restapi_pagination_search_sort.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thien.codelearn.restapi_pagination_search_sort.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
