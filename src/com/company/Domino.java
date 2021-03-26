package com.company;

public class Domino {
    static String getIterationResult(String current_string, int iterations){
        int str_length = current_string.length();
        if(str_length<2){
            return current_string;
        }
        char[] results = current_string.toCharArray();
        char[] current_string_array = current_string.toCharArray();
        for(int iter1 = 0; iter1<iterations; ++iter1){
            boolean was_change = false;
            for(int iter2 = 0; iter2<str_length; ++iter2){
                if(current_string_array[iter2] == '|'){
                    if(iter2>0 && iter2+1<str_length){
                        if(current_string_array[iter2+1] == '\\' && current_string_array[iter2-1]!= '/') {
                            results[iter2] = '\\';
                            was_change = true;
                        } else if(current_string_array[iter2-1] == '/' && current_string_array[iter2+1]!= '\\') {
                            results[iter2] = '/';
                            was_change = true;
                        }
                    }else if(iter2 == 0 && current_string_array[iter2+1]=='\\'){
                        results[iter2] = '\\';
                    }else if(iter2==str_length-1 && current_string_array[str_length-1]=='/'){
                        results[iter2] = '/';
                    }

                }
            }
            if(!was_change){
                break;
            }
            System.arraycopy(results, 0, current_string_array, 0, str_length);
        }
        return new String(results);
    }

    static String getReverseIterationResults(String current_string, int iterations){
        int str_length = current_string.length();
        if(str_length<2){
            return current_string;
        }
        char[] results = current_string.toCharArray();
        char[] current_string_array = current_string.toCharArray();
        for(int iter1 = 0; iter1<iterations; ++iter1){
            boolean was_change = false;
            for(int iter2 = 0; iter2<str_length; ++iter2){
                if(iter2<str_length-1 && current_string_array[iter2+1]=='\\' && current_string_array[iter2]=='\\'
                        && (iter2 == 0 || current_string_array[iter2-1]!='\\')){
                    results[iter2] = '|';
                    was_change = true;
                }else if(iter2>0 && current_string_array[iter2-1]=='/' && current_string_array[iter2]=='/'
                        && (iter2 == str_length-1 || current_string_array[iter2+1]!='/')){
                    results[iter2] = '|';
                    was_change = true;
                }
            }
            if(!was_change){
                break;
            }
            System.arraycopy(results, 0, current_string_array, 0, str_length);
        }

        return new String(results);
    }

}
