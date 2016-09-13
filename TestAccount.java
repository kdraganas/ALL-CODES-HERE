public class TestAccount {
   public static void main(String[] args) {
      // Test constructor and toString()

      Account a1 = new Account(201510391, 1000);
      Account a2 = new Account(201510392);
      System.out.println(a1);  // toString()
 
      // Test Setters and Getters
      a1.setBalance(2000);
      a1.credit(500);
      a1.debit(600);
      System.out.println(a1);  // toString()
      a2.credit(100);
      a2.setBalance(1250);
      a2.debit(50);
      System.out.println(a2);  // toString()
   }
}