package vn.plusplus.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountJPArepo extends JpaRepository<AccountJpa, Long> {

    AccountJpa findByPhoneJpa(String phone);
    AccountJpa findByEmailJpa(String email);
    AccountJpa findOneById(Long id);

    @Query(nativeQuery = true, value = "SELECT T1.* FROM user_info.account T1 JOIN user_info.user T2\n" +
            "ON T1.id = T2.account_id WHERE T1.phone =:phone AND T2.status='ACTIVE';")
    AccountJpa findByActivePhone(@Param("phone") String phone);

}
