include "assgn.Grm"

redefine program
  [IfThenStat]
end redefine

define IfThenStat
  if [assgnExpr] then [NL][IN]
     [assgnExpr] 
end define

function main
 match [program]
       P[program]
end function
