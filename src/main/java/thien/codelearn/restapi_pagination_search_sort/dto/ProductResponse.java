package thien.codelearn.restapi_pagination_search_sort.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse<T> {
    int total;
    T data;
}
