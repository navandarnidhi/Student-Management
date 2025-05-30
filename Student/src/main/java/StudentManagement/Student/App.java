package StudentManagement.Student;
 import org.hibernate.Session;
 import org.hibernate.Transaction;
 import java.util.Scanner;
 import StudentManagement.Student.User;
 
 public class App{
	 public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 Session session;
		 Transaction tx;
		 
		 
		 while(true) {
			 System.out.println("---Student Management----");
			 System.out.println("1. Add Student");
			 System.out.println("2. View Student");
			 System.out.println("3. Update Student");
			 System.out.println("4. Delete Student");
			 
			 System.out.println("Choose the option: ");
			 
			 int choice = Integer.parseInt(sc.nextLine());
			 
			 switch(choice) {
			 
			 case 1:
				 
				 User student = new User();
				 System.out.println("Enter Name");
				 student.setName(sc.nextLine());
				 
				 System.out.println("Enter Email");
				 student.setEmail(sc.nextLine());
				 
				 System.out.println("Enter Cousre");
				 student.setCourse(sc.nextLine());
				 
				 System.out.println("Enter Grade");
				 student.setGrade(sc.nextLine());
				 
				 
				 session = HibernateUtil.getSessionFactory().openSession();
				 tx = session.beginTransaction();
				 session.persist(student);
				 tx.commit();
				 session.close();
				 
				 System.out.println("Student added with Id: " + student.getRollNo());
				 break;
				 
			 case 2:
				 
				 System.out.println("Enter Student Id to view: ");
				 int idToRead = Integer.parseInt(sc.nextLine());
				 
				 session = HibernateUtil.getSessionFactory().openSession();
				 User readStudent = session.get(User.class, idToRead);
				 if(readStudent != null) {
					 System.out.println(" STUDENTS DETAILS");
					 System.out.println("ID: "+ readStudent.getRollNo());
					 System.out.println("Name: "+ readStudent.getName());
					 System.out.println("Email: "+ readStudent.getEmail());
					 System.out.println("Cousre: "+ readStudent.getCourse());
					 System.out.println("Grade: "+ readStudent.getGrade());
					 
				 }else {
					 System.out.println("Student not found");
				 }
				 session.close();
				 break;
				 
			 case 3:
                 
                 System.out.print("Enter Student ID to update: ");
                 int idToUpdate = Integer.parseInt(sc.nextLine());

                 session = HibernateUtil.getSessionFactory().openSession();
                 tx = session.beginTransaction();
                 User updateStudent = session.get(User.class, idToUpdate);
                 if (updateStudent != null) {
                     System.out.print("Enter new Email: ");
                     updateStudent.setEmail(sc.nextLine());

                     System.out.print("Enter new Grade: ");
                     updateStudent.setGrade(sc.nextLine());

                     session.merge(updateStudent);
                     tx.commit();
                     System.out.println("Student updated.");
                 } else {
                     System.out.println("Student not found.");
                     tx.rollback();
                 }
                 session.close();
                 break;
                 
			 case 4:
				 System.out.print("Enter Student Id to delete");
				 int idToDelete = Integer.parseInt(sc.nextLine());
				 
				 session = HibernateUtil.getSessionFactory().openSession();
				 tx = session.beginTransaction();
				 User deleteStudent = session.get(User.class, idToDelete);
				 if(deleteStudent != null) {
					 session.remove(deleteStudent);
					 tx.commit();
					 
					 System.out.println("Student Deleted");
				 }else {
					 
					 System.out.println("STUDENT NOT FOUND");
					 tx.rollback();
				 }
				 session.close();
				 break;
				 
				 
				 default:
					 System.out.println("Invalid choice");
				 
				 
				 
				 
				 
			 
			 }
		 }
	 }
 }