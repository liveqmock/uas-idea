package uas.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uas.model.AccessToken;

public interface AccessTokenRepo extends JpaRepository<AccessToken, Long> {
	//@Query("from AccessToken where code = ?1")
	List<AccessToken> findByCode(String code);
	
	List<AccessToken> findByCodeAndToken(String code, String token);
}
