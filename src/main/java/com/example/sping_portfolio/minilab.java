package com.example.sping_portfolio;

import java.util.Scanner;

public class minilab {
    public static void main(String args[]){
        int answer=1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("What factorial would you like?");
        int n = scanner.nextInt();
        for(int i=1; i<=n; i++)answer*=i;
        System.out.println("The factorial of " + n + " is " + answer);
    }
}
