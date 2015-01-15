package framework.board;

public class Terrain {
	private String name;
	public static final String DEFAULT = "default";
	
	public Terrain(){
		this(Terrain.DEFAULT);
	}
	
	public Terrain(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
}
