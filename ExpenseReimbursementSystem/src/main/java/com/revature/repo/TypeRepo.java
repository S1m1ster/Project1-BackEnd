package com.revature.repo;


import com.revature.models.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepo extends JpaRepository<Type, Integer> {
    Type findTypeBytypeId(int typeId);
}
