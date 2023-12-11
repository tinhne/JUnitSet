package Algorithm;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;

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

    @ParameterizedTest
    @MethodSource("getPrimeNumbersFromExcel")
    void TestPrimeNumber(int number) {
        assertTrue(m.isPrimeNumber(number));
    }

    @Test
    void multiplication() {
        int result = m.multiplication(5, 7);
        assertEquals(result, 35);
    }

    static Object[] getPrimeNumbersFromExcel() throws IOException {
        return (Object[]) ExcelDataReader.readTestData("/Users/levantrungtinhgmail.com/Downloads/PrimeNumber.xlsx","PrimeNumber")[0];
    }


}