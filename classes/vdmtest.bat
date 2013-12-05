@echo off
rem Tests the date book specification for one test case (argument)
rem -- Output the argument to stdout (for redirect) and "con" (for user feedback)
echo VDM Test: '%1' > con
echo VDM Test: '%1'

rem short names for specification files in Word RTF Format
set S1=BoardLine.rtf
set S2=TestBoardLine.rtf
set S3=Cell.rtf
set S4=TestCell.rtf
set S5=Bishop.rtf
set S6=GoldGeneral.rtf
set S7=King.rtf
set S8=Knight.rtf
set S9=Lance.rtf
set S10=Pawn.rtf
set S11=Piece.rtf
set S12=Rook.rtf
set S13=SilverGeneral.rtf
set S14=TestPiece.rtf
set S15=Board.rtf
set S16=TestBoard.rtf
set S17=BoardState.rtf

rem -- Calls the interpreter for this test case
"C:\Program Files\The VDM++ Toolbox v9.0.2\bin\vppde" -i -D -I -P -Q -R vdm.tc -O %1.res %1 %S1% %S2% %S3% %S4% %S5% %S6% %S7% %S8% %S9% %S10% %S11% %S12% %S13% %S14% %S15% %S16% %S17% 

rem -- Check for difference between result of execution and expected result.
if EXIST %1.exp fc /w %1.res %1.exp

:end
