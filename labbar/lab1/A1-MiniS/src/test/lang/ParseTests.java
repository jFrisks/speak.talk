package lang;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import static org.junit.Assert.fail;

public class ParseTests {
	/**
	 * Directory where the test input files are stored.
	 */
	private static final File TEST_DIRECTORY = new File("testfiles");

	@Test
	public void shortestCorrectProgram() {
		Util.testValidSyntax(TEST_DIRECTORY, "shortestCorrectProgram.in");
	}

	@Test
	public void allLanguageConstructs() {
		Util.testValidSyntax(TEST_DIRECTORY, "allLanguageConstructs.in");
	}

	@Test
	public void parsingError() {
		Util.testSyntaxError(TEST_DIRECTORY, "parsingError.in");
	}

	@Test
	public void scanningError() {
		Util.testSyntaxError(TEST_DIRECTORY, "scanningError.in");
	}

	@Test
	public void integerCorrect1() {
		Util.testValidSyntax(TEST_DIRECTORY, "integerCorrect1.in");
	}
	@Test
	public void integerCorrect2() {
		Util.testValidSyntax(TEST_DIRECTORY, "integerCorrect2.in");
	}
	@Test
	public void integerError1() {
		Util.testSyntaxError(TEST_DIRECTORY, "integerError1.in");
	}
	@Test
	public void integerError2() {
		Util.testSyntaxError(TEST_DIRECTORY, "integerError2.in");
	}

}