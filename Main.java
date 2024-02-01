import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static String decrypt(File message_file) throws IOException {

        HashMap<String, String> map = new HashMap<>();          //Hashmap to hold lines from file
        StringBuilder result = new StringBuilder();             //result string

        //read lines from file and add them to list
        Scanner inputStream = new Scanner(new FileInputStream(message_file));
        do {
            //split string into key(number) and value (text)
            String parts[] = inputStream.nextLine().split(" ", 2);
            map.put(parts[0], parts[1]);
        } while(inputStream.hasNextLine());

        inputStream.close();   //close reader
        int toGet = 0;
        for(int i = 1; i<map.size(); i++){
            if(toGet>map.size()){
                break;
            }
            toGet = (i * (i+1))/2d;
            result.append(map.get(toGet + "") + " ");
        }
        return result.toString();
    }


    public static void main(String[] args) throws IOException {
        File file = new File("message.txt");
        System.out.println(decrypt(file));
    }
}