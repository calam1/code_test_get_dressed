# code_test_get_dressed

You may complete this test in the language of your choosing.  When submitting your solution please provide all source code, tests, and all necessary files/libraries for building and running your solution.
Organize your solution however you choose, but, assume that this code will be deployed to production and maintained by others in the future.
Your solution will be reviewed based on the correctness of the outputs, use of Object Oriented Principals, code legibility, ease of maintenance, use of tests, and proper use of design patterns used.

Problem:  You must get fully dressed before leaving the house 
Rules: 

1.	You always start with your PJ’s on
2.	Only 1 piece of each item of clothing may be put on 
3.	You cannot wear socks when it is hot 
4.	You cannot ear a jacket when it is hot 
5.	Socks must be put on before footwear 
6.	Shirt must be put on before a headwear and jacket 
7.	Pants must be put on before footwear 
8.	PJ’s must be taken off before anything can be put on 
9.	You cannot leave the house until all items of clothing are on (except socks and a jacket when it is hot) 
10.	If an invalid command is issued your program should output “Fail” 

Input: Temperature (HOT or COLD) followed by a comma separated list of numeric commands 

|Command |Description |Hot Output |Cold Output| 
|--------|------------|-----------|-----------|
|1 |Put on footwear |“Sandals” |“Boots”| 
|2 |Put on headwear |“Sunglasses” |“Hat”| 
|3 |Put on socks |“Fail” |“Socks”| 
|4 |Put on shirt |“Shirt” |“Shirt”| 
|5 |Put on jacket |“Fail” |“Jacket”| 
|6 |Put on pants |“Shorts” |“Pants”| 
|7 |Leave house |“Leaving house” |“Leaving house”| 
|8 |Take off PJ’s |“Removing PJ’s” |“Removing PJ’s”|


Example scenarios:
Success:
Input: HOT 8 6 4 2 1 7
Output: Removing PJ’s Shorts Shirt Sunglasses Sandals Leaving House

Input: COLD 8 6 3 4 2 5 1 7
Output: Removing PJ’s Pants Socks Shirt Hat Jacket Boots Leaving House

Failure:
Input: HOT 7
Output: Fail

Input: HOT 8 6 6
Output: Removing PJ’s shorts fail

Input: HOT 8 6 3
Output: Removing PJ’s shorts fail

Input: COLD 8 6 3 4 2 5 7
Output: Removing PJ’s Pants Socks Shirt Hat Jacket Fail

Input: COLD 8, 6, 3, 4, 2, 5, 1
Output: Removing PJ’s, Pants, Socks, Shirt, Hat, Jacket, Boots, Fail

Input: COLD 6
Output: Fail

