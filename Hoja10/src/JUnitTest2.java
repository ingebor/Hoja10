import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class JUnitTest2 {
	Matrix matrix = new Matrix();
	public int Test2() {
		int cantCiudades = 0;
		ArrayList<String> miArrayL = new ArrayList<String>();
		miArrayL.add("Antigua");
		miArrayL.add("Escuintla");
		String actual = "Mixco";
		matrix.addCity(miArrayL, actual);
		cantCiudades= miArrayL.size();
		return cantCiudades;
	}
	@Test
	void test() {
		int resultado = Test2();
		int esperado = 3;
		assertEquals(esperado,resultado);
	}

}
