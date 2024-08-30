package com.assessment.saheed;

public class NumberToWord {
    public String numberToWords(int num){
        if(num == 0) return "Zero";
        int temp =0,workMode=0;
        if(num > (Math.pow(2, 31)-1)){
            return "";
        } else {
            if(num >= 1_000_000_000){
                temp =(int)Math.floor(num/1000000000);
                workMode = num - (temp*1000000000);
                return numberToWords((int)Math.floor(num/1_000_000_000)) + " Billion" + (workMode>0?" "+numberToWords(workMode):"");
            } else if (num >= 1_000_000) {
                temp =(int)Math.floor(num/1000000);
                workMode = num - (temp*1000000);
                return numberToWords((int)Math.floor(num/1_000_000)) + " Million" + (workMode>0?" "+numberToWords(workMode):"");
            } else if (num >= 1_000) {
                temp =(int)Math.floor(num/1000);
                workMode = num - (temp*1000);
                return numberToWords((int)Math.floor(num/1_000)) + " Thousand" + (workMode>0?" "+numberToWords(workMode):"");
            }  else if (num >= 100) {
                temp =(int)Math.floor(num/100);
                workMode = num - (temp*100);
                //return numberToWords(temp) + " Hundred" + (workMode>0?" and "+numberToWords(workMode):"");
                return numberToWords(temp) + " Hundred" + (workMode>0?" "+numberToWords(workMode):"");
            } else if(num>19 && num<100){
                //  && (num % 10 == 0)
                switch (num/10) {
                    case 2:
                        workMode = num-20;
                        return "Twenty" + (workMode>0?" "+numberToWords(workMode):"");
                    case 3:
                        workMode = num-30;
                        return "Thirty" + (workMode>0?" "+numberToWords(workMode):"");
                    case 4:
                        workMode = num-40;
                        return "Forty" + (workMode>0?" "+numberToWords(workMode):"");
                    case 5:
                        workMode = num-50;
                        return "Fifty" + (workMode>0?" "+numberToWords(workMode):"");
                    case 6:
                        workMode = num-60;
                        return "Sixty" + (workMode>0?" "+numberToWords(workMode):"");
                    case 7:
                        workMode = num-70;
                        return "Seventy" + (workMode>0?" "+numberToWords(workMode):"");
                    case 8:
                        workMode = num-80;
                        return "Eighty" + (workMode>0?" "+numberToWords(workMode):"");
                    case 9:
                        workMode = num-90;
                        return "Ninety" + (workMode>0?" "+numberToWords(workMode):"");
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
    public static void main(String[] args) {
        NumberToWord solution = new NumberToWord();
        int o=0;
        //for(int i = 0; i<10; i++){
        //  o=(new Random().nextInt(2123212231 - 1 + 1) + 1);
        o=2123212231;
        //System.out.println("Num:"+21200000+" Words:"+ solution.numberToWords(21200000));
//            System.out.println("Num:"+9+" Words:"+ solution.numberToWords(9));
//            System.out.println("Num:"+29+" Words:"+ solution.numberToWords(29));
//            System.out.println("Num:"+290+" Words:"+ solution.numberToWords(290));
//            System.out.println("Num:"+295+" Words:"+ solution.numberToWords(295));
//            System.out.println("Num:"+2905+" Words:"+ solution.numberToWords(2905));
//        System.out.println("Num:"+29802+" Words:"+ solution.numberToWords(29802));
//        System.out.println("Num:"+129802+" Words:"+ solution.numberToWords(129802));
//        System.out.println("Num:"+9129802+" Words:"+ solution.numberToWords(9129802));
//        System.out.println("Num:"+96129802+" Words:"+ solution.numberToWords(96129802));
//        System.out.println("Num:"+986129802+" Words:"+ solution.numberToWords(986129802));
        System.out.println("Num:"+2146129802+" Words:"+ solution.numberToWords(2146129802));
        //System.out.println("Num:"+o+" Words:"+ solution.numberToWords(o));
        //}

    }
}