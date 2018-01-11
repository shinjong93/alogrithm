class main:
	n = int(input())
	s = [1,1]
	for i in range(2,n+1):
		s.append(s[i-2] * 2 + s[i-1])
	print(s[n] % 10007)
	

if __name__ == "__main__":
	main()
