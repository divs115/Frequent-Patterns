import java.io.*;
import java.util.*;

public class Main{

  TreeMap<Integer, ArrayList<String>> list = new TreeMap<Integer, ArrayList<String>>(); 

  /**
    Main method that initializes the class
  */
  public static void main(String[] args){
    Main m = new Main();
    m.init();
  }

  /**
    Method to initialize all the needed variables and 
    call all the needed methods in a sequential manner. 
  */
  public void init(){
    readFile();
  }

  /**
    Reads and parses csv file into data structure in the form of
    a map where the key is the index/id number and the value is
    the list of data.

    Note: Change the file name from "test.csv" to your file name
    and make sure it is saved in the same folder as this java file.
  */
  public void readFile(){
    try{
      BufferedReader csvReader = new BufferedReader(new FileReader("test.csv"));
      String row="";
      while ((row = csvReader.readLine()) != null) {
          String[] index = row.split(",");
          for(int i=0; i<index.length; i++){
            if(index[i].contains(";")){
              ArrayList<String> data = new ArrayList<String>(Arrays.asList(index[i].split(";")));
              list.put(Integer.parseInt(index[0]), data);
            }
          }          
      }
      System.out.println(list.get(4).size());
      csvReader.close();
    }catch(Exception e){
      e.printStackTrace();
    }
  }


}