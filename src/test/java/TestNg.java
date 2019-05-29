import org.testng.annotations.Test;

public class TestNg {

    @Test(priority = 9)
    public void test(){
        System.out.println("TEST executed last");
        //Assert.assertEquals(5,5);
    }


    @Test(priority = 8)
    public void test1(){
        System.out.println("TEST executed 9th");
      //  Assert.assertEquals("1","1");
    }
    @Test(priority = 7)
    public void test2() {
        System.out.println("TEST executed 8th");
        //Assert.fail();
    }

    @Test(priority = 6)
    public void test3(){
        System.out.println("TEST executed 7th");
        //Assert.assertEquals(31,31);
    }
    @Test(priority = 5)
    public void test4(){
        System.out.println("TEST executed 6th");
        //Assert.assertEquals(31,31);
    }
    @Test(priority = 4)
    public void test5(){
        System.out.println("TEST executed 5th");
        //Assert.assertEquals(31,31);
    }@Test(priority = 3)
    public void test6(){
        System.out.println("TEST executed 4th");
        //Assert.assertEquals(31,31);
    }
    @Test(priority = 2)
    public void test7(){
        System.out.println("TEST executed 3rd");
        //Assert.assertEquals(31,31);
    }@Test(priority = 1)
    public void test8(){
        System.out.println("TEST executed 2nd");
        //Assert.assertEquals(31,31);
    }
    int count=1;
    @Test(invocationCount = 5)
    public void test9(){
        System.out.println("TEST executed "+count++);
        //Assert.assertEquals(31,31);
    }

}

