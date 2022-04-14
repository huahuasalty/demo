package com.xyh.demo;

import com.xyh.demo.domain.dto.MessageDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class DemoTest {

    public boolean checkString(String str, Predicate<String> pred1,Predicate<String> pred2){
        return pred1.and(pred2).test(str);
    }

    public String testPred(){
        return null;
    }

    @Test
    public void testFunction(){
        Function<Integer,Integer> multi = e-> e*2;
        Function<Integer,Integer> square = e-> e*e;

        Integer apply = multi.andThen(square).apply(5);
        log.info("apply={}",apply);
        Integer apply1 = multi.compose(square).apply(5);
        log.info("apply1={}",apply1);
        Function.identity().apply("hahha");

    }

    public void testPredicate(){
        MessageDto dto = new MessageDto();
        dto.setToUserId("1");
        dto.setContentText("hello world!!");

        Predicate<MessageDto> pred = e -> e==null;
    }
}
