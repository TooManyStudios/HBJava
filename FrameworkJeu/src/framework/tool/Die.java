package framework.tool;

public class Die<T> {
	private T [] faces; 
 
	 public Die(T[] faces) {
		 this.faces = faces;	 
	 }
	 
	public int getSize() {
		return faces.length;
	}

	public T roll() {
		int index = (int)(Math.random()*getSize());
		return faces[index];
	}

}
