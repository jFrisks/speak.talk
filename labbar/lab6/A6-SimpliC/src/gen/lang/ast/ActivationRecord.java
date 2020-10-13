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
 * @declaredat /Users/Jonte/Documents/Appar/edan65-compilers/labbar/lab6/A6-SimpliC/src/jastadd/ActivationRecord.jrag:4
 */
public class ActivationRecord extends java.lang.Object {
  
        //Local variables wiht name -> int (Name -> Value) (Boolean is converted to int)
        private HashMap<String, Integer> locals = new HashMap<>();

  
        private boolean shouldReturn = false;

  
        //Default java behavior
        private int returnValue = 0;

  

        void put(String name, int value){
            locals.put(name, value);
        }

  

        int get(String name){
            int value = locals.get(name);
            return value;
        }

  

        boolean contains(String name){
            return locals.containsKey(name);
        }

  

        void setReturnValue(int i) {
            returnValue = i;
        }

  

        void setShouldReturn(boolean b) {
            shouldReturn = b;
        }

  

        boolean shouldReturn() {
            return shouldReturn;
        }

  

        int getReturnValue() {
            return returnValue;
        }



}
