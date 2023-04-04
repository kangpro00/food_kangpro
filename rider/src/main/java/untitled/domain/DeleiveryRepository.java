package untitled.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import untitled.domain.*;

@RepositoryRestResource(
    collectionResourceRel = "deleiveries",
    path = "deleiveries"
)
public interface DeleiveryRepository
    extends PagingAndSortingRepository<Deleivery, Long> {}
