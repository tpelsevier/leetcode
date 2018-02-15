//Time O(N) Space O(N)
public class Solution {
    Map<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<>();//Store old node and new node
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        if(map.containsKey(node)) return map.get(node);//If this node is visted return the new node generated
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node,newNode);
        for(UndirectedGraphNode n:node.neighbors){//Iterate through it's neighbors
            newNode.neighbors.add(cloneGraph(n));
        }
        return newNode;
    }
}
