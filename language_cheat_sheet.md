## Types
- Delcare integer: `an integer`
  regex2: `(|^)(int (\w*))[ ]*(=)`
- Declare string: `a string`

## Function
- Declare (statement) without arguments: A function that is called [function name]. It returns [type] by running the following code: [code block].
  regex: `^int (\w*)( )?\(\) \{`
- Declare (statement) with arguments: A function that is called [function name] and [arguments], It returns [type] by running the following code: [code block] .
  regex: `^int (\w*)( )?\(([\w, ]*)\) \{
- Run with arguments (expression): the function that is called print and [arguments].
  regex: `\([^,]*,[^,)]*\)`

## Arguments
- Argument for function (declare/run): uses the arguments of [arg1], [arg2], [...args]
  regex: `(of |, |\()(int (\w*))`
- Multiple args (possible future sol): - Argument for function (declare/run): uses the arguments of [arg1], [arg2], and [arg3]

## Block of code
0+ statements

## Statements
- Assignment with declaration: - [declare variable] and has the value of [expression] .
  Regex1: `(-[ ]*[ \w]*) =`
- While: - loop while [condition(s)]. Run the following code each time: [code block] .
- If: - if [conditions(s)], do the following: [code block] - else, do: [code block] .
  regex: `([ ]*)(\})\n?([ ]*)else[ ]*\{`
- Return: - finally return [expression].
  regex: `(^[ ]*)(return)(.*)`
- Function:  run the function that is called [name] and uses the arguments of [args].

## Variables
- Declare: [type] that is called [name]
- Use: the variable that is called [name]
  regex1: `((\()([a-zA-Z]*)([,)]))`

## Expressions
- Run function: [(Please refer to function-title)]
- Minus: [variable] subtracted by [variable]
- Negative:
  regex: `(?<![\n\v][ ]*)(-)`

## Conditions
- Is not equal: [variable] is not equal to [variable]
- Is greater than: [declared variable] is greater than [declared variable]

## Built in functions
Use as a normal function with names:
- read: `read`
- print: `print`

## TODO
- Remove punctuation and replace with indention shift.

## Interesting thoughts perfect langauge vs sloppy language vs images in comparision with programming langauges vs low code. Write article!