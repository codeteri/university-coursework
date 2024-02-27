compile_array:
	javac Statement.java
	javac GenericsKbArrayApp.java



clean:
	rm Statement.class
	rm GenericsKbArrayApp.java
run:
	java Statement
	java GenericsKbArrayApp
