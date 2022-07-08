package com.revature.repo;

import com.revature.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepo extends JpaRepository<Status, Integer> {
    Status findStatusBystatusId(int statusId);
}
