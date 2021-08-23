package lang.ast;

import java.util.*;
import java.io.PrintStream;
import java.util.Set;
import java.util.TreeSet;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
/**
 * @ast class
 * @aspect ActivationRecord
 * @declaredat /h/d2/c/lu6512ed-s/dod/kompilatorer/lab6/edan65-compilers/labbar/lab6/A6-SimpliC/src/jastadd/ActivationRecord.jrag:41
 */
public class Utils extends java.lang.Object {
  
        public static int boolToInt(boolean b) {
            return b ? 1 : 0;
        }

  

        public static String uniqueNameRec(ASTNode node, String currentString) {
            if(node instanceof FunctionDecl){
                //System.out.println("Var name is: " + currentString);
                return currentString;
            }
            else if(node instanceof Stmt){
                //get index of stmt
                int index = node.getParent().getIndexOfChild(node);
                //System.out.println(node.getParent().getClass().getName() + " has " + node.getClass().getName() + " on index " + index);
                //add it to currentString
                String newString = index + "_" + currentString;
                //System.out.println("Unfinished unique is: "+newString);

                //recursively call
                return uniqueNameRec(node.getParent(), newString);
            }
            else{
                return uniqueNameRec(node.getParent(), currentString);
            }
        }



}
