package com.demo.login;

import com.demo.login.user.User;
import com.demo.login.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.assertThat;  //자동 import되지 않음


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repo;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setEmail("kylekim@gmail.com");
        user.setPassword("ravi1994");
        user.setFirstName("Kyle");
        user.setLastName("Kim");

        User savedUser = repo.save(user);

        User existUser = entityManager.find(User.class, savedUser.getId());

        assertThat( user.getEmail() ).isEqualTo( existUser.getEmail() );

    }

    @Test
    public void testFindUserByEmail(){
        String email = "nam@codejave.com";
        User user = repo.findByEmail(email);
        assertThat(user).isNotNull();

    }
}
