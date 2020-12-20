package com.kamer.springbootuserregistration.user;

import com.kamer.springbootuserregistration.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
interface UserRepository extends CrudRepository<User, Long> {

	Optional<User> findByEmail(String email);
}
