% Autor: Ferdinand Trendelenburg
% Datum: 26.10.2017

% 1.
is_a_list([]).
% 2.
is_a_list([_H|T]) :-
    is_a_list(T).

diffList(L1, [], L1).
% 1.a
diffList([], _L2, []).
diffList(L1, L2, ErgList) :-
        difflist_add(L1, L2, [], ErgList).

difflist_add([], _L2, L3, L3).
difflist_add([H1|T1], L2, L3, ErgList) :-
        % 2.a
        member(H1, L2),
        difflist_add(T1, L2, L3, ErgList).
difflist_add([H1|T1], L2, L3, ErgList):-
        % 2.a
        \+member(H1, L2),
        append(L3, [H1], NewList),
        difflist_add(T1, L2, NewList, ErgList).



% 1.
praefix([H|T1], [H|T2]):-
        praefix_(T1, T2).

% 2. b.i
praefix_([], [_H|_T]).
% 2. a
praefix_([H|T1], [H|T2]):-
        praefix_(T1, T2).



suffix(L1, L2):-
        % 1.
        reverse(L1, NewL1),
        % 2.
        reverse(L2, NewL2),
        % 3.
        praefix(NewL1, NewL2).





% 1. & 2.
infix([H|T1], [_H2|T2]):-
        infix_([H|T1], T2).

                % 4.a
infix_([H|T], [H|T1]):-
        infix_1([H|T], [H|T1]).
% 4.b
infix_([H1|T], [_H|T1]):-
        infix_([H1|T], T1).

infix_1([], [_H|_T]).
infix_1([H|T1], [H|T2]):-
        infix_1(T1, T2).

        % -----------------------------------------------

del_element(Position, Element, List, _ReturnList):-
      del_element_(Position, Element, List, []).

% 2.
del_element_(e, Element, [Element|T], ReturnList):-
      del_element_(ende, Element, T, ReturnList).

% 3.
del_element_(a, Element, [Element|T], ReturnList):-
      del_element_(a, Element, T, ReturnList).

% 1.
del_element_(l, Element, List, ReturnList):-
      reverse(List, NewList),
      del_element_(e, Element, NewList, ReturnList).

% 5.
del_element_(_Position, _Element, [], _ReturnList).
% 4.
del_element_(Position, Element, [H|T], ReturnList):-
      del_element_(Position, Element, T, [H|ReturnList]).


substitute(Position, Element, NewElement, List, _ReturnList):-
      substitute_(Position, Element, NewElement, List, []).

% 2.
substitute_(e, Element, NewElement, [Element|T], ReturnList):-
      substitute_(ende, Element, NewElement, T, [NewElement|ReturnList]).

% 3.
substitute_(a, Element, NewElement, [Element|T], ReturnList):-
      substitute_(a, Element, NewElement, T, [NewElement|ReturnList]).

% 1.
substitute_(l, Element, NewElement, List, ReturnList):-
      reverse(List, NewList),
      substitute_(e, Element, NewElement, NewList, ReturnList).

% 5.
substitute_(_Position, _Element, _NewElement, [], _ReturnList).
% 4.
substitute_(Position, Element, NewElement, [H|T], ReturnList):-
      substitute_(Position, Element, NewElement, T, [H|ReturnList]).


% 1.a
eo_count(_,0,0).
% 1.b.i
eo_count(List,Even,Odd):-

  % 1.b.i
  is_list(List),
  length(List, Length),
  0 is Length mod 2,
  % 1.b.i.3
  eo_count_(List,Even1,Odd),
  % 1.b.i.1
  Even is Even1+1.


% 1.b.i
eo_count(List,Even,Odd):-

  % 1.b.i
  is_list(List),
  % 1.b.i.3
  eo_count_(List,Even,Odd1),
  % 1.b.i.2
  Odd is Odd1 + 1.

eo_count_([],0,0).
eo_count_([Head|Tail],Even,Odd):-
  % 1.b.i.3
  eo_count_(Tail,TailEven,TailOdd),
  % 1.b.i.4
  eo_count(Head,HeadEven,HeadOdd),
  Even is HeadEven + TailEven,
  Odd is HeadOdd + TailOdd.



