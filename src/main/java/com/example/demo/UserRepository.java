package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.User;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
	@Modifying
	@Query("update User u set u.password = :password where u.userid = :userid ")
	int updateByUserid(@Param("password")String password, @Param("userid")String userid);
}