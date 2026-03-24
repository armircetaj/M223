package ch.samt.customers.data;

import ch.samt.customers.model.Customers;
import org.jspecify.annotations.Nullable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository
        extends CrudRepository<Customers, Long> {
    @Nullable Object findByCity(String city);
    @Nullable Object findById(long id);
}
