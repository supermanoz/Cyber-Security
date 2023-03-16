import java.util.Scanner;
import java.lang.Math;
import java.util.ArrayList;
class rsa
{
	static ArrayList<Integer> factors,pows;
	public static void main(String [] args)
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter p,q,m: ");
		long p=s.nextInt();
		long q=s.nextInt();
		long m=s.nextInt();
		long n=p*q;
		long totient=(p-1)*(q-1);
		System.out.println("n: "+n);
		System.out.println("totient: "+totient);
		factors=new ArrayList<Integer>();
		pows=new ArrayList<Integer>();
		findFactors(totient);
		System.out.print("Factos of Totient ( "+totient+" ): ");
		for(long a:factors)
		{
			System.out.print(a+", ");
		}
		System.out.println();
		long e=getE(totient);
		System.out.println("e: "+e);
		long d=getD(e,totient);
		System.out.println("d: "+d);
		long c=enc(m,n,e);
		System.out.println("c: "+c);
		System.out.println("Deciphered c: "+dec(c,n,d));
	}

	public static long getE(long tot)
	{
		long e=2;
		long count=0;
		while(e<tot)
		{
			count=0;
			for(long a:factors)
			{
				if(e==a)
					count++;
			}
			if(count==0)
				return e;
			e++;
		}
		return 0;
	}

	public static void findFactors(long totient)
	{
		for(int i=2;i<totient;i++)
		{
			if(totient%i==0)
			{
				factors.add(i);
			}
		}
	}

	public static long getD(long e,long tot)
	{
		long i=0;
		long d=1;
		while(i==0)
		{
			if((d*e)%tot==1 && d!=e)
			{
				return d;
			}
			else
			{
				d++;
			}
		}
		return 0;
	}

	public static long enc(long m, long n, long e)
	{
		long res=(long)Math.pow(m,e);
		long c=res%n;
		return c;
	}

	public static long dec(long c, long n, long d)
	{
		long res=1;;
		recur(c,d);
		for(int a:pows)
		{
			res=((long)Math.pow(c,a)%n)*res;
		}
		System.out.println(res);
		return res%n;
	}

	public static void recur(long c,long d)
	{
		if((Math.pow(c,d))<Long.MAX_VALUE)
			pows.add((int)d);
		else
		{
			recur(c,d/2);
			recur(c,d-d/2);
		}
	}
}