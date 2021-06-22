import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class CountWords {
    private String fileName;
    private int wordCount;
    private ArrayList<NumStr> words;

    public CountWords(String fileName){
        this.fileName = fileName;
        words = new ArrayList<>();
        readFromFile();
        countIt();
    }

    public int getWordCount(){
        return this.wordCount;
    }

    private void readFromFile(){
        try {
            File myObj = new File(this.fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                words.add(new NumStr(data));
            }
            myReader.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private void countIt(){
        for(NumStr n:words){
            wordCount += n.getCnt();
        }
    }

}