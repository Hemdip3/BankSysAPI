package org.example.accounts.savings;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingsRepo extends JpaRepository<Savings,Integer> {
    Savings findByClientID(int id);
}
