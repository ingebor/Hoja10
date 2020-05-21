/**
 * 
 */

/**
 * @author Ingebor Rubio
 *
 */
public class Edges {
	private String start;
	private String whereTo;
	private int km;
	
	public Edges(String start,String whereTo,int km) {
		this.start= start;
		this.whereTo= whereTo;
		this.km = km;
	}

	public Edges() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the start
	 */
	public String getStart() {
		return start;
	}

	/**
	 * @param start the start to set
	 */
	public void setStart(String start) {
		this.start = start;
	}

	/**
	 * @return the whereTo
	 */
	public String getWhereTo() {
		return whereTo;
	}

	/**
	 * @param whereTo the whereTo to set
	 */
	public void setWhereTo(String whereTo) {
		this.whereTo = whereTo;
	}

	/**
	 * @return the km
	 */
	public int getKm() {
		return km;
	}

	/**
	 * @param km the km to set
	 */
	public void setKm(int km) {
		this.km = km;
	}
	
	
}
