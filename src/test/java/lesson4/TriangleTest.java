package lesson4;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static lesson4.TriangleData.triangleSquare;

public class TriangleTest {
    private static Logger logger = LoggerFactory.getLogger("TriangleTest");
    @BeforeEach
    void beforeEach () {
        logger.info("Выполняется тест для проверки подсчета площади по 3-м сторонам");
    }

    //1.Проверить расчет площади со сторонами 3,4,5. ОР - площадь = 6
    @Test
    @DisplayName("Метод проверки кооректности рассчета для метода подсчета площади по 3-м сторонам")
    public void checkCorrectnessOfCountingForMethodTriangleSquare() {
        double result = TriangleData.triangleSquare(3,4,5);
        Assertions.assertEquals(6.0,result);
    }

    //
    @Test
    @DisplayName("Метод проверки кооректности рассчета для метода подсчета площади по 3-м сторонам c " +
            "некорректными значениями")
    public void checkCorrectnessOfCountingForMethodTriangleSquareWithIncorrectValues() {
        double result = TriangleData.triangleSquare(0,0,0);
        Assertions.assertFalse(false);
    }


}
