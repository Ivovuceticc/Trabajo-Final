package Persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public final class PersistenciaBin implements IPersistencia<Serializable>
{
	private FileOutputStream fileout;
	private FileInputStream filein;
	private ObjectOutputStream objout = null;
	private ObjectInputStream objin = null;
	
	@Override
	public void abrirInput(String nombre) throws IOException
	{
		filein = new FileInputStream(nombre);
		objin = new ObjectInputStream(filein);
	}

	@Override
	public void abrirOutput(String nombre) throws IOException
	{
		fileout = new FileOutputStream(nombre);
		objout = new ObjectOutputStream(fileout);
	}

	@Override
	public void cerrarInput() throws IOException
	{
		if(objin != null)
			objin.close(); 
	}

	@Override
	public void cerrarOutput() throws IOException
	{
		if(objout != null)
			objout.close();
	}

	@Override
	public void escribir(Serializable objeto) throws IOException
	{
		if(objout != null)
			objout.writeObject(objeto);
	}

	@Override
	public Serializable leer() throws IOException, ClassNotFoundException
	{	
		Serializable objSerializable = null;
		if(objin != null)
			objSerializable = (Serializable)objin.readObject();
		
		return objSerializable; 
	}

}
