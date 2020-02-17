package com.cooldown.primenumber.Model;

public class isPrime {

	public static int JudgePrimeNumber(int num) {
	    if (num < 2) {
	    	return 1;
	    }
	    else if (num == 2) {
	    	return 0;
	    }

	    if (num % 2 == 0) {
	    	return 1;
	    }

	    int i = 3;
	    double root = Math.sqrt(num);
	    while (i <= root)
	    {
	        if (num % i == 0)
	        {
	            return 1;
	        }
	     i += 2;
	    }
	    return 0;
	}
}