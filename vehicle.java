package testing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class vehicle
{
	private int cc;
	private int modelno;
	public vehicle()
	{}
	public vehicle(int cc,int model)
	{
		this.cc=cc;
		this.modelno=model;
	}
	
}
class car extends vehicle
{
	String cat;
	public car(){}
	public car(String s,int cc, int model )
	{
		super(cc,model);
		this.cat=s;
	}
}
/*class bike extends vehicle
{
	int gears;
	public bike(){}
	public bike(int g,int cc, int model )
	{
		super(cc,model);
		this.gears=g;
	}
}*/
class running
{
	public static void main (String args[])
	{
		try
		{
			fileop fp=new fileop();
			PrintWriter pw = new PrintWriter("C:\\Users\\mosharif\\Desktop\\car.txt");
			for(;;)
			{
					System.out.println("enter 1.insert\t 2.delete ");
					Scanner in=new Scanner(System.in);
					int ch=in.nextInt();
					switch(ch)
					{
					case 1: System.out.println("enter the no of cars");
							int n=in.nextInt();
							for(int i=0;i<n;i++)
							{
							System.out.println("enter car category");
							String cat=in.next();
							System.out.println("enter car cc");
							int cc=in.nextInt();
							System.out.println("enter car model no");
							int model=in.nextInt();
							car obj=new car(cat,cc,model);
							pw.println(cat+":" + cc + ":" +model);
							}
							pw.close();
							break;
					case 2: System.out.println("enter the car to be deleted");
					String title=in.next();
					System.out.println(title);
					try
					{
					File inputFile = new File("C:\\Users\\mosharif\\Desktop\\car.txt");
							File tempFile = new File("C:\\Users\\mosharif\\Desktop\\tempfile.txt");

						BufferedReader br = new BufferedReader (new FileReader("C:\\Users\\mosharif\\Desktop\\car.txt"));
					 PrintWriter Pwr = new PrintWriter(new FileWriter (tempFile));
					 String line = null;
					 while((line = br.readLine()) !=null) {
					     if(line.trim().equals(title))
					     {
					         continue;
					         }
					     else
					     {
					         Pwr.println(line);
					         Pwr.flush();

						}
				}
					 br.close();
					 Pwr.close();
					 in.close();

					 // delete book file before renaming temp
					 inputFile.delete();

					 // rename temp file back to books.txt
					 if(tempFile.renameTo(inputFile)){
					        System.out.println("Update succesful");
					    }else{
					        System.out.println("Update failed");
					    }
					}
				//catch( IOException e){
					//e.printStackTrace();
				//}
					finally
					{System.exit(0);
				}
				default:	System.exit(0);
					}
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}