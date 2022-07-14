package com.nashtech.assignment.ecommerce.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nashtech.assignment.ecommerce.data.entities.Banned;

@Repository
@Transactional
public interface BannedRepository extends JpaRepository<Banned, Integer> {
	
	
	@Query(value = "select * from banned where user_id = :userId", nativeQuery = true)
	public Banned getBannedAccount(int userId);
	
	@Modifying
	@Query(value = "update banned set unban_code = :code where user_id = :userId", nativeQuery = true)
	public void saveVertiCode(String code, int userId);

}
