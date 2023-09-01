// package tests.sourceIO.lexing;

// import java.util.Iterator;

// import org.junit.jupiter.api.Test;
// import static org.junit.jupiter.api.Assertions.assertEquals;

// import sourceIO.dao.KeyValuePairCollection;
// import sourceIO.lexing.KeyValuePairLexer;

// public class KeyValuePairLexerTest {
// @Test
// public void testExistence() {
// KeyValuePairLexer<String> lexer = new KeyValuePairLexer<String>(new
// Iterator<String>() {

// @Override
// public boolean hasNext() {
// return false;
// }

// @Override
// public String next() {
// return "";
// }
// });
// }

// @Test
// public void testLex() {
// String[][] testValues = {
// { "key1", "value1" },
// { "key2", "value2" }
// };

// KeyValuePairLexer<String><String> lexer = new KeyValuePairLexer<String>(new
// Iterator<String>() {
// private int index = 0;

// @Override
// public boolean hasNext() {
// return index < testValues.length;
// }

// @Override
// public String next() {
// return String.format("%s %s", testValues[index][0], testValues[index][1]);
// }

// });

// KeyValuePairCollection<String> pairs = lexer.lex();

// assertEquals(testValues[0][1], pairs.get(testValues[0][0]));
// assertEquals(testValues[1][1], pairs.get(testValues[1][0]));
// assertEquals("doesnt exist", null);
// }
// }
