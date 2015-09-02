package io;

import java.io.IOException;
import java.io.OutputStream;

public class MyCompressorOutputStream extends OutputStream {
	
	OutputStream out;
	public MyCompressorOutputStream(OutputStream other) {
		this.out=other;
		
	}
	public void write(byte[] b)
	{
		
	}
	@Override
	public void write(int arg0) throws IOException {
		// TODO Auto-generated method stub

	}

}
