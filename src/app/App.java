package app;

public class App {
    public static void main(String[] args) {
        System.out.println(stringToPig("Hello world! "));
    }

    public static String wordToPig(String word) {
        int len = word.length();
        StringBuilder pigWord = new StringBuilder();

        char firstChar = word.charAt(0);
        if (isVowel(firstChar) == true) {
            for(int i = 0; i <= len -1; ++i) {
                pigWord.append(word.charAt(i));
            } 
            pigWord.append("ay");
        } else {
            for (int i = 1; i <= len - 1; ++i) {
                pigWord.append(word.charAt(i));
            }

            if (Character.isUpperCase(word.charAt(0))) {
                //to change other char to Uppercase
                pigWord.setCharAt(0,Character.toUpperCase(pigWord.charAt(0)));
            }
            //to change firstChar to lowercase.
            char letter1 = Character.toLowerCase(firstChar);
            pigWord.append(letter1);
            pigWord.append("ay");
        }

        return pigWord.toString();
    }

    public static String stringToPig(String input) {
        int len = input.length();
        StringBuilder output = new StringBuilder();
        StringBuilder wordAssemble = new StringBuilder();
        for(int i = 0; i <= len - 1; ++i) {
            if (Character.isAlphabetic(input.charAt(i)) | Character.isDigit(input.charAt(i))) {
                wordAssemble.append(input.charAt(i));
            }  else if (input.charAt(i) == ' ') {
                output.append(wordToPig(wordAssemble.toString()));
                wordAssemble.delete(0, wordAssemble.length() - 1);
                output.append(' ');
            } else if (i == len - 1) {
                output.append(wordToPig(wordAssemble.toString()));
            } else {
                char punct = input.charAt(i);
                output.append(wordToPig(wordAssemble.toString()));
                output.append(punct);
                wordAssemble.delete(0, wordAssemble.length() - 1);
                
            }
        }
        return output.toString();
    }

    public static boolean isVowel(char a) {
        if(a == 'A' | a == 'E' | a == 'I' | a == 'O' | a == 'U' | a == 'a' | a == 'e' | a == 'i' | a == 'o' | a == 'u') {
            return true;
        } else {
            return false;
        }
    }
}