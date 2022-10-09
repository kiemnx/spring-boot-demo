package vn.plusplus.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountJPArepo extends JpaRepository<AccountJpa, Long> {

    AccountJpa findByPhoneJpa(String phone);
    AccountJpa findByEmailJpa(String email);
    AccountJpa findOneById(Long id);
}
