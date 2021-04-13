package com.daily.verify.verify.threadPool.thread;
import java.util.*;
public class Main{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] arr = new String[n];
        for(int i=0;i<n;i++){
            arr[i] = in.next();
        }
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            // System.out.println(arr[i]);
            if(i-1>=0&&i+1<n){
                System.out.println(func(arr[i-1],arr[i],arr[i+1]));
            }else if(i==0&&i+1<n){
                System.out.println(func("",arr[i],arr[i+1]));
            }else{
                System.out.println(func(arr[i-1],arr[i],""));
            }
        }
    }

    public static String func(String pre,String str,String last){
        int max = 0;
        int i=0;
        //boolean flag = true;
        while( i<str.length() && i<pre.length() && str.charAt(i)==pre.charAt(i) ){
            i++;
        }
        max = i;
        int j=0;
        while(j<str.length()&&j<last.length()&&str.charAt(j)==last.charAt(j)){
            j++;
            if(j>max) max = j;
        }
        return str.substring(0,max+1);
    }
}