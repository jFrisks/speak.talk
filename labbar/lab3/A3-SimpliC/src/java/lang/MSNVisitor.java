package lang;

import lang.ast.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MSNVisitor extends TraversingVisitor {
    private static int maxDepth = 0;
    private static int depth = 0;

    public static int result(ASTNode n) {
        MSNVisitor v = new MSNVisitor();
        n.accept(v, 0);
        return v.maxDepth;
    }

    public Object visit(Block node, Object data) {
        depth += 1;
        if(depth > maxDepth){
            maxDepth = depth;
        }
        visitChildren(node, null);
        depth -= 1;
        return data;
    }
}

/*
public class MSNVisitor extends TraversingVisitor {
    private static int maxDepth = 0;
    public static int result(ASTNode n) {
        MSNVisitor v = new MSNVisitor();
        n.accept(v, 0);
        return v.maxDepth;
    }

    public Object visit(Block node, Object data) {
        int newDepth = (int) data + 1;
        if (newDepth > maxDepth) {
            maxDepth = newDepth;
        }
        visitChildren(node, newDepth);
        return data;
    }
}
*/