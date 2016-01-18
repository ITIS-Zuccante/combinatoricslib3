package org.paukov.combinatorics3;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.fest.assertions.Assertions.assertThat;


public class SimpleCombinationTest {

    @Test
    public void test_simple_3_combination_of_5_colors() {

        List<List<String>> combinations =
                Generator.combination("red", "black", "white", "green", "blue")
                .simple(3)
                .stream()
                .collect(Collectors.<List<String>>toList());

        assertThat(combinations).hasSize(10);

        System.out.println("Simple combinations 3 of 5 colors:");
        combinations.stream().forEach(System.out::println);

        assertThat(combinations.get(0)).containsSequence("red", "black", "white");
        assertThat(combinations.get(1)).containsSequence("red", "black", "green");
        assertThat(combinations.get(2)).containsSequence("red", "black", "blue");
        assertThat(combinations.get(3)).containsSequence("red", "white", "green");
        assertThat(combinations.get(4)).containsSequence("red", "white", "blue");
        assertThat(combinations.get(5)).containsSequence("red", "green", "blue");
        assertThat(combinations.get(6)).containsSequence("black", "white", "green");
        assertThat(combinations.get(7)).containsSequence("black", "white", "blue");
        assertThat(combinations.get(8)).containsSequence("black", "green", "blue");
        assertThat(combinations.get(9)).containsSequence("white", "green", "blue");
    }


    @Test
    public void test_simple_2_combination_of_3_numbers() {

        List<List<Integer>> combinations =
                Generator.combination(0, 1, 2)
                        .simple(2)
                        .stream()
                        .collect(Collectors.<List<Integer>>toList());

        assertThat(combinations).hasSize(3);

        System.out.println("Simple combinations 2 of the integers (0, 1, 2):");
        combinations.stream().forEach(System.out::println);

        assertThat(combinations.get(0)).containsSequence(0, 1);
        assertThat(combinations.get(1)).containsSequence(0, 2);
        assertThat(combinations.get(2)).containsSequence(1, 2);

    }

    @Test
    public void test_simple_0_combination_of_5_colors() {

        List<List<String>> combinations =
                Generator.combination("red", "black", "white", "green", "blue")
                        .simple(0)
                        .stream()
                        .collect(Collectors.<List<String>>toList());

        assertThat(combinations).hasSize(1);

        System.out.println("Simple combinations 0 of 5 colors:");
        combinations.stream().forEach(System.out::println);

        assertThat(combinations.get(0)).isEmpty();
    }
}
