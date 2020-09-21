package lang;

import lang.ast.*;

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
