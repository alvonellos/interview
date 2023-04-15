package com.alvonellos.interview.helpers;

import com.alvonellos.interview.client.ClientProperties;
import com.alvonellos.interview.client.KanyeClient;
import com.alvonellos.interview.client.MemeClient;
import com.alvonellos.interview.config.KanyeClientURL;
import com.alvonellos.interview.config.MemeClientURL;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

import java.time.Clock;

import static org.mockito.Mockito.doReturn;

@Configuration
public class TestConfig {

    @Bean
    public MemeClientURL memeClientURL() {
        MemeClientURL memeClientURL = Mockito.mock(MemeClientURL.class);
        doReturn("email").when(memeClientURL).getEmail();
        doReturn("password").when(memeClientURL).getPassword();
        doReturn("scheme").when(memeClientURL).getScheme();
        doReturn("base").when(memeClientURL).getBaseUrl();
        doReturn("res").when(memeClientURL).getResourcePath();
        doReturn("get_memes").when(memeClientURL).getGetMemesPath();
        doReturn("caption_image").when(memeClientURL).getCaptionImagePath();
        doReturn("search_memes").when(memeClientURL).getSearchMemesPath();
        doReturn("automeme").when(memeClientURL).getAutoMemePath();
        doReturn("ai_meme").when(memeClientURL).getAiMemePath();
        doReturn("get_top_100").when(memeClientURL).getGetTopPath();
        return memeClientURL;
    }

    @Bean
    public KanyeClientURL kanyeClientURL() {
        KanyeClientURL kanyeClientURL = Mockito.mock(KanyeClientURL.class);
        doReturn("scheme").when(kanyeClientURL).getScheme();
        doReturn("base").when(kanyeClientURL).getBaseUrl();
        doReturn("res").when(kanyeClientURL).getResourcePath();
        return kanyeClientURL;
    }

    @Bean
    public Clock clock() {
        return Mockito.mock(Clock.class);
    }

    @Bean
    @Qualifier("mockRest")
    public RestTemplate restTemplate() {
        return Mockito.mock(RestTemplate.class);
    }

    @Bean
    @Qualifier("mockClient")
    public ClientProperties clientProperties() {
        ClientProperties clientProperties = Mockito.mock(ClientProperties.class);
        doReturn(this.memeClientURL()).when(clientProperties).getMemeClientURL();
        doReturn(this.kanyeClientURL()).when(clientProperties).getKanyeClientURL();
        return clientProperties;
    }

    @Qualifier("mockKanye")
    @Bean
    public KanyeClient kanyeClient() {
        return new KanyeClient(restTemplate(), clientProperties());
    }

    @Qualifier("mockMeme")
    @Bean
    public MemeClient memeClient() {
        return new MemeClient(restTemplate(), clientProperties());
    }
}

