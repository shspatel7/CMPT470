include "assgn.Grm"

redefine program
 ...
 |[IfThenStat]
end redefine


define IfThenStat
  if [assgnExpr] then [NL][IN]
     [repeat statement] [NL][EX]
  else [NL][IN]
    [repeat statement] 
end define

define statement
 [assgnExpr]';
end define

function main
 match [program]
       P[program]
end function
