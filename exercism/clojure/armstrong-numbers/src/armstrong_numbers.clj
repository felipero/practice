(ns armstrong-numbers)
(use 'clojure.math.numeric-tower)

(defn digits
  [num]
  (if (< num 10)
    [num]
    (conj (digits (quot num 10))
          (rem num 10))))

(defn armstrong?
  [num]
  (def nums (digits num))
  (def power (count nums))
  (= (reduce (fn
               [result digit]
               (+ result (expt digit power))) 0 nums) num))