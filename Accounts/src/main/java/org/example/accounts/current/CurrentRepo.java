package org.example.accounts.current;

import org.example.accounts.savings.Savings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentRepo extends JpaRepository<Current,Integer> {
    Current findByClientID(int clientID);
}
