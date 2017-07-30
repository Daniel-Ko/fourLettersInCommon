/**
 * Created by Dan Ko on 7/29/2017.
 */
import java.util.List;
import java.util.ArrayList;

public class Test{
    public Test() {
        String[] dict = {"OneHello", "TwoBoyo", "ThreePizza", "FourAHell", "FiveObhell", "Six", "SevenHel", "Eightello"}; //1, 4, 5, 8 should pass
        fourLettersInCommon("HELLO", dict);
    }

    /** Returns all words in dictionary that have at least 4 consecutive letters in common with the source words
     @param str is the source word. dict is a String array to search and compare from.
     @return if source word is shorter than 3 characters, returns null. If no words in dict meet criteria, return empty list.
     Otherwise, return a List of words that meet criteria
     **/
    public List<String> fourLettersInCommon(String str, String[] dict) {
        if(str.length() < 3) return null;

        List<String> common = new ArrayList<>();

        str = str.toLowerCase();

        for(String wd : dict) { //O(n), n = length of dict
            if(wd.length() < 4) continue; //word less than 4 characters long will not meet criteria
            String word = wd.toLowerCase(); //letter matching should ignore case
            System.out.println("----------------------\n" + word);

            boolean added = false; //prevents word from being added to list more than once
            for(int character = 0; character < word.length()-3; character++) {
                char c = word.charAt(character);
                System.out.println("c in word: " + c);
                for(int i = 0; i < str.length()-3; i++) {
                    //if there is a matching letter from word in str
                    if(str.charAt(i) == c) {
                        boolean fourMatch = true;
                        System.out.println("START MATCH");
                        for(int lookahead = character; lookahead < character+4; lookahead++) { //lookahead 3 more places, matchng as we go
                            System.out.println("\tMatching: \n\tWord: " + word.charAt(lookahead) + ", Source: " + str.charAt(i+(lookahead-character)));
                            System.out.println("\t" + (i+(lookahead-character)));
                            if(word.charAt(lookahead) != str.charAt(i+(lookahead-character))) {
                                System.out.println("MISMATCH");
                                fourMatch = false;
                                break; //if not matching till 4 ahead from character, no need to search more
                            }
                        }
                        if(fourMatch) {
                            common.add(word);
                            added = true;
                            break;
                        }
                    }
                }
                if(added) break;
            }
        }

        System.out.println("\n===========================\nList size: " + common.size());
        int j = 0;
        for(String word : common) {
            System.out.print(word + ", ");
            j++;
            if(j > 10) System.out.println();
        }
        return common;
    }

    public static void main(String[] args) {
        new Test();
    }

}

