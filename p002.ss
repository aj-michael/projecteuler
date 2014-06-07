(define fib-sum
  (lambda (LIMIT)
    (let sum ([a 1] [b 1] [total 0])
      (cond
        ((> a LIMIT) total)
        ((even? a) (sum b (+ a b) (+ total a)))
        (else (sum b (+ a b) total))))))
(fib-sum 4000000)