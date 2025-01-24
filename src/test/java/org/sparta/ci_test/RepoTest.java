package org.sparta.ci_test;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.sparta.ci_test.domain.Repository;
import org.sparta.ci_test.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RepoTest {

	@Autowired
	private Repository repository;

	@Test
	public void simpleTest() {

		User user = new User("name");

		user = repository.save(user);

		Optional<User> foundUser = repository.findById(user.getId());

		Assertions.assertNotNull(user);
		if(foundUser.isPresent()) {
			Assertions.assertEquals(user.getId(), foundUser.get().getId());
		}

	}
}