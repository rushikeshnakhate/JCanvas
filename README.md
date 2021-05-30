1. Scope:
	1.1	Current application does not use configuration, Config file can be used to enable/disable specific shape.
	1.2.	Application does not support for bdd feature ,I have just added a sample feature file.
	1.3.	Application uses gtes as test library and it is provided with package .
	1.4.	I have tried to keep it very simple and did not use any external library.
	1.5.	used simple Sysyem out  for logging the information
	1.6.	Single threaded application


2. Directory Structure 

D:\SUBMISSION\JCanvas>tree
D:.
└───src
    ├───main
    │   ├───java
    │   │   └───apps
    │   │       ├───application
    │   │       ├───menu
    │   │       ├───page
    │   │       ├───processor
    │   │       ├───shape
    │   │       │   └───impl
    │   │       │       └───attributes
    │   │       └───status
    │   └───resources
    └───test
        ├───java
        │   └───apps
        │       ├───application
        │       ├───menu
        │       ├───processor
        │       └───shape
        └───resources


3. Installation  
	Please unzip JCanvas.zip and compile the code
	Build Using InteiiJ
	Run the Application build->classes->main->apps->MainCanvas
	Run Test Application build->classes->test->apps->TestMainCanvas; 


> Task :compileJava UP-TO-DATE
> Task :processResources
> Task :classes
> Task :compileTestJava UP-TO-DATE
> Task :processTestResources NO-SOURCE
> Task :testClasses UP-TO-DATE
> Task :test
C Should create a new canvas CanvasPage of width w and height h.
L Should create a new line from (x1,y1) to (x2,y2).Currently only horizontal or vertical lines are supported.Horizontal and vertical lines will be drawn using the 'x' character.
R Should create a new rectangle, whose upper left corner is (x1,y1) and lower right corner is (x2,y2). Horizontal and vertical lines will be drawn using the 
B Should fill the entire area connected to (x,y) with colour c.The behavior of this is the same as that of the bucket fill tool in getBuildCanvas  programs.
Q Should quit the program.
----------------------
|                    |
|                    |
|                    |
|                    |
----------------------
----------------------
|                    |
|xxxxxx              |
|                    |
|                    |
----------------------
----------------------
|                    |
|xxxxxx              |
|     x              |
|     x              |
----------------------

----------------------
|             xxxxx  |
|xxxxxx       x   x  |
|     x       xxxxx  |
|     x              |
----------------------
----------------------
|oooooooooooooxxxxxoo|
|xxxxxxooooooox   xoo|
|     xoooooooxxxxxoo|
|     xoooooooooooooo|
----------------------
Application Stopped request=`Q` is received,Application will stop.
BUILD SUCCESSFUL in 1s
4 actionable tasks: 2 executed, 2 up-to-date
11:23:46 AM: Task execution finished ':test --tests "apps.TestMainCanvas"'.


