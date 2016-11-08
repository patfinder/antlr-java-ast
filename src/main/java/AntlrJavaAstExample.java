import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Objects;

public class AntlrJavaAstExample {

    public static void main(String[] args) throws IOException {
        print(parseJava(readFile(new File("examples/java/Demo.java"))), false);
    }

    private static String readFile(File file) throws IOException {
        byte[] encoded = Files.readAllBytes(file.toPath());
        return new String(encoded, Charset.forName("UTF-8"));
    }

    private static ParserRuleContext parseJava(String code) throws IOException {
        Java8Lexer lexer = new Java8Lexer(new ANTLRInputStream(code));

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        Java8Parser parser = new Java8Parser(tokens);

        return Objects.requireNonNull(parser.classDeclaration());
    }

    private static void print(RuleContext ctx, boolean verbose) {
        explore(ctx, verbose, 0);
    }

    private static void explore(RuleContext ctx, boolean verbose, int indentation) {
        boolean toBeIgnored = !verbose && ctx.getChildCount() == 1
                && ctx.getChild(0) instanceof ParserRuleContext;
        if (!toBeIgnored) {
            String ruleName = Java8Parser.ruleNames[ctx.getRuleIndex()];
            for (int i = 0; i < indentation; i++) {
                System.out.print("  ");
            }
            System.out.println(ruleName + " " + ctx.getText());
        }
        for (int i=0;i<ctx.getChildCount();i++) {
            ParseTree element = ctx.getChild(i);
            if (element instanceof RuleContext) {
                explore((RuleContext)element, verbose, indentation + (toBeIgnored ? 0 : 1));
            }
        }
    }
}
