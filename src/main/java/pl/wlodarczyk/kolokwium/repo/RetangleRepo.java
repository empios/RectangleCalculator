package pl.wlodarczyk.kolokwium.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wlodarczyk.kolokwium.models.Retangle;

public interface RetangleRepo extends JpaRepository<Retangle, Long> {

}
