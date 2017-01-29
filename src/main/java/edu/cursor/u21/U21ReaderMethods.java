package edu.cursor.u21;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by o.kociuta on 25.01.2017.
 */
public class U21ReaderMethods implements U21ReaderMethodsInterface {
    @Override
    public void lexemesAndTokensDivider(U21Reader reader) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(reader.getFilePath()));
        String currentLine;
        String str;
        while ((currentLine = br.readLine()) != null) {
            for (int i = 0; i < currentLine.length(); i++) {
                str = "";
                if (currentLine.charAt(i) >= (char) (48) && currentLine.charAt(i) <= (char) (57) || currentLine.charAt(i) >= (char) (65) && currentLine.charAt(i) <= (char) (90) || currentLine.charAt(i) >= (char) (97) && currentLine.charAt(i) <= (char) (122)) {
                    while (true) {
                        str += currentLine.charAt(i);
                        if (i == currentLine.length() - 1 || currentLine.charAt(i + 1) >= (char) (32) && currentLine.charAt(i + 1) <= (char) (47) || currentLine.charAt(i + 1) >= (char) (58) && currentLine.charAt(i + 1) <= (char) (64) || currentLine.charAt(i + 1) >= (char) (91) && currentLine.charAt(i + 1) <= (char) (96) || currentLine.charAt(i + 1) >= (char) (123) && currentLine.charAt(i + 1) <= (char) (126)) {
                            break;
                        } else {
                            i++;
                        }
                    }
                } else if (currentLine.charAt(i) != (char) (32)) {
                    str += currentLine.charAt(i);
                } else {
                    continue;
                }
                reader.getSplitWords().add(str);
            }
        }
    }

    public void wordsStatistics(){

        String arrayWords[] = {};
        HashMap<Integer, String> m = new HashMap<>(2500, 1);

        int a = 0;
        int result;
        for (int i = 0; i < arrayWords.length; i++){
            for (int j = i; j < arrayWords.length; j++){
                result = arrayWords[i].compareTo(arrayWords[j]);
                if (result == 0){
                    a++;
                    m.put(a,arrayWords[i]);
                }
            }
            System.out.println(m.get(arrayWords[i]) + " зустрічається " + a + " раз");
        }
    }
}
