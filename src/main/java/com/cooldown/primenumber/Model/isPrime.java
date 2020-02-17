package com.cooldown.primenumber.Model;

public class isPrime {

	public static int JudgePrimeNumber(int num) {
	    //2なら素数
		if (num == 2) {
	    	return 0;
	    }

		//偶数は全部2で割れるから素数じゃない
	    if (num % 2 == 0) {
	    	return 1;
	    }

	    int i = 3;
	    //numの平方根を求める
	    double root = Math.sqrt(num);
	    
	    //9以上はループ
	    while (i <= root)
	    {
		     //3以上の奇数で割り切れたら素数じゃない
	        if (num % i == 0)
	        {
	            return 1;
	        }
	     i += 2;
	    }
	    //割り切れなかったら素数（3,5,7はループせず素数と判定）
	    return 0;
	}
}