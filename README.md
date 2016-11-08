# antlr-java-ast
Sample Java AST built using ANTLR

## Build

```
gradle fatJar
```

## Run

```
java -cp build/libs/antlr-java-ast-all.jar AntlrJavaAstExample
```

will print:

```
normalClassDeclaration publicclassDemo{voidm(){Stringvar="value";if(var!=null){System.out.println(var);}}publicstaticvoidmain(String[]args){newDemo().m();}}
  classModifier public
  classBody {voidm(){Stringvar="value";if(var!=null){System.out.println(var);}}publicstaticvoidmain(String[]args){newDemo().m();}}
    methodDeclaration voidm(){Stringvar="value";if(var!=null){System.out.println(var);}}
      methodHeader voidm()
        result void
        methodDeclarator m()
      block {Stringvar="value";if(var!=null){System.out.println(var);}}
        blockStatements Stringvar="value";if(var!=null){System.out.println(var);}
          localVariableDeclarationStatement Stringvar="value";
            localVariableDeclaration Stringvar="value"
              unannClassType_lfno_unannClassOrInterfaceType String
              variableDeclarator var="value"
                variableDeclaratorId var
                literal "value"
          ifThenStatement if(var!=null){System.out.println(var);}
            equalityExpression var!=null
              expressionName var
              literal null
            block {System.out.println(var);}
              expressionStatement System.out.println(var);
                methodInvocation System.out.println(var)
                  typeName System.out
                    packageOrTypeName System
                  expressionName var
    methodDeclaration publicstaticvoidmain(String[]args){newDemo().m();}
      methodModifier public
      methodModifier static
      methodHeader voidmain(String[]args)
        result void
        methodDeclarator main(String[]args)
          formalParameter String[]args
            unannArrayType String[]
              unannClassType_lfno_unannClassOrInterfaceType String
              dims []
            variableDeclaratorId args
      block {newDemo().m();}
        expressionStatement newDemo().m();
          methodInvocation newDemo().m()
            classInstanceCreationExpression_lfno_primary newDemo()
```

## Grammar

The original grammar has been obtained from:

https://github.com/antlr/grammars-v4/tree/master/java8

It is available under the MIT License

## Fork

This project is a fork of https://github.com/ftomassetti/python-ast

