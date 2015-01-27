run-tests: test
	./test

test: test.o ../dice.o
	$(CC) -o $@ $^

../dice.o:
	make -C ../

test.o: test.c

clean:
	rm -f *.o

realclean: clean
	rm -f test
