package harbour.barber.repository;

import harbour.barber.model.Haircut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HaircutRepository extends JpaRepository<Haircut, Long> {

    Haircut findByName(String name);

}
