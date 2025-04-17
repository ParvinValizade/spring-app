package paputu.company.az.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import paputu.company.az.dto.request.CreateProductRequest;
import paputu.company.az.dto.request.UpdateProductRequest;
import paputu.company.az.dto.response.ProductResponse;
import paputu.company.az.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("v1/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody CreateProductRequest productRequest) {
        return ResponseEntity.ok(productService.createProduct(productRequest));
    }

    @PatchMapping("/{productHashCode}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable String productHashCode,
                                                         @RequestBody UpdateProductRequest request){
        return new ResponseEntity<>(productService.updateProduct(productHashCode,request), HttpStatus.ACCEPTED);
    }

    @GetMapping("/by")
    public ResponseEntity<ProductResponse> getProductByHashCode(@RequestParam String productHashCode){
        return ResponseEntity.ok(productService.getProductByProductHashCode(productHashCode));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @DeleteMapping("/delete-by")
    public ResponseEntity<Void> deleteProductByHashCode(@RequestParam String productHashCode){
        productService.deleteProductByHashCode(productHashCode);
        return ResponseEntity.ok().build();
    }
}
