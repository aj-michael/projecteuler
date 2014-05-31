(define f
  (lambda (a b total)
    (let ([c (+ a b)])
      (if (> c 4000000)
        total
        (f b c
          (if (even? c)
            (+ total c)
            total))))))

(f 1 2 2)
