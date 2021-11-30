package telran.util.memory;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemoryServiceTest {
	byte array[];
	final long MG = 1024 * 1024;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		int maxSize = MemoryService.getMaxAvailableMemory();
		array = new byte[maxSize]; //normal allocation
		array = null;
		boolean gotException = false;
		try {
			array = new byte[maxSize + 1]; //exception	
			array = null;
		} catch (Throwable e) {
			gotException = true;
		}
		assertTrue(gotException);		
		System.out.printf("The End. Max size=%dM", maxSize/MG);
	}
//	@Test
	void singletonIntro() {
		Regular r1 = new Regular();
		Regular r2 = new Regular();
		r1.setString("YYY");
//		System.out.println("Regular. r1="+r1.getString()+ "  r2="+r2.getString());
		assertEquals("XXX", r2.getString());
		assertEquals("YYY", r1.getString());
		Singleton s1 = Singleton.instance();
		Singleton s2 = Singleton.instance();
		Integer i77 = 77;
		Integer i55 = 55;
		s1.setInteger(i77);
		assertEquals(i77, s2.getInteger());
		assertEquals(i77, s1.getInteger());
//		System.out.println("Singleton. s1=" +s1.getInteger() + "  s2=" + s2.getInteger());
	}

}
