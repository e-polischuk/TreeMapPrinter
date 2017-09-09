package copy.java.util;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * This simple short application investigates java.util.TreeMap with
 * help of {@link TreeMapPrinter}. Unless your console supports 
 * color print then before run uncomment the line 45. As nodes are 
 * handled randomly, the application should be run several times to 
 * watch how TreeMap works in different cases.
 * 
 * @author e-polischuk
 * @see TreeMapPrinter
 */

public class TreeMapInvestigation {
    
    static int nodesCount = 10; // can be changed manually
    
    // java.util.TreeMap put/remove visualization
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void main(String[] args) {
	TreeMap<Integer, Integer> tree = new TreeMap<>();
	int put = nodesCount + 1;
	int end = nodesCount + put;
	System.out.println("TreeMap put/remove visualization:");
	String operator = null;
	Integer node = null;
	List<Integer> keys;
	for (int i = 1; i < end; i++) {
	    if (i < put) {
		node = (int) (Math.random() * 99) + 1;
		tree.put(node, node);
		operator = "put";
	    } else if (!tree.isEmpty()) {
		keys = new ArrayList(tree.keySet());
		int index = (int) (Math.random() * keys.size());
		node = tree.remove(keys.get(index));
		operator = "remove";
	    } else operator = null;
	    
	    if (operator != null) {
//		TreeMapPrinter.setColorPrintSupport(false);
		String g = TreeMapPrinter.isColorPrintSupport() ? "\u001B[32m" : "";
		String x = TreeMapPrinter.isColorPrintSupport() ? "\u001B[0m" : "";
		System.out.println(g+ "> " + operator + "(" + node + "):" +x);
		TreeMapPrinter.printTree(tree);
		System.out.println();
	    }
	}
    }
    
}
