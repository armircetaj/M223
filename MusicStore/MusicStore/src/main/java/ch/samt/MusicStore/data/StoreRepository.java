package ch.samt.MusicStore.data;

import ch.samt.MusicStore.model.Instrument;
import org.jspecify.annotations.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface StoreRepository     extends JpaRepository<Instrument, Long> {
    List<Instrument> findByBrandIgnoreCase(String brand);
    List<Instrument> findByTypeIgnoreCase(String type);
    List<Instrument> findByTypeIgnoreCaseAndBrandIgnoreCase(String type, String brand);
    List<Instrument> findByPriceLessThanEqual(BigDecimal price);
}
