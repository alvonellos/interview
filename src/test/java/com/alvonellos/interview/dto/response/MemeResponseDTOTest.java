package com.alvonellos.interview.dto.response;

import com.alvonellos.interview.repository.AddressRepository;
import com.alvonellos.interview.repository.KVDatabase;
import com.alvonellos.interview.repository.MemeRepository;
import com.alvonellos.interview.repository.PersonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@JsonTest
@MockBean({KVDatabase.class, PersonRepository.class, AddressRepository.class, MemeRepository.class})
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MemeResponseDTOTest {
    private final JacksonTester<MemeResponseDTO> json;

    private final ObjectMapper objectMapper;

    @Test
    public void testDeserialize() throws IOException, IOException {
        // Given
        Resource resource = new ClassPathResource("MemeClient/response/get_memes_response_success.json");
        MemeResponseDTO expected = new MemeResponseDTO();
        expected.setSuccess(true);
        MemeResponseDTO.MemeDTO meme = new MemeResponseDTO.MemeDTO();
        meme.setId(181913649L);
        meme.setName("Drake Hotline Bling");
        meme.setUrl("https://i.imgflip.com/30b1gx.jpg");
        meme.setWidth(1200);
        meme.setHeight(1200);
        meme.setBoxCount(2);
        expected.setData(new MemeResponseDTO.Memes(new MemeResponseDTO.MemeDTO[]{meme}));

        // When
        MemeResponseDTO actual = json.readObject(resource);

        // Then
        assertNotNull(actual);
        assert(actual.getData().getMemes().length > 0);
        assertEquals(expected.getData().getMemes()[0], actual.getData().getMemes()[0]);
    }

}