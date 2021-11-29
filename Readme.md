### installation
	- Download the repository
	- Import the project as maven project in Eclipse or any Ide
	- Download all the maven dependencies
	- Go to the project configuration by right clicking the project root and then properties, then go to java building path, libraries and check if the testNg library was added, if not click on add library and select TestNg
	
### Run the test cases
	- You can run the test cases by right clicking on the tests located on the package tests and then selecting testNG as runner
	- I also created a xml file located on src/test/results, this can be excecuted as a testNg suite

### Checking results
	- After the test case finished you can review the Result of running suite tab provided by TestNG on the terminal and you can also review the test-output folder