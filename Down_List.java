//Recursive
public List<Integer> flattenList(Node node){
    List<Integer> result = new ArrayList<>();
    while(node.next != null){
        res.add(node.val);
        if(node.down != null) flatten(n.down,res);
        node = node.next;
    }
    return result;
}
private void flatten(Node n, List<Integer> res){
    while(node != null){
        res.add(node.val);
        if(node.down != null) flatten(n.down,res);
        node = node.next;
    }
}
//Iterative
public List<Integer> flattenList(Node node){
    List<Integer> result = new ArrayList<>();
    Stack<Node> stack = new Stack<>();
    while(node != null || !stack.isEmpty()){
        if(node == null) node = stack.pop();
        result.add(node.val);
        if(node.down != null) {
          if(node.next != null) stack.push(node.next);
          node = node.down;
        }else{
          node = node.next;
        }
    }
    return result;
}
