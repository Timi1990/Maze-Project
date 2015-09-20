package io;

import java.io.IOException;
import java.io.OutputStream;

public class MyCompressorOutputStream extends OutputStream {
	
	OutputStream out;
	public MyCompressorOutputStream(OutputStream other) {
		this.out=other;
		
	}
	public void write(byte[] b) throws IOException
	{
		for(int i=0;i<9;i++)
		{
			out.write((int)b[i]);
		}
		int i=9,counter=0;
		int currentInt=b[i+1];
		while(i<b.length)
		{
			if(b[i]==currentInt)
			{
				counter++;
			}
			else
			{
				counter++;
				out.write(b[i]);
				out.write(counter);
				counter=0;
			}
			i++;
			if(i+1<b.length)
			currentInt=(int)b[i+1];    
			
			
		}
	}
	@Override
	public void write(int arg0) throws IOException {
//		out.write(arg0);
	}

}
