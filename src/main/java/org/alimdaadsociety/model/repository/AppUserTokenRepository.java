package org.alimdaadsociety.model.repository;

import org.alimdaadsociety.model.bean.AppUserToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserTokenRepository extends JpaRepository<AppUserToken, String>/*, AppUserRegTokenRepositoryCustom*/ {

}
