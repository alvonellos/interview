package com.alvonellos.interview.service;


import com.alvonellos.interview.client.MemeClient;
import com.alvonellos.interview.dto.MemeTemplateDTO;
import com.alvonellos.interview.dto.response.MemeResponseDTO;
import com.alvonellos.interview.model.MemeEntity;
import com.alvonellos.interview.repository.KVDatabase;
import com.alvonellos.interview.repository.MemeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Log
public class MemeService {
    private final MemeRepository memeRepository;

    private final MemeClient memeClient;

    private final KVDatabase kvDatabase;

    public MemeEntity save(MemeResponseDTO.MemeDTO meme) {
        return memeRepository.save(new MemeEntity(meme.getId(), meme.getName()));
    }

    public List<MemeTemplateDTO> memeList() {
        return memeClient.getTopMemes();
    }

    public void saveImage(String path) {

    }
}