# TeaVM LWJGL Port
TeaVM-LWJGL-Port<br />
This is a port of LWJGL2 that attempts to simulate the library.
JAVAU files are unfinished java files.
OpenGL 3.0 to OpenGL 3.3 are untested. Use at your own risk.
Some functions may have no implementations due to them not being supported or that we are working on them.
All OpenGL Versions from OpenGL 1.1 to OpenGL 3.3 are finished.  
## Minimal MC
For more info, please check the minimal-mc branch.
Checkout the branch minimal-mc for the upcoming Minecraft port.
This will attemmpt to port 1.8.8


## Display lists
We are currently working on a way to stabilize display lists.

## gl(\*)Pointer functions(except for glVertexAttribPointer)
These functions are currently being added. Thanks for your patience.
## glDrawElements with indices as a ByteBuffer
These functions are currently being added. Thanks for your patience.

## Authors
Authors: MunyDev, vTajae, WeekendGamez12

## Upcoming featurs
### Different file system types(not the in-memory filesystem)
 - Preloading into in-memory file system
 -  <a href="https://developer.mozilla.org/en-US/docs/Web/API/File_System_Access_API" target="_blank"> File System Access API </a>
 - Attempt at supporting the RandomAccessFile
For these featurs a new repo will be created for this called TeaVM-FS-Port
### Fonts
 - TeaVM-Font-Port
 -Loads fonts using browser apis.
 
 Use this as a library by looking in the packages section.
 DON'T USE TESTING, USE org.munydev.ports.lwjgl
