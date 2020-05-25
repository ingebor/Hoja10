/**
 * 
 */

/**
 * @author Ingebor Rubio
 *
 */
public class Shortest {
	
	public String floyd(long [][] pesos) {
		int cantVer = pesos.length;
		long mtrzPesos[][] = pesos;
		String ways[][]= new String[cantVer][cantVer];
		String auxWays[][] = new String[cantVer][cantVer];
		String wayR = "";
		String chain = "";
		String shortWay = "";
		int i;
		int j;
		int k;
		float temp1;
		float temp2;
		float temp3;
		float temp4;
		float temp5; //Este sera para el camino mas corto
		
		//inicializar matrices
		for(i = 0; i<cantVer;i++) {
			for(j=0;j<cantVer;j++) {
				ways[i][j] = "";
				auxWays[i][j]="";
			}
		}
		
		
		for(k=0;k<cantVer;k++) {
			for(i=0;i<cantVer;i++) {
				for(j=0;j<cantVer;j++) {
					temp1=mtrzPesos[i][j];
					temp2=mtrzPesos[i][k];
					temp3=mtrzPesos[k][j];
					temp4=temp2+temp3;
					
					temp5=Math.min(temp1, temp4);
					if(temp1!=temp4) {
						if(temp5==temp4) {
							wayR="";
							auxWays[i][j]=k+"";
							ways[i][j]=caminosR(i,k,auxWays,wayR)+(k+1);
						}
					}
					mtrzPesos[i][j]=(long)temp5;
				}
			}
		}
		//Agregar el camino minimo
		for(i = 0; i<cantVer;i++) {
			for(j=0;j<cantVer;j++) {
				chain=chain+"["+mtrzPesos+"]";
			}
			chain=chain+"\n";
		}
		
		for(i = 0; i<cantVer;i++) {
			for(j=0;j<cantVer;j++) {
				if(mtrzPesos[i][j]!=1000000000) {
					if(i!=j) {
						if(ways[i][j].equals("")) {
							shortWay = shortWay + "De (" + (i+1)+"--->" + (j+1)+") Ir por ("+(i+1)+", "+(j+1)+")\n";
						}
						else {
							shortWay = shortWay + "De (" + (i+1)+"--->"+(j+1)+") Ir por ("+(i+1)+", "+ways[i][j]+", "+(j+1)+")\n";
						}
					}
				}
			}
		}
		
		return "\nLos diferentes caminos mas cortos entre vertices son:\n"+shortWay;
	}
	
	public String caminosR(int i, int k,String[][] auxWays,String wayR) {
		if(auxWays[i][k].equals("")) {
			return "";
		}
		else {
			//recursividad
			wayR += caminosR(i, Integer.parseInt(auxWays[i][k].toString()), auxWays, wayR)+(Integer.parseInt(auxWays[i][k].toString())+1)+", ";
			return wayR;
		}
	}
	
	
	
	
}
