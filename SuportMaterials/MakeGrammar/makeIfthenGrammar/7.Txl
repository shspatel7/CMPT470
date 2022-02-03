include "assgn.Grm"

redefine program
 ...
 |[IfThenStat]
end redefine

define IfThenStat
  if [assgnExpr] then [NL][IN]
     [assgnExpr]'; [NL][EX]
  else [NL][IN]
    [assgnExpr]'; 
end define

function main
 match [program]
       P[program]
end function
