INSTALLATION 

D:\SUBMISSION\JCanvas>tree
Folder PATH listing for volume DATA
Volume serial number is 06F2-F376
D:.
├───.gradle
│   ├───6.8
│   │   ├───fileChanges
│   │   ├───fileHashes
│   │   └───vcsMetadata-1
│   ├───buildOutputCleanup
│   ├───checksums
│   ├───configuration-cache
│   └───vcs-1
├───.idea
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




1. DownLoad the dolder b.uncompress it
2. Build Using InteiiJ  
3. Run the Application build->classes->main->apps->MainCanvas
4. Run Test Application  build->classes->test->apps->TestMainCanvas


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
|             x      |
|xxxxxx       x      |
|     x       x      |
|     x              |
----------------------
----------------------
|             xxxxx  |
|xxxxxx       x      |
|     x       x      |
|     x              |
----------------------
----------------------
|             xxxxx  |
|xxxxxx       x   x  |
|     x       x   x  |
|     x              |
----------------------
----------------------
|             xxxxx  |
|xxxxxx       x   x  |
|     x       xxxxx  |
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
