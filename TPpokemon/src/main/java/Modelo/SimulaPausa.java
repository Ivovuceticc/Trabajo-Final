package Modelo;

import java.util.Random;

public class SimulaPausa
{
	private static Random r = new Random();

	public static void espera()
	{	
		try
		{
			Thread.sleep(r.nextInt(1000));
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
