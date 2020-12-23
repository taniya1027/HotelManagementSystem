
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
public class Hotel
{
	static class FoodOrder 
	{
		static String food;
		static int itemno;
		static int bill = 0;
		
	}
	
    //this function takes food order	
	static void	FoodOrder(int roomno,int itemquan, int ch)
	{
			switch(ch)
			{
				case 1 :
				    FoodOrder.bill = 50*itemquan;
				    System.out.println(" order successfull ! " + "\n bill:" + FoodOrder.bill);
					break;
					
				case 2:
				    FoodOrder.bill = 70*itemquan;
					System.out.println(" order successfull!" +"\nbill:" +FoodOrder.bill);
					break;
					
				case 3:
				    FoodOrder.bill = 80*itemquan;
					System.out.println(" order successfull!" +"\nbill:" +FoodOrder.bill);
					break;
					
				case 4:
				    return;
					
				default:
				    System.out.println("please enter a valid choice");
					
			}
		
	}
			
	
	
    static class SingleRoom extends FoodOrder
    {
    	String name;
    	String gender;
    	String address;
    	int price = 500;
	
    	SingleRoom(String name, String gender, String address)
    	{ 
	         this.name = name;
	    	 this.gender = gender;
		     this.address = address;
	    }
	
   }

   static class DoubleRoom extends FoodOrder 
   {
    	String name;
	    String gender;
    	String address;
	    String name2;
    	String gender2;
    	String address2;
    	int price = 700;
	
    	DoubleRoom(String name, String gender, String address,String name2, String gender2, String address2)
    	{ 
	         this.name = name;
	    	 this.gender = gender;
	    	 this.address = address;
	    	 this.name2 = name2;
	    	 this.gender2 = gender2;
	    	 this.address2 = address2;
	    }
    }
	
	
	
			
		
    //this class is to create array of SingleRoom and DoubleRoom Classes
    static class Holder 
    {
	    static  DoubleRoom doubleroom[] = new DoubleRoom[10];
	    static  SingleRoom singleroom[] = new SingleRoom[10];
		
	
	
    }
	
	
	
	
	static void roomBooking()
	{
		int choice;
		System.out.println("enter room choice \n1.Single room \n2.Double room");
		Scanner sc = new Scanner (System.in);
		choice = sc.nextInt();
		int roomno = 0;
		
		switch(choice)
		{
		    case 1:
			        
			        for(int i = 0; i < Holder.singleroom.length; i++)
				    {
						//checks if any of the rooms are empty
					   if(Holder.singleroom[i] == null)
					   {
						    
						     
						    Scanner input = new Scanner(System.in);
                            System.out.println("enter your details \n1.name:");
                			String name = input.nextLine();
                 			System.out.println("\n2.gender");
                 			String gender = input.nextLine();
                 			System.out.println("\n3.address");
                			String address = input.nextLine();
							
							Holder.singleroom[i] = new SingleRoom(name,gender,address);
						   
						    roomno = i+1;
						    System.out.println(" your name:" + name + "\nroom number:" +roomno);
						   
						    return;
						   
					   }
					}
					//if any of the rooms are not empty 
					
					for( int j = roomno -1; j < Holder.singleroom.length; j++)
					{
						if( Holder.singleroom[j] != null)
						{
							System.out.println(" sorry,room not available");
						}
						
					   
				    }			
						   
			
            case 2:
			        for(int i = 0; i < Holder.doubleroom.length; i++)
				    {
					   if(Holder.doubleroom[i] == null)
					   {
						    
						     
						    Scanner input = new Scanner(System.in);
                            System.out.println("enter your details \n1.name:");
                			String name = input.nextLine();
                 			System.out.println("\n2.gender");
                 			String gender = input.nextLine();
                 			System.out.println("\n3.address");
                			String address = input.nextLine();
							System.out.println("\nenter your details \n1.name:");
                			String name2 = input.nextLine();
                 			System.out.println("\n2.gender");
                 			String gender2 = input.nextLine();
                 			System.out.println("\n3.address");
                			String address2 = input.nextLine();
							
							Holder.doubleroom[i] = new DoubleRoom(name,gender,address,name2,gender2,address2);
						   
						    roomno = i+11;
						    System.out.println(" your name:" + name +" \nsecond user name: " +name2+ "\nroom number:" +roomno);
						   
						    return;
						   
					   }
					}
					for( int j = roomno -11; j < Holder.doubleroom.length; j++)
					{
						if( Holder.doubleroom[j] != null)
						{
							System.out.println(" sorry,room not available");
						}
						
					   
				    }	
 					
						   
			default:
			
				   System.out.println(" please enter a valid choice");
				   
				   
			
		
	    }
	}
	
