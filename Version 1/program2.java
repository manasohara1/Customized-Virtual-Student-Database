import java.lang.*;
import java.util.*;
class Student
{
	public int rollno;
	public String name;
	public int age;
	
	public Student(int rollno,String name,int age)
	{
		this.rollno = rollno;
		this.name = name;
		this.age = age;
	}
	public String toString()
	{
		return "\nRoll no : "+this.rollno+", Name : "+this.name+", Age : "+this.age+"\n";
	}
}
class program2
{
	public static void main(String args[])
	{
		LinkedList<Student> lobj = new LinkedList<Student>();
		Scanner sobj = new Scanner(System.in);
		int iStudentNumbers = 0;
		int r = 0;
		
		while(true)
		{
			System.out.println("-----Menu-----");
			System.out.println("1 : Add new student" );
			System.out.println("2 : Display all student");
			System.out.println("3 : Update a student");
			System.out.println("4 : Delete a student");
			System.out.println("5 : Search a student");
			System.out.println("6 : Exit");
			System.out.println("Enter your choice : ");
			int choice = sobj.nextInt();
			switch(choice)
			{
				case 1 : System.out.println("How many student to add ? ");
					 iStudentNumbers=sobj.nextInt();
		
					 for(int iCnt = 1; iCnt <= iStudentNumbers; iCnt++)
					 {
						System.out.println("-------------Student"+iCnt+"--------------");
						System.out.println("Enter roll no : ");
						r = sobj.nextInt();
						sobj.nextLine(); //flush
						System.out.println("Enter name : ");
						String str = sobj.nextLine().trim();
						System.out.println("Enter age : ");
						int m = sobj.nextInt();
						Student studobj = new Student(r,str,m);
						lobj.add(studobj);
					}
					System.out.println("Student added successfully");
					break;
				case 2 : System.out.println(lobj);
					 break; 
				case 3 : System.out.println("Enter roll no. of student to update record : ");
					 r = sobj.nextInt();
					 sobj.nextLine();//flush
					 for(int iCnt =0 ; iCnt < lobj.size(); iCnt++)
					 {
						Student tempobj = lobj.get(iCnt);
						if(tempobj.rollno == r)
						{
							System.out.println("Enter new name for student : ");
							String name = sobj.nextLine();
							tempobj.name = name;
							lobj.set(iCnt,tempobj);
						}
					 }
					 System.out.println("After Updation :");
					 System.out.println(lobj);
					 break;
				case 4 : System.out.println("Enter roll no. of student to delete record : ");
					 r = sobj.nextInt();
					 sobj.nextLine();//flush
			 		 for(int iCnt =0 ; iCnt < lobj.size(); iCnt++)
					 {
						Student tempobj = lobj.get(iCnt);
						if(tempobj.rollno == r)
						{
							lobj.remove(iCnt);
						}
					 }
					 System.out.println("After Updation :");
					 System.out.println(lobj);
					 break;
				case 5 : System.out.println("Enter roll no. of student to search record : ");
					 r = sobj.nextInt();
					 sobj.nextLine();//flush
					 for(int iCnt =0 ; iCnt < lobj.size(); iCnt++)
					 {
						Student tempobj = lobj.get(iCnt);
						if(tempobj.rollno == r)
						{
							System.out.println(tempobj);
							break;
						}
					 }
					 break;
				case 6 : System.out.println("Thank you for using Customized Student database");
					 System.exit(0);
					 break;
				default : System.out.println("Invalid Case");
					  break;
			}
		}
	}
}
