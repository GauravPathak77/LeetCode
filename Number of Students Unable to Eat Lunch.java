class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();
        int n = students.length;

        for(int i=0; i<n; i++){
            q.add(students[i]);
            s.push(sandwiches[n-i-1]);
        }

        while(!s.isEmpty()){
            if(q.peek() == s.peek()){
                q.remove();
                s.pop();
            }
            else{
                if(isPossible(s.peek(), q)){
                    q.add(q.remove());
                } else {
                    return s.size();
                }
            }
        }
        return 0;
    }

    public static boolean isPossible(int ele, Queue<Integer> q){
        Iterator<Integer> it = q.iterator();
        while(it.hasNext()){
            if(it.next() == ele){
                return true;
            }
        }
        return false;
    }
}
