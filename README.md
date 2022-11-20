# automata
Automata Theory and Programming Languages
Term Project 1/2565

## about
เพือให้เห็นถึงการใช้งาน regular expression และ Finite automata ไปใช้งานจริง โดยใน Project นีจะใช้กับการ
ทํา lexical analysis ซึงเป็นส่วนหนึงของ compiler

## member
61050252,
63050090,
63050095,
63050096,
63050146,
63050147,
63050166

## example
testcase
```
A + B
-
*
if
then
id1
id2
id1
"Hello World"
/* comment */
```

output
```
new identifier : A
operator : +
new identifier : B
operator : -
operator : *
keywords : if
keywords : then
new identifier : id1
new identifier : id2
identifier "id1" already in symbol table
String : "Hello World"
```