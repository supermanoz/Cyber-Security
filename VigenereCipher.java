import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
class VigenereCipher
{
	static String key;
	static String msg;
	static ArrayList<Integer> list;
	static ArrayList<Integer> li;
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		list=new ArrayList<Integer>();
		li=new ArrayList<Integer>();
		key="point";
		System.out.println("Enter the message: ");
		msg=s.nextLine();
		char[] m=msg.toCharArray();
		for(char a:m)
		{
			list.add(charToInt(a));
		}
		int count=1;
		Iterator itr=list.iterator();
		while(itr.hasNext())
		{
			if(count==1){
				li.add(((int)itr.next()+charToInt(key.charAt(0))));
				count++;
			}
			else if(count==2){
				li.add(((int)itr.next()+charToInt(key.charAt(1))));
				count++;
			}
			else if(count==3){
				li.add(((int)itr.next()+charToInt(key.charAt(2))));
				count++;
			}
			else if(count==4){
				li.add(((int)itr.next()+charToInt(key.charAt(3))));
				count++;
			}
			else{
				li.add(((int)itr.next()+charToInt(key.charAt(4))));
				count=1;
			}
		}
		Iterator itr1=li.iterator();
		System.out.print("Cipher: ");
		while(itr1.hasNext())
		{
			System.out.print(intToChar((int)itr1.next()%26));
		}
	}

	public static int charToInt(char c)
	{
			if(c=='a' || c=='A')
				return 0;
			else if(c=='b' || c=='B')
				return 1;
			else if(c=='c' || c=='C')
				return 2;
			else if(c=='d' || c=='D')
				return 3;
			else if(c=='e' || c=='E')
				return 4;
			else if(c=='f' || c=='F')
				return 5;
			else if(c=='g' || c=='G')
				return 6;
			else if(c=='h' || c=='H')
				return 7;
			else if(c=='i' || c=='I')
				return 8;
			else if(c=='j' || c=='J')
				return 9;
			else if(c=='k' || c=='K')
				return 10;
			else if(c=='l' || c=='L')
				return 11;
			else if(c=='m' || c=='M')
				return 12;
			else if(c=='n' || c=='N')
				return 13;
			else if(c=='o' || c=='O')
				return 14;
			else if(c=='p' || c=='P')
				return 15;
			else if(c=='q' || c=='Q')
				return 16;
			else if(c=='r' || c=='R')
				return 17;
			else if(c=='s' || c=='S')
				return 18;
			else if(c=='t' || c=='T')
				return 19;
			else if(c=='u' || c=='U')
				return 20;
			else if(c=='v' || c=='V')
				return 21;
			else if(c=='w' || c=='W')
				return 22;
			else if(c=='x' || c=='X')
				return 23;
			else if(c=='y' || c=='Y')
				return 24;
			else
				return 25;
	}

	public static char intToChar(int n)
	{
		if(n==0)
			return 'a';
		else if(n==1)
			return 'b';
		else if(n==2)
			return 'c';
		else if(n==3)
			return 'd';
		else if(n==4)
			return 'e';
		else if(n==5)
			return 'f';
		else if(n==6)
			return 'g';
		else if(n==7)
			return 'h';
		else if(n==8)
			return 'i';
		else if(n==9)
			return 'j';
		else if(n==10)
			return 'k';
		else if(n==11)
			return 'l';
		else if(n==12)
			return 'm';
		else if(n==13)
			return 'n';
		else if(n==14)
			return 'o';
		else if(n==15)
			return 'p';
		else if(n==16)
			return 'q';
		else if(n==17)
			return 'r';
		else if(n==18)
			return 's';
		else if(n==19)
			return 't';
		else if(n==20)
			return 'u';
		else if(n==21)
			return 'v';
		else if(n==22)
			return 'w';
		else if(n==23)
			return 'x';
		else if(n==24)
			return 'y';
		else if(n==25)
			return 'z';
		else
			return ' ';
	}
}