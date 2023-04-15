package com.alvonellos.interview.client;

import com.alvonellos.interview.config.KanyeClientURL;
import com.alvonellos.interview.config.MemeClientURL;
import com.alvonellos.interview.dto.MemeTemplateDTO;
import com.alvonellos.interview.helpers.TestConfig;
import com.alvonellos.interview.repository.AddressRepository;
import com.alvonellos.interview.repository.KVDatabase;
import com.alvonellos.interview.repository.MemeRepository;
import com.alvonellos.interview.repository.PersonRepository;
import jnr.ffi.annotations.In;
import lombok.AllArgsConstructor;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MemeClient.class, TestConfig.class})
@AllArgsConstructor(onConstructor = @__(@Autowired))
@MockBean({AddressRepository.class, KVDatabase.class, MemeRepository.class, PersonRepository.class})
@ComponentScan("com.alvonellos.interview")
@ContextConfiguration(classes = TestConfig.class)
class MemeClientTest {

    @Autowired
    @Qualifier("mockRest")
    private final RestTemplate restTemplate;

    @Autowired
    @Qualifier("mockClient")
    private final ClientProperties clientProperties;

    private final TestConfig testConfig;

    @Autowired
    @Qualifier("mockMeme")
    private final  MemeClient memeClient;

    @BeforeEach
    void setUp() {
    }


    @Test
    void testGetTopMemes() throws IOException {
        Resource resource = new ClassPathResource("MemeClient/response/top_memes_response.html");

        String res = "";
        try(InputStreamReader input = new InputStreamReader(resource.getInputStream(), "UTF-8")) {
            BufferedReader reader = new BufferedReader(input);
            StringBuffer b = new StringBuffer();
            while (reader.ready()) {
                b.append(reader.readLine());
            }
            res = b.toString();
        } catch (Exception e) {
            fail();
        } finally {
            resource.getInputStream().close();
        }

        doReturn(res).when(restTemplate).getForObject(any(), eq(String.class));
        List<MemeTemplateDTO> response = memeClient.getTopMemes();

        assertNotNull(response);
        assert(response.size() > 1);
    }
}