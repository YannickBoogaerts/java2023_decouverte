package be.technifutur.decouverte.junit;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class RationnelTest {
    @Test
    void testCreationrationnel1sur2() throws RationnalException {
        Rationnel rationnel = new Rationnel(1, 2);
        assertAll(
                () -> assertEquals(1, rationnel.getNumerator(), "le numérateur de 1/2 est 1"),
                () -> assertEquals(2, rationnel.getDenominator(), "le dénominateur de 1/2 est 2")
        );
    }

    @Test
    void testCreationrationnel2sur3() throws RationnalException {
        Rationnel rationnel = new Rationnel(2, 3);
        assertAll(
                () -> assertEquals(2, rationnel.getNumerator(), "le numérateur de 2/3 est 2"),
                () -> assertEquals(3, rationnel.getDenominator(), "le dénominateur de 2/3 est 3")
        );
    }

    @Test
    void test1sur2Plus2sur3() throws RationnalException {
        assertEquals(
                new Rationnel(7, 6),
                new Rationnel(1, 2).add(new Rationnel(2, 3))
        );
    }

    @Test
    void test1sur3Plus1sur2() throws RationnalException {
        assertEquals(
                new Rationnel(7, 6),
                new Rationnel(1, 2).add(new Rationnel(2, 3))
        );
    }

    @DisplayName(" la création d'un rationnel avec un dénominateur à 0 soulève une exception")
    @Test
    void testCreationRationnelAvec0AuDenomateur(TestInfo info) {
        assertThrows(RationnalException.class, () -> new Rationnel(2, 0),()->info.getDisplayName());
    }

    @DisplayName("test de simplification")
    @ParameterizedTest(name = "test {index} : la version simplifiée de {0}/{1} est {2}/{3}")
    @MethodSource("rationnalProvider")
    void testSimplification(int num, int de, int nums, int des, TestInfo info) throws RationnalException {
        assertEquals(new Rationnel(nums, des), new Rationnel(num, de).simplify(),()->info.getDisplayName());
    }

    static Stream<Arguments> rationnalProvider() {
        return Stream.of(
                Arguments.arguments(2, 4, 1, 2),
                Arguments.arguments(12, 15, 4, 5),
                Arguments.arguments(8, 4, 2, 1),
                Arguments.arguments(3, 5, 3, 5),
                Arguments.arguments(15, 12, 5, 4),
                Arguments.arguments(1, 1, 1, 1)
        );
    }

    @Test
    void testLazySimplify() throws RationnalException {
        Rationnel rationnel = new Rationnel(36, 18);
        Rationnel simplify1 = rationnel.simplify();
        Rationnel simplify2 = rationnel.simplify();
        assertSame(simplify1,simplify2);
    }
}
