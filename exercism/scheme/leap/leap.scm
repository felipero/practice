(import (rnrs))

(define (leap-year? year)
   (and
     (eq? (remainder year 4) 0) 
     (or (not (eq? (remainder year 100) 0)) 
	 (eq? (remainder year 400) 0))))

