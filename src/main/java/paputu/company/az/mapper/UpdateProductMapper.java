package paputu.company.az.mapper;

import org.mapstruct.*;
import paputu.company.az.dto.request.UpdateProductRequest;
import paputu.company.az.model.Product;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UpdateProductMapper extends EntityMapper<Product,UpdateProductRequest>{

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateProductFromRequest(UpdateProductRequest request, @MappingTarget Product product);
}
