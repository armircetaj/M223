package ch.samt.customers.data;

import ch.samt.customers.model.Customers;
import org.jspecify.annotations.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository
    extends JpaRepository<Customers, Long>
{
    List<Customers> findById (long id);
    List<Customers> findByCity (String city);
    List<Customers> findBySurnameIgnoreCase(String surname);
    List<Customers> findByAgeIsLessThan(Integer agelimit);
}
