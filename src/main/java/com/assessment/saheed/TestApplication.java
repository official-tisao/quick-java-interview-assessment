package com.assessment.saheed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TestApplication {

    public static class Solution {
        public String numWordsFiboNacci(String num){
            String[] out = new String[0];
            String outS ="";
            if(num.contains(" ")){
                out = num.split(" ");
                outS = numWordsFiboNacci(Integer.valueOf(out[0]));
            }
            else { outS = numWordsFiboNacci(Integer.valueOf(num)); }
            if(num.contains(" ")) out[0]=""; outS = String.join(" ", out) + outS;
            return outS;
        }
        public String numWordsFiboNacci(int num){
            int temp =0,workMode=0;
            if(num > (Math.pow(2, 31)-1)){
                return "Unsupported";
            } else {
                if(num >= 1_000_000_000){
                    System.out.println("Here 1");
                    temp =(int)Math.floor(num/1000000000);
                    workMode = num - (temp*1000000000);
                    return numWordsFiboNacci((int)Math.floor(num/1_000_000_000)) + " Billion" + (workMode>0?" "+numWordsFiboNacci(workMode):"");
                } else if (num >= 1_000_000) {
                    System.out.println("Here 2");
                    temp =(int)Math.floor(num/1000000);
                    workMode = num - (temp*1000000);
                    return numWordsFiboNacci((int)Math.floor(num/1_000_000)) + " Million" + (workMode>0?" "+numWordsFiboNacci(workMode):"");
                } else if (num >= 1_000) {
                    temp =(int)Math.floor(num/1000);
                    System.out.println("Here 3= ee="+temp);
                    workMode = num - (temp*1000);
                    return numWordsFiboNacci((int)Math.floor(num/1_000)) + " Thousand" + (workMode>0?" "+numWordsFiboNacci(workMode):"");
                }  else if (num >= 100) {
                    System.out.println("Here 4");
                    temp =(int)Math.floor(num/100);
                    workMode = num - (temp*100);
                    return numWordsFiboNacci(temp) + " Hundred" + (workMode>0?" and "+numWordsFiboNacci(workMode):"");
                } else if(num>19 && num<100){
                    //  && (num % 10 == 0)
                    System.out.println("Here 5");
                    switch (num/10) {
                        case 2:
                            return "Twenty " + numWordsFiboNacci(num-20);
                        case 3:
                            return "Thirty " + numWordsFiboNacci(num-30);
                        case 4:
                            return "Fourty " + numWordsFiboNacci(num-40);
                        case 5:
                            return "Fifty " + numWordsFiboNacci(num-50);
                        case 6:
                            return "Sixty " + numWordsFiboNacci(num-60);
                        case 7:
                            return "Seventy " + numWordsFiboNacci(num-70);
                        case 8:
                            return "Eighty " + numWordsFiboNacci(num-80);
                        case 9:
                            return "Ninety " + numWordsFiboNacci(num-90);
                        default:
                            return "";
                    }
                }else if(num > 0 && num < 20){
                    System.out.println("Here 6");
                    if (num == 1) {
                        return "One";
                    } else if (num == 2) {
                        return "Two";
                    } else if (num == 3) {
                        return "Three";
                    } else if (num == 4) {
                        return "Four";
                    } else if (num == 5) {
                        return "Five";
                    } else if (num == 6) {
                        return "Six";
                    } else if (num == 7) {
                        return "Seven";
                    } else if (num == 8) {
                        return "Eight";
                    } else if (num == 9) {
                        return "Nine";
                    } else if (num == 10) {
                        return "Ten";
                    } else if (num == 11) {
                        return "Eleven";
                    } else if (num == 12) {
                        return "Twelve";
                    } else if (num == 13) {
                        return "Thirteen";
                    } else if (num == 14) {
                        return "Fourteen";
                    } else if (num == 15) {
                        return "Fifteen";
                    } else if (num == 16) {
                        return "Sixteen";
                    } else if (num == 17) {
                        return "Seventeen";
                    } else if (num == 18) {
                        return "Eighteen";
                    } else if (num == 19){
                        return "Nineteen";
                    }


                }
            }
            return "";

        }

        public String numWords(int num){
            int temp =0,workMode=0;
            if(num > (Math.pow(2, 31)-1)){
                return "";
            } else {
                if(num >= 1_000_000_000){
                    temp =(int)Math.floor(num/1000000000);
                    workMode = num - (temp*1000000000);
                    return numWordsFiboNacci((int)Math.floor(num/1_000_000_000)) + " Billion" + (workMode>0?" "+numWordsFiboNacci(workMode):"");
                } else if (num >= 1_000_000) {
                    temp =(int)Math.floor(num/1000000);
                    workMode = num - (temp*1000000);
                    return numWordsFiboNacci((int)Math.floor(num/1_000_000)) + " Million" + (workMode>0?" "+numWordsFiboNacci(workMode):"");
                } else if (num >= 1_000) {
                    temp =(int)Math.floor(num/1000);
                    workMode = num - (temp*1000);
                    return numWordsFiboNacci((int)Math.floor(num/1_000)) + " Thousand" + (workMode>0?" "+numWordsFiboNacci(workMode):"");
                }  else if (num >= 100) {
                    temp =(int)Math.floor(num/100);
                    workMode = num - (temp*100);
                    return numWordsFiboNacci(temp) + " Hundred" + (workMode>0?" and "+numWordsFiboNacci(workMode):"");
                } else if(num>19 && num<100){
                    //  && (num % 10 == 0)
                    switch (num/10) {
                        case 2:
                            return "Twenty " + numWordsFiboNacci(num-20);
                        case 3:
                            return "Thirty " + numWordsFiboNacci(num-30);
                        case 4:
                            return "Fourty " + numWordsFiboNacci(num-40);
                        case 5:
                            return "Fifty " + numWordsFiboNacci(num-50);
                        case 6:
                            return "Sixty " + numWordsFiboNacci(num-60);
                        case 7:
                            return "Seventy " + numWordsFiboNacci(num-70);
                        case 8:
                            return "Eighty " + numWordsFiboNacci(num-80);
                        case 9:
                            return "Ninety " + numWordsFiboNacci(num-90);
                        default:
                            return "";
                    }
                }else if(num > 0 && num < 20){
                    if (num == 1) {
                        return "One";
                    } else if (num == 2) {
                        return "Two";
                    } else if (num == 3) {
                        return "Three";
                    } else if (num == 4) {
                        return "Four";
                    } else if (num == 5) {
                        return "Five";
                    } else if (num == 6) {
                        return "Six";
                    } else if (num == 7) {
                        return "Seven";
                    } else if (num == 8) {
                        return "Eight";
                    } else if (num == 9) {
                        return "Nine";
                    } else if (num == 10) {
                        return "Ten";
                    } else if (num == 11) {
                        return "Eleven";
                    } else if (num == 12) {
                        return "Twelve";
                    } else if (num == 13) {
                        return "Thirteen";
                    } else if (num == 14) {
                        return "Fourteen";
                    } else if (num == 15) {
                        return "Fifteen";
                    } else if (num == 16) {
                        return "Sixteen";
                    } else if (num == 17) {
                        return "Seventeen";
                    } else if (num == 18) {
                        return "Eighteen";
                    } else if (num == 19){
                        return "Nineteen";
                    }
                }
            }
            return "";

        }
    }

    public boolean testMethod(String input){
        char[] testCh = {'(', ')', '{', '}', '[',']'};

        ArrayList<Character> testChar = new ArrayList<>();
        ArrayList<Character> test2Char = new ArrayList<>();
        ArrayList<Character> test3Char = new ArrayList<>(List.of(new Character[]{'(', ')', '{', '}', '[', ']'}));
        testChar.add('(');
        test2Char.add(')');
        testChar.add('{');
        test2Char.add('}');
        testChar.add('[');
        test2Char.add(']');
        char[] inputChar = input.toCharArray();
        ArrayList<Character> expect = new ArrayList<>();
        for(int i = 0; i < inputChar.length; i++){
            if(testChar.contains(inputChar[i])){
                int ii = testChar.indexOf(inputChar[i]);
                expect.add(test2Char.get(ii));
                continue;
            }
            if(test2Char.contains(inputChar[i])){
                if(expect.isEmpty()) return false;
                char t2c = expect.remove(expect.toArray().length-1);
                    if(inputChar[i] != t2c) return false;

            }

        }

        if(expect.isEmpty()){ return true; }


        return false;
    }
    public static void main(String[] args) {



        TestApplication app = new TestApplication();
        Solution solution = new Solution();
        System.out.println(app.testMethod("())[]{}"));
        int o=0;
        //for(int i = 0; i<10; i++){
          //  o=(new Random().nextInt(2123212231 - 1 + 1) + 1);
            o=2123212231;
            //System.out.println("Num:"+21200000+" Words:"+ solution.numWordsFiboNacci(21200000));
//            System.out.println("Num:"+9+" Words:"+ solution.numWordsFiboNacci(9));
//            System.out.println("Num:"+29+" Words:"+ solution.numWordsFiboNacci(29));
//            System.out.println("Num:"+290+" Words:"+ solution.numWordsFiboNacci(290));
//            System.out.println("Num:"+295+" Words:"+ solution.numWordsFiboNacci(295));
//            System.out.println("Num:"+2905+" Words:"+ solution.numWordsFiboNacci(2905));
//        System.out.println("Num:"+29802+" Words:"+ solution.numWordsFiboNacci(29802));
//        System.out.println("Num:"+129802+" Words:"+ solution.numWordsFiboNacci(129802));
//        System.out.println("Num:"+9129802+" Words:"+ solution.numWordsFiboNacci(9129802));
//        System.out.println("Num:"+96129802+" Words:"+ solution.numWordsFiboNacci(96129802));
//        System.out.println("Num:"+986129802+" Words:"+ solution.numWordsFiboNacci(986129802));
        System.out.println("Num:"+2146129802+" Words:"+ solution.numWordsFiboNacci(2146129802));
            //System.out.println("Num:"+o+" Words:"+ solution.numWordsFiboNacci(o));
        //}

    }
    /*
    * Problem Statement:
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
*  determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
    * */
}
