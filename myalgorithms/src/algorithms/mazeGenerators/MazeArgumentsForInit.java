package algorithms.mazeGenerators;


//Class for initialization maze arguments
//Created for comfort and future code programming

public class MazeArgumentsForInit
{
    private int dimension;
    private int rows;
    private int columns;

    public MazeArgumentsForInit(int dimension, int rows, int columns)
    {
        this.dimension = dimension;
        this.rows = rows;
        this.columns = columns;
    }

    public int getDimension()
    {
        return dimension;
    }

    public void setDimension(int dimension)
    {
        this.dimension = dimension;
    }

    public int getRows()
    {
        return rows;
    }

    public void setRows(int rows)
    {
        this.rows = rows;
    }

    public int getColumns()
    {
        return columns;
    }

    public void setColumns(int columns)
    {
        this.columns = columns;
    }
}
