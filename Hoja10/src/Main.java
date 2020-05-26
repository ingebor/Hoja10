import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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
		
		boolean frstFlag = true;
		while (frstFlag) {
			if(archive.exists()) {
				Scanner readInt = new Scanner(System.in);
				Scanner readString = new Scanner(System.in);
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
				
				
				Shortest shortest = new Shortest();
				String caminosCortos = shortest.floyd(matriz,arrCiudades);
				String[] eachWay = caminosCortos.split("/");
				/*for(int i= 0;i<eachWay.length;i++) {
					System.out.println(eachWay[i]);
				}*/
				
				boolean flag = true;
				while(flag) {
					System.out.println("Que desea realizar?\n1. Calcular ruta mas corta\n2. Calcular el centro del grafo"
							+ "\n3. Modificar una conexion entre ciudades\n4. Mostrar matriz de adyacencia\n5. Salir");
					try {
						int option = readInt.nextInt();
						if(option<1||option>5) {
							throw new Exception();
						}
						else if (option == 1) {
							System.out.println("--En caso de que tome mas de una ciudad llegar al destino, se le mostrara el numero que le corresponde a la"
									+ " ciudad intermedia, el cual puede encontrarse en el listado de ciudades mostrado inicialmente\n"
									+ "--Si no hay un camino establecido entre el origen y el destino ingresados, se le consultara de nuevo los mismos\n");
							boolean flag1Camino = true;
							while(flag1Camino) {
								System.out.println("Ingrese el nombre de la ciudad de **origen** exactamente como lo hizo en el archivo de texto: ");
								String deOrigen = readString.nextLine();
								boolean loContiene = arrCiudades.contains(deOrigen);
								if(loContiene) {
									System.out.println("Ingrese el nombre de la ciudad de **destino** exactamente como lo hizo en el archivo de texto: ");
									String aDestino = readString.nextLine();
									boolean contieneDestino = arrCiudades.contains(aDestino);
									if(contieneDestino) {
										try {
										for(int i= 0;i<eachWay.length;i++) {
											String[] tempEachWay = eachWay[i].split(" ");
												if(tempEachWay[1].equals(deOrigen) && tempEachWay[3].equals(aDestino)) {
													System.out.println(eachWay[i]);
													contieneDestino = false;
													loContiene = false;
													flag1Camino = false;
												}
												else {
												}
											}
										}
										catch(Exception e) {
											System.out.println(" ");
										}
									}
									else {
										System.out.println("\nPor favor ingrese una ciudad que se encuentre en los datos ingresados originalmente");
									}
								}
								else {
									System.out.println("\nPor favor ingrese una ciudad que se encuentre en los datos ingresados originalmente");
								}
							}
						}
						else if (option == 2) {
							System.out.println("El centro del grafo es: ");
							System.out.println(matrix.findCenter(matriz, arrCiudades));
							System.out.println("\n");
						}
						else if (option == 3) {
							boolean thrdFlag = true;
							while(thrdFlag) {
								System.out.println("Ingrese el motivo: \n1. Este camino se encuentra obstruido\n2. Deseo actualizar la distancia\n3. Regresar al menu");
								try {
									int scndOption = readInt.nextInt();
									if(scndOption<1||scndOption>3) {
										throw new Exception();
									}
									else if(scndOption ==1) {
										boolean frthFlag = true;
										while(frthFlag) {
											System.out.println("Ingrese el nombre de la ciudad de **origen** exactamente como lo hizo en el archivo de texto: ");
											String deOrigen = readString.nextLine();
											boolean loContiene = arrCiudades.contains(deOrigen);
											if(loContiene) {
												System.out.println("Ingrese el nombre de la ciudad de **destino** exactamente como lo hizo en el archivo de texto: ");
												String aDestino = readString.nextLine();
												boolean contieneDestino = arrCiudades.contains(aDestino);
												if(contieneDestino) {
													int numOrigen = arrCiudades.indexOf(deOrigen);
													int numDestino = arrCiudades.indexOf(aDestino);
													for(int i = 0;i<filasColumnas;i++) {
														for(int j=0;j<filasColumnas;j++) {
															if(i==numOrigen && j == numDestino) {
																matriz[i][j] = 999999999;
																contieneDestino = false;
																loContiene = false;
																frthFlag = false;
															}
														}
													}
												}
												else {
													System.out.println("Por favor ingrese una ciudad que se encuentre en los datos ingresados originalmente");
												}
											}
											else {
												System.out.println("Por favor ingrese una ciudad que se encuentre en los datos ingresados originalmente");
											}
										}
									}
									else if (scndOption == 2) {
										boolean frthFlag = true;
										while(frthFlag) {
											System.out.println("Ingrese el nombre de la ciudad de **origen** exactamente como lo hizo en el archivo de texto: ");
											String deOrigen = readString.nextLine();
											boolean loContiene = arrCiudades.contains(deOrigen);
											if(loContiene) {
												System.out.println("Ingrese el nombre de la ciudad de **destino** exactamente como lo hizo en el archivo de texto: ");
												String aDestino = readString.nextLine();
												boolean contieneDestino = arrCiudades.contains(aDestino);
												if(contieneDestino) {
													int numOrigen = arrCiudades.indexOf(deOrigen);
													int numDestino = arrCiudades.indexOf(aDestino);
													System.out.println("Ingrese la nueva distancia: ");
													try {
														long nuevDist = readInt.nextLong();
														for(int i = 0;i<filasColumnas;i++) {
															for(int j=0;j<filasColumnas;j++) {
																if(i==numOrigen && j == numDestino) {
																	matriz[i][j] = nuevDist;
																	contieneDestino = false;
																	loContiene = false;
																	frthFlag = false;
																}
															}
														}
													}
													catch(Exception e) {
														System.out.println("No ha ingresado un valor correcto, intente de nuevo por favor");
														contieneDestino=false;
														loContiene = false;
														frthFlag=false;
														thrdFlag=false;
														flag = false;
													}
												}
												else {
													System.out.println("Por favor ingrese una ciudad que se encuentre en los datos ingresados originalmente");
													frthFlag=false;
												}
											}
											else {
												System.out.println("Por favor ingrese una ciudad que se encuentre en los datos ingresados originalmente");
											}
										}
									}
									
									else if(scndOption == 3) {
										thrdFlag = false;
									}
								}
								catch(Exception e) {
									System.out.println("No ha ingresado un dato correcto, intente de nuevo por favor");
									thrdFlag=false;
									flag = false;
									frstFlag = false;
									
								}
							}
						}
						else if(option == 4) {
							System.out.println("\nLa matriz de adyacencia es la siguiente: ");
							for(long mtrz[]:matriz) {
								System.out.println(Arrays.toString(mtrz));
							}
						}
						else if(option==5) {
							flag = false;
							frstFlag=false;
						}
						
					}
					catch(Exception e) {
						System.out.println("No ha ingresado un dato valido, intentelo de nuevo por favor");
						flag = false;
						frstFlag = false;
					}
				}
				
			}
		}
		 buffRea.close();
	 }
	
}

