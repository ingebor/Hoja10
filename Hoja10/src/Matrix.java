import java.util.ArrayList;

/**
 * @author Ingebor Rubio
 * @date 25/05/2020
 * Hoja de trabajo 10 de Estructura de Datos
 */
public class Matrix {
	
	/**
	 * Agregar una ciudad al ArrayList que las contiene
	 * @param cities
	 * @param actual
	 * @return ArrayList con las ciudades con las que se cuenta
	 */
	public ArrayList<String> addCity(ArrayList<String> cities,String actual){
		ArrayList<String> tempArray = cities;
		boolean maybeContains = tempArray.contains(actual);
		if(maybeContains == false) {
			tempArray.add(actual);
		}
		else {
			//Si ya lo contiene, no hace nada
		}
		return tempArray;
	}
	
	/**
	 * Algoritmo para encontrar el centro de la matriz
	 * @param matriz
	 * @param cities
	 * @return String con el nombre del centro de la matriz
	 */
	public String findCenter(long[][]matriz,ArrayList<String> cities) {
		String centro = "";
		long[][] pesos = matriz;
		ArrayList<String> mayores = new ArrayList<String>();
		ArrayList<String> arrCiudades = cities;
		int k = 0;
		long mayor = 0;
		int a = 0;
		//Recorrer la matriz verticalmente
		for(int i=0;i<arrCiudades.size();i++) {
			for (int j = 0;j<arrCiudades.size();j++) {
				long mientras = pesos[j][i];
				//Encontrar el peso mayor de la columna
				if(mientras>mayor) {
					mayor = mientras;
					k=k+1;
				}
				else {
					k=k+1;
				}
				//Agregar en otro ArrayList el peso mayor de cada columna
				if(k==(arrCiudades.size())) {
					String elMayor = Long.toString(mayor);
					mayores.add(a, elMayor);
					k=0;
					mayores.get(0);
					a++;
					mayor = 0;
				}
				
			}
		}
		//Encontrar el peso menor entre todas las columnas
		long menor = 999999999;
		for(int i =0;i<mayores.size();i++) {
			long mientras = Long.parseLong(mayores.get(i));
			if(mientras<menor) {
				menor = mientras;				
			}
		}

		//Ver a que ciudad corresponde el peso menor
		String centroTemp= Long.toString(menor);
		int indx = mayores.indexOf(centroTemp);
		centro = arrCiudades.get(indx);
		return centro;
	}
}
