/*topological sort 给string pairs:
[dogs, are], [cats, are], [are, cute] 输出“dogs cats are cute".特别说明无环
*/

class String_In_Order{

  public static void main(String[] args) {
     System.out.println(correctOrder(new String[][]{ {"dogs", "are"}, {"cats", "are"}, {"are", "cute"}}));
     System.out.println(correctOrder(new String[][]{ {"care", "hello"}, {"hello", "world"}, {"world", "java"}}));
     System.out.println(correctOrder(new String[][]{ {"google", "facebook"}, {"google", "amazon"}, {"google", "apple"}}));
  }
  public static String correctOrder(String[][] inputs){
      int n = inputs.length;
      Map<String,List<String>> graph = new HashMap<>();
      Map<String,Integer> indegree = new HashMap<>();
      for(int i = 0; i < n; i++){
          if(!graph.containsKey(inputs[i][0])){
              graph.put(inputs[i][0], new ArrayList<>());
          }
          graph.get(inputs[i][0]).add(inputs[i][1]);
          indegree.put(inputs[i][1],indegree.getOrDefault(inputs[i][1],0) + 1);
      }
      Queue<String> queue = new LinkedList<>();
      Set<String> visited = new HashSet<>();
      for(String[] input: inputs){
          if(visited.add(input[0]) && !indegree.containsKey(input[0])) queue.offer(input[0]);
      }
      StringBuilder sb = new StringBuilder();
      while(!queue.isEmpty()){
          String curr = queue.poll();
          sb.append(curr+" ");
          if(!graph.containsKey(curr)) continue;
          for(String next: graph.get(curr)){
              if(indegree.get(next) == 1){
                  queue.offer(next);
              }
              else indegree.put(next,indegree.get(next)-1);
          }
         graph.remove(curr);
      }
      return sb.toString().trim();
  }

}
