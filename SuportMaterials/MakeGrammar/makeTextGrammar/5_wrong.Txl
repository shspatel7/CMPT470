define program
	[repeat ID_OR_Number]
end define

define ID_OR_Number
       [id]
     |[number]
end define

function main
  match [program]
         P[program]
end function 

