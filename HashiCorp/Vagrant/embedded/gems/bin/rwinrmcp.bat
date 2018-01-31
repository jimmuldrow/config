@ECHO OFF
IF NOT "%~f0" == "~f0" GOTO :WinNT
@"C:\Users\vagrant\AppData\Local\Temp\lm2twcmo.e5h\embedded\mingw64\bin\ruby.exe" "C:/Users/vagrant/AppData/Local/Temp/lm2twcmo.e5h/embedded/gems/bin/rwinrmcp" %1 %2 %3 %4 %5 %6 %7 %8 %9
GOTO :EOF
:WinNT
@"C:\Users\vagrant\AppData\Local\Temp\lm2twcmo.e5h\embedded\mingw64\bin\ruby.exe" "%~dpn0" %*
