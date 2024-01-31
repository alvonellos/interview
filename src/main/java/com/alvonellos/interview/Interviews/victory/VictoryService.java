package com.alvonellos.interview.Interviews.victory;

import com.alvonellos.interview.exceptions.InterviewIdNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.val;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

@Log
@Service
@RequiredArgsConstructor
public class VictoryService implements InitializingBean {

    private final VictoryRepo victoryRepo;

    public boolean health() {
        log.entering(this.getClass().getName(), "health");
        val result = victoryRepo.count() >= 0;
        log.exiting(this.getClass().getName(), "health");
        return result;
    }

    public List<Victory> get() {
        log.entering(this.getClass().getName(), "getAll");

        val result = victoryRepo.findAll();
        if (result.isEmpty())
            return List.of();

        return result.stream().map(VictoryEntity::toDto).toList();
    }

    public Victory get(UUID id) throws InterviewIdNotFoundException {
        log.entering(this.getClass().getName(), "get");
         val result = victoryRepo.findById(id).orElse(null);
        log.entering(this.getClass().getName(), "get");
        if(result == null)
            throw new InterviewIdNotFoundException(id);

        return result.toDto();

    }

    public URI post(String value) throws InterviewIdNotFoundException {
        log.entering(this.getClass().getName(), "post");
        val result = victoryRepo.save(
                VictoryEntity.builder()
                        .value(value)
                        .build()
        );
        log.entering(this.getClass().getName(), "post");

        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/api/v1/victory/{id}")
                .buildAndExpand(result.getId())
                .toUri();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.entering(this.getClass().getName(), "init");



        log.exiting(this.getClass().getName(), "init");
    }

    public long[] getOnly(boolean odd) {
        final int mod;
        if(odd)
            mod = 1;
        else
            mod = 0;

        return IntStream.rangeClosed(0, 10)
                .asLongStream()
                .filter(x -> x % 2 == mod)
                .toArray();
    }
}
