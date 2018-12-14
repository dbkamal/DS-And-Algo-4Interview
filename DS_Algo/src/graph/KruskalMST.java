package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * Find minimum spanning tree (MST) using Kruskal algorithm
 */
public class KruskalMST {
	
	UnionFindAlgo obj;
	ArrayList<String> forest;
	
	KruskalMST(UnionFindAlgo obj) {
		this.obj = obj;
		forest = new ArrayList<String>();
	}
	
	/*
	 * sort the collection based on edge weight
	 */
	HashMap<String, Integer> sortByWeight(HashMap<String, Integer> edgeList) {
		
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(edgeList.entrySet());
		//sort the list
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>> () {
			public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
				return (obj1.getValue()).compareTo(obj2.getValue());
			}
		});
		
		HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> aa : list) {
			System.out.println("st val " + aa.getKey() + ", " + aa.getValue());
			temp.put(aa.getKey(), aa.getValue());
		}
		
		return temp;
	}
	
	/*
	 * Main routine.
	 * Send the minimum spanning tree
	 * Example, {1,3}, {2,3}
	 */
	void mstForest() {
		
		HashMap<String, Integer> edgeList;
		//Sort the tree based on edge weight
		edgeList = sortByWeight(obj.graph.edgeList);
		
		Iterator<String> it = edgeList.keySet().iterator();
		
		while (it.hasNext()) {
			String p = it.next();
			System.out.println("key " + p);
			int comma = p.indexOf(",");
			int source = Integer.parseInt(p.substring(0, comma));
			int dest = Integer.parseInt(p.substring(comma+1, p.length()));
			
			if (obj.find(source) == obj.find(dest)) {
				//TODO
			}
			else {
				forest.add(p);
				obj.unionByRank(source, dest);
			}
		}
		
		for (String p : forest) {
			System.out.println("forest val");
			System.out.print(p + " ");
		}
	}
	
}
