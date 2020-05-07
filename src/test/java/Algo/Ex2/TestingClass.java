package Algo.Ex2;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestingClass {
    
    public class Inner {

        public int num1;
        public int num2;
        
        public Inner(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
        }
    }

    @Test 
    public void RandomTest() {

        Inner obj1 = new Inner(1, 2);
        Inner obj2 = new Inner(2, 3);

        Inner[] arrayOfObjects = new Inner[]{ obj1, obj2 };
        Inner obj1Container = arrayOfObjects[0];

        assertEquals(true, obj1 == obj1Container);
        assertEquals(false, obj1 == new Inner(1, 2));
    }
}