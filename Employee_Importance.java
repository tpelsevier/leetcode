/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
//Time O(V+E)
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Employee> map = new HashMap<>();
        for(int i = 0; i < employees.size(); i++){
            map.put(employees.get(i).id,employees.get(i));
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);
        int importance = 0;

        while(!queue.isEmpty()){
            int val = queue.poll();
            Employee employee = map.get(val);
            importance += employee.importance;
            for(int next: employee.subordinates){
                queue.offer(next);
            }
        }
        return importance;
    }
}
