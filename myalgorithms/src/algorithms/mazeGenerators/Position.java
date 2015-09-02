package algorithms.mazeGenerators;


//Position class,which holds (z,y,x) coordinates

public class Position{
	private int x,y,z;

	public Position() {
		this.x=0;
		this.y=0;
		this.z=0;
	}
	Position(int dimension,int rows,int columns)
	{
		z=dimension;
		y=rows;
		x=columns;
	}
	public Position(Position pos)
	{
		this.x=pos.getX();
		this.y=pos.getY();
		this.z=pos.getZ();
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setZ(int z) {
		this.z = z;
	}
	public int getZ() {
		return z;
	}
	public void setPosition(int x,int y,int z)
	{
		this.x=x;
		this.y=y;
		this.z=z;
	}
	public void changeX(int n)
	{
		this.x+=n;
	}
	public void changeY(int n)
	{
		this.y+=n;
	}
	public void changeZ(int n)
	{
		this.z+=n;
	}
	public String toString()    //override toString object method
	{
		return String.format("{%d,%d,%d}", getZ(),getY(),getX());
	}

}
