package lang;

import java.io.File;

import org.junit.Test;

public class ParseTests {
	/** Directory where the test input files are stored. */
	private static final File TEST_DIRECTORY = new File("testfiles/parser");

	@Test public void empty() {
		Util.testValidSyntax(TEST_DIRECTORY, "empty.in");
	}

	@Test public void functionIntEmpty() {
		Util.testValidSyntax(TEST_DIRECTORY, "functionIntEmpty.in");
	}

	@Test public void function2IntEmpty() {
		Util.testValidSyntax(TEST_DIRECTORY, "function2IntEmpty.in");
	}

    @Test public void declaration() {
        Util.testValidSyntax(TEST_DIRECTORY, "declaration.in");
    }

	@Test public void variableDeclarationAndUses() {
		Util.testValidSyntax(TEST_DIRECTORY, "variableDeclarationAndUses.in");
	}

	@Test public void mul1() {
		Util.testValidSyntax(TEST_DIRECTORY, "mul1.in");
	}

	@Test public void mul2() {
		Util.testValidSyntax(TEST_DIRECTORY, "mul2.in");
	}

	@Test public void add1() {
		Util.testValidSyntax(TEST_DIRECTORY, "add1.in");
	}

	@Test public void add2() {
		Util.testValidSyntax(TEST_DIRECTORY, "add2.in");
	}

	@Test public void sub1() {
		Util.testValidSyntax(TEST_DIRECTORY, "sub1.in");
	}

	@Test public void sub2() {
		Util.testValidSyntax(TEST_DIRECTORY, "sub2.in");
	}

	@Test public void div1() {
		Util.testValidSyntax(TEST_DIRECTORY, "div1.in");
	}

	@Test public void div2() {
		Util.testValidSyntax(TEST_DIRECTORY, "div2.in");
	}

	@Test public void mod1() {
		Util.testValidSyntax(TEST_DIRECTORY, "mod1.in");
	}

	@Test public void mod2() {
		Util.testValidSyntax(TEST_DIRECTORY, "mod2.in");
	}

	@Test public void operations1() {
		Util.testValidSyntax(TEST_DIRECTORY, "operations1.in");
	}

	@Test public void comparators() {
		Util.testValidSyntax(TEST_DIRECTORY, "comparators.in");
	}

	@Test public void paren1() {
		Util.testValidSyntax(TEST_DIRECTORY, "paren1.in");
	}

	@Test public void emptyFunction() {
		Util.testValidSyntax(TEST_DIRECTORY, "emptyFunction.in");
	}

	@Test public void functionCall() {
		Util.testValidSyntax(TEST_DIRECTORY, "functionCall.in");
	}

	@Test public void functionCallArgs() {
		Util.testValidSyntax(TEST_DIRECTORY, "functionCallArgs.in");
	}

	@Test public void functionCallStmtArgs() {
		Util.testValidSyntax(TEST_DIRECTORY, "functionCallStmtArgs.in");
	}

	@Test public void comment() {
		Util.testValidSyntax(TEST_DIRECTORY, "comment.in");
	}

	@Test public void returnTest() {
		Util.testValidSyntax(TEST_DIRECTORY, "returnTest.in");
	}

	@Test public void print() {
		Util.testValidSyntax(TEST_DIRECTORY, "print.in");
	}

	@Test public void read() {
		Util.testValidSyntax(TEST_DIRECTORY, "read.in");
	}



	@Test public void ifOnly() {
		Util.testValidSyntax(TEST_DIRECTORY, "ifOnly.in");
	}

	@Test public void ifElse() {
		Util.testValidSyntax(TEST_DIRECTORY, "ifElse.in");
	}

	@Test public void assignTest() {
		Util.testValidSyntax(TEST_DIRECTORY, "assignTest.in");
	}


	@Test public void whileTest() {
		Util.testValidSyntax(TEST_DIRECTORY, "while.in");
	}

	@Test public void finalBoss() {
		Util.testValidSyntax(TEST_DIRECTORY, "finalBoss.in");
	}

    @Test public void functionCallAsStatement() {
        Util.testValidSyntax(TEST_DIRECTORY, "functionCallAsStatement.in");
    }

	/* ERROR TESTS */

	@Test public void errorFunctionBadOrder() {
		Util.testSyntaxError(TEST_DIRECTORY, "errorFunctionBadOrder.in");
	}

	@Test public void errorFunctionString() {
		Util.testSyntaxError(TEST_DIRECTORY, "errorFunctionString.in");
	}

	@Test public void variableDeclarationAndUsesError1() {
		Util.testSyntaxError(TEST_DIRECTORY, "variableDeclarationAndUsesError1.in");
	}

	@Test public void variableDeclarationAndUsesError2() {
		Util.testSyntaxError(TEST_DIRECTORY, "variableDeclarationAndUsesError2.in");
	}

	@Test public void comparatorsError() {
		Util.testSyntaxError(TEST_DIRECTORY, "comparatorsError.in");
	}

	@Test public void functionCallTrailingComma() {
		Util.testSyntaxError(TEST_DIRECTORY, "functionCallTrailingComma.in");
	}

	@Test public void functionCallStmtArgsError() {
		Util.testSyntaxError(TEST_DIRECTORY, "functionCallStmtArgsError.in");
	}

	@Test public void functionCallStmtArgsError2() {
		Util.testSyntaxError(TEST_DIRECTORY, "functionCallStmtArgsError2.in");
	}

	@Test public void functionCallStmtArgsError3() {
		Util.testSyntaxError(TEST_DIRECTORY, "functionCallStmtArgsError3.in");
	}

	@Test public void returnError() {
		Util.testSyntaxError(TEST_DIRECTORY, "returnError.in");
	}

	@Test public void whileError() {
		Util.testSyntaxError(TEST_DIRECTORY, "whileError.in");
	}

	@Test public void functionError() {
		Util.testSyntaxError(TEST_DIRECTORY, "functionError.in");
	}

	@Test public void functionArgsCommaFirst() {
		Util.testSyntaxError(TEST_DIRECTORY, "functionArgsCommaFirst.in");
	}


}