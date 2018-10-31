% Author = Ferdinand

is_a_list([]).
is_a_list([_|T]) :-
    is_a_list(T).

diffList(L1, [], L1).
diffList([], _L2, []).
diffList(L1, L2, ErgList) :-
        difflist_delete(L1, L2, [], ErgList).

difflist_delete([], _L2, L3, L3).
difflist_delete([H1|T1], L2, L3, ErgList) :-
        member(H1, L2),
        difflist_delete(T1, L2, L3, ErgList).
difflist_delete([H1|T1], L2, L3, ErgList):-
        \+member(H1, L2),
        append(L3, [H1], NewList),
        difflist_delete(T1, L2, NewList, ErgList).

        

        
praefix([H|T1], [H|T2]):-
        praefix_(T1, T2).       
praefix_([], [_H|_T]).
praefix_([H|T1], [H|T2]):-
        praefix_(T1, T2).

        
suffix(L1, L2):-
        reverse(L1, NewL1),
        reverse(L2, NewL2),
        praefix(NewL1, NewL2).


        
        
infix([], []).
infix([H|T1], [_H2|T2]):-
        infix_([H|T1], T2).
        
infix_([H|T], [H|T1]):-
        infix_1([H|T], [H|T1]).
        
infix_([H1|T], [_H|T1]):-
        infix_([H1|T], T1).

infix_1([], [_H|_T]).
infix_1([H|T1], [H|T2]):-
        infix_1(T1, T2).



del_element(Position, Element, List, _ReturnList):-
      del_element_(Position, Element, List, []).

del_element_(e, Element, [Element|T], ReturnList):-
      del_element_(ende, Element, T, ReturnList).

del_element_(a, Element, [Element|T], ReturnList):-
      del_element_(a, Element, T, ReturnList).

del_element_(l, Element, List, ReturnList):-
      reverse(List, NewList),
      del_element_(e, Element, NewList, ReturnList).
      
del_element_(_Position, _Element, [], _ReturnList).
del_element_(Position, Element, [H|T], ReturnList):-
      del_element_(Position, Element, T, [H|ReturnList]).


substitute(Position, Element, NewElement, List, _ReturnList):-
      substitute_(Position, Element, NewElement, List, []).

substitute_(e, Element, NewElement, [Element|T], ReturnList):-
      substitute_(ende, Element, NewElement, T, [NewElement|ReturnList]).

substitute_(a, Element, NewElement, [Element|T], ReturnList):-
      substitute_(a, Element, NewElement, T, [NewElement|ReturnList]).

substitute_(l, Element, NewElement, List, ReturnList):-
      reverse(List, NewList),
      substitute_(e, Element, NewElement, NewList, ReturnList).

substitute_(_Position, _Element, _NewElement, [], _ReturnList).
substitute_(Position, Element, NewElement, [H|T], ReturnList):-
      substitute_(Position, Element, NewElement, T, [H|ReturnList]).



eo_count(L, Even, Odd):-
      length(L, Even).