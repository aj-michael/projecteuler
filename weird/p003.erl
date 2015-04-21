-module(p003).
-export([largest_prime_factor/1,largest_prime_factor/4]).

largest_prime_factor(N) ->
	largest_prime_factor(N,1,3, N).

largest_prime_factor(N,_,START,CUTOFF) when N rem START =:= 0 ->
	largest_prime_factor(N div START,START,START,CUTOFF);
largest_prime_factor(N,MAX,START,CUTOFF) when START < CUTOFF ->
	largest_prime_factor(N,MAX,START+2,CUTOFF);
largest_prime_factor(_,MAX,_,_) -> MAX.
