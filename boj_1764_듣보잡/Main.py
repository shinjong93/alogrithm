class main:
	l,s = [int(i) for i in input().split()]
	personL =set( [input() for i in range (l)])
	personS =set( [input() for i in range (s)])

	personLS = [i for i in personL & personS]
	personLS.sort()

	print(len(personLS))
	for i in personLS:
		print(i)


	

if __name__ == "__main__":
	main()
