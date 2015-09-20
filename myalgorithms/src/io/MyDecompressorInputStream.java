package io;

import java.io.IOException;
import java.io.InputStream;

public class MyDecompressorInputStream extends InputStream {
	
	InputStream in;
	public MyDecompressorInputStream(InputStream other) {
		this.in=other;
	}
	public int read(byte[] b) throws IOException
	{
		for(int i=0;i<9;i++)
		{
			b[i]=(byte) in.read();
		}
		int index=9;
		while(index<b.length)
		{
			int symbol=in.read();
			int amount=in.read();
			if(symbol==-1||amount==-1)
			{
				while(index<b.length)
				{
					b[index]=1;
					index++;
				}
				return 0;
			}
			for(int i=index;i<index+amount;i++)
			{
				b[i]=(byte)symbol;
			}
			index+=amount;
		}
		return 0;
	}
	@Override
	public int read() throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
