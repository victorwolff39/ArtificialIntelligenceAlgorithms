package com.victorwolff.waterjug;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BFSTest {

    @Test
    void shouldSolveBFSCorrectly() {
        BFS bfs = new BFS(4, 3, 2);
        String expected = """
                0 , 0
                0 , 3
                3 , 0
                3 , 3
                4 , 2
                0 , 2
                """;

        String result = bfs.solve();

        assertEquals(expected, result);
    }
}
