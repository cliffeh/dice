CFLAGS=-g

dice: dice.o main.o
	$(CC) -o $@ $^

dice.o: dice.c

main.o: main.c

test: FORCE
	make -C test

FORCE:

emacs-clean: FORCE
	find . -iname '*~' -exec rm -f {} \;

clean: emacs-clean
	rm -f *.o
	make -C test clean

realclean: clean
	rm -f dice
	make -C test realclean
	rm -f .test
