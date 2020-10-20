package com.algo.string;

public class CompareVersions {
    public int compareVersion(String version1, String version2) {
        String[] str1= version1.split("\\.");
        String[] str2= version2.split("\\.");
        int i =0,j=0;
        while(i<str1.length && j< str2.length){
            if(Integer.parseInt(str1[i]) < Integer.parseInt(str2[j])){
                return 1;
            }else if(Integer.parseInt(str1[i]) > Integer.parseInt(str2[j])){
                return -1;
            } else{
                i++;
                j++;
            }
        }
        while(i<str1.length || j< str2.length){

            if(i!=str1.length && Integer.parseInt(str1[i++]) !=0){
                return 1;
            }else if(j!=str2.length && Integer.parseInt(str2[j++]) !=0){
                return -1;
            }

        }
        return 0;

    }
    public static void main(String[] args){
        CompareVersions compareVersions = new CompareVersions();
        System.out.println(compareVersions.compareVersion("0.1","1.1"));
    }
}
