EGGJAR=./eggc-5.4.3.jar
JDIR=/usr/bin
JAVAC=$(JDIR)/javac $(JOPTS)
JAVA=$(JDIR)/java
JAR=$(JDIR)/jar
JAVADOC=$(JDIR)/javadoc

#################

all : legg compile doc exec

doc :
	mkdir doc && \
	cd doc && \
	$(JAVADOC) ../src/fr/n7/stl/block/ast/*.java ../src/fr/n7/stl/block/ast/impl/*.java \
	../src/fr/n7/stl/tam/ast/*.java ../src/fr/n7/stl/tam/ast/impl/*.java \
	../src/fr/n7/stl/util/*.java

legg : 
	$(JAVA) -jar $(EGGJAR) MiniJava.egg

compile :
	cd egg && \
	$(JAVAC) -classpath ../$(EGGJAR):../.:. *.java&& \
	cd .. && \
	$(JAVAC) -classpath $(EGGJAR):. Main.java

exec :
	$(JAVA) -classpath $(EGGJAR):. Main test.txt

clean :
	-rm Main.class
	-rm -rf egg
	-rm -rf doc
	-rm -rf src/fr/n7/stl/block/ast/*.class src/fr/n7/stl/block/ast/impl/*.class
	-rm -rf src/fr/n7/stl/tam/ast/*.class src/fr/n7/stl/tam/ast/impl/*.class
	-rm -rf src/fr/n7/stl/util/*.class
