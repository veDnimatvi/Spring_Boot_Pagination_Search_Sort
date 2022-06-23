package thien.codelearn.restapi_pagination_search_sort.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import thien.codelearn.restapi_pagination_search_sort.entity.Product;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse<T> {
    int total;
    List<T> data;
    int pageSize;
    int pageNo;
}
