package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Todo;

@Repository
public interface TodoRepository  extends JpaRepository<Todo, String>{
	List<Todo> findByUseridIs(String userid);
	@Modifying
	@Query("update Todo t set t.todoflg = '0' where t.todoid = :todoid ")
	int deleteByTodoid(@Param("todoid") Integer todoid);

	List<Todo> findByUseridIsAndTodoflgIs(@Param("userid") String userid, @Param("todoflg") String todoflg);
}
