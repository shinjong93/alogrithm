class main:
	albums = {}
	strings = """1967 DavidBowie 1969 SpaceOddity 1970 TheManWhoSoldTheWorld 1971 HunkyDory 1972 TheRiseAndFallOfZiggyStardustAndTheSpidersFromMars 1973 AladdinSane 1973 PinUps 1974 DiamondDogs 1975 YoungAmericans 1976 StationToStation 1977 Low 1977 Heroes 1979 Lodger 1980 ScaryMonstersAndSuperCreeps 1983 LetsDance 1984 Tonight 1987 NeverLetMeDown 1993 BlackTieWhiteNoise 1995 1.Outside 1997 Earthling 1999 Hours 2002 Heathen 2003 Reality 2013 TheNextDay 2016 BlackStar"""
	total = [str(i) for i in strings.split(" ")]
	years = []
	names = []
	inputList = []
	for i in range (0,len(total),2): 
		years.append(total[i])
		names.append(total[i+1])
	for i in range (0,len(years),1):
			if(years[i] in albums):
				albums[years[i]].append(names[i])
			else:
				albums[years[i]] = [names[i]]

	for times in range(int(input())):
		inputs = [int(i) for i in input().split(" ")]
		start = inputs[0]
		totalCD = 0
		while(start <= inputs[1]):
			if str(start) in albums:
				totalCD += len(albums[str(start)])
			start+=1
		print(totalCD)
		start = inputs[0]
		while start <= inputs[1]:
			if str(start) in albums:
				for cd in albums[str(start)]:
					print(str(start) + " " + cd)
			start += 1
	
	
#	print(total[i] + " ==  " + total[i+1])


if __name__ == "__main__":
	main()


"""
1967 DavidBowie
1969 SpaceOddity
1970 TheManWhoSoldTheWorld
1971 HunkyDory
1972 TheRiseAndFallOfZiggyStardustAndTheSpidersFromMars
1973 AladdinSane
1973 PinUps
1974 DiamondDogs
1975 YoungAmericans
1976 StationToStation
1977 Low
1977 Heroes
1979 Lodger
1980 ScaryMonstersAndSuperCreeps
1983 LetsDance
1984 Tonight
1987 NeverLetMeDown
1993 BlackTieWhiteNoise
1995 1.Outside
1997 Earthling
1999 Hours
2002 Heathen
2003 Reality
2013 TheNextDay
2016 BlackStar


"""
