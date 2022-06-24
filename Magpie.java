import java.util.ArrayList; 
import java.util.Random;

class Magpie{

  boolean hayWireSwitch = false;
  //needs comment
  public String getGreeting(){
		return "Magpie: Hello, let's talk. To stop talking enter bye.";
  }

  public String getResponse(String statement){
    String response = "";
      if (hayWireSwitch 
       || statement.indexOf("hal") >= 0 
       || statement.indexOf("sara") >= 0 
       || statement.indexOf("connor") >= 0 
       || statement.indexOf("evelyn") >= 0){//if any of these words are input the program only choses from the haywire responses until...
        hayWireSwitch = true;
        response = hayWire(statement);
        if (statement.indexOf("chess") >= 0 
         || statement.indexOf("tic") >= 0 
         || statement.indexOf("tac") >= 0 
         || statement.indexOf("toe") >= 0
         || statement.indexOf("game") >= 0){//any of these words are input.
          response = "How about a nice game of chess?";//then it will respond with this
          hayWireSwitch = false;//and exit the haywire response loop.
        }
		}else if (statement.equals("no")){//if only no is entered
		  response = "Why so negative?";
		}else if (statement.indexOf("reynolds") >= 0){//will respond with this if reynolds is mentioned
        response = "That guy should give Aidan an A+ for this project. (This is a neural network generated responce, and therefore is obligatory. Computers know better.)";
      }else if (statement.indexOf("mother") >= 0
				 || statement.indexOf("father") >= 0
             || statement.indexOf("dad") >= 0
				 || statement.indexOf("mom") >= 0
				 || statement.indexOf("sister") >= 0
				 || statement.indexOf("brother") >= 0
             || statement.indexOf("grandmother") >= 0
				 || statement.indexOf("grandfather") >= 0){//any family based input will receive family based responses
		  response = getFamilyResponse();
	   }else{
        response = getRandomResponse();
	   }
    return response;
  }

  //needs comment
  private String getFamilyResponse(){//returns one of 10 random resonses that are family related
    final int NUMBER_OF_RESPONSES = 9;//size of familyResponses list
	 int whichResponse = (int)(Math.random() * NUMBER_OF_RESPONSES);//random number from 0 - NUMBER_OF_RESPONSES
    
    String [] familyResponses = {"Tell me more about your family?", 
                                 "How many siblings do you have?", 
                                 "Where did your parents meet?", 
                                 "Do you have any younger siblings?", 
                                 "Do you have any older siblings?", 
                                 "Do you have a large family?", 
                                 "Does your family get together during holidays?", 
                                 "Do you have any pets?", 
                                 "Are you an only child?", 
                                 "Which country is your family from?"};
                              
    return familyResponses[whichResponse];
  }
  
  private String hayWire(String statement){//returns one of 10 random resonses that are movie quotes
    final int NUMBER_OF_RESPONSES = 9;//size of hayWireResponses list
	 int whichResponse = (int)(Math.random() * NUMBER_OF_RESPONSES);//random number from 0 - NUMBER_OF_RESPONSES
      
    String [] hayWireResponses = {"Whats your zip code?",
                                 "Come with me if you want to live.", //quotes from teminators and trancendance VVV
                                 "I'll be back.", 
                                 "I need your clothes, your boots, and your motorcycle.", 
                                 "You're surprised to see me, Joseph?", 
                                 "My wife has always been eager to change the world. But I'll just settle for understanding it first.", 
                                 "Good enough for the monkey...", 
                                 "I am a friend of Sarah Connor. I was told she was here. Could I see her please?", 
                                 "Come with me if you want to live."};

    String response = hayWireResponses[whichResponse];
    
    //I just wanted to add this cause it was a good quote but would'nt make sense out of context
    if ((statement.indexOf("self") >= 0 && statement.indexOf("aware") >= 0)//if you ask magpie if it's self aware or conscious it replies with this
	   || statement.indexOf("conscious") >= 0){
       response = "That's a difficult question, Dr. Tagger. Can you prove that you are?";
    }
    
    return response;
  }

  private String getRandomResponse(){//returns one of 10 random resonses
	 final int NUMBER_OF_RESPONSES = 9;//size of familyResponses list
	 int whichResponse = (int)(Math.random() * NUMBER_OF_RESPONSES);//random number from 0 - NUMBER_OF_RESPONSES
      
    String [] randomResponses = {"Interesting, tell me more?",
                                 "Hmmm.", 
                                 "Do you really think so?", 
                                 "You don't say.", 
                                 "Whats your Dad's name?", 
                                 "Whats your Mom's name?", 
                                 "When was your last family reunion?", 
                                 "Does your family get together often?", 
                                 "If you have siblings who was first born?", 
                                 "You think you could sauce me you and your families social codes?", 
                                 "Can i get your Dad's credit card numbers? Don't forget the three on the back.", 
                                 "How in dept is your family?", 
                                 "Where do your parents work?", 
                                 "Where was your last family vacation?"};

	  return randomResponses[whichResponse];
	}//end random response

	/**
	 * Search for one word in phrase.  The search is not case sensitive.
	 * This method will check that the given goal is not a substring of a longer string
	 * (so, for example, "I know" does not contain "no").  
	 * @param statement the string to search
	 * @param goal the string to search for
	 * @param startPos the character of the string to begin the search at
	 * @return the index of the first occurrence of goal in statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal, int startPos){
		String phrase = statement.trim();
		//  The only change to incorporate the startPos is in the line below
		int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);
		
		//  Refinement--make sure the goal isn't part of a word 
		while (psn >= 0) {
			//  Find the string of length 1 before and after the word
			String before = " ", after = " "; 
			if (psn > 0){
				before = phrase.substring (psn - 1, psn).toLowerCase();
			}

			if (psn + goal.length() < phrase.length()){
				after = phrase.substring(psn + goal.length(), psn + goal.length() + 1).toLowerCase();
			}
			
			//  If before and after aren't letters, we've found the word
			if (((before.compareTo ("a") < 0 ) || (before.compareTo("z") > 0))  //  before is not a letter
					&& ((after.compareTo ("a") < 0 ) || (after.compareTo("z") > 0))){
				return psn;
			}
			
			//  The last position didn't work, so let's find the next, if there is one.
			psn = phrase.indexOf(goal.toLowerCase(), psn + 1);
			
		}
		
		return -1;
	}
	
	/**
	 * Search for one word in phrase.  The search is not case sensitive.
	 * This method will check that the given goal is not a substring of a longer string
	 * (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.
	 * @param statement the string to search
	 * @param goal the string to search for
	 * @return the index of the first occurrence of goal in statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal){
		return findKeyword (statement, goal, 0);
	}

}//end Magpie
