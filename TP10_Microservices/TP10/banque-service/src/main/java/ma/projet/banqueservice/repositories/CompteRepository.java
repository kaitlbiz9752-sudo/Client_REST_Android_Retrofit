package ma.projet.banqueservice.repositories;

import ma.projet.banqueservice.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte, Long> {
}
