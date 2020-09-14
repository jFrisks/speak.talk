/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.4 */
package lang.ast;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
/**
 * @ast node
 * @declaredat /Users/lucas/Documents/LTH/edan_new_new/edan65-compilers/labbar/lab2/A2-SimpliC/src/jastadd/calc.ast:1
 * @astdecl Program : ASTNode ::= FunctionCallStmt*;
 * @production Program : {@link ASTNode} ::= <span class="component">{@link FunctionCallStmt}*</span>;

 */
public class Program extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @declaredat ASTNode:1
   */
  public Program() {
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
    children = new ASTNode[1];
    setChild(new List(), 0);
  }
  /**
   * @declaredat ASTNode:14
   */
  @ASTNodeAnnotation.Constructor(
    name = {"FunctionCallStmt"},
    type = {"List<FunctionCallStmt>"},
    kind = {"List"}
  )
  public Program(List<FunctionCallStmt> p0) {
    setChild(p0, 0);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:23
   */
  protected int numChildren() {
    return 1;
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
  public Program clone() throws CloneNotSupportedException {
    Program node = (Program) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:42
   */
  public Program copy() {
    try {
      Program node = (Program) clone();
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
  public Program fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:71
   */
  public Program treeCopyNoTransform() {
    Program tree = (Program) copy();
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
  public Program treeCopy() {
    Program tree = (Program) copy();
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
   * Replaces the FunctionCallStmt list.
   * @param list The new list node to be used as the FunctionCallStmt list.
   * @apilevel high-level
   */
  public Program setFunctionCallStmtList(List<FunctionCallStmt> list) {
    setChild(list, 0);
    return this;
  }
  /**
   * Retrieves the number of children in the FunctionCallStmt list.
   * @return Number of children in the FunctionCallStmt list.
   * @apilevel high-level
   */
  public int getNumFunctionCallStmt() {
    return getFunctionCallStmtList().getNumChild();
  }
  /**
   * Retrieves the number of children in the FunctionCallStmt list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the FunctionCallStmt list.
   * @apilevel low-level
   */
  public int getNumFunctionCallStmtNoTransform() {
    return getFunctionCallStmtListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the FunctionCallStmt list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the FunctionCallStmt list.
   * @apilevel high-level
   */
  public FunctionCallStmt getFunctionCallStmt(int i) {
    return (FunctionCallStmt) getFunctionCallStmtList().getChild(i);
  }
  /**
   * Check whether the FunctionCallStmt list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasFunctionCallStmt() {
    return getFunctionCallStmtList().getNumChild() != 0;
  }
  /**
   * Append an element to the FunctionCallStmt list.
   * @param node The element to append to the FunctionCallStmt list.
   * @apilevel high-level
   */
  public Program addFunctionCallStmt(FunctionCallStmt node) {
    List<FunctionCallStmt> list = (parent == null) ? getFunctionCallStmtListNoTransform() : getFunctionCallStmtList();
    list.addChild(node);
    return this;
  }
  /** @apilevel low-level 
   */
  public Program addFunctionCallStmtNoTransform(FunctionCallStmt node) {
    List<FunctionCallStmt> list = getFunctionCallStmtListNoTransform();
    list.addChild(node);
    return this;
  }
  /**
   * Replaces the FunctionCallStmt list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public Program setFunctionCallStmt(FunctionCallStmt node, int i) {
    List<FunctionCallStmt> list = getFunctionCallStmtList();
    list.setChild(node, i);
    return this;
  }
  /**
   * Retrieves the FunctionCallStmt list.
   * @return The node representing the FunctionCallStmt list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="FunctionCallStmt")
  public List<FunctionCallStmt> getFunctionCallStmtList() {
    List<FunctionCallStmt> list = (List<FunctionCallStmt>) getChild(0);
    return list;
  }
  /**
   * Retrieves the FunctionCallStmt list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the FunctionCallStmt list.
   * @apilevel low-level
   */
  public List<FunctionCallStmt> getFunctionCallStmtListNoTransform() {
    return (List<FunctionCallStmt>) getChildNoTransform(0);
  }
  /**
   * @return the element at index {@code i} in the FunctionCallStmt list without
   * triggering rewrites.
   */
  public FunctionCallStmt getFunctionCallStmtNoTransform(int i) {
    return (FunctionCallStmt) getFunctionCallStmtListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the FunctionCallStmt list.
   * @return The node representing the FunctionCallStmt list.
   * @apilevel high-level
   */
  public List<FunctionCallStmt> getFunctionCallStmts() {
    return getFunctionCallStmtList();
  }
  /**
   * Retrieves the FunctionCallStmt list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the FunctionCallStmt list.
   * @apilevel low-level
   */
  public List<FunctionCallStmt> getFunctionCallStmtsNoTransform() {
    return getFunctionCallStmtListNoTransform();
  }

}
