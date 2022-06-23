package thien.codelearn.restapi_pagination_search_sort.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import thien.codelearn.restapi_pagination_search_sort.entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT c FROM Product c WHERE c.name LIKE CONCAT('%', :name, '%')")
    List<Product> findProductByName(@Param("name") String name);
}
