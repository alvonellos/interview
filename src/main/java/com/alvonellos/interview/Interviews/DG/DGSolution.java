package com.alvonellos.interview.Interviews.DG;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Log
public class DGSolution {
    public static boolean isArmstrongNumber(String number) {
        char[] digits = number.toCharArray();
        int sum = 0;
        for( int i = 0; i < digits.length; i++) {
            sum += Math.pow(Integer.parseInt(String.valueOf(digits[i])), 3);
        }
        return Integer.parseInt(number) == sum ? true : false;
    }

    public static boolean isConsecutive(String[] numberList) {
        final short CONSECUTIVE_MATCHES = 2;
        assert(numberList.length >= CONSECUTIVE_MATCHES); //size() = 1; length = 0
        boolean[] bs = new boolean[numberList.length];
        for( int i = 0; i < numberList.length; i++) {
            bs[i] = isArmstrongNumber(numberList[i]);
        }

        StringBuffer sb = new StringBuffer();
        for( int i = 0; i < bs.length; i++) {
            sb.append(bs[i] ? "1" : "0");
        }

        String test = sb.toString();
        return test.indexOf("111") < 0 ? false : true;

    }

    @PostMapping("/armstrong")
    public ResponseEntity<Boolean> isConsecutiveArmStrong(@RequestBody String[] input) {
        return isConsecutive(input)? ResponseEntity.ok(true) : ResponseEntity.ok(false);
    }
//    Expose a service to take list of numbers as input ,
//    Return true if the list contains three consecutive Armstrong number else return false
//      
//
//    Example 1: 
//
//    Input: Numbers = [6, 7, 153, 11, 13, 407] 
//
//    Response: false 
//
//    Example 2: 
//
//    Input: Numbers = [2, 2, 153, 371, 407, 534] 
//
//    Response: true 
//
//             Armstrong Number  
//            A positive number is called 
//            Armstrong number if it is equal to the sum of cubes of its digits for example
//            0, 1, 153, 370, 371, 407 etc. 
//
//             Why 153 is Armstrong number 
//
//            153 = (1*1*1)+(5*5*5)+(3*3*3)   
//
//    where:   
//
//            (1*1*1)=1   
//
//            (5*5*5)=125   
//
//            (3*3*3)=27   
//
//            1+125+27=153
}
