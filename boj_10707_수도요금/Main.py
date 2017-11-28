class main:
	A = int(input())
	B = int(input())
	limit = int(input())
	Add = int(input())
	use = int(input())

	a_total = A * use;

	if use < limit:
		b_total = B
	else:
		b_total = B + Add * (use - limit)

	if a_total < b_total:
		print(a_total)
	else:
		print(b_total)

if __name__ == "__main__":
	main()
