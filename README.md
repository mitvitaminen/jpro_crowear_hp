# crowear_hp 
cro stands for Christian Rocholl, which is my name
and Wear is self explaining. It is a nice effect, 
that you could also Say CrowEar, since crows are my 
favorite bird animal. Since it is a raven bird. It is also 
part of the logo which is within the projects resources files.

 CroWearWebShop spawning out of my Cannabis Social Clubs Webpage.

This is modularized web shop with animations written in JavaFX.
IT has working I18N in German and English, this must be extended to
more/all languages. It is secured with shiro, uses google guice as 
Dependency Injection Framework and Log4J for logging. Additionally 
there are some control dependencies for javafx and some smaller tweak
 libraries just check out the poms of the modules for details.

There are some dependencies which are used in both modules, hence 
they are declared in the parent pom. Please notice that they have 
to be declared again but without the version number in the modules pom.
I think you get the point.:)

Prior run please do mvn install. 

To run either launch the Launcher.java in you IDE, after importing as
maven project in Eclipse (IntelliJ is not tested) to run as a regular 
JavaFX application without the jpro server

To run with jpro-ed shop (translated to javascript) on a nginx server 
on http://localhost:8080 please do mvn jpro:run. Jpro.one launches 
a nginx server so this might to be installed and configured prior 
running. When run a browser will open on this page so do not be alarmed. 
 
Have fun extending for your own need and kind regards, if you feel like 
it do a pull request and show me bugs or errors .

You can write me a note of what you think of it too.
 
Notice: I know this is yet a cannabis social club web page instead of
a webshop, but the web shop is not done yet and I wrote the CSC webpage
of the PotPourri Cannabis Social Club prior and used it as basis for the 
project.

If you have trouble running this please contact me via github for advice.
thanks and enjoy
Chris