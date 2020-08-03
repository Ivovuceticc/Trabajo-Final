package Modelo;

import java.util.Random;

public class SimulaPausa
{
	private static Random r = new Random();
	private static final int esperaMax = 3000;
	
	public static void espera()
	{	
		try
		{
			Thread.sleep(r.nextInt(SimulaPausa.esperaMax));
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	public static int getEsperamax()
	{
		return esperaMax;
	}
	
	
}
