package cefim.java;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.LongFunction;
import static java.lang.System.out ;
import java.util.Comparator;

public class LambdaEssai {

	public static void main(String[] args)
	{
		essai01();
		essai02();
		essai03();
		essai04();
	}

	public static void essai01()
	{
		System.out.println(">>> essais01 <<<");

		List<String> strList = Arrays.asList("ABCDEF", "abc", "ABCD");

		strList.forEach( System.out::println );
	}

	public static void essai02()
	{
		System.out.println(">>> essais02 <<<");

		List<String> strList = Arrays.asList("ABCDEF", "abc", "ABCD");
		System.out.println(strList);

		strList.sort(
			(final String chaine1, final String chaine2)
			-> Integer.compare(chaine1.length(), chaine2.length())
		);

		System.out.println(strList);
	}

	@FunctionalInterface
	interface OperationEntiere
	{
		long effectuer(int a, int b);
	}

	public static void essai03()
	{
		System.out.println(">>> essais03 <<<");

		LongFunction<?> f1 = x -> x * 2;
		out.println( f1.apply(2) );

		OperationEntiere addition = (a, b) -> a + b;
		out.println( addition.effectuer(2,2) );

		OperationEntiere soustraction = (a, b) -> a - b;
		out.println( soustraction.effectuer(2,2) );

		OperationEntiere ope = (a, b) -> { long c = a - b; return c; };
		out.println( ope.effectuer(2,2) );
	}

	public static void essai04()
	{
		Function<Long, Long> doubler = (i) -> {
			long resultat = (long) i * 2;
			out.println("doubler=" + resultat);
			return resultat;
		};

		Function<Long, Long> laMoitie = (i) -> {
			long resultat = i / 2;
			System.out.println("laMoitie=" + resultat);
			return resultat;
		};

		out.println( doubler.andThen(laMoitie).apply(3L) );
		out.println( doubler.compose(laMoitie).apply(3L) );
		out.println( doubler.compose(laMoitie).andThen(laMoitie).apply(3L) );

	}

}
