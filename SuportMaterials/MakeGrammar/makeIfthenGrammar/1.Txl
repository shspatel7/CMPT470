define program
  if x == 470 then
     y := 816 
end define

%keys
%if else 
%end keys

%define IfExpression
%  if ('condition){[IN][NL]
%    'StatementsInsideIfBlock [EX] 
%   }[NL]
%  else { [IN][NL]
%    'StatementsInsideElseBlock[EX]
%    }
%end define

function main
 match [program]
       P[program]
end function
