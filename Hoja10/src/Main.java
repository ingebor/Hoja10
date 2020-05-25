import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	 public static void main(String[] args) throws Exception{
		 ArrayList<String> arrOrigen = new ArrayList<String>();
		 ArrayList<String> arrDestino = new ArrayList<String>();
		 ArrayList<String> arrDistancia = new ArrayList<String>();
		 ArrayList<String> arrCiudades = new ArrayList<String>();
		 
		 File archive = new File("guategrafo.txt");
		 FileReader fileRe = new FileReader(archive);
		 BufferedReader buffRea = new BufferedReader(fileRe);
		 
		 Matrix matrix = new Matrix();
		 

		System.out.println("------------------");
		System.out.println("|   Bienvenido   |");
		System.out.println("------------------");
		System.out.println("Desea agregar lo siguiente: ");
		
		if(archive.exists()) {
			String line = "";
			while((line = buffRea.readLine()) != null) {
				System.out.println(line);
				String[] eachLine = line.split(" ");
				eachLine[0].toLowerCase();
				eachLine[1].toLowerCase();
				arrOrigen.add(eachLine[0]);		//agregar el origen
				arrDestino.add(eachLine[1]);	//agregar el destino
				arrDistancia.add(eachLine[2]);	//agregar la distancia 
				arrCiudades = matrix.addCity(arrCiudades, eachLine[0]);
				arrCiudades = matrix.addCity(arrCiudades, eachLine[1]);
			}
			System.out.println("\nLas diferentes ciudades ingresadas son: ");
			System.out.println(Arrays.toString(arrCiudades.toArray()));
			
			int filasColumnas = arrCiudades.size();
			long[][] matriz = new long[filasColumnas][filasColumnas];
			
			int cantAristas = arrDistancia.size();
			for (int i =0;i<cantAristas;i++) {
				String origen = arrOrigen.get(i);
				String destino = arrDestino.get(i);
				int distancia = Integer.parseInt(arrDistancia.get(i));
				int indxOrigen = arrCiudades.indexOf(origen);
				int indxDestino = arrCiudades.indexOf(destino);
				matriz[indxOrigen][indxDestino] = (long) distancia;
			}
			
			
			
			//llenar matriz 
			for(int i = 0;i<filasColumnas;i++) {
				for(int j=0;j<filasColumnas;j++) {
					if(matriz[i][j]==0 && i!=j) {
						matriz[i][j] = 999999999;
					}
				}
			}
			
			System.out.println("\nLa matriz de adyacencia es la siguiente: ");
			for(long mtrz[]:matriz) {
				System.out.println(Arrays.toString(mtrz));
			}
			
			Shortest shortest = new Shortest();
			System.out.println(shortest.floyd(matriz));
		}
		 buffRea.close();
	 }
	
}

