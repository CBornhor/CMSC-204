package JUnit;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradeBookTest {
GradeBook g1, g2;
	@BeforeEach
	void setUp () throws Exception {
		
		g1 = new GradeBook(5);
		g2 = new GradeBook(5);
		g1.addScore(50);
		g1.addScore(75);
		g1.addScore(100);
		g2.addScore(50);
		g2.addScore(70);
		g2.addScore(99);
	}
	
	@AfterEach
	void tearDown () throws Exception {
		g1 = null;
		g2 = null;
	}
	@Test
    public void testAddScore() {
        assertTrue(g1.toString().equals("85.0 92.0 100.0 "));
        assertTrue(g2.toString().equals("85.0 92.0 99.0 "));
    }

    @Test
    public void testSum() {
        // Test the sum method
        assertEquals(177.0, g1.sum(), 0.01);
        assertEquals(200.0, g2.sum(), 0.01);
    }

    @Test
    public void testMinimum() {
        // Test the minimum method
        assertEquals(85.0, g1.minimum(), 0.01);
        assertEquals(95.0, g2.minimum(), 0.01);
    }

    @Test
    public void testFinalScore() {
        // Test the finalScore method
        assertEquals(177.0, g1.finalScore(), 0.01);
        assertEquals(166.0, g2.finalScore(), 0.01);
    }
}
