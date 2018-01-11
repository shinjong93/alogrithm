class main:
	def total(hp,mp,atk,df):
       		if int(hp) < 1:
        	        hp = 1
       		if int(mp) < 1:
             	  	mp = 1
	        if int(atk) < 0:
	                atk = 0

	        return int(hp) + 5*int(mp) + 2*int(atk) + 2*int(df)


	testValue = int(input())
	for i in range(testValue):
		inputNum = input()
		stats = []
		stats = inputNum.split(" ")
		hp = int(stats[0]) + int(stats[4])
		mp = int(stats[1]) + int(stats[5])
		atk = int(stats[2]) + int(stats[6])
		df = int(stats[3]) + int(stats[7])
	
		result = total(hp,mp,atk,df)
		print(result)

if __name__ == "__main__":
	main()
	
