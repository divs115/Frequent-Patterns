import java.io.*;
import java.util.*;

public class Main{
  TreeMap<Integer, ArrayList<String>> list = new TreeMap<Integer, ArrayList<String>>(); 

  public static void main(String[] args){
    Main m = new Main();
    m.init();
  }

  public void init(){
    readFile();
  }

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
          // do something with the data
          
      }
      System.out.println(list.get(4).size());
      csvReader.close();
    }catch(Exception e){
      e.printStackTrace();
    }
  }


}