package com.sda.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DisplayUtilTest {

    @Test
    void shouldCreatMapFromProvidedCollection() {
        // given
        ExampleClass exampleClass1 = new ExampleClass("test1");
        ExampleClass exampleClass2 = new ExampleClass("test2");
        List<ExampleClass> exampleList = List.of(exampleClass1, exampleClass2);
        Map<Integer, ExampleClass> expectedResult = Map.of(1, exampleClass1, 2, exampleClass2);
        DisplayUtil<ExampleClass> displayUtil = new DisplayUtil<>();
        // when
        Map<Integer,ExampleClass> result = displayUtil.getItems(exampleList);
        // then
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }

    @Data
    @AllArgsConstructor
    class ExampleClass {
        private String test;
    }
}