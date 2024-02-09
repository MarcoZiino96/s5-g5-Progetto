package it.epicode.s5g5.repository;

import it.epicode.s5g5.bean.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EdificoRepository extends JpaRepository<Edificio, Integer> {
}
