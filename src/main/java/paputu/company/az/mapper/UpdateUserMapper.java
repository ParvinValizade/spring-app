package paputu.company.az.mapper;

import org.mapstruct.*;
import paputu.company.az.dto.request.UpdateUserRequest;
import paputu.company.az.model.User;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UpdateUserMapper extends EntityMapper<User, UpdateUserRequest> {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromRequest(UpdateUserRequest request, @MappingTarget User user);
}
