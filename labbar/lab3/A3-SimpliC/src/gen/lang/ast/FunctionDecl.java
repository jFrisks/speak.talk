/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.4 */
package lang.ast;
import java.io.PrintStream;
import java.util.Set;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
/**
 * @ast node
 * @declaredat /Users/lucas/Documents/LTH/edan_new_new/edan65-compilers/labbar/lab3/A3-SimpliC/src/jastadd/calc.ast:3
 * @astdecl FunctionDecl : ProgramStmt ::= IdDecl Param:IdDecl* Block;
 * @production FunctionDecl : {@link ProgramStmt} ::= <span class="component">{@link IdDecl}</span> <span class="component">Param:{@link IdDecl}*</span> <span class="component">{@link Block}</span>;

 */
public class FunctionDecl extends ProgramStmt implements Cloneable {
  /**
   * @aspect Visitor
   * @declaredat /Users/lucas/Documents/LTH/edan_new_new/edan65-compilers/labbar/lab3/A3-SimpliC/src/jastadd/Visitor.jrag:80
   */
  public Object accept(Visitor visitor, Object data) {
        return visitor.visit(this, data);
    }
  /**
   * @aspect PrettyPrint
   * @declaredat /Users/lucas/Documents/LTH/edan_new_new/edan65-compilers/labbar/lab3/A3-SimpliC/src/jastadd/PrettyPrint.jrag:158
   */
  public void prettyPrint(PrintStream out, String ind) {
        getIdDecl().prettyPrint(out, ind);
        out.print("(");
        for (int i = 0; i < getParamList().numChildren(); i++) {
          if(i == 0){
            (getParamList().getChild(i)).prettyPrint(out, ind);
          }else{
            out.print(", ");
            (getParamList().getChild(i)).prettyPrint(out, ind);
          }
        }
        out.print(") ");
        getBlock().prettyPrint(out, ind);
        out.println();
        out.println();
    }
  /**
   * @declaredat ASTNode:1
   */
  public FunctionDecl() {
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
    setChild(new List(), 1);
  }
  /**
   * @declaredat ASTNode:14
   */
  @ASTNodeAnnotation.Constructor(
    name = {"IdDecl", "Param", "Block"},
    type = {"IdDecl", "List<IdDecl>", "Block"},
    kind = {"Child", "List", "Child"}
  )
  public FunctionDecl(IdDecl p0, List<IdDecl> p1, Block p2) {
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
  public FunctionDecl clone() throws CloneNotSupportedException {
    FunctionDecl node = (FunctionDecl) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:44
   */
  public FunctionDecl copy() {
    try {
      FunctionDecl node = (FunctionDecl) clone();
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
  public FunctionDecl fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:73
   */
  public FunctionDecl treeCopyNoTransform() {
    FunctionDecl tree = (FunctionDecl) copy();
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
  public FunctionDecl treeCopy() {
    FunctionDecl tree = (FunctionDecl) copy();
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
   * Replaces the IdDecl child.
   * @param node The new node to replace the IdDecl child.
   * @apilevel high-level
   */
  public FunctionDecl setIdDecl(IdDecl node) {
    setChild(node, 0);
    return this;
  }
  /**
   * Retrieves the IdDecl child.
   * @return The current node used as the IdDecl child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="IdDecl")
  public IdDecl getIdDecl() {
    return (IdDecl) getChild(0);
  }
  /**
   * Retrieves the IdDecl child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the IdDecl child.
   * @apilevel low-level
   */
  public IdDecl getIdDeclNoTransform() {
    return (IdDecl) getChildNoTransform(0);
  }
  /**
   * Replaces the Param list.
   * @param list The new list node to be used as the Param list.
   * @apilevel high-level
   */
  public FunctionDecl setParamList(List<IdDecl> list) {
    setChild(list, 1);
    return this;
  }
  /**
   * Retrieves the number of children in the Param list.
   * @return Number of children in the Param list.
   * @apilevel high-level
   */
  public int getNumParam() {
    return getParamList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Param list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Param list.
   * @apilevel low-level
   */
  public int getNumParamNoTransform() {
    return getParamListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Param list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Param list.
   * @apilevel high-level
   */
  public IdDecl getParam(int i) {
    return (IdDecl) getParamList().getChild(i);
  }
  /**
   * Check whether the Param list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasParam() {
    return getParamList().getNumChild() != 0;
  }
  /**
   * Append an element to the Param list.
   * @param node The element to append to the Param list.
   * @apilevel high-level
   */
  public FunctionDecl addParam(IdDecl node) {
    List<IdDecl> list = (parent == null) ? getParamListNoTransform() : getParamList();
    list.addChild(node);
    return this;
  }
  /** @apilevel low-level 
   */
  public FunctionDecl addParamNoTransform(IdDecl node) {
    List<IdDecl> list = getParamListNoTransform();
    list.addChild(node);
    return this;
  }
  /**
   * Replaces the Param list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public FunctionDecl setParam(IdDecl node, int i) {
    List<IdDecl> list = getParamList();
    list.setChild(node, i);
    return this;
  }
  /**
   * Retrieves the Param list.
   * @return The node representing the Param list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Param")
  public List<IdDecl> getParamList() {
    List<IdDecl> list = (List<IdDecl>) getChild(1);
    return list;
  }
  /**
   * Retrieves the Param list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Param list.
   * @apilevel low-level
   */
  public List<IdDecl> getParamListNoTransform() {
    return (List<IdDecl>) getChildNoTransform(1);
  }
  /**
   * @return the element at index {@code i} in the Param list without
   * triggering rewrites.
   */
  public IdDecl getParamNoTransform(int i) {
    return (IdDecl) getParamListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the Param list.
   * @return The node representing the Param list.
   * @apilevel high-level
   */
  public List<IdDecl> getParams() {
    return getParamList();
  }
  /**
   * Retrieves the Param list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Param list.
   * @apilevel low-level
   */
  public List<IdDecl> getParamsNoTransform() {
    return getParamListNoTransform();
  }
  /**
   * Replaces the Block child.
   * @param node The new node to replace the Block child.
   * @apilevel high-level
   */
  public FunctionDecl setBlock(Block node) {
    setChild(node, 2);
    return this;
  }
  /**
   * Retrieves the Block child.
   * @return The current node used as the Block child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Block")
  public Block getBlock() {
    return (Block) getChild(2);
  }
  /**
   * Retrieves the Block child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Block child.
   * @apilevel low-level
   */
  public Block getBlockNoTransform() {
    return (Block) getChildNoTransform(2);
  }

}
