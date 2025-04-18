package paputu.company.az.mapper;

import java.util.List;

public interface EntityMapper<E, D> {

    E toEntity(D dto);

    List<E> toEntity(List<D> dtoList);

    D toDto(E entity);

    List<D> toDto(List<E> entityList);

}
