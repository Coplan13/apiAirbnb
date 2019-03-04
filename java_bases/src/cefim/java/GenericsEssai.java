package cefim.java;

import static java.lang.System.out;

public class GenericsEssai
{

	/**
	 * une classe Generic
	 * 
	 * @author cyrille
	 *
	 * @param <T1>
	 *          un 1er paramètre, de type "encore" inconnu.
	 * @param <T2>
	 *          un 2em paramètre ...
	 */
	static class GenericBidon<T1, T2>
	{
		private T1 param1;
		private T2 param2;

		public GenericBidon( T1 param1, T2 param2 ) {
			this.param1 = param1;
			this.param2 = param2;
		}

		public T1 getParam1()
		{
			return this.param1 ;
		}

		public T2 getParam2()
		{
			return this.param2;
		}
	}

	/**
	 * GenericBidon s'utilise avec des données de types différents. Le compilateur
	 * va "infèrer" les types pour vérifier le casting des opérations à suivre.
	 * 
	 * @param args
	 */
	public static void main( String[] args )
	{
		GenericBidon<Integer, String> bidon = new GenericBidon<Integer, String>(123, "abc");

		Integer p1 = bidon.getParam1(); // <- getParam1() retourne un Int
		String p2 = bidon.getParam2();
		out.println(p1 + " " + p2);

		GenericBidon<String, String> bidon2 = new GenericBidon<String, String>("abc", "abc");

		String p3 = bidon2.getParam1(); // <- getParam1() retourne un String
		p2 = bidon.getParam2();
		out.println(p3 + " " + p2);
	}

}
