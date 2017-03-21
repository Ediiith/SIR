package NF;

/**
 *
 * @author JEMCare Solution
 */

public class Levenshtein {
    //Calcule la distance Levenshtein entre deux strings s0 et s1 
    //Plus les phrases sont ressemblantes, plus le résulat est petit (0 si elles sont égales)
    
    public int levenshtein(String s0, String s1) {
	int len0 = s0.length()+1;
	int len1 = s1.length()+1;
 
	// tableau des distances
	int[] cost = new int[len0];
	int[] newcost = new int[len0];
 
	// coût initial de saut des préfixes dans le string s0
	for(int i=0;i<len0;i++) cost[i]=i;
 
	// calcule dynamiquement le tableau des distances
 
	// coût des transformations pour chaque lettre dans s1
	for(int j=1;j<len1;j++) {
 
		// coût initial de saut des préfixes dans le string s1
		newcost[0]=j-1;
 
		// coût des transformations pour chaque lettre dans s0
		for(int i=1;i<len0;i++) {
 
			// fait correspondre les lettres en commun dans les deux strings
			int match = (s0.charAt(i-1)==s1.charAt(j-1))?0:1;
 
			// calcule le coût pour chaque transformation
			int cost_replace = cost[i-1]+match;
			int cost_insert  = cost[i]+1;
			int cost_delete  = newcost[i-1]+1;
 
			// garde le coût minimum
			newcost[i] = min(cost_insert, cost_delete, cost_replace);
		}
 
		// change le nouveau coût
		int[] swap=cost; cost=newcost; newcost=swap;
	}
 
	// la distance est le coût pour la transformation de chaque lettre dans les deux strings
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
