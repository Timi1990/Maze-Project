package algorithms.mazeGenerators;


//Class for initialization maze arguments
//Created for comfort and future code programming

public class InitMazeArguments {
	private int _dimension=0;
	private int _rows = 0;
	private int _columns = 0;

	public int get_dimension()
	{
		return _dimension;
	}
	public void set_dimension(int _dimension)
	{
		this._dimension=_dimension;
	}
	public int get_rows() {
		return _rows;
	}

	public void set_rows(int _rows) {
		this._rows = _rows;
	}

	public int get_columns() {
		return _columns;
	}

	public void set_columns(int _columns) {
		this._columns = _columns;
	}
}
