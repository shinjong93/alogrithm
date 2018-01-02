class main:
	s = input()
	for i in range (len(s)):
		if( i % 10 == 0) and (i > 0):
			print()
			print(s[i],end = '')
		else:
			print(s[i],end = '')

if __name__ == "__main__":
	main()
