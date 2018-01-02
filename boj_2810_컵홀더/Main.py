class main:
	numSeats = input()
	seats = [i for i in input()]
	s = 0
	l = 0
	for i in seats:
		if i == 'S':
			s += 1
		elif i == 'L':
			l += 1

	total_cupHold = 1 + int(s) + int(0.5*int(l))

	print(total_cupHold)

if __name__ == "__main__":
	main()
