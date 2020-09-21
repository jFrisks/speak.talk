/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.4 */
package lang.ast;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
/**
 * @ast node
 * @declaredat /Users/lucas/Documents/LTH/edan_new_new/edan65-compilers/labbar/lab3/A3-SimpliC/src/jastadd/calc.ast:9
 * @astdecl CommentStmt : Stmt ::= <COMMENT:String>;
 * @production CommentStmt : {@link Stmt} ::= <span class="component">&lt;COMMENT:{@link String}&gt;</span>;

 */
public class CommentStmt extends Stmt implements Cloneable {
  /**
   * @declaredat ASTNode:1
   */
  public CommentStmt() {
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
  }
  /**
   * @declaredat ASTNode:12
   */
  @ASTNodeAnnotation.Constructor(
    name = {"COMMENT"},
    type = {"String"},
    kind = {"Token"}
  )
  public CommentStmt(String p0) {
    setCOMMENT(p0);
  }
  /**
   * @declaredat ASTNode:20
   */
  public CommentStmt(beaver.Symbol p0) {
    setCOMMENT(p0);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:24
   */
  protected int numChildren() {
    return 0;
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
  public CommentStmt clone() throws CloneNotSupportedException {
    CommentStmt node = (CommentStmt) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:43
   */
  public CommentStmt copy() {
    try {
      CommentStmt node = (CommentStmt) clone();
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
  public CommentStmt fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:72
   */
  public CommentStmt treeCopyNoTransform() {
    CommentStmt tree = (CommentStmt) copy();
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
  public CommentStmt treeCopy() {
    CommentStmt tree = (CommentStmt) copy();
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
   * Replaces the lexeme COMMENT.
   * @param value The new value for the lexeme COMMENT.
   * @apilevel high-level
   */
  public CommentStmt setCOMMENT(String value) {
    tokenString_COMMENT = value;
    return this;
  }
  /** @apilevel internal 
   */
  protected String tokenString_COMMENT;
  /**
   */
  public int COMMENTstart;
  /**
   */
  public int COMMENTend;
  /**
   * JastAdd-internal setter for lexeme COMMENT using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme COMMENT
   * @apilevel internal
   */
  public CommentStmt setCOMMENT(beaver.Symbol symbol) {
    if (symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setCOMMENT is only valid for String lexemes");
    tokenString_COMMENT = (String)symbol.value;
    COMMENTstart = symbol.getStart();
    COMMENTend = symbol.getEnd();
    return this;
  }
  /**
   * Retrieves the value for the lexeme COMMENT.
   * @return The value for the lexeme COMMENT.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="COMMENT")
  public String getCOMMENT() {
    return tokenString_COMMENT != null ? tokenString_COMMENT : "";
  }

}
