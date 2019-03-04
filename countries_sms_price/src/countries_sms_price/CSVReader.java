package countries_sms_price;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader
{
	static final char DEFAULT_SEP = ',';
	static final int DEFAULT_HEADERLINES = 1;
	static final char DEFAULT_QUOTE ='"' ;

	protected String filename;
	protected char separator;
	protected int headerLines = DEFAULT_HEADERLINES;
	protected char customQuote = DEFAULT_QUOTE ;

	/**
	 * Could not create without a filename.
	 */
	protected CSVReader() {
	};

	public CSVReader( String filename ) {
		this(filename, DEFAULT_SEP);
	}

	public CSVReader( String filename, char separator ) {
		this.filename = filename;
		this.separator = separator;
	}

	public CSVReader separator( char sep )
	{
		this.separator = sep;
		return this;
	}

	/**
	 * Set heade lines count. Fluid interface.
	 * 
	 * @param headerLines
	 * @return CSVReader
	 */
	public CSVReader headerLines( int headerLines )
	{
		this.headerLines = headerLines;
		return this;
	}

	public ArrayList<String[]> readAll()
	{
		/*
		 * Avec Java 7, arrive l'operateur "diamon" : <>
		 */
		ArrayList<String[]> lines = new ArrayList<>();

		/*
		 * Avec Java 7, l'instruction try−with−resources. L'instruction try avec
		 * ressource permet de définir une ressource qui sera automatiquement fermée à
		 * la fin de l'exécution du bloc de code de l'instruction.
		 */
		try( BufferedReader br = new BufferedReader(new FileReader(this.filename)) )
		{
			while( lines.add(br.readLine().split( String.valueOf(this.separator))) )
				;
		}
		catch( IOException e )
		{
			e.printStackTrace();
		}

		return lines;
	}

	public interface RowListener
	{
		void onRow( int linesCount, List<String> line );
	}

	public void read( RowListener rowListener )
	{
		try( BufferedReader br = new BufferedReader(new FileReader(this.filename)) )
		{
			int linesCount = 0;
			String line = "";
			while( (line = br.readLine()) != null )
			{
				linesCount++;
				if( linesCount <= this.headerLines )
					continue;
				//String[] row = line.split(this.separator);
				List<String> row = parseLine( line, this.separator, this.customQuote );
				rowListener.onRow(linesCount, row);
			}

		}
		catch( IOException e )
		{
			e.printStackTrace();
		}

	}

	public static List<String> parseLine( String cvsLine , char separators, char customQuote)
	{

		List<String> result = new ArrayList<>();

		// if empty, return!
		if( cvsLine == null || cvsLine.isEmpty() )
		{
			return result;
		}

		StringBuffer curVal = new StringBuffer();
		boolean inQuotes = false;
		boolean startCollectChar = false;
		boolean doubleQuotesInColumn = false;

		char[] chars = cvsLine.toCharArray();

		for( char ch : chars )
		{
			if( inQuotes )
			{
				startCollectChar = true;
				if( ch == customQuote )
				{
					inQuotes = false;
					doubleQuotesInColumn = false;
				}
				else
				{
					// Fixed : allow "" in custom quote enclosed
					if( ch == '\"' )
					{
						if( !doubleQuotesInColumn )
						{
							curVal.append(ch);
							doubleQuotesInColumn = true;
						}
					}
					else
					{
						curVal.append(ch);
					}

				}
			}
			else
			{
				if( ch == customQuote )
				{

					inQuotes = true;

					// Fixed : allow "" in empty quote enclosed
					/*if( chars[0] != '"' && customQuote == '\"' )
					{
						curVal.append('"');
					}*/

					// double quotes in column will hit this!
					if( startCollectChar )
					{
						curVal.append('"');
					}

				}
				else if( ch == separators )
				{

					result.add(curVal.toString());

					curVal = new StringBuffer();
					startCollectChar = false;

				}
				else if( ch == '\r' )
				{
					// ignore LF characters
					continue;
				}
				else if( ch == '\n' )
				{
					// the end, break!
					break;
				}
				else
				{
					curVal.append(ch);
				}
			}

		}
		result.add(curVal.toString());
		return result;
	}
}
