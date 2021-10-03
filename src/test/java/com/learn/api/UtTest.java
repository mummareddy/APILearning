package com.learn.api;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.Assertion;

import static org.testng.Assert.*;

public class UtTest {
    Math math;
    @BeforeClass
    public void init() {
        math = new Math();
    }

    @Test
    public void testAdd() throws Exception{
        assertEquals(math.add(5,4), 9, "addition failed");
    }
    @Test
    public void testSub() throws Exception{
        assertEquals(math.sub(5,4), 1, "Sub failed");
    }
    @Test
    public void testMul() throws Exception{
        assertEquals(math.mul(5,4), 20, "multiplication failed");
    }
    @Test
    public void testdiv() throws Exception{
        assertEquals(math.div(5,4), 1, " division failed");
    }

    @DataProvider(name = "data")
    public Object[][] isIntData(){
        return new Object[][] {{"7", true}, {"dsdhgdf", false}, {"112132", true}};
    }

    @Test(dataProvider = "data")
    public void testNum(String ip, boolean result) throws Exception{
        assertEquals(math.isInt(ip), result, ip + " isInt failed");
    }
}
