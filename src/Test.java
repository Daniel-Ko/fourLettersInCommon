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

        str = str.toLowerCase(); //letter-matching should ignore case

        for(String wd : dict) {
            if(wd.length() < 4) continue; //skip words less than 4 characters long

            String word = wd.toLowerCase(); //letter-matching should ignore case
            boolean added = false; //flag to prevent word from being added to list more than once

            //for each character in word
            for(int character = 0; character < word.length()-3; character++) {
                char c = word.charAt(character);

                for(int i = 0; i < str.length()-3; i++) {
                    if(str.charAt(i) == c) { //if c has found a match in source string
                        boolean fourMatch = true;

                        //lookahead 3 more places, matchng as we go
                        for(int lookahead = character; lookahead < character+4; lookahead++) {
                            if(word.charAt(lookahead) != str.charAt(i + (lookahead-character) )) { //if mismatch
                                fourMatch = false;
                                break; //if mismatch is found, no need to keep comparing
                            }
                        }
                        if(fourMatch) { //if full match was found
                            common.add(word);
                            added = true;
                            break; //if word has been added, no point to searching for more matches
                        }
                    }
                }
                if(added) break; //once added, we can discard the word entirely and move onto the next word
            }
        }
        return common;
    }

    public static void main(String[] args) {
        new Test();
    }

}

