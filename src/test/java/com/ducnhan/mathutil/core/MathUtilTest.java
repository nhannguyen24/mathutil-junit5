package com.ducnhan.mathutil.core;

import static com.ducnhan.mathutil.core.MathUtil.getFactorial;
// import static la danh rieng cho nhung ham static
// goi ham ma bo qua ten class

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class MathUtilTest {
    
    // choi DDT, tach data ra khoi cau lenh kiem thu, tham so hoa data nay
    // vao trong cau lenh kiem thu
    
    // chuan bi bo data
    public static Object[][] initData() {
        return new Integer[][] {
                                    {1, 1},
                                    {2, 2},
                                    {5, 120},
                                    {6, 120}
                               };
    }
    
    @ParameterizedTest
    @MethodSource(value = "initData") // ten ham cung cap data, ngam dinh thu tu
    // cua cac phan tu mang, map vao tham so ham
    public void testGetFactorialGivenRightArgReturnsWell(int input, long expected) {
        assertEquals(expected, getFactorial(input));
    }
    
//    @Test
//    public void testGetFactorialGivenRightArgReturnsWell() {
//        assertEquals(120, getFactorial(5));
//    }
    
    // Bat ngoai le khi dua data ca chon!
    // @Test(expected = ten ngoai le.class) JUnit 4 thoi, JUnit 5 ko lam vay
    @Test
    public void testGetFactorialGivenWrongArgThrowException() {
        // xai bieu thuc Lambda
        // ham nhan tham so thu 2 la 1 cai object/co code implement cai
        // functional interface ten la Executable - co 1 ham duy nhat ko code
        // ten la execute()
        // choi cham
        
//        Executable exOject = new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                getFactorial(-5);
//            }
//        };

//        Executable exOject = () -> getFactorial(-5);
        assertThrows(IllegalArgumentException.class, () -> getFactorial(-5));
    }
    
}
