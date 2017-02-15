# 98point6 Drop Token
My coding challenge for 98point6.
Completed: *Winter Quarter 2017*

## Instuctions To Play
1. Download files from repository.
2. After downloading, open a command line interface.
  - Note (1): For reference, the following instructions will written by a user of a bash shell.
  - Note (2): The following commands are expected to be run directly in the command line.
3. cd path/to/project
4. cd 98Point6/src
5. javac DropToken.java
6. java DropToken
7. Play the game!

## Notes 
- I had to make an assumption in my implementation that in an interview or production setting, I would have asked for further clarification on. I wasn't sure how to handle the PUT command being called after the game has already been won. My intuiton told me it would be silly to allow this to happen, so I simply print "ERROR" each time this occurs. My apalogies if this assumption was incorrect. To reverse my assumption, you would need to remove the "hasWon" variable and it's corresponding code, thus allowing the user to PUT after the game has already been won.
- If you wish to run the DropToken_Tests.java, make sure to change the private methods in DropToken to be public. I kept them private in my version, since in a production setting, we wouldn't want any class beyond DropToken to have access to these.
