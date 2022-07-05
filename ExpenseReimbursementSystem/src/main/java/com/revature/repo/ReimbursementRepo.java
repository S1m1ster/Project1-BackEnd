package com.revature.repo;

import com.revature.models.Reimbursement;
import com.revature.models.Status;
import com.revature.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*@Repository
public interface ReimbursementRepo extends JpaRepository<Reimbursement, Integer> {
    Reimbursement findByStatus(Status status);

    List<Reimbursement> findAllByStatus(Status status);

    List<Reimbursement> findAllStatusByUser(Status status, User user);
}*/
