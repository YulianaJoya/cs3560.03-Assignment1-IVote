import java.util.*;
public class SimulationDriver {

   //Number of students
   private static final int CO = 10;
   
   //Generates random answers
   protected static ArrayList<Character> generateAnswers(int type){
      Random rand = new Random();

      //Helps ensure there aren't duplicate answers for each student
      HashSet<Character> ans1 = new HashSet<Character>();

      //Generates single question answers 
      if(type == 1){
         ArrayList<Character> ar = new ArrayList<>();
         ar.add((char)(rand.nextInt(5) + 65));
         return ar;
      }

      //Generates multiple question answers
      else{
         for(int i = 0 ; i < 1 + rand.nextInt(6); i++){
            ans1.add((char)(rand.nextInt(5) + 65));
         }

         //Copies student answers into an array
         ArrayList<Character> array = new ArrayList<>();
         array.addAll(ans1);
         return array;
      } 
   }

   //Generates a random student id 
   protected static String generateId(){
      return  UUID.randomUUID().toString();
   }

   public static void SingleAnswer(){

      SingleQuestion sq = new SingleQuestion();
      Student[] singlestu = new Student[CO];
      
      //Save student id and answers for each student
      for(int i = 0; i < CO; i++){
         singlestu[i] = new Student(generateId(), generateAnswers(1));
      }

      //Submits ids and answers into the voting service
      VotingServices singvote = new VotingServices(singlestu);
      System.out.println("\n-----Single Choice Question-----\n");

      //Initialize with question
      sq.setQuest("What was the very first Pixar movie?\n");

      //Display question for students
      System.out.println(sq.getQuest());
      
      String[] que = {"Wall-E", "Monsters Inc.", "Cars", "Toy Story", "A Bug's Life"};
      
      //Initialiize with the answers
      sq.setChoice(que);

      //Displays answer choices
      sq.displayChoice();

      //Displays the overall sum of answers chosen by all students
      singvote.calculateAnswer();
      System.out.println("Correct Answer: D: Toy Story");
   }

   public static void MultipleAnswer(){
      MultipleQuestion mq = new MultipleQuestion();
      Student[] multistu = new Student[CO];

      //Save student id and answers for each student
      for(int i = 0; i < CO; i++){
         multistu[i] = new Student(generateId(), generateAnswers(2));
      }
      
      //Submits ids and answers into the voting service
      VotingServices multvote = new VotingServices(multistu);
      System.out.println("\n-----Multiple Choice Question-----\n");

      //Intiazlise with question
      mq.setQuest("Which sea creatures are the best?\n");
      
      //Display question for students
      System.out.println(mq.getQuest());
      String[] cho = {"Jellyfish", "Stringrays", "Octupus", "Sharks", "Whales" };

      //Initialize with the answers
      mq.setChoice(cho);

      //Display answer choices
      mq.displayChoice();

      //Displays the overall sum of answers chosen by all students
      multvote.calculateAnswer();
      System.out.println("Correct Answer: All of them");
   }

   public static void main(String[] args){
      SingleAnswer();
      MultipleAnswer();
   }

}
