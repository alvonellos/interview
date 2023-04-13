package com.alvonellos.interview.util.strings;

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
class LongestCommonPrefixTest {
    @Test
    void longestCommonPrefixTest() {
        String[] words = { "flower","flow","flight"};
        assertEquals("fl", LongestCommonPrefix.longestCommonPrefix(words));
    }
}