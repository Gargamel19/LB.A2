% Author = Ferdinand

is_a_list([]).
is_a_list([_|T]) :-
    is_a_list(T).

diffList(L1, L2, L3) :-
    findall((X), (
    member(X, L1),
    not(member(X, L2))
	), L3).
	
% diffList(L1, [], L1).
% diffList([], _L2, []).
% diffList(L1, L2, ErgList) :-
% 	difflist_delete(L1, L2, L1).
% 	
% difflist_delete(L1, [], ErgList).
% difflist_delete(L1, [H|T], ErgList):-
% 	difflist_delete_(H, ErgList, NewErgList),
% 	difflist_delete(L1, T, NewErgList).
% 
% difflist_delete_(H, [], List).
% difflist_delete_(H, [H|T], List):-
% 	difflist_delete_(H, T, List).
% difflist_delete_(H, [H1|T], List):-
% 	difflist_delete_(H, T, [H1|List]).
	
	
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
	
infix_([_H1|T], [H|T1]):-
	infix_([_H1|T], T1).

infix_1([], [_H|_T]).
infix_1([H|T1], [H|T2]):-
	infix_1(T1, T2).


% del_element(Position, Element, List, _ReturnList):-
% 	del_element_(Position, Element, List, []).
% 		
% 	
% del_element_(l, Element, List, ReturnList):-
% 	reverse(List, NewList),
% 	del_element_(e, Element, NewList, ReturnList).
% 	
% 	
% 
% del_element_(e, Element, [Element|T], ReturnList):-
% 	del_element_(ende, Element, T, ReturnList).
% 	
% del_element_(a, Element, [Element|T], ReturnList):-
% 	del_element_(a, Element, T, ReturnList).
% 	
% del_element_(Position, Element, [H|T], ReturnList):-
% 	del_element_(Position, Element, T, [H|ReturnList]).
% del_element_(_,_,[],[]).



















