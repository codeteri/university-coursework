JC = javac
JFLAGS = -g
SRCDIR = src
BINDIR = bin

.SUFFIXES: .java .class

# Compile .java files in src directory and place .class files in bin directory
$(BINDIR)/%.class: $(SRCDIR)/%.java
	$(JC) $(JFLAGS) -d $(BINDIR) $<

# List all Java source files
CLASSES := $(wildcard $(SRCDIR)/*.java)

# Convert source file names to corresponding class file names
CLASS_FILES := $(CLASSES:$(SRCDIR)/%.java=$(BINDIR)/%.class)

# Default target: compile all .java files
default: classes

# Compile all .java files
classes: $(CLASS_FILES)

# Clean up all generated .class files
clean:
	$(RM) $(BINDIR)/*.class

# Run the GenericsKbArrayApp
run_array: classes
	java -cp $(BINDIR) GenericsKbArrayApp

# Run the GenericsKbBSTApp
run_bst: classes
	java -cp $(BINDIR) GenericsKbBSTApp
