import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class JUnitTest {
	Matrix matrix = new Matrix();
	public boolean Test() {
		boolean loContiene = true;
		ArrayList<String> miArrayL = new ArrayList<String>();
		miArrayL.add("Antigua");
		miArrayL.add("Escuintla");
		String actual = "Mixco";
		matrix.addCity(miArrayL, actual);
		loContiene=miArrayL.contains(actual);
		return loContiene;
	}
	@Test
	void test() {
		boolean resultado = Test();
		boolean esperado = true;
		assertEquals(esperado,resultado);
		
	}

}
