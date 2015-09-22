package io;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.MazeArgumentsForInit;
import algorithms.mazeGenerators.MyMaze3dGenerator;

import java.io.*;

public class Stammain
{

    public static void main(String[] args)
    {
        MazeArgumentsForInit mazeArgumentsForInit = new MazeArgumentsForInit(7, 10, 4);
        Maze3d maze = new MyMaze3dGenerator().generate(mazeArgumentsForInit);
        maze.printMaze();
        try
        {
            OutputStream out = new MyCompressorOutputStream(new FileOutputStream("maze.maz"));
            out.write(maze.toByteArray());
            out.flush();
            out.close();
            InputStream in = new MyDecompressorInputStream(new FileInputStream("maze.maz"));
            byte[] b = new byte[maze.toByteArray().length];
            in.read(b);
            in.close();
            Maze3d loaded = new Maze3d(b);
            loaded.printMaze();

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }


    }

}
