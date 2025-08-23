package com.example.usermanagementapi.repository;

import com.example.usermanagementapi.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    private User user1;
    private User user2;

    @BeforeEach
    void setUp() {
        userRepository.deleteAllInBatch();

        user1 = new User();
        user1.setName("Alice");
        user1.setEmail("alice@example.com");
        user1.setPassword("password123");
        entityManager.persist(user1);

        user2 = new User();
        user2.setName("Bob");
        user2.setEmail("bob@example.com");
        user2.setPassword("password456");
        entityManager.persist(user2);

        entityManager.flush();
    }

    @Test
    void testFindByEmail() {
        User found = userRepository.findByEmail("alice@example.com");
        assertNotNull(found);
        assertEquals("Alice", found.getName());
        assertEquals("alice@example.com", found.getEmail());
    }

    @Test
    void testFindAllUsers() {
        List<User> users = userRepository.findAll();
        assertEquals(2, users.size());
    }

    @Test
    void testSaveUser() {
        User newUser = new User();
        newUser.setName("Charlie");
        newUser.setEmail("charlie@example.com");
        newUser.setPassword("password789");

        User saved = userRepository.save(newUser);

        assertNotNull(saved.getId());
        assertEquals("Charlie", saved.getName());
        assertEquals("charlie@example.com", saved.getEmail());
    }
}
