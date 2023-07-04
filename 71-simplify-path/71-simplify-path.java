import java.util.StringTokenizer;
class Solution {
    public String simplifyPath(String path) {
        StringTokenizer tokenizer = new StringTokenizer(path, "/");
        List<String> list = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            list.add(tokenizer.nextToken());
        }

        // System.out.println(list);

        Stack<String> stack = new Stack<>();
        Set<String> set = new HashSet<>();
        set.add("/");
        set.add(".");
        set.add("..");
        
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (!set.contains(s)) {
                stack.push(s);
            } else if (s.equals(".")) {
                continue;
            } else if (s.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
                continue;
            }
        }

        String res = "";
        System.out.println(stack);
        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }
        if (res.length() == 0) {
            res = "/";
        }
        
        return res;
    }
}