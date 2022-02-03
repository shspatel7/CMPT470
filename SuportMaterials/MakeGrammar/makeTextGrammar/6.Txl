#pragma -idchars "/."

define program
	[repeat ID_OR_Number]
end define

define ID_OR_Number
       [id] [NL] [IN]
     |[EX] [number] 
end define

function main
  match [program]
         P[program]
end function 

