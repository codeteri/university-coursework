JC = javac
JFLAGS = -g -d bin -sourcepath src

bin/%.class: src/%.java
		$(JC) $(JFLAGS) $<

SOURCES = GenericsKbArrayApp.java GenericsKbBSTApp.java Statement.java

CLASSES = $(SOURCES:%.java=bin/%.class)

default: $(CLASSES)


compile_array:
	javac src/Statement.java
	javac src/GenericsKbArrayApp.java
	javac src/BinarySearchTree.java
	javac src/BinaryTreeNode.java
	javac src/BinaryTree.java
	javac src/BTQueue.java
	javac src/BTQueueNode.java

compile_bst:
	javac src/GenericsKbBSTApp.java
	javac src/BinarySearchTree.java
	javac src/BinaryTreeNode.java
	javac src/BinaryTree.java
	javac src/BTQueue.java
	javac src/BTQueueNode.java

javadoc:
	javadoc -d doc -sourcepath src/*.java


clean:
	$(RM) bin/*.class

run_array: bin/GenericsKbArrayApp.class
	java -cp bin GenericsKbArrayApp

run_bst: bin/GenericsKbBSTApp.class
	java -cp bin GenericsKbBSTApp
