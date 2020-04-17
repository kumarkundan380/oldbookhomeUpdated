package com.oldBookSell.repository;



import org.springframework.data.repository.CrudRepository;

import com.oldBookSell.model.UserDetails;

public interface UserDetailRepository extends CrudRepository<UserDetails,Integer>{
	UserDetails findByEmail(String name);
			boolean	existsByEmail(String name);
			
//			@Query(value="select user_id from user_details where email=?1",nativeQuery = true)
//			Iterable<Integer> getId(String email);
}
