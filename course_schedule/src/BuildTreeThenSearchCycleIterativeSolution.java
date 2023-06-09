import java.util.*;

public class BuildTreeThenSearchCycleIterativeSolution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0 || prerequisites.length == 1) return true;

        List<Req> roots = new ArrayList<>();
        Set<Integer> visitedTrees = new HashSet<>();
        for (int i=0; i < prerequisites.length; i++) {
            if (!visitedTrees.contains(prerequisites[i][0])) {
                Req root = new Req(prerequisites[i][0]);
                buildTree(root, prerequisites, visitedTrees);
                roots.add(root);
            }
        }

        for (int i=0; i < roots.size(); i++) {
            if (!isDag(roots.get(i))) return false;
        }

        return true;
    }

    private boolean isDag(Req root) {
        Set<Integer> visited = new HashSet<>();
        LinkedList<Req> parentsStack = new LinkedList<>();
        LinkedList<Req> stack = new LinkedList<>();

        stack.push(root);
        while(!stack.isEmpty()) {
            Req curr = stack.pop();

            if (parentsStack.peek() == curr) {
                visited.remove(curr.base);
                parentsStack.pop();
                continue;
            }

            if (visited.contains(curr.base)) return false;
            if (!curr.reqs.isEmpty()) {
                stack.push(curr);
                parentsStack.push(curr);
                visited.add(curr.base);
                for (Req req: curr.reqs) {
                    stack.push(req);
                }
            }
        }
        return true;
    }

    private void buildTree(Req root, int[][] prereqs, Set<Integer> visitedTrees) {
        LinkedList<Req> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Req curr = stack.pop();
            addRequirements(curr, prereqs, visitedTrees);
            for (int i=0; i < curr.reqs.size(); i++) {
                if (!visitedTrees.contains(curr.reqs.get(i).base)) {
                    stack.push(curr.reqs.get(i));
                }
            }
        }
    }

    private void addRequirements(Req req, int[][] prereqs, Set<Integer> visitedTrees) {
        for (int i=0; i < prereqs.length; i++) {
            if (prereqs[i][0] == req.base) {
                req.addReq(new Req(prereqs[i][1]));
                visitedTrees.add(prereqs[i][0]);
            }
        }
    }

    class Req {
        int base;
        LinkedList<Req> reqs = new LinkedList<>();

        public Req(int base) {
            this.base = base;
        }

        public void addReq(Req req) {
            reqs.push(req);
        }
    }
}
