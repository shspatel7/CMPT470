define program
  if x == [number] then [NL][IN] y := [number] 
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
