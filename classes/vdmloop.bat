@echo off
rem Runs a collection of VDM++ test examples
rem Assumes specification is in Word RTF files

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

"C:\Program Files\The VDM++ Toolbox v9.0.2\bin\vppde" -p -R vdm.tc %S1% %S2% %S3% %S4% %S5% %S6% %S7% %S8% %S9% %S10% %S11% %S12% %S13% %S14% %S15% %S16% %S17% 
for /R %%f in (*.arg) do call vdmtest "%%f"
