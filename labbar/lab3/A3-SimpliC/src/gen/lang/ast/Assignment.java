/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.4 */
package lang.ast;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
/**
 * @ast node
 * @declaredat /Users/lucas/Documents/LTH/edan_new_new/edan65-compilers/labbar/lab3/A3-SimpliC/src/jastadd/calc.ast:7
 * @astdecl Assignment : Stmt ::= IdUse Expr;
 * @production Assignment : {@link Stmt} ::= <span class="component">{@link IdUse}</span> <span class="component">{@link Expr}</span>;

 */
public class Assignment extends Stmt implements Cloneable {
  /**
   * @aspect Visitor
   * @declaredat /Users/lucas/Documents/LTH/edan_new_new/edan65-compilers/labbar/lab3/A3-SimpliC/src/jastadd/Visitor.jrag:65
   */
  public Object accept(Visitor visitor, Object data) {
		return visitor.visit(this, data);
	}
  /**
   * @aspect PrettyPrint
   * @declaredat /Users/lucas/Documents/LTH/edan_new_new/edan65-compilers/labbar/lab3/A3-SimpliC/src/jastadd/PrettyPrint.jrag:81
   */
  public void prettyPrint(PrintStream out, String ind) {
		getIdUse().prettyPrint(out, ind);
		out.append(" = ");
		getExpr().prettyPrint(out, ind+"    ");
	}
  /**
   * @declaredat ASTNode:1
   */
  public Assignment() {
    super();
  }
  /**
   * Initializes the child array to the correct size.
   * Initializes List and Opt nta children.
   * @apilevel internal
   * @ast method
   * @declaredat ASTNode:10
   */
  public void init$Children() {
    children = new ASTNode[2];
  }
  /**
   * @declaredat ASTNode:13
   */
  @ASTNodeAnnotation.Constructor(
    name = {"IdUse", "Expr"},
    type = {"IdUse", "Expr"},
    kind = {"Child", "Child"}
  )
  public Assignment(IdUse p0, Expr p1) {
    setChild(p0, 0);
    setChild(p1, 1);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:23
   */
  protected int numChildren() {
    return 2;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:27
   */
  public void flushAttrCache() {
    super.flushAttrCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:32
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:37
   */
  public Assignment clone() throws CloneNotSupportedException {
    Assignment node = (Assignment) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:42
   */
  public Assignment copy() {
    try {
      Assignment node = (Assignment) clone();
      node.parent = null;
      if (children != null) {
        node.children = (ASTNode[]) children.clone();
      }
      return node;
    } catch (CloneNotSupportedException e) {
      throw new Error("Error: clone not supported for " + getClass().getName());
    }
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @deprecated Please use treeCopy or treeCopyNoTransform instead
   * @declaredat ASTNode:61
   */
  @Deprecated
  public Assignment fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:71
   */
  public Assignment treeCopyNoTransform() {
    Assignment tree = (Assignment) copy();
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        ASTNode child = (ASTNode) children[i];
        if (child != null) {
          child = child.treeCopyNoTransform();
          tree.setChild(child, i);
        }
      }
    }
    return tree;
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The subtree of this node is traversed to trigger rewrites before copy.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:91
   */
  public Assignment treeCopy() {
    Assignment tree = (Assignment) copy();
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        ASTNode child = (ASTNode) getChild(i);
        if (child != null) {
          child = child.treeCopy();
          tree.setChild(child, i);
        }
      }
    }
    return tree;
  }
  /**
   * Replaces the IdUse child.
   * @param node The new node to replace the IdUse child.
   * @apilevel high-level
   */
  public Assignment setIdUse(IdUse node) {
    setChild(node, 0);
    return this;
  }
  /**
   * Retrieves the IdUse child.
   * @return The current node used as the IdUse child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="IdUse")
  public IdUse getIdUse() {
    return (IdUse) getChild(0);
  }
  /**
   * Retrieves the IdUse child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the IdUse child.
   * @apilevel low-level
   */
  public IdUse getIdUseNoTransform() {
    return (IdUse) getChildNoTransform(0);
  }
  /**
   * Replaces the Expr child.
   * @param node The new node to replace the Expr child.
   * @apilevel high-level
   */
  public Assignment setExpr(Expr node) {
    setChild(node, 1);
    return this;
  }
  /**
   * Retrieves the Expr child.
   * @return The current node used as the Expr child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Expr")
  public Expr getExpr() {
    return (Expr) getChild(1);
  }
  /**
   * Retrieves the Expr child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Expr child.
   * @apilevel low-level
   */
  public Expr getExprNoTransform() {
    return (Expr) getChildNoTransform(1);
  }

}
