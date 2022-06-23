package thien.codelearn.restapi_pagination_search_sort.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import thien.codelearn.restapi_pagination_search_sort.dto.ProductResponse;
import thien.codelearn.restapi_pagination_search_sort.entity.Product;
import thien.codelearn.restapi_pagination_search_sort.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

//    @GetMapping("/product")
//    public List<Product> getAllEmployees(){
//        return productService.findAllProducts();
//    }

//    @GetMapping("/products")
//    public ProductResponse<List<Product>> getAllEmployees(){
//        List<Product> allProduct = productService.findAllProducts();
//        return new ProductResponse<>(allProduct.size(), allProduct);
//    }

//    @GetMapping("/{field}")
//    private APIResponse<List<Product>> getProductsWithSort(@PathVariable String field) {
//        List<Product> allProducts = service.findProductsWithSorting(field);
//        return new APIResponse<>(allProducts.size(), allProducts);
//    }

//    @GetMapping("/product")
//    private ProductResponse<List<Product>> getProductsWithSort(@RequestParam("sort") String field) {
//        List<Product> allProducts = productService.findProductsWithSorting(field);
//        return new ProductResponse<>(allProducts.size(), allProducts);
//    }

//    @GetMapping("/pagination/{offset}/{pageSize}")
//    private APIResponse<Page<Product>> getProductsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
//        Page<Product> productsWithPagination = service.findProductsWithPagination(offset, pageSize);
//        return new APIResponse<>(productsWithPagination.getSize(), productsWithPagination);
//    }

    @GetMapping("/pagination")
    private ProductResponse<Product> getProductsWithPagination(@RequestParam(value = "offset", required = false, defaultValue = "1") int offset, @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
        Page<Product> productsWithPagination = productService.findProductsWithPagination(offset, pageSize);

        return new ProductResponse<>(productsWithPagination.getSize(), productsWithPagination.getContent(), productsWithPagination.getPageable().getPageSize(), productsWithPagination.getPageable().getPageNumber() + 1);
    }

//    @GetMapping("/paginationAndSort/{offset}/{pageSize}/{field}")
//    private ProductResponse<Page<Product>> getProductsWithPaginationAndSort(@PathVariable int offset, @PathVariable int pageSize,@PathVariable String field) {
//        Page<Product> productsWithPagination = productService.findProductsWithPaginationAndSorting(offset, pageSize, field);
//        return new ProductResponse<>(productsWithPagination.getSize(), productsWithPagination);
//    }

    @GetMapping("/paginationAndSort")
    private ProductResponse<Product> getProductsWithPaginationAndSort(@RequestParam(value = "offset" ,required = false, defaultValue = "1") int offset, @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,@RequestParam(value = "sort", required = false, defaultValue = "id") String field) {
        Page<Product> productsWithPagination = productService.findProductsWithPaginationAndSorting(offset, pageSize, field);
        return new ProductResponse<>(productsWithPagination.getSize(), productsWithPagination.getContent(), productsWithPagination.getPageable().getPageSize(), productsWithPagination.getPageable().getPageNumber() + 1);
    }

}
