package com.revature.repo;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReimbursementRepo extends JpaRepository<Reimbursement, Integer> {

    Reimbursement findReimbursementByreimbursementId(int reimbursementId);

    Reimbursement[] findReimbursementByuserPair(User current);

}
