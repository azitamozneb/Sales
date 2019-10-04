import java.lang.reflect.Array;

import javax.swing.JOptionPane;
public class Sales {

	public static void main(String[] args) {
		final int ONE_WEEK = 7;
		double[] sales = new double[ONE_WEEK];
		//get the week's sales figures.
		getValues(sales);
		SalesData week = new SalesData(sales);
		JOptionPane.showMessageDialog(null, String.format("The total sales were $%,.2f\n" +
		"The average sales were $%,.2f\n" + 
				"The highest sales were $%,.2f\n" + 
		"The lowest sales were $%,.2f\n",week.getTotal(),
		week.getAverage(),
		week.getHighest(),
		week.getLowest()));
		System.exit(0);
		
		
	}

	private static void getValues(double[] array) {
		String input;
		for (int i=0; i< array.length;i++)
		{
			input=JOptionPane.showInputDialog("Enter the sales for day " +(i+1) +".");
			array[i]=Double.parseDouble(input);
		}
	}
}
//***************************************************************************************

public class SalesData {
	private double[] sales;
	public SalesData(double[] sal)
	{
		//create an array as large as sal.
		sales = new double[sal.length];
		//copy the elements from s to sales.
		for(int i=0; i<sal.length;i++)
			sales[i]=sal[i];
	}
	
	public double getTotal() {
		double total=0.0;
		for(int i=0; i<sales.length;i++)
			total += sales[i];
		return total;
		
	}
	public double getHighest()
	{
		double highest=sales[0];
		for(int i=0; i<sales.length; i++)
			if (sales[i]>highest)
				highest = sales[i];
		return highest;
	
	}

	public double getAverage()
	{
		return getTotal() / sales.length;
	}
	public double getLowest()
	{
		double lowest=sales[0];
		for(int i=0; i<sales.length; i++)
			if (sales[i]>lowest)
				lowest = sales[i];
		return lowest;
	}
}
