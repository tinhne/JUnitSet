package Algorithm;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class mathTest {
    private math m;
    @BeforeEach
    void setUp() {
        System.out.println("Setting up...");
        m = new math();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Tearing down...");
        m = null;
    }

//    @ParameterizedTest
//    @MethodSource("getPrimeNumbersFromExcel")
//    void TestPrimeNumber(int number) {
//        assertTrue(m.isPrimeNumber(number));
//    }
    @ParameterizedTest
    @MethodSource("getPrimeNumbersFromExcel")
    void TestPrimeNumber(List<Integer> data) {
        for (int number : data) {
            assertTrue(m.isPrimeNumber(number));
        }
    }


    @Test
    void multiplication() {
        int result = m.multiplication(5, 7);
        assertEquals(result, 35);
    }
    static Stream<Arguments> getPrimeNumbersFromExcel() throws IOException {
        List<List<Integer>> testData = ExcelDataReader.readTestData("C:\\Users\\Administrator\\IdeaProjects\\JUnitSet\\Book1.xlsx", "Sheet1");
        return testData.stream().map(Arguments::of);
    }

}