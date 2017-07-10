set projectLocation=C:\Users\catalinf\Projects\IntJ\DesiLaColScripts
cd %projectLocation%
set classpath=%projectLocation%\Req\*;
java org.testng.TestNG %projectLocation%\testng.xml
pause