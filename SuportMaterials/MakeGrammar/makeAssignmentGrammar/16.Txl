
define program
  [id] [assgn_operators] [ID_or_Number] [op] [ID_or_Number]
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

