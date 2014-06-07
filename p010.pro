is_prime(2).
is_prime(Z) :-
  Z > 2,
  1 is mod(Z,2),
  N is floor(Z/2),
  forall(between(2,N,X), mod(Z,X) > 0).

prime_sum(N, Sum) :- prime_sum(N, 0, Sum).
prime_sum(1, Sum, Sum).
prime_sum(N, PrevSum, Sum) :-
  M is N - 1,
  NewSum is PrevSum + N,
  ( is_prime(N) -> 
    prime_sum(M, NewSum, Sum)
  ; prime_sum(M, PrevSum, Sum)
  ).

