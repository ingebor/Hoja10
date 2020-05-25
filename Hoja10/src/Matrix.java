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
}
