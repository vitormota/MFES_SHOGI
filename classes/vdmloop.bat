@echo off
rem Runs a collection of VDM++ test examples
rem Assumes specification is in Word RTF files

set S1=BoardLine.rtf
set S2=TestBoardLine.rtf
set S3=Cell.rtf


"C:\Program Files\The VDM++ Toolbox v9.0.2\bin\vppde" -p -R vdm.tc %S1% %S2% %S3%
for /R %%f in (*.arg) do call vdmtest "%%f"
