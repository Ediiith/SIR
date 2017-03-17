/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NF;

/**
 *
 * @author Marie
 */
public class Levenshtein {
    /**
 * compute the Levenshtein distance between two strings
 * @author Xavier Philippeau
 * 
 * @param s0 String 0
 * @param s1 String 1
 * @return the Levenshtein distance
 */
    //Plus les phrases sont ressemblantes, plus le résulat est petit (0 si elles sont égales)
public int levenshtein(String s0, String s1) {
	int len0 = s0.length()+1;
	int len1 = s1.length()+1;
 
	// the array of distances
	int[] cost = new int[len0];
	int[] newcost = new int[len0];
 
	// initial cost of skipping prefix in String s0
	for(int i=0;i<len0;i++) cost[i]=i;
 
	// dynamicaly computing the array of distances
 
	// transformation cost for each letter in s1
	for(int j=1;j<len1;j++) {
 
		// initial cost of skipping prefix in String s1
		newcost[0]=j-1;
 
		// transformation cost for each letter in s0
		for(int i=1;i<len0;i++) {
 
			// matching current letters in both strings
			int match = (s0.charAt(i-1)==s1.charAt(j-1))?0:1;
 
			// computing cost for each transformation
			int cost_replace = cost[i-1]+match;
			int cost_insert  = cost[i]+1;
			int cost_delete  = newcost[i-1]+1;
 
			// keep minimum cost
			newcost[i] = min(cost_insert, cost_delete, cost_replace);
		}
 
		// swap cost/newcost arrays
		int[] swap=cost; cost=newcost; newcost=swap;
	}
 
	// the distance is the cost for transforming all letters in both strings
	return cost[len0-1];
}

public int min(int a, int b, int c){
    int minimum=a;

    if (b<=a && b<=c){
        minimum=b;
    }
    else if (c<=a && c<=b){
        minimum=c;
    }
    return minimum;
}
}