package algorithms.mazeGenerators;

//Index out of bounds exception class->extends Exception class, throws String message when catches.

public class IndexOutOfBoundsException extends Exception
{

    private String boundsMessage;

    public IndexOutOfBoundsException(String outOfBounds)
    {
        this.boundsMessage = outOfBounds;
    }

    public String getBoundsMessage()
    {
        return boundsMessage;
    }


}
