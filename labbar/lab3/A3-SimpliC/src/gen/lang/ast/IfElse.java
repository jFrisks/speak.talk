/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.4 */
package lang.ast;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
/**
 * @ast node
 * @declaredat /Users/lucas/Documents/LTH/edan_new_new/edan65-compilers/labbar/lab3/A3-SimpliC/src/jastadd/calc.ast:12
 * @astdecl IfElse : Stmt ::= IfExpr:Expr If:Block [Else:Block];
 * @production IfElse : {@link Stmt} ::= <span class="component">IfExpr:{@link Expr}</span> <span class="component">If:{@link Block}</span> <span class="component">[Else:{@link Block}]</span>;

 */
public class IfElse extends Stmt implements Cloneable {
  /**
   * @declaredat ASTNode:1
   */
  public IfElse() {
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
    children = new ASTNode[3];
    setChild(new Opt(), 2);
  }
  /**
   * @declaredat ASTNode:14
   */
  @ASTNodeAnnotation.Constructor(
    name = {"IfExpr", "If", "Else"},
    type = {"Expr", "Block", "Opt<Block>"},
    kind = {"Child", "Child", "Opt"}
  )
  public IfElse(Expr p0, Block p1, Opt<Block> p2) {
    setChild(p0, 0);
    setChild(p1, 1);
    setChild(p2, 2);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:25
   */
  protected int numChildren() {
    return 3;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:29
   */
  public void flushAttrCache() {
    super.flushAttrCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:34
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:39
   */
  public IfElse clone() throws CloneNotSupportedException {
    IfElse node = (IfElse) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:44
   */
  public IfElse copy() {
    try {
      IfElse node = (IfElse) clone();
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
   * @declaredat ASTNode:63
   */
  @Deprecated
  public IfElse fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:73
   */
  public IfElse treeCopyNoTransform() {
    IfElse tree = (IfElse) copy();
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
   * @declaredat ASTNode:93
   */
  public IfElse treeCopy() {
    IfElse tree = (IfElse) copy();
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
   * Replaces the IfExpr child.
   * @param node The new node to replace the IfExpr child.
   * @apilevel high-level
   */
  public IfElse setIfExpr(Expr node) {
    setChild(node, 0);
    return this;
  }
  /**
   * Retrieves the IfExpr child.
   * @return The current node used as the IfExpr child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="IfExpr")
  public Expr getIfExpr() {
    return (Expr) getChild(0);
  }
  /**
   * Retrieves the IfExpr child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the IfExpr child.
   * @apilevel low-level
   */
  public Expr getIfExprNoTransform() {
    return (Expr) getChildNoTransform(0);
  }
  /**
   * Replaces the If child.
   * @param node The new node to replace the If child.
   * @apilevel high-level
   */
  public IfElse setIf(Block node) {
    setChild(node, 1);
    return this;
  }
  /**
   * Retrieves the If child.
   * @return The current node used as the If child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="If")
  public Block getIf() {
    return (Block) getChild(1);
  }
  /**
   * Retrieves the If child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the If child.
   * @apilevel low-level
   */
  public Block getIfNoTransform() {
    return (Block) getChildNoTransform(1);
  }
  /**
   * Replaces the optional node for the Else child. This is the <code>Opt</code>
   * node containing the child Else, not the actual child!
   * @param opt The new node to be used as the optional node for the Else child.
   * @apilevel low-level
   */
  public IfElse setElseOpt(Opt<Block> opt) {
    setChild(opt, 2);
    return this;
  }
  /**
   * Replaces the (optional) Else child.
   * @param node The new node to be used as the Else child.
   * @apilevel high-level
   */
  public IfElse setElse(Block node) {
    getElseOpt().setChild(node, 0);
    return this;
  }
  /**
   * Check whether the optional Else child exists.
   * @return {@code true} if the optional Else child exists, {@code false} if it does not.
   * @apilevel high-level
   */
  public boolean hasElse() {
    return getElseOpt().getNumChild() != 0;
  }
  /**
   * Retrieves the (optional) Else child.
   * @return The Else child, if it exists. Returns {@code null} otherwise.
   * @apilevel low-level
   */
  public Block getElse() {
    return (Block) getElseOpt().getChild(0);
  }
  /**
   * Retrieves the optional node for the Else child. This is the <code>Opt</code> node containing the child Else, not the actual child!
   * @return The optional node for child the Else child.
   * @apilevel low-level
   */
  @ASTNodeAnnotation.OptChild(name="Else")
  public Opt<Block> getElseOpt() {
    return (Opt<Block>) getChild(2);
  }
  /**
   * Retrieves the optional node for child Else. This is the <code>Opt</code> node containing the child Else, not the actual child!
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The optional node for child Else.
   * @apilevel low-level
   */
  public Opt<Block> getElseOptNoTransform() {
    return (Opt<Block>) getChildNoTransform(2);
  }

}
