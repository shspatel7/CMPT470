% Grammar for pretty printing of C code


% New tokens
tokens
    include_files     "\#(include)(<)[\u]+(.)[hc](>)"
    id ... |    "[(&)(!)(*)(\u)(:)]\i+"
    operators   "[&|<>=+-]+"
    increment   "[\u]+[ \t]*[(++)(--)]"
    continue    "continue"
    return      "return"
end tokens


% C comments
comments
    //
    /* */
end comments


% C Program
define program
	[c_function]
    | [single_include] [NL] [c_function]
    | [multi_include] [NL] [c_function]
end define

define single_include
    [include_files] [NL]
end define

define multi_include
    [repeat single_include]
end define


% C Function
define c_function
    [c_function_header] [NL]
        { [NL][IN]
          [c_function_body] [EX]
        }
end define

define c_function_header
    [c_function_type] [c_function_name] ()
end define

define c_function_type
    int
end define

define c_function_name
    [id]
end define

define c_function_body
    [repeat c_function_body_statement]
end define


% C Function Body Statements
define c_function_body_statement
    [c_function_body_statement_if]
    | [c_function_body_statement_else]
    | [c_function_body_statement_while]
    | [c_function_body_statement_for]
    | [c_function_body_statement_switch]
    | [c_function_body_statement_return]
    | [c_function_body_statement_break_continue]
    | [c_function_body_statement_declaration]
    | [c_function_body_statement_assignment]
    | [c_function_body_statement_print_scan]
end define


% If - Else Statement
define c_function_body_statement_if
    if ( [c_function_body_statement_condition] ) [NL] [c_condition_body_condition_body]  
end define

define c_function_body_statement_else
    else [NL] [c_condition_body_condition_body]
end define


% C Function Body Condition
define c_function_body_statement_condition
    [single_condition]
    | [multi_condition]
end define

define single_condition
    [c_condition_body_compare_value] [operators] [c_condition_body_compare_value]
    | ( [c_condition_body_compare_value] [operators] [c_condition_body_compare_value] )
    | [c_condition_body_compare_special] ( [c_condition_body_compare_value] [operators] [c_condition_body_compare_value] )
end define

define multi_condition
    [single_condition] [add_condition]
end define

define add_condition
    [operators] [single_condition]
end define

define c_condition_body_compare_special
    : | '!
end define

define c_condition_body_compare_value
    [value]
    | [id]
end define

define c_condition_body_condition_body
    { [NL] [IN] [repeat c_function_body_statement] [EX] } [NL]
    | [IN] [c_function_body_statement] [EX]
    | [IN] [c_function_body_statement_break_continue]
end define


% C declaration
define c_function_body_statement_declaration
    [c_function_body_data_type] [c_function_body_variable]
    | [c_function_body_data_type] [repeat c_function_body_variable]
    | [c_function_body_data_type] [c_function_body_statement_assignment]
    | [c_function_body_statement_assignment]
end define

define c_function_body_data_type
    'const [c_function_body_data_type_type]
    | 'unsigned [c_function_body_data_type_type]
    | 'signed [c_function_body_data_type_type]
    | [c_function_body_data_type_type]
end define

define c_function_body_data_type_type
    'int
    | 'char
    | 'float
end define

define c_function_body_statement_assignment
    [c_function_body_variable] = [c_function_body_variable_assignment_value]
    | [c_function_body_variable] = [c_function_body_variable_assignment_value]; [NL]
end define

define c_function_body_variable
    [id]
    | [id],
    | [id]; [NL]
end define

define c_function_body_variable_assignment_value
    [value]
    | [expression]
end define

define value
    [number]
    | [floatnumber]
    | [charlit]
    | [id]
end define

define expression
    [id] [operator] [value]
    | [id] [operator] [value]; [NL]
end define

define operator
    '+
    | '-
    | '*
    | '/
end define


% C for loop
define c_function_body_statement_for
    [id] ( [c_function_body_statement_declaration]; [single_condition]; [c_function_body_loop_increment] )
    [NL] [c_function_body_statement_loop_body]
end define

define c_function_body_loop_increment
    [id] [SPOFF] ++ [SPON]
end define

define c_function_body_statement_loop_body
    { [NL] [IN] [repeat c_function_body_statement] [EX] } [NL]
    | [IN] [c_function_body_statement] [EX]
end define


% C switch statement
define c_function_body_statement_switch
    [id] ([id]) [NL]{
        [NL][IN]
        [repeat c_function_body_statement_switch_case] [c_function_body_statement_switch_default] [EX]
    } [NL]
end define

define c_function_body_statement_switch_case
    [id] [value] [c_condition_body_compare_special]
    [NL] [IN] [c_function_body_statement] [c_function_body_statement_break_continue] [EX]
end define

define c_function_body_statement_break_continue
    [token]; [NL]
    | [id]; [NL] [EX]
end define

define c_function_body_statement_switch_default
    [id] [c_condition_body_compare_special] [NL] [IN] [c_function_body_statement] [EX]
end define


% C while loop
define c_function_body_statement_while
    [id] [c_function_body_statement_condition] [NL] [c_function_body_statement_loop_body]
end define

define c_function_body_statement_do_while
    [id] [NL] [c_function_body_statement_do_while_body] [id] [c_function_body_statement_condition]; [NL]
end define 

define c_function_body_statement_do_while_body
    { [NL] [IN] [repeat c_function_body_statement] [EX] }
    | [IN] [c_function_body_statement] [EX]
end define


% C print and scan statement
define c_function_body_statement_print_scan
    printf([c_function_body_statement_print_scan_body]); [NL]
    | scanf([c_function_body_statement_print_scan_body]); [NL]
end define

define c_function_body_statement_print_scan_body
    [stringlit]
    | [stringlit], [id]
end define


% C return statement
define c_function_body_statement_return
    [token] [c_function_body_statement_return_value]; [NL]
end define

define c_function_body_statement_return_value
    [number]
end define


% C main function
function main
    match [program]
        P[program]
end function   