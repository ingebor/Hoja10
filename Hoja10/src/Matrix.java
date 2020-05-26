import java.util.ArrayList;

/**
 * @author Ingebor Rubio
 *
 */
public class Matrix {
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
	
	public String findCenter(long[][]matriz,ArrayList<String> cities) {
		String centro = "";
		long[][] pesos = matriz;
		ArrayList<String> mayores = new ArrayList<String>();
		ArrayList<String> arrCiudades = cities;
		int k = 0;
		long mayor = 0;
		int a = 0;
		for(int i=0;i<arrCiudades.size();i++) {
			for (int j = 0;j<arrCiudades.size();j++) {
				long mientras = pesos[j][i];
				if(mientras>mayor) {
					mayor = mientras;
					k=k+1;
				}
				else {
					k=k+1;
				}
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
		long menor = 999999999;
		for(int i =0;i<mayores.size();i++) {
			long mientras = Long.parseLong(mayores.get(i));
			if(mientras<menor) {
				menor = mientras;				
			}
		}

		String centroTemp= Long.toString(menor);
		int indx = mayores.indexOf(centroTemp);
		centro = arrCiudades.get(indx);
		return centro;
	}
}
