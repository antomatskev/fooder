package eu.fooder.repositories;

import eu.fooder.models.Order;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderRepo extends PagingAndSortingRepository<Order, Long> {
}
