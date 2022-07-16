import java.lang.*;
import java.util.*;
//Database table /schema

class Student
{
	public int RID;
	public String Name;
	public int Salary;
	
	private static int Generator;
	
	static{
		Generator = 0;
	}
	
	public Student(String str,int value)
	{
		this.RID = ++Generator; //pre-increment
		this.Name = str;
		this.Salary = value;
	}
	
	public void DisplayData()
	{
		System.out.println(this.RID+"\t"+this.Name+"\t"+this.Salary);
	}
	
	
}
class DBMS
{
	LinkedList<Student> lobj; //just a reference
	public DBMS()
	{
		lobj = new LinkedList<>();
	}
	
		
	public void StartDBMS()
	{
		Scanner scanobj = new Scanner(System.in);
		
		System.out.println("Customized DBMS Started Sucessfully...");
		String Query="";
		
		while(true) //Infinite loop
		{
			System.out.print("Customized DBMS console>");
			Query = scanobj.nextLine();
			Query = Query.toLowerCase();
			
			String tokens[] = Query.split(" ");
			
			int QuerySize = tokens.length;
			
			if(QuerySize == 1)
			{
				if("help".equals(tokens[0]))
				{
					System.out.println("This application is used to demonstrate customized DBMS");
					System.out.println("----------------------------------------");
					System.out.println("Exit : Terminate DBMS");
					System.out.println("----------------------------------------");
					System.out.println("Display All Data : Select * from Student ");
					System.out.println("----------------------------------------");
					System.out.println("Insert Data : Insert into Student Name Salary");
					System.out.println("-------------------Update--------------------");
					System.out.println("Update Student set name = ? where rid = ?");
					System.out.println("----------------------------------------");
					System.out.println("Update Student set salary = ? where rid = ?");
					System.out.println("----------------------------------------");
					System.out.println("Update Student set name = ? salary = ? where rid = ?");
					System.out.println("------------------Aggregate----------------------");
					System.out.println("select min(salary) from student");
					System.out.println("----------------------------------------");
					System.out.println("select max(salary) from student");
					System.out.println("----------------------------------------");
					System.out.println("select avg(salary) from student");
					System.out.println("----------------------------------------");
					System.out.println("select sum(salary) from student");
					System.out.println("-------------------delete---------------------");
					System.out.println("delete from student where rid = ?");
					System.out.println("----------------------------------------");
					System.out.println("delete from student where name = ?");
					System.out.println("----------------------------------------");
				}
				else if("exit".equals(tokens[0]))
				{
					System.out.println("Thank you for using Customized Database");
					System.exit(0);
					//break;
				}
			}
			else if(QuerySize == 2)
			{
			
			}
			else if(QuerySize == 4)
			{
				//Select * from Student
				if( ("select".equals(tokens[0])) && ("*".equals(tokens[1])) && ("from".equals(tokens[2])) && ("student".equals(tokens[3])) )
				{
				 	DisplayAll();
				}
				//select min(salary) from student
				else if( ("select".equals(tokens[0])) && ("min(salary)".equals(tokens[1])) && ("from".equals(tokens[2])) && ("student".equals(tokens[3])) )
				{
					AggregateMin();
				}
				//select max(salary) from student
				else if( ("select".equals(tokens[0])) && ("max(salary)".equals(tokens[1])) && ("from".equals(tokens[2])) && ("student".equals(tokens[3])) )
				{
					AggregateMax();
				}
				//select avg(salary) from student
				else if( ("select".equals(tokens[0])) && ("avg(salary)".equals(tokens[1])) && ("from".equals(tokens[2])) && ("student".equals(tokens[3])) )
				{
					AggregateAvg();
				}
				//select sum(salary) from student
				else if( ("select".equals(tokens[0])) && ("sum(salary)".equals(tokens[1])) && ("from".equals(tokens[2])) && ("student".equals(tokens[3])) )
				{
					AggregateSum();
				}
			}
			else if(QuerySize == 5)
			{
				//Insert into Student Manas 1000
				if( ("insert".equals(tokens[0])) && ("into".equals(tokens[1])) && ("student".equals(tokens[2])) )
				{
				 	InsertData(tokens[3],Integer.parseInt(tokens[4]));
				 	
				}
			}
			else if(QuerySize == 7)
			{
				//delete from student where rid = ?
				if( ("delete".equals(tokens[0])) && ("from".equals(tokens[1])) && ("student".equals(tokens[2])) && ("where".equals(tokens[3])) && ("rid".equals(tokens[4])) && ("=".equals(tokens[5])))
				{
					DeleteSpecific(Integer.parseInt(tokens[6]));
				}
				else if( ("delete".equals(tokens[0])) && ("from".equals(tokens[1])) && ("student".equals(tokens[2])) && ("where".equals(tokens[3])) && ("name".equals(tokens[4])) && ("=".equals(tokens[5])))
				{
					DeleteSpecific(tokens[6]);;
				}
			}
			else if(QuerySize == 10)
			{
				//update student set name = ? where rid = ?
				if(("update".equals(tokens[0])) && ("student".equals(tokens[1])) && ("name".equals(tokens[3])) && ("rid".equals(tokens[7])) )
				{
					String name_to_update = tokens[5];
					int id = Integer.parseInt(tokens[9]);
					UpdateData(name_to_update,id);
				}
				//update student set salary = ? where rid = ?
				else if(("update".equals(tokens[0])) && ("student".equals(tokens[1])) && ("salary".equals(tokens[3])) && ("rid".equals(tokens[7])) )
				{
					int salary_to_update = Integer.parseInt(tokens[5]);
					int id = Integer.parseInt(tokens[9]);
					UpdateData(salary_to_update,id);
				}
			}
			else if(QuerySize == 13)
			{
				//update Student set name = ? salary = ? where rid = ?
				if(("update".equals(tokens[0])) && ("student".equals(tokens[1])) && ("name".equals(tokens[3])) && ("salary".equals(tokens[6])) && ("rid".equals(tokens[10]))  )
				{
					String name_to_update = tokens[5];
					int salary_to_update = Integer.parseInt(tokens[8]);
					int id = Integer.parseInt(tokens[12]);
					UpdateData(name_to_update,salary_to_update,id);
				}
			}
			
			
		}
		
	}
	public void InsertData(String str,int value)
	{
		Student sobj = new Student(str,value);
		lobj.add(sobj);
	}
	public void DisplayAll()
	{
		//Display by no condition
		//for-each 
		for(Student sref : lobj)
		{
			sref.DisplayData();
		}
	}
	public void DisplaySpecific(int rid)
	{
		//Display by rid
		//for-each 
		for(Student sref : lobj)
		{
			if(sref.RID == rid )
			{
				sref.DisplayData();
				break;
			}
		}
	}
	public void UpdateData(String str,int id)
	{
		int iCnt = 0;
		for( Student sref : lobj)
		{
			if(sref.RID == id)
			{
				sref.Name = str;
				lobj.set(iCnt,sref);
			}
			iCnt++;
		}
	}
	public void UpdateData(int value,int id)
	{
		int iCnt = 0;
		for( Student sref : lobj)
		{
			if(sref.RID == id)
			{
				sref.Salary = value;
				lobj.set(iCnt,sref);
			}
			iCnt++;
		}
	}
	public void UpdateData(String str,int value,int id)
	{
		int iCnt = 0;
		for( Student sref : lobj)
		{
			if(sref.RID == id)
			{
				sref.Name = str;
				sref.Salary = value;
				lobj.set(iCnt,sref);
			}
			iCnt++;
		}
	}
	public void DisplaySpecific(String name) //function overloading
	{
		//Display by name
		//for-each 
		for(Student sref : lobj)
		{
			if(name.equals(sref.Name))
			{
				sref.DisplayData();
			}
		}
	}
	public void DeleteSpecific(int rid) //Delete by rid
	{
		int index = 0;
		//for-each 
		for(Student sref : lobj)
		{
			if(sref.RID == rid )
			{
				lobj.remove(index);
				break;
			}
			index++;
		}
	}
	public void DeleteSpecific(String name) //Delete by name
	{
		int index = 0;
		//for-each 
		for(Student sref : lobj)
		{
			if(name.equals(sref.Name))
			{
				lobj.remove(index);
				break;
			}
			index++;
		}
	}
	public void AggregateMax()
	{
		int iMax = 0;
		Student temp = null;
		for(Student sref : lobj)
		{
			if(sref.Salary > iMax)
			{
				iMax = sref.Salary;
				temp = sref;
			}
		}
		System.out.println("Student having max salary : ");
		temp.DisplayData();
	}
	public void AggregateMin()
	{
		int iMin = lobj.getFirst().Salary;
		Student temp = lobj.getFirst();
		for(Student sref : lobj)
		{
			if(sref.Salary < iMin)
			{
				iMin = sref.Salary;
				temp = sref;
			}
		}
		System.out.println("Student having min salary : ");
		temp.DisplayData();
	}
	public void AggregateSum()
	{
		long iSum = 0;
		Student temp = null;
		for(Student sref : lobj)
		{
			iSum = iSum + sref.Salary;
		}
		System.out.println("Student total salary : "+iSum);
	}
	public void AggregateAvg()
	{
		long iSum = 0;
		//float fAvg = 0.0f;
		Student temp = null;
		for(Student sref : lobj)
		{
			iSum = iSum + sref.Salary;
		}
		System.out.println("Student Average salary : "+iSum/lobj.size());
	}
	public void AggrigateCount()
	{
		
		System.out.println("Student count is : "+lobj.size());
	}
}
class program371
{
	public static void main(String args[])
	{
		DBMS dobj = new DBMS();
		dobj.StartDBMS();	
	}
}
