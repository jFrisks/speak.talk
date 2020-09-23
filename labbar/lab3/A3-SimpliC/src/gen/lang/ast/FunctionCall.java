/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.4 */
package lang.ast;
import java.io.PrintStream;
import java.util.Set;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
/**
 * @ast node
 * @declaredat /Users/lucas/Documents/LTH/edan_new_new/edan65-compilers/labbar/lab3/A3-SimpliC/src/jastadd/calc.ast:16
 * @astdecl FunctionCall : Expr ::= IdUse Expr*;
 * @production FunctionCall : {@link Expr} ::= <span class="component">{@link IdUse}</span> <span class="component">{@link Expr}*</span>;

 */
public class FunctionCall extends Expr implements Cloneable {
  /**
   * @aspect Visitor
   * @declaredat /Users/lucas/Documents/LTH/edan_new_new/edan65-compilers/labbar/lab3/A3-SimpliC/src/jastadd/Visitor.jrag:74
   */
  public Object accept(Visitor visitor, Object data) {
        return visitor.visit(this, data);
    }
  /**
   * @aspect PrettyPrint
   * @declaredat /Users/lucas/Documents/LTH/edan_new_new/edan65-compilers/labbar/lab3/A3-SimpliC/src/jastadd/PrettyPrint.jrag:144
   */
  public void prettyPrint(PrintStream out, String ind) {
        getIdUse().prettyPrint(out, ind);
        out.print("(");
        for (int i = 0; i < getExprList().numChildren(); i++) {
          if(i == 0){
            (getExprList().getChild(i)).prettyPrint(out, ind);
          }else{
            out.print(", ");
            (getExprList().getChild(i)).prettyPrint(out, ind);
          }
        }
        out.print(")");
    }
  /**
   * @aspect NameAnalysis
   * @declaredat /Users/lucas/Documents/LTH/edan_new_new/edan65-compilers/labbar/lab3/A3-SimpliC/src/jastadd/NameAnalysis.jrag:96
   */
  public void checkNames(PrintStream err, SymbolTable symbols) {
        getIdUse().checkNames(err, symbols);
    }
  /**
   * @declaredat ASTNode:1
   */
  public FunctionCall() {
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
    setChild(new List(), 1);
  }
  /**
   * @declaredat ASTNode:14
   */
  @ASTNodeAnnotation.Constructor(
    name = {"IdUse", "Expr"},
    type = {"IdUse", "List<Expr>"},
    kind = {"Child", "List"}
  )
  public FunctionCall(IdUse p0, List<Expr> p1) {
    setChild(p0, 0);
    setChild(p1, 1);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:24
   */
  protected int numChildren() {
    return 2;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:28
   */
  public void flushAttrCache() {
    super.flushAttrCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:33
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:38
   */
  public FunctionCall clone() throws CloneNotSupportedException {
    FunctionCall node = (FunctionCall) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:43
   */
  public FunctionCall copy() {
    try {
      FunctionCall node = (FunctionCall) clone();
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
   * @declaredat ASTNode:62
   */
  @Deprecated
  public FunctionCall fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:72
   */
  public FunctionCall treeCopyNoTransform() {
    FunctionCall tree = (FunctionCall) copy();
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
   * @declaredat ASTNode:92
   */
  public FunctionCall treeCopy() {
    FunctionCall tree = (FunctionCall) copy();
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
  public FunctionCall setIdUse(IdUse node) {
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
   * Replaces the Expr list.
   * @param list The new list node to be used as the Expr list.
   * @apilevel high-level
   */
  public FunctionCall setExprList(List<Expr> list) {
    setChild(list, 1);
    return this;
  }
  /**
   * Retrieves the number of children in the Expr list.
   * @return Number of children in the Expr list.
   * @apilevel high-level
   */
  public int getNumExpr() {
    return getExprList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Expr list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Expr list.
   * @apilevel low-level
   */
  public int getNumExprNoTransform() {
    return getExprListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Expr list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Expr list.
   * @apilevel high-level
   */
  public Expr getExpr(int i) {
    return (Expr) getExprList().getChild(i);
  }
  /**
   * Check whether the Expr list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasExpr() {
    return getExprList().getNumChild() != 0;
  }
  /**
   * Append an element to the Expr list.
   * @param node The element to append to the Expr list.
   * @apilevel high-level
   */
  public FunctionCall addExpr(Expr node) {
    List<Expr> list = (parent == null) ? getExprListNoTransform() : getExprList();
    list.addChild(node);
    return this;
  }
  /** @apilevel low-level 
   */
  public FunctionCall addExprNoTransform(Expr node) {
    List<Expr> list = getExprListNoTransform();
    list.addChild(node);
    return this;
  }
  /**
   * Replaces the Expr list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public FunctionCall setExpr(Expr node, int i) {
    List<Expr> list = getExprList();
    list.setChild(node, i);
    return this;
  }
  /**
   * Retrieves the Expr list.
   * @return The node representing the Expr list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Expr")
  public List<Expr> getExprList() {
    List<Expr> list = (List<Expr>) getChild(1);
    return list;
  }
  /**
   * Retrieves the Expr list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Expr list.
   * @apilevel low-level
   */
  public List<Expr> getExprListNoTransform() {
    return (List<Expr>) getChildNoTransform(1);
  }
  /**
   * @return the element at index {@code i} in the Expr list without
   * triggering rewrites.
   */
  public Expr getExprNoTransform(int i) {
    return (Expr) getExprListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the Expr list.
   * @return The node representing the Expr list.
   * @apilevel high-level
   */
  public List<Expr> getExprs() {
    return getExprList();
  }
  /**
   * Retrieves the Expr list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Expr list.
   * @apilevel low-level
   */
  public List<Expr> getExprsNoTransform() {
    return getExprListNoTransform();
  }

}
