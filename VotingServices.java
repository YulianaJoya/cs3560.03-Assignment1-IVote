import java.util.*;
public class VotingServices{
   
   private Student[] student;
   
   protected VotingServices(Student[] student)
   {
      this.student = student;
   }

   protected void setStudent(Student[] student){
      this.student = student;
   }
   
   protected Student[] getStudent(){
      return student;
   }

   protected void calculateAnswer(){
      int[] count = new int[5];
      for(int i = 0; i < student.length; i++){
         System.out.println("Student " + student[i].getId() + " answered " + student[i].getAns());
         
      }
      System.out.println("\n-----Overall Results-----\n");
      for(int i = 0; i < student.length; i++){
         count[0] += Collections.frequency(student[i].getAns(), 'A');
         count[1] += Collections.frequency(student[i].getAns(), 'B');
         count[2] += Collections.frequency(student[i].getAns(), 'C');
         count[3] += Collections.frequency(student[i].getAns(), 'D');
         count[4] += Collections.frequency(student[i].getAns(), 'E');
      }
      int asc = 65;
      for(int j = 0; j < count.length; j++){
         System.out.println((char)asc + ": "  + count[j]);
         asc++;
      }
   }

}
