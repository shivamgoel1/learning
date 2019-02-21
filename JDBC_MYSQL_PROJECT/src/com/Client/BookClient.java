package com.Client;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.*;

import com.Dao.BookDaoImpl;
import com.model.Book;

public class BookClient {
	
	
	
	public static void main(String args[]) throws SQLException{
		 String url="jdbc:mysql://localhost:3306/bookstore?useSSL=false";
		 String usr="root";
		 String pass="root";
		 
		 BookDaoImpl b1  =new BookDaoImpl(usr, pass, url);
		 b1.connect();
		 
		 
		 
		 
		 int c=0;
		 System.out.println("List Book =1\n"+"Insert Book=2\n"+"Update Book=3\n"+"Delete Book=4");
		 Scanner sc= new Scanner(System.in);
		 c=sc.nextInt();
		 
		 switch (c) {
		 case 1: 	
		 			List<Book> list=new ArrayList<Book>();
		 			list=b1.listBook();
		 			
			 		Iterator i =list.iterator();
			 		while(i.hasNext()){
			 			System.out.println(i.next());	 	
			 		}
			 		break;
			 		
		 case 2: 
			 		String bookname,bookauthor;
		 			float bookprice;
		 			System.out.println("Enter Book name");	
		 			bookname=sc.next();
		 	
		 			System.out.println("Enter Book auhtor");	
		 			bookauthor=sc.next();
		 	
		 			System.out.println("Enter Book price");	
		 			bookprice=sc.nextInt(); 
		 	
		 			Book b2= new Book(bookname,bookauthor,bookprice);
		 			int res=b1.insertBook(b2);
		 			if(res==1){
		 				System.out.println("Successcully Inserted");
		 			}
		 			else
		 				System.out.println("Not Inserted");
			
		 			break;
		 case 3: 
		 			float price=0;
		 			int bookid=0;
		 			String author="",title="";
		 			System.out.println("Enter Book Price");
		 			price=sc.nextFloat();
		 			System.out.println("Enter Book Id");
		 			bookid=sc.nextInt();
		 			
		 			Book b3= new Book(bookid,title,author,price);
		 			
		 		    res=b1.updateBook(b3);
		 			if(res==1){
		 				System.out.println("Successcully Inserted");
		 			}
		 			else
		 				System.out.println("Not Inserted");
			
		 			break;
		 			
		 case 4:
		 			int id=0;
		 			System.out.println("Enter Book Id You want tot delete");
		 			id=sc.nextInt();
		 			Book b4= new Book(id,"","",0);
		 			int result =b1.deleteBook(b4);
		 			
		 			if(result==1){
		 				System.out.println("Successcully deleted");
		 			}
		 			else
		 				System.out.println("Not deleted");
			
		 			
		 			break;

		default: System.out.println("Enter Valid Number Plz");
			break;
		}
		 
		 
	}
}
