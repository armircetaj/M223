package ch.samt.GardenWarehouse.data;

import ch.samt.GardenWarehouse.model.Item;
import org.jspecify.annotations.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WarehouseRepository
    extends JpaRepository<Item, Long> {
    List<Item> findByName(String name);
    Optional<Item> findFirstByCode(String code);

}
