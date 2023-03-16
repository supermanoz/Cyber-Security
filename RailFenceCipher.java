import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
class RailFenceCipher
{
	static String msg;
	static int railno;
	static ArrayList<Character> al;
	public static void main(String [] args)
	{
		Scanner s1=new Scanner(System.in);
		al=new ArrayList<Character>();
		railno=2;
		System.out.println("Enter the message: ");
		msg=s1.nextLine();
		char m[]=msg.toCharArray();
		System.out.print("Cipher: ");
		int count=0;
		for(char a:m)
		{
			if(count%railno==0)
			{
				System.out.print(msg.charAt(count));
				count++;
			}
			else{
				al.add(a);
				count++;
			}
		}
		Iterator itr=al.iterator();
		while(itr.hasNext())
			System.out.print(itr.next());
	}
}