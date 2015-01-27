dice: dice.o main.o
	$(CC) -o $@ $^

dice.o: dice.c

main.o: main.c

clean:
	rm -f *.o

realclean: clean
	rm -f dice
