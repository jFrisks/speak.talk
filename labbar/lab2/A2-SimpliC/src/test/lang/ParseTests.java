package lang;

import java.io.File;

import org.junit.Test;

public class ParseTests {
	/** Directory where the test input files are stored. */
	private static final File TEST_DIRECTORY = new File("testfiles/parser");

	@Test public void functionIntEmpty() {
		Util.testValidSyntax(TEST_DIRECTORY, "functionIntEmpty.in");
	}

	@Test public void function2IntEmpty() {
		Util.testValidSyntax(TEST_DIRECTORY, "function2IntEmpty.in");
	}

	@Test public void variableDeclarationAndUses() {
		Util.testValidSyntax(TEST_DIRECTORY, "variableDeclarationAndUses.in");
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

	@Test public void variableDeclarationAndUsesError3() {
		Util.testSyntaxError(TEST_DIRECTORY, "variableDeclarationAndUsesError3.in");
	}

}
//variableDeclarationAndUsesError1