	static void roomCheckingOut(int roomno)
	{
		if( roomno <= 10 && Holder.singleroom[roomno-1] != null )
		{
			System.out.println("And you have successfully checked out.Thank you !");
			
			Holder.singleroom[roomno -1] = null;
			
		}
		else if( roomno >= 11 && Holder.doubleroom[roomno - 11] != null)
		{
			System.out.println( " you have successfully checked out.Thank you !");
			Holder.doubleroom[ roomno -11] = null;
		}
		else if( roomno <= 10 && Holder.singleroom[roomno-1] == null )
		{
			System.out.println(" this room is already empty ");
			
		}
		else
		{
			if( roomno >= 11 && Holder.doubleroom[roomno - 11] == null)
				System.out.println(" this room is already empty ");
		}
	}
		
		
    static void bill(int roomno) throws IOException
	{
		FileWriter fw = new FileWriter("C:\\Users\\Taniya\\java programs\\file try\\Hotel.txt",true);
		BufferedWriter bw = new BufferedWriter(fw);
		if( roomno <= 10 && Holder.singleroom[roomno-1] != null )
		{
			System.out.println( Holder.singleroom[roomno - 1].name +" your total bill is "+ Holder.singleroom[roomno - 1].price);
			
			String name = Holder.singleroom[roomno - 1].name;
			// writing the bill in the file for backup
			bw.newLine();
			bw.write("name : ");
			bw.write(name);
			bw.newLine();
			
			bw.write("roomno : ");
		    bw.write(String.valueOf(roomno));
			bw.newLine();
			
			bw.write("total bill:");
            bw.write(String.valueOf(Holder.singleroom[roomno - 1].price));
			bw.newLine();
			
			bw.write("*****************");
			
			bw.close();
			roomCheckingOut(roomno);
			
			System.out.println("");
			
		}
		else if( roomno >= 11 && Holder.doubleroom[roomno - 11] != null)
		{
			System.out.println( Holder.doubleroom[roomno - 11].name +" your total bill is "+ Holder.doubleroom[roomno - 11].price);
			
			//writing the bill into backup
			String name = Holder.doubleroom[roomno - 11].name;
			bw.newLine();
			
			bw.write("name : ");
			bw.write(name);
			bw.newLine();
			
			bw.write("roomno : ");
		    bw.write(String.valueOf(roomno));
			bw.newLine();
			
			bw.write("total bill:");
            bw.write(String.valueOf(Holder.doubleroom[roomno - 11].price));
			bw.newLine();
			
			bw.write("*********************");
			
			bw.close();
			
			roomCheckingOut(roomno);
			
			System.out.println("");
		}
		else if( roomno <= 10 && Holder.singleroom[roomno-1] == null )
		{
			System.out.println(" please enter a valid room no");
			System.out.println("");
			
		}
		else
		{
			if( roomno >= 11 && Holder.doubleroom[roomno - 11] == null)
				System.out.println(" please enter a valid room no");
			    System.out.println("");
		}
	}
	
	
	public static void main(String[] args) throws IOException 
	{
	    
		int flag = 1;
		int choice;
		
		while(flag != 0)
		{
			
		
	         System.out.println("1.RoomBooking \n2.FoodOrder \n3.bill & RoomCheckingOut \n4.exit");
		
	         Scanner sc = new Scanner(System.in);
		     choice = sc.nextInt();
			
		    switch(choice)
		    {
		    	case 1:
				       System.out.println("ROOM BOOKING");
		    	       roomBooking();
					   System.out.println("");
					  
					   break;
		    		   
		  		   
		        case 2:
				      System.out.println("FOOD ORDER");
					   
					   System.out.println(" enter your roomno ");
					   Scanner in = new Scanner(System.in);
					   int roomno = in.nextInt();
					   if ( roomno <= 10 && Holder.singleroom[roomno-1] == null)
					   {
						  
						   System.out.println(" sorry food order is not available");
						   System.out.println("");
					   }
					   else if ( roomno >= 11 && Holder.doubleroom[roomno-11] == null)
					   {
						   System.out.println(" sorry food order is not available");
						   System.out.println("");
					   }
					   else
					   {
						   
					         System.out.println(" enter your food name");
							 System.out.println(" food menu \n1.pavbhaji \n2.samosa \n3.noodles \n4.nothing");
							 int i = in.nextInt();
							 
							 if( i == 4)
							 {
								 System.out.println(" bye bye, have a good day");
								 System.out.println("");
								 break;
							 }
							 
							 
							 System.out.println(" enter your item quantity");
							 int itemquan = in.nextInt();
							 
							 FoodOrder(roomno,itemquan,i);
							 System.out.println("");
							  
							 if(roomno <= 10)
							 {
							    Holder.singleroom[roomno-1].price += FoodOrder.bill;
							 }
							 else
							 {
								Holder.doubleroom[roomno-10-1].price += FoodOrder.bill;
							 }
					   }
					   
					   break; 
					   
				   
	     	    case 3:
				       System.out.println("BILL PAYEMENT & CHECKING OUT");
					   System.out.println("enter your roomno");
					   
					   roomno = sc.nextInt();
					   bill(roomno);
					  
	    		       
					   System.out.println("");
					   break;
					
     		    
			    case 4:
	    		       return;
					   
			    default:
				      System.out.println("please enter a valid choice");
					   
	   			   
		    }
		}
		
		
    }
	
}
	
		
		
		
	


	
		