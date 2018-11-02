nat(0).
nat(s(X)):- 
        nat(X).

nat2s(0, 0).
nat2s(Zahl, s(SZahl)) :-
        Zahl>0,
        SubZahl is Zahl-1,
        nat2s(SubZahl, SZahl).
        
s2nat(0, 0).
s2nat(s(SZahl), Zahl) :-
        s2nat(SZahl, NewZahl),
        Zahl is NewZahl+1.
        
add(Summand1, Summand2, _Summe):-
        add_(Summand1, Summand2, Summand1).

add_(_Summand1, 0, _Summe).
add_(Summand1, s(Zahl), Summe):-
        add_(Summand1, Zahl, s(Summe)).


sub(Minuend, Subtrahend, _Differenz):-
        sub_(Minuend, Subtrahend, Minuend).

sub_(_Minuend, 0, _Differenz).
sub_(_Minuend, s(_Zahl), 0).
sub_(Minuend, s(Zahl), s(Differenz)):-
        sub_(Minuend, Zahl, Differenz).
        
        
mul(_Faktor1, 0, 0).
mul(0, _Faktor2, 0).
mul(_Faktor1, 0, _Produkt).
mul(Faktor1, s(Faktor2), Produkt):-
        mul(Faktor1, Faktor2, Produkt),
        add(Faktor1, Faktor1, Produkt).
        
mul(_Faktor1, 0, 0).
mul(0, _Faktor2, 0).
mul(_Faktor1, 0, _Produkt).
mul(Faktor1, s(Faktor2), Produkt):-
        mul(Faktor1, Faktor2, Produkt),
        add(Faktor1, Faktor1, Produkt).

power(_B, 0, 0).
power(0, _E, 0).
power(_B, 0, _R).
power(B, s(E), R):-
        power(B, E, R),
        mul(B, B, R).

fac(0, s(0)).
fac(s(Zahl), FactorialTemp):-
        fac(Zahl, TempErg),
        mul(s(Zahl), TempErg, FactorialTemp).
        

lt(0, s(_Y)).
lt(s(X), s(Y)):-
        lt(X, Y).
        
        
mods(_, 0, _) :- !, fail.
mods(0, _B, 0).
mods(A, B, _C):-
        lt(A, B).
mods(A, B, C):-
        sub(A, B, NewA),
        mods(NewA, B, C).






