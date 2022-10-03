package com.alvonellos.interview.service;

import com.alvonellos.interview.exceptions.InterviewAPIException;
import com.alvonellos.interview.exceptions.InterviewIdNotFoundException;
import com.alvonellos.interview.model.KVEntity;
import com.alvonellos.interview.repository.KVDatabase;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class KVService {

    private final KVDatabase kvDatabase;


    public KVEntity get(Long id) throws InterviewAPIException {
        return kvDatabase.findById(id)
                .orElseThrow(() -> new InterviewIdNotFoundException("No record found for id: " + id));
    }

    public Long post(String key, String value) throws InterviewAPIException {
        return kvDatabase.save(new KVEntity(key, value)).getId();
    }

    public void put(KVEntity entity) throws InterviewAPIException {
        kvDatabase.save(entity);
    }

    //todo implement patch

    public void delete(Long id) {
        kvDatabase.deleteById(id);
    }

    public List<KVEntity> findAll() {
        return kvDatabase.findAll();
    }

    public List<KVEntity> searchByKey(String key) {
        KVEntity kvEntity = new KVEntity(null, key, null);
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("key", match -> match.contains())
                .withIgnorePaths("id", "value");
        Example<KVEntity> example = Example.of(kvEntity, matcher);
        return kvDatabase.findAll(example);
    }
}
