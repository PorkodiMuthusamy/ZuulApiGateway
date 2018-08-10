package com.javasampleapproach.s3.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javasampleapproach.s3.model.User;
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

}
