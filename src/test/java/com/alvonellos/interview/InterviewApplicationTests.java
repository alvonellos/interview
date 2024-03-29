package com.alvonellos.interview;

import com.alvonellos.interview.repository.KVDatabase;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
@AutoConfigureMockMvc
@MockBean(KVDatabase.class)
class InterviewApplicationTests {

	@Test
	void contextLoads() {
	}

}
