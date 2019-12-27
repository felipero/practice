(import (rnrs))

(define (leap-year? year)
   (and
     (eqv? (remainder year 4) 0) 
     (or (not (eqv? (remainder year 100) 0)) 
	 (eqv? (remainder year 400) 0))))

