# MinesweeperProject
This project makes a minesweeper game similar to Google Minesweeper.

How to run:
Step 1) Download a professional environment that compiles and runs Java files. (https://spider.eng.auburn.edu/user-cgi/grasp/grasp.pl?;dl=download_jgrasp.html) use the link to download and follow instructions on the installer. https://www.oracle.com/java/technologies/downloads/#jdk18-windows Use this link to install an Installer for your OS.
Step 2) Open the program
Step 3) Create a folder 
Step 4) Download all the files from the repo 
Step 5) Open all files
Step 6) Save them all in the same folder
Step 7) Compile all files
Step 8) After compiling all of them, run MinesweeperTester
Step 9) Play Minesweeper!
(If you want to play again after closing the game, re-run MinesweeperTester).

How to play:
The program responds to mouse(or touchpad) clicks.
We used swing, JPanel and MouseInputAdapter for graphics and user interaction.

Make sure your first click is left click to not mess up the program!
Bombs are generated after the first click, so unless you start off with right click, your first left click will never click on a bomb. 
Left click - Reveals the tile you are clicking on, if it's a bomb, you lose
Middle click - If there's an exact amount of flags as there is bombs near the tile, it will reveal all tiles in 1 tile range, unless it's already revealed or if it's a flag.
Right click - Places a flag, which is useful for remembering where the bombs are, and how many there are left, which makes the game easier
To win the game, reveal all tiles without opening a bomb. When you win, the program will let you exit or play again, and tell you your time.
