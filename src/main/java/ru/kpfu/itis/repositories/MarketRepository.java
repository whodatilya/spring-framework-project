package ru.kpfu.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.models.Market;

public interface MarketRepository extends JpaRepository<Market, Long> {
}
