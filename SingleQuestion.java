public class SingleQuestion implements Questions {
   private String quest;
   private String[] choice;
   
   @Override
   public void setQuest(String quest){
     this.quest = quest;
   }
   @Override
   public void setChoice(String[] choice){
      this.choice = choice;
   }
   @Override
   public String getQuest(){
      return quest;
   }
   @Override
   public String[] getChoice(){
     return choice;
   }
   @Override
   public void displayChoice(){
      System.out.println("Choices:");
      int asc = 65;
      for(int i = 0; i < choice.length; i++){
         System.out.println("-"+ (char)asc + " : " + choice[i]);
         asc++;
      }
      System.out.println();
   }
}
