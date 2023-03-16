import java.util.Scanner;
import java.util.Arrays;
class PlayfairCipher
{
	static char keyArray[];
	static char sortedKeyArray[];
	static char keyMatrix[][]=new char[5][5];
	public static void generateMatrix(){
		boolean cont=false;
		do{
			Scanner s=new Scanner(System.in);
			System.out.print("Enter the key:");
			String keyString=s.nextLine();
			keyString=keyString.toUpperCase();
			keyArray=keyString.toCharArray();
			sortedKeyArray=keyString.toCharArray();
			int count=0;
			for(int i=0;i<keyArray.length;i++){
				for(int j=0;j<keyArray.length;j++){
					if(keyArray[i]==(keyArray[j]))
						count++;
				}
			}
			if(count>keyArray.length){
				System.out.println("Key shouldn't contain duplicate letters!");
				cont=true;
			}
			else{
				cont=false;
				Arrays.sort(sortedKeyArray);
				for(char c:sortedKeyArray){
					if(c==74){
						System.out.println("Key shouldn't contain the letter 'J'!");
						cont=true;
					}
				}
			}
		}while(cont==true);

		int index=0;
		char alphabet=65;
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				if(index<keyArray.length){
					keyMatrix[i][j]=keyArray[index];
					index++;	
				}

				else if(alphabet==74){
					alphabet++;
					keyMatrix[i][j]=(char)alphabet;
					alphabet++;
				}

				else{
					for(char key:sortedKeyArray){
						if((char)alphabet==key){
							alphabet++;
						}
					}
					keyMatrix[i][j]=(char)alphabet;
					alphabet++;
				}
			}
		}

		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				System.out.print(keyMatrix[i][j]+"|");
			}
			System.out.println();
		}
	}

	public static String cipher(String plainText)
	{
		if(plainText.length()%2==1){
			plainText=plainText+"z";
		}
		plainText=plainText.replace('j','i');
		plainText=plainText.toUpperCase();
		System.out.println("Plain Text: "+plainText);
		char text[]=plainText.toCharArray();

		char cipher[]=new char[plainText.length()];

		int posA1=0;
		int posA2=0;
		int posB1=0;
		int posB2=0;
		int c=0;

		for(int k=0;k<plainText.length();k+=2)
		{
			for(int i=0;i<5;i++){
				for(int j=0;j<5;j++){
					if(keyMatrix[i][j]==text[k])
					{
						posA1=i;
						posA2=j;
					}
				}
			}

			for(int i=0;i<5;i++){
				for(int j=0;j<5;j++){
					if(keyMatrix[i][j]==text[k+1])
					{
						posB1=i;
						posB2=j;
					}
				}
			}

			//System.out.println(posA1+" "+posA2+" "+posB1+" "+posB2);

			if(posA2==posB2){
				if(posA1==4)
					cipher[c++]=keyMatrix[0][posA2];
				else
					cipher[c++]=keyMatrix[posA1+1][posA2];

				if(posB1==4)
					cipher[c++]=keyMatrix[0][posB2];
				else
					cipher[c++]=keyMatrix[posB1+1][posB2];
			}

			else if(posA1==posB1){
				if(posA2==4)
					cipher[c++]=keyMatrix[posA1][0];
				else
					cipher[c++]=keyMatrix[posA1][posA2+1];

				if(posB1==4)
					cipher[c++]=keyMatrix[posB1][0];
				else
					cipher[c++]=keyMatrix[posB1][posB2+1];
			}

			else{
				cipher[c++]=keyMatrix[posA1][posB2];
				cipher[c++]=keyMatrix[posB1][posA2];
			}
		}

		String cipheredText=new String(cipher);
		return cipheredText;

	}

	public static String decipher(String cipher)
	{
		cipher=cipher.toUpperCase();
		char text[]=cipher.toCharArray();

		char plain[]=new char[cipher.length()];

		int posA1=0;
		int posA2=0;
		int posB1=0;
		int posB2=0;
		int c=0;

		for(int k=0;k<cipher.length();k+=2)
		{
			for(int i=0;i<5;i++){
				for(int j=0;j<5;j++){
					if(keyMatrix[i][j]==text[k])
					{
						posA1=i;
						posA2=j;
					}
				}
			}

			for(int i=0;i<5;i++){
				for(int j=0;j<5;j++){
					if(keyMatrix[i][j]==text[k+1])
					{
						posB1=i;
						posB2=j;
					}
				}
			}

			//System.out.println(posA1+" "+posA2+" "+posB1+" "+posB2);

			if(posA2==posB2){
				if(posA1==0)
					plain[c++]=keyMatrix[4][posA2];
				else
					plain[c++]=keyMatrix[posA1-1][posA2];

				if(posB1==0)
					plain[c++]=keyMatrix[4][posB2];
				else
					plain[c++]=keyMatrix[posB1-1][posB2];
			}

			else if(posA1==posB1){
				if(posA2==0)
					plain[c++]=keyMatrix[posA1][4];
				else
					plain[c++]=keyMatrix[posA1][posA2-1];

				if(posB1==0)
					plain[c++]=keyMatrix[posB1][4];
				else
					plain[c++]=keyMatrix[posB1][posB2-1];
			}

			else{
				plain[c++]=keyMatrix[posA1][posB2];
				plain[c++]=keyMatrix[posB1][posA2];
			}
		}

		String plainText=new String(plain);
		return plainText;

	}

	public static void main(String [] args)
	{
		generateMatrix();
		Scanner sc=new Scanner(System.in);
		Scanner sc1=new Scanner(System.in);
		System.out.print("Enter text: ");
		String text=sc.nextLine();

		System.out.print("Would you like to encrypt or decrypt? (e/d): ");
		String action=sc1.nextLine();

		switch(action){
			case  "e":
			System.out.println("Cipher: "+cipher(text));
			break;

			case "d":
			System.out.println("Deciphered: "+decipher(text));
			break;

			default:
			System.out.println("Invalid input!");
		}
	}
}