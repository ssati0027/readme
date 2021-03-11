package interview;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Bus {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Total No Of Seats Available In Bus:");
		int ts=0,stp=0,fare=0;
		boolean error= false;
		do{
			try{
				Scanner s=new Scanner(System.in);
				ts=s.nextInt();
				System.out.println("Enter Total No Of Stops:");
				stp=s.nextInt();

				System.out.println("Enter min fare:");
				fare=sc.nextInt();
				break;
			}
			catch(InputMismatchException e){
				System.out.println("Eenter valid value");
				error=true;
			}
		}while(error);

		System.out.println("===============================================");
		int a[][]=new int [ts][2];
		int sum=0,p=0,pasno=0;
		System.out.println("bus after dprtd from depo");

		for(int m[]:a){
			for(int n:m){
				System.out.print(n+" ");
			}
			System.out.println();
		}
		for(int x=1;x<stp;x++){
			pasno=0;
			System.out.println("==========================================");
			System.out.println("Bus Arrived At stop:"+x);
			System.out.println("Enter No of Pssngr Waiting At stop:"+x);

			int count=sc.nextInt();
			for(int i=0;i<a.length;i++){
				for(int j=1;j<2;j++){
					if((a[i][j]==x||a[i][j]==0) &&x!=stp)
					{
						a[i][0]=0;
						a[i][j]=0;
						pasno++;
						if(pasno>count)
							break;
						if(x==stp-1){
							a[i][0]=x;
							a[i][j]=stp;
							p++;

							sum=sum+((a[i][j]-a[i][0])*fare);
							break;

						}
						a[i][0]=x;
						p++;
						System.out.println("Enter p"+p+" destination:");
						a[i][j]=sc.nextInt();
						while((a[i][j]<=x||a[i][j]>stp))
						{
							System.out.println("Entr valid dstntn btwn "+(x+1)+" and "+stp);

							a[i][j]=sc.nextInt();
						}
						sum=sum+((a[i][j]-a[i][0])*fare);
					}
				}
			}
			// System.out.println();
			System.out.println("Pssngr Deatail after bus dprtd from STOP:"+x);

			for(int m[]:a){
				for(int n:m){
					System.out.print(n+" ");
				}
				System.out.println();
			}
			System.out.println("Aaftr dprtng stop"+x+" Amount collected Rs:"+sum);
		}
		System.out.println("=============================================");
		System.out.println("Bus Returning to Depo");

		for(int m[]:a){
			for(int n:m){
				n=0;
				System.out.print(n+" ");
			}
			System.out.println();
		}
		System.out.println("Total Number Of Passenger:"+p);
		System.out.println("Total Amount Collected Rs:"+sum);
		sc.close();
	}
}


