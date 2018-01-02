class main:
	n = int(input())
	for i in range(n):
		a,b = [int(i) for i in input().split()]
		print("Case #"+ str(i+1) + ":" + " "+ str( a+b ) )

if __name__ == "__main__":
	main()
