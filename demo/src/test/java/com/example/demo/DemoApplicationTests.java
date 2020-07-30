package com.example.demo;

import Utils.LetterCombineUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Test
    public void test() {
        LetterCombineUtils utils = new LetterCombineUtils();
        Integer[] input = {2,99,4};
        List<String> list = utils.combine(input,0,new ArrayList<>());
        list.stream().forEach(l-> System.out.print(l+"\t"));
    }

}
