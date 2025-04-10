package paputu.company.az.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import paputu.company.az.dto.response.ProductResponse;
import paputu.company.az.model.Product;


@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper extends EntityMapper<Product, ProductResponse> {
}
