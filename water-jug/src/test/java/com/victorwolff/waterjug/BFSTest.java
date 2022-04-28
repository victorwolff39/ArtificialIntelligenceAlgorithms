package com.victorwolff.waterjug;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BFSTest {

    @Test
    void shouldSolveBFSCorrectly() {
        BFS bfs = new BFS(4, 3, 2);
        String expected = """
                (0, 0)\s
                (0, 3)\s
                (4, 0)\s
                (4, 3)\s
                (3, 0)\s
                (1, 3)\s
                (3, 3)\s
                (4, 2)\s
                (0, 2)""";

        String answer = bfs.solve();

        assertEquals(answer.trim(), expected.trim());
    }
}
