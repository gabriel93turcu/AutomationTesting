package valueReference;

import org.testng.annotations.Test;

public class ReferenceTest {

    @Test
    public void testMethod() {
        Curs curs = new Curs();
        curs.info();
        curs.id = 10;
        curs.info();
        curs.id = 5;
        curs.info();
    }
}
