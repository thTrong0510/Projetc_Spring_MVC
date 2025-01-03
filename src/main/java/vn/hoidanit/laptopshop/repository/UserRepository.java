package vn.hoidanit.laptopshop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.hoidanit.laptopshop.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User save(User user);

    List<User> findByEmail(String email);

    List<User> findByEmailAndAddress(String email, String Address);

    Optional<User> findById(long id);

    void deleteById(long id);

    Boolean existsByEmail(String email);

    User findOneByEmail(String email);
}
