class main:
	n = int(input())
	s = [0,1,2]
	for i in range(3,n+1):
		s.append(s[i-2] + s[i-1])
	print(int(s[n]) % 10007)

if __name__ == "__main__":
	main()
