package com.alvonellos.interview.util.numbers;

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
class FractionTest {

    @Test
    void addTest() {
        Fraction f = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 2);
        Fraction f3 = f.add(f2);
        assertEquals(2, f3.getNumerator());
        assertEquals(2, f3.getDenominator());
    }

    @Test
    void subtractTest() {
        Fraction f = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 2);
        Fraction f3 = f.subtract(f2);
        assertEquals(0, f3.getNumerator());
        assertEquals(2, f3.getDenominator());
    }

    @Test
    void multiplyTest() {
        Fraction f = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 2);
        Fraction f3 = f.multiply(f2);
        assertEquals(1, f3.getNumerator());
        assertEquals(4, f3.getDenominator());
    }

    @Test
    void divideTest() {
        Fraction f = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 2);
        Fraction f3 = f.divide(f2);
        assertEquals(2, f3.getNumerator());
        assertEquals(2, f3.getDenominator());
    }

    @Test
    void reduceTest() {
        Fraction f = new Fraction(2, 4);
        assertEquals("1/2", f.reduce().toString());
    }

    @Test
    void testEqualsTest() {
        Fraction f = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 2);
        assertEquals(f, f2);
    }

    @Test
    void testToStringTest() {
        Fraction f = new Fraction(1, 2);
        assertEquals("1/2", f.toString());

        Fraction f2 = new Fraction(2, 4);
        assert(!f.equals(f2));
    }

    @Test
    void toDouble() {
        Fraction f = new Fraction(1, 2);
        assertEquals(0.5, f.toDouble());
    }

    @Test
    void toPercent() {
        Fraction f = new Fraction(1, 2);
        assertEquals("50%", f.toPercent(0));
    }
}