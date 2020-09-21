/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.4 */
package lang.ast;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
/**
 * @ast node
 * @declaredat /Users/lucas/Documents/LTH/edan_new_new/edan65-compilers/labbar/lab3/A3-SimpliC/src/jastadd/calc.ast:4
 * @astdecl Comment : ProgramStmt ::= CommentStmt;
 * @production Comment : {@link ProgramStmt} ::= <span class="component">{@link CommentStmt}</span>;

 */
public class Comment extends ProgramStmt implements Cloneable {
  /**
   * @declaredat ASTNode:1
   */
  public Comment() {
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
  }
  /**
   * @declaredat ASTNode:13
   */
  @ASTNodeAnnotation.Constructor(
    name = {"CommentStmt"},
    type = {"CommentStmt"},
    kind = {"Child"}
  )
  public Comment(CommentStmt p0) {
    setChild(p0, 0);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:22
   */
  protected int numChildren() {
    return 1;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:26
   */
  public void flushAttrCache() {
    super.flushAttrCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:31
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:36
   */
  public Comment clone() throws CloneNotSupportedException {
    Comment node = (Comment) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:41
   */
  public Comment copy() {
    try {
      Comment node = (Comment) clone();
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
   * @declaredat ASTNode:60
   */
  @Deprecated
  public Comment fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:70
   */
  public Comment treeCopyNoTransform() {
    Comment tree = (Comment) copy();
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
   * @declaredat ASTNode:90
   */
  public Comment treeCopy() {
    Comment tree = (Comment) copy();
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
   * Replaces the CommentStmt child.
   * @param node The new node to replace the CommentStmt child.
   * @apilevel high-level
   */
  public Comment setCommentStmt(CommentStmt node) {
    setChild(node, 0);
    return this;
  }
  /**
   * Retrieves the CommentStmt child.
   * @return The current node used as the CommentStmt child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="CommentStmt")
  public CommentStmt getCommentStmt() {
    return (CommentStmt) getChild(0);
  }
  /**
   * Retrieves the CommentStmt child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the CommentStmt child.
   * @apilevel low-level
   */
  public CommentStmt getCommentStmtNoTransform() {
    return (CommentStmt) getChildNoTransform(0);
  }

}
