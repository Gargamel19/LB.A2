% Autor: Ferdinand Trendelenburg
% Datum: 26.10.2017

% 1.a
nat2s(0, 0).
% 1.b &
nat2s(Zahl, s(SZahl)) :-
        Zahl>0,
        SubZahl is Zahl-1,
        nat2s(SubZahl, SZahl).

% 1.a
s2nat(0, 0).
% 1.b
s2nat(s(SZahl), Zahl) :-
        s2nat(SZahl, NewZahl),
        Zahl is NewZahl+1.

% 1.a
add(Summand1, Summand2, _Summe):-
        add_(Summand1, Summand2, Summand1).

% 3.
add_(_Summand1, 0, _Summe).

% 2.a
add_(Summand1, s(Zahl), Summe):-
        add_(Summand1, Zahl, s(Summe)).


% 1.a
sub(Minuend, Subtrahend, _Differenz):-
        sub_(Minuend, Subtrahend, Minuend).
% 3.
sub_(_Minuend, 0, _Differenz).
% 2.a.i
sub_(_Minuend, s(_Zahl), 0).
% 2.a.ii
sub_(Minuend, s(Zahl), s(Differenz)):-
        sub_(Minuend, Zahl, Differenz).
        
% 1.
mul(_Faktor1, 0, 0).
% 1.
mul(0, _Faktor2, 0).
% 2.b
mul(_Faktor1, 0, _Produkt).
% 2.a
mul(Faktor1, s(Faktor2), Produkt):-
        mul(Faktor1, Faktor2, Produkt),
        add(Faktor1, Faktor1, Produkt).

% 1.
power(_B, 0, 0).
% 1.
power(0, _E, 0).
% 2.b
power(_B, 0, _R).
% 2.a
power(B, s(E), R):-
        power(B, E, R),
        mul(B, B, R).

% 1. & 2.b
fac(0, s(0)).
% 2.a
fac(s(Zahl), FactorialTemp):-
        fac(Zahl, TempErg),
        mul(s(Zahl), TempErg, FactorialTemp).
        
% 1.b.i
lt(0, s(_Y)).
% 1.a
lt(s(X), s(Y)):-
        lt(X, Y).
        

mods(_, 0, _) :- !, fail.
mods(0, _B, 0).
mods(A, B, _C):-
        % 1.a
        lt(A, B).
mods(A, B, C):-
        % 1.b
        sub(A, B, NewA),
        mods(NewA, B, C).






