package com.org.pimentorbackend.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.org.pimentorbackend.dao.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    @Query(value = "SELECT * FROM userdata u WHERE u.emailId = :number", nativeQuery = true)
    public List<User> findByEmail(@Param("number") String number);
    
    @Query(value = "SELECT * FROM userdata u WHERE u.userName = :number", nativeQuery = true)
    public List<User> findByUserName(@Param("number") String number);
    
    @Query(value = "SELECT * FROM userdata u WHERE u.contactNumber = :number", nativeQuery = true)
    public List<User> findByContact(@Param("number") String number);    

    @Query(value = "SELECT * FROM userdata u WHERE u.userName = :uname and u.userPassWord = :pword", nativeQuery = true)
    public List<User> loginUser(@Param("uname") String un, @Param("pword") String pw);
}
