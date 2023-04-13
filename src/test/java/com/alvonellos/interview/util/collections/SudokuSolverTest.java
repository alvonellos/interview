package com.alvonellos.interview.util.collections;

import com.alvonellos.interview.repository.KVDatabase;
import com.alvonellos.interview.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static com.alvonellos.interview.util.collections.SudokuSolver.solveSudoku;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@MockBean({KVDatabase.class, PersonRepository.class})
class SudokuSolverTest {
    char[][] input = {{'5','3','.','.','7','.','.','.','.'},
                      {'6','.','.','1','9','5','.','.','.'},
                      {'.','9','8','.','.','.','.','6','.'},
                      {'8','.','.','.','6','.','.','.','3'},
                      {'4','.','.','8','.','3','.','.','1'},
                      {'7','.','.','.','2','.','.','.','6'},
                      {'.','6','.','.','.','.','2','8','.'},
                      {'.','.','.','4','1','9','.','.','5'},
                      {'.','.','.','.','8','.','.','7','9'}};
    char[][] expected = {{'5','3','4','6','7','8','9','1','2'},
                         {'6','7','2','1','9','5','3','4','8'},
                         {'1','9','8','3','4','2','5','6','7'},
                         {'8','5','9','7','6','1','4','2','3'},
                         {'4','2','6','8','5','3','7','9','1'},
                         {'7','1','3','9','2','4','8','5','6'},
                         {'9','6','1','5','3','7','2','8','4'},
                         {'2','8','7','4','1','9','6','3','5'},
                         {'3','4','5','2','8','6','1','7','9'}};
    @Test
    void solveSudokuTest() {
        solveSudoku(input);
        assertArrayEquals(expected, input);
    }
}