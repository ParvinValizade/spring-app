package paputu.company.az.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import paputu.company.az.dto.request.CreateUserRequest;
import paputu.company.az.model.User;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserRequestMapper extends EntityMapper<CreateUserRequest, User>{
}
