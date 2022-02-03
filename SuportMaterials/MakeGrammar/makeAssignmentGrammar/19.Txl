
define program
  [id] [assgn_operators] [expression]
end define

compounds
 == :=
end compounds

define assgn_operators
'==
|':=
end define

define ID_or_Number
     [id]
    | [number]
end define

define expression
  [ID_or_Number]
 |[expression] '+ [expression]
 |[expression] '- [expression]
 |[expression] '/ [expression]
 |[expression] '* [expression]
end define

define op
 '+
 |'-
 |'/
 |'*
end define

function main
   match [program]
   P[program]
end function 

