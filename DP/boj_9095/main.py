class main:
	n = int(input())
	for i in range(n):
		k = int(input())
		s = [0,1,2,4]
		for i in range(4,k+1):
			s.append(s[i-3] + s[i-2] + s[i-1])
		print(s[k])

if __name__ == "__main__":
	main()
