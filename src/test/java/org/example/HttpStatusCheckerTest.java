package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HttpStatusCheckerTest {
    HttpStatusChecker httpStatusChecker;
    @BeforeEach
    void setUp() {
        httpStatusChecker = new HttpStatusChecker();
    }
    @AfterEach
    void cleanUp() {
        httpStatusChecker = null;
    }
    @ParameterizedTest(name = "{0}")
    @MethodSource("getValidInputParams")
    void httpStatusCheckerWithValidArgument(String name, int input, String expected) {
        String result = httpStatusChecker.getStatusImage(input);
        assertEquals(expected,result);
    }

    @Test
    void httpStatusCheckerWithInvalidArgument() {
        assertThrows(IllegalArgumentException.class,
                () -> httpStatusChecker.getStatusImage(-1));
    }

    private static Stream<Arguments> getValidInputParams() {
        return Stream.of(
                Arguments.of("Error when test:100",100,"https://http.cat/100.jpg"),
                Arguments.of("Error when test:200",200,"https://http.cat/200.jpg"),
                Arguments.of("Error when test:300",300,"https://http.cat/300.jpg"),
                Arguments.of("Error when test:400",400,"https://http.cat/400.jpg"),
                Arguments.of("Error when test:500",500,"https://http.cat/500.jpg")
        );
    }
}