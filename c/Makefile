CFLAGS=-g # -DDEBUG

dice: dice.o main.o
	$(CC) $(CFLAGS) -o $@ $^

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
	rm -f dice *.exe
	make -C test realclean
	rm -f .test
