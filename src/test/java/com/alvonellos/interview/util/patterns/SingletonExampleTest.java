package com.alvonellos.interview.util.patterns;

import com.alvonellos.interview.repository.KVDatabase;
import com.alvonellos.interview.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@MockBean({KVDatabase.class, PersonRepository.class})
class SingletonExampleTest {
    @Test
    void getInstance() {
        SingletonExample instance = SingletonExample.getInstance();
        assertNotNull(instance);
        assertEquals(instance, SingletonExample.getInstance());
    }
}