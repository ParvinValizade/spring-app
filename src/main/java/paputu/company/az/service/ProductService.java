package paputu.company.az.service;

import paputu.company.az.dto.request.CreateProductRequest;
import paputu.company.az.dto.request.CreateUserRequest;
import paputu.company.az.dto.response.ProductResponse;
import paputu.company.az.dto.response.UserResponse;

import java.util.List;


public interface ProductService {

    ProductResponse createProduct(CreateProductRequest productRequest);

    ProductResponse getProductByProductHashCode(String productHashCode);

    List<ProductResponse> getAllProducts();

    void deleteProductByHashCode(String hashCode);
}
