package countries_sms_price;

import java.util.HashMap;
import java.util.Locale;
//import java.util.concurrent.atomic.DoubleAdder;
import java.util.Map.Entry;

import static java.lang.System.out;

import java.text.NumberFormat;

public class CountriesSmsPrice
{
	static class Country
	{
		public String iso3;
		public String iso2;
		public int count;
		public double smsPrice;
	}

	public static void main( String[] args )
	{
		String countriesFile = "/home/cyrille/Taf/CEFIM/CEFIM_2019-1/eclipse.workspace/countries_sms_price/data/countries.csv";
		String smsPricesFile = "/home/cyrille/Taf/CEFIM/CEFIM_2019-1/eclipse.workspace/countries_sms_price/data/nexmo_outbound_sms.csv";

		HashMap<String, Country> countries = loadCountries(countriesFile);
		loadSmsPrices(countries, smsPricesFile);

		// Java 8 Collection.Stream
		countries.entrySet().parallelStream()
			.map( (/*Entry<String, Country>*/ e) -> { return e.getKey() + " : " + e.getValue().smsPrice+"€"; } )
			.sorted()
			.forEach(System.out::println);

		out.println("countries count: " + countries.keySet().size());

		stats01( countries );
		//stats02( countries );
		
	}

	private static void stats02( HashMap<String, Country> countries )
	{
		countries.keySet().stream().mapToDouble( key -> countries.get(key).smsPrice ).sum();
	}

	static void stats01( HashMap<String, Country> countries )
	{
		class Stats
		{
			public double totalPrice = 0;
			public int totalSms = 0;
			public double pricesSum = 0;
			public String toString()
			{
				NumberFormat bf = NumberFormat.getInstance(Locale.FRENCH);
				bf.setMaximumFractionDigits(4);
				return 
						"total price: " + bf.format(this.totalPrice) + "\n"
						+ "total sms: " + bf.format(this.totalSms) 
						//+ "" + bf.format(this.pricesSum) + "\n"
						;
			}
		};
		Stats stats = new Stats();

		// double totalPrice
		// DoubleAdder totalPrice = new DoubleAdder();
		countries.forEach(( k, c ) ->
		{
			stats.totalPrice += c.count * c.smsPrice;
			stats.totalSms += c.count;
			stats.pricesSum += c.smsPrice;
		});

		out.println( stats );

	}

	private static void loadSmsPrices( HashMap<String, Country> countries, String smsPricesFile )
	{
		new CSVReader(smsPricesFile).read(( linesCount, line ) ->
		{
			Country c = countries.get(line.get(0));
			if( c == null )
				return;
			if( c.smsPrice > 0 )
			{
				/*
				// [CA, Canada, 302940, , Wightman Telecom, 1, 0,0057, 2016-10-31 14:00] / 0.01068
				double d = Double.parseDouble(line.get(6).replace(',', '.'));
				if( d != c.smsPrice )
				{
					out.println( line +" / " + c.smsPrice);
				}*/
				return ;				
			}
			c.smsPrice = Double.parseDouble(line.get(6).replace(',', '.'));
		});
	}

	/**
	 * Charge les dpnnées "countries" depuis un fichier csv.
	 * 
	 * @param countriesFile
	 * @return
	 */
	private static HashMap<String, Country> loadCountries( String countriesFile )
	{
		// < Java7: HashMap<String,HashMap> countries = new HashMap<String, HashMap<?,
		// ?>>();
		HashMap<String, Country> countries = new HashMap<>();
		new CSVReader(countriesFile).read(( linesCount, line ) ->
		{
			// out.println(linesCount + " : " + line);
			Country c = new Country();
			c.iso3 = line.get(0);
			c.iso2 = line.get(1);
			c.count = Integer.parseInt(line.get(2));
			countries.put(c.iso2, c);
		});
		return countries;
	}

}
