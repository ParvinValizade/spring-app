package paputu.company.az.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import paputu.company.az.dto.request.CreateProductRequest;
import paputu.company.az.dto.request.UpdateProductRequest;
import paputu.company.az.dto.response.ProductResponse;
import paputu.company.az.mapper.ProductMapper;
import paputu.company.az.mapper.ProductRequestMapper;
import paputu.company.az.mapper.UpdateProductMapper;
import paputu.company.az.model.Product;
import paputu.company.az.repository.ProductRepository;
import paputu.company.az.service.ProductService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ProductRequestMapper productRequestMapper;
    private final UpdateProductMapper updateProductMapper;

    @Override
    public ProductResponse createProduct(CreateProductRequest productRequest) {

        Product savedProduct = productRepository.save(productRequestMapper.toEntity(productRequest));

        return productMapper.toDto(savedProduct);
    }

    @Override
    public ProductResponse getProductByProductHashCode(String productHashCode) {

        Product product = productRepository.findProductByProductHashCode(productHashCode)
                .orElseThrow(()-> new RuntimeException("can't find prodcut by this hashCode: " + productHashCode));

        return productMapper.toDto(product);
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return productMapper.toDto(productRepository.findAll());
    }

    @Override
    public void deleteProductByHashCode(String productHashCode) {
        productRepository.findProductByProductHashCode(productHashCode)
                .ifPresent(productRepository::delete);
    }

    @Override
    @Transactional
    public ProductResponse updateProduct(String productHashCode, UpdateProductRequest request) {
        //TODO NotFoundException
        Product product = productRepository.findProductByProductHashCode(productHashCode)
                .orElseThrow(()-> new RuntimeException("can't find product by this hashCode: " + productHashCode));

        updateProductMapper.updateProductFromRequest(request, product);

        return productMapper.toDto(product);
    }
}
