import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.UIManager;

public class PhraseBank {

    private ArrayList<String> phrases;
    private int currentIndex;
    private String topic;
    
    /*
     * When a wordbank is created a window will open to
     * select the file with the phrases. Each line in the file
     * will be treated as a single phrase.
     */
    public PhraseBank(){
        phrases = new ArrayList<String>();
        currentIndex = -1;
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e){
            System.out.println("Unable to change look and feel");
        }
        loadWords();
    }
    
    /*
     * Call this method to get the next phrase.
     * The returned String will contain upper case
     * letters are spaces
     */
    public String getNextPhrase(){
        currentIndex = (currentIndex + 1) % phrases.size();
        return phrases.get(currentIndex);
    }
    
    public String getTopic(){
        return topic;
    }
    
    
    // to consider. Shoudl this be broken up into two methods?
    private void loadWords() {
        // get the file
        JFileChooser chooser = new JFileChooser(".");
        int retval = chooser.showOpenDialog(null);
        File f = null;
        chooser.requestFocusInWindow();
        if (retval == JFileChooser.APPROVE_OPTION)
           f = chooser.getSelectedFile();
        // first line is assumed to be the topic!
        // load the phrases
        try{
            Scanner s = new Scanner(f);
            topic = s.nextLine();
            while(s.hasNextLine()){
                String phrase = trim(s.nextLine().trim());
                phrases.add(phrase.toUpperCase());
            }
        }
        catch(IOException e){
            System.out.println("Unable to load phrases. Please exit.");
        }
        // if no values add in one
        if(phrases.size() == 0)
            phrases.add("HANGMAN");
        Collections.shuffle(phrases);
    }

    // I assume nextLine is not null.
    // Return a String with only characters and spaces.
    // All other characters in org are removed.
    private static String trim(String org) {
        String result = "";
        for(int i = 0; i < org.length(); i++){
            char ch = org.charAt(i);
            if( Character.isLetter(ch))
                result += ch;
            else if(ch == ' ')
                result += '_';
        }
        return result;
    }
}
