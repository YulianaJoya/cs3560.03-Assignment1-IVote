import java.util.*;
public class Student{
   protected String id;
   protected ArrayList<Character> ans;

   protected Student(String id, ArrayList<Character> ans){
      this.id = id;
      this.ans = ans;
   }

   protected void setId(String stuid){
      this.id = stuid;
   }
   
   protected String getId(){
      return id;
   }
   
   protected void setAns(ArrayList<Character> ans){
      this.ans = ans;
   }
   
   protected ArrayList<Character> getAns(){
      return ans;
   }

}