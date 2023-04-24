package com.alvonellos.interview.games.codinggame.clashofbots;

import lombok.AllArgsConstructor;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AllArgsConstructor(onConstructor = @__(@Autowired))
class PlayerTest {
    private final Player player;

    @Test
    public void testGetName() {
        assertEquals("Player", player);
    }
}