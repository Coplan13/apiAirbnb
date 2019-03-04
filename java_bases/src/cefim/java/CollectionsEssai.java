package cefim.java;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;
import java.util.Vector;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Function;
import java.util.function.LongConsumer;
import java.util.function.Supplier;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.stream.LongStream ;

public class CollectionsEssai
{

	@SuppressWarnings("rawtypes")
	public static void main(String[] args)
	{
		essai01(new ArrayList());
		essai01(new LinkedList());

		essai02(new HashSet<String>() );
		essai02(new TreeSet<String>() );
		
		//System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "8");
		essai03( 5345);
		//essai03( 1045);

		essai04();
		
		out.println("=== END ===");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	static void essai01( List liste  )
	{
		out.println("=== essais01 ===");

		for( int i = 10; i > 0; i-- )
		{
			liste.add(i);
		}

		for( Object element : liste )
		{
			System.out.print(element + ",");
		}
		out.println();

		liste.forEach(
				ele -> out.print( ele+"," )
		);
		out.println();
		
		System.out.println();

	}

	static void essai02(Collection<String> coll)
	{
		out.println("=== essais02 ===");

		coll.add("CCCCC");
		coll.add("BBBBB");
		coll.add("BBBBB");
		coll.add("DDDDD");
		coll.add("AAAAA");

		/*Iterator<String> iterator = coll.iterator();
		while( iterator.hasNext() )
		{
			System.out.println(iterator.next());
		}*/
		for( String s : coll )
		{
			System.out.println(s);
		}
	}
	
	public static class Chrono {
		long start ;
		long end ;
		Chrono()
		{
			this.start();
		}
		void start()
		{
			this.start = System.nanoTime();
			this.end = 0 ;
		}
		Chrono stop()
		{
			this.end = System.nanoTime();
			return this ;
		}
		long ellapsed()
		{
			return (this.end > 0 ? this.end : System.nanoTime()) - this.start ;
		}
		long ellapsedMs()
		{
			return this.ellapsed() / (1000 * 1000);
		}
		long ellapsedS()
		{
			return this.ellapsedMs() / 1000  ;
		}
	}

	static final long primesCount = 8_000_000 ;

	/**
	 * System property to defined pool threads count.
	 * java -Djava.util.concurrt.ForkJoinPool.common.parallelism=8 -classpath ./bin cefim.java.CollectionsEssai
	 * @param blabla
	 */
	static void essai03( int blabla )
	{
		out.println("=== essais03 ===");
		out.println( "ForkJoinPool.common.parallelism: "+System.getProperty("java.util.concurrent.ForkJoinPool.common.parallelism") );

		Chrono c = new Chrono();

		out.println("with ...");
		c.start();
		searchPrimes1();
		out.println( c.stop().ellapsedMs() +"ms ("+c.ellapsedS() +"s)");


		out.println("with ...");
		c.start();
		searchPrimes1();
		out.println( c.stop().ellapsedMs() +"ms ("+c.ellapsedS() +"s)");

		return ;
	}

	static void essai04()
	{
		out.println("=== essais04 ===");

		Chrono c = new Chrono();

		out.println("with parallel...");
		c.start();
		searchPrimes( 1);
		out.println( c.stop().ellapsedMs() +"ms ("+c.ellapsedS() +"s)");

		out.println("with parallel...");
		c.start();
		searchPrimes( 8);
		out.println( c.stop().ellapsedMs() +"ms ("+c.ellapsedS() +"s)");

		out.println("with parallel...");
		c.start();
		searchPrimes( 1);
		out.println( c.stop().ellapsedMs() +"ms ("+c.ellapsedS() +"s)");

	}

	static void searchPrimes1()
	{
		out.println( "searchPrimes1()");

			List<Long> list = 
			    LongStream.range(1, primesCount)
			    	.parallel()
			    	.filter(CollectionsEssai::isPrime)
			    	.map(Long::valueOf)
			    	.boxed()
			    	.collect(Collectors.toList())
			    	;
			out.println( list.size() );
	}

	static void searchPrimes( int threadsCount )
	{
		out.println( "searchPrimes() "+threadsCount+" threads...");
		try
		{
			List<Long> list = (new ForkJoinPool(threadsCount)).submit( () ->
			    LongStream.range(1, primesCount)
			    	.parallel()
			    	.filter(CollectionsEssai::isPrime)
			    	.map(Long::valueOf)
			    	.boxed()
			    	.collect(Collectors.toList( ))
			).get();
			out.println( list.size() );
		}
		catch( InterruptedException | ExecutionException e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

  public static boolean isPrime(long n) {
    return n > 1 && LongStream.rangeClosed(2, (long) Math.sqrt(n)).noneMatch(divisor -> n % divisor == 0);
}
}
