package eu.fooder.repositories;

import eu.fooder.models.Provider;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProviderRepo extends PagingAndSortingRepository<Provider, Long> {
}